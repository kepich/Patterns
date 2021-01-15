package Source.Chain;

import Source.Chain.Context.ChainContext;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Nucleotide.NucleotideManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Chain {
    private List<Nucleotide> nucleotides;
    private MyLogger logger = MyLoggerFactory.getLogger(Chain.class.getName());
    private Random random = new Random();
    private NucleotideManager nucleotideManager = NucleotideManager.instance();


    public Chain(List<Nucleotide> nucleotides) {
        this.nucleotides = nucleotides;
        this.logger.info("Created " + this.toString());
    }

    public Chain getDNAComplimentary() {
        Chain result = new Chain(
                this.nucleotides.stream()
                        .map(nucleotide -> nucleotideManager.getNucleotide(NucleotideEnum.getDNAComplimentary(nucleotide.getType())))
                        .collect(Collectors.toList())
        );
        this.logger.info("Get complimentary DNA " + this.toString());
        return result;
    }

    public void addNucleotide(Nucleotide nucleotide){
        this.nucleotides.add(nucleotide);
    }

    public Chain getRNAComplimentary() {
        Chain result = new Chain(
                this.nucleotides.stream()
                        .map(nucleotide -> nucleotideManager.getNucleotide(NucleotideEnum.getRNAComplimentary(nucleotide.getType())))
                        .collect(Collectors.toList())
        );
        this.logger.info("Get complimentary RNA " + this.toString());
        return result;
    }

    public void setNucleotide(Integer position, Nucleotide nucleotide) {
        if (position < this.nucleotides.size()) {
            this.nucleotides.set(position, nucleotide);
            this.logger.info("Set nucleotide " + nucleotide.toString() + " on pos " + position.toString());
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    public Nucleotide getNucleotide(Integer position) {
        if (position < this.nucleotides.size()) {
            Nucleotide result = this.nucleotides.get(position);
            this.logger.info("Get nucleotide " + result.toString() + " on pos " + position.toString());
            return result;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    public Integer size() {
        return this.nucleotides.size();
    }

    @Override
    public String toString() {
        return "Chain " + nucleotides;
    }

    public List<Nucleotide> getNucleotides() {
        this.logger.info("Get nucleotides");
        return nucleotides;
    }

    public Chain replicate(Float mutateProbability, Nucleotide[] availableNucleotides) {
        logger.info("Replicate with mutation probability " + mutateProbability.toString());
        List<Nucleotide> resultNucleotides = new ArrayList<>();
        for (int i = 0; i < this.size(); i++)
            if (this.random.nextFloat() < mutateProbability)
                resultNucleotides.add(Nucleotide.getRandomNucleotide(availableNucleotides));
            else
                resultNucleotides.add(this.getNucleotide(i));

        return new Chain(resultNucleotides);
    }

    public void mutate(Float probability, Nucleotide[] availableNucleotides) {
        this.logger.info("Mutate chain");
        for (int i = 0; i < this.nucleotides.size(); i++)
            if (random.nextFloat() < probability)
                this.setNucleotide(i, Nucleotide.getRandomNucleotide(availableNucleotides));
    }

    public Memento createMemento(){
        return new Memento(this.nucleotides);
    }

    public void resetState(Memento mem){
        this.logger.info("Reset state");
        this.nucleotides = new ArrayList<>();
        NucleotideManager manager = NucleotideManager.instance();
        for(Nucleotide nucleotide: mem.mem){
            this.nucleotides.add(manager.getNucleotide(nucleotide.getType()));
        }
    }

    public class Memento {
        private ArrayList<Nucleotide> mem;
        private MyLogger logger;

        public Memento(List<Nucleotide> mem){
            this.mem = new ArrayList<>();
            this.logger = MyLoggerFactory.getLogger(Memento.class.getName());
            this.logger.info("Created memento");
            this.setState(mem);
        }

        private void setState(List<Nucleotide> mem){
            this.logger.info("(MEMENTO) Set state");
            NucleotideManager manager = NucleotideManager.instance();
            for(Nucleotide nucleotide: mem){
                this.mem.add(manager.getNucleotide(nucleotide.getType()));
            }
        }

        private ArrayList<Nucleotide> getState(){
            this.logger.info("(MEMENTO) getState");
            return this.mem;
        }
    }

}
