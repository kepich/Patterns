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

    public void addNucleotide(Nucleotide nucleotide){
        this.nucleotides.add(nucleotide);
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
}
