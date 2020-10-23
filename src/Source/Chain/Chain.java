package Source.Chain;

import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideController;

import java.util.List;
import java.util.stream.Collectors;

public class Chain {
    private List<Nucleotide> nucleotides;
    private MyLogger logger = new MyLogger(Chain.class.getName());

    public Chain(List<Nucleotide> nucleotides){
        this.nucleotides = nucleotides;
        this.logger.info("Created " + this.toString());
    }

    public Chain getDNAComplimentary(){
        Chain result = new Chain(
                this.nucleotides.stream()
                        .map(nucleotide -> new Nucleotide(NucleotideController.getDNAComplimentary(nucleotide.getType())))
                        .collect(Collectors.toList())
        );
        this.logger.info("Get complimentary DNA " + this.toString());
        return result;
    }

    public Chain getRNAComplimentary(){
        Chain result = new Chain(
                this.nucleotides.stream()
                        .map(nucleotide -> new Nucleotide(NucleotideController.getRNAComplimentary(nucleotide.getType())))
                        .collect(Collectors.toList())
        );
        this.logger.info("Get complimentary RNA " + this.toString());
        return result;
    }

    public void setNucleotide(Integer position, Nucleotide nucleotide){
        if (position < this.nucleotides.size()){
            this.nucleotides.set(position, nucleotide);
            this.logger.info("Set nucleotide " + nucleotide.toString() + " on pos " + position.toString());
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    public Nucleotide getNucleotide(Integer position){
        if (position < this.nucleotides.size()){
            Nucleotide result = this.nucleotides.get(position);
            this.logger.info("Get nucleotide " + result.toString() + " on pos " + position.toString());
            return result;
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    public Integer size(){
        return this.nucleotides.size();
    }

    @Override
    public String toString() {
        return "Chain {" +
                "nucleotides=" + nucleotides + '}';
    }

    public List<Nucleotide> getNucleotides() {
        this.logger.info("Get nucleotides");
        return nucleotides;
    }
}
