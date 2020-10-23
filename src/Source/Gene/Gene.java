package Source.Gene;

import Source.Chain.Chain;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;

public class Gene {
    private Chain chain;
    private MyLogger logger = new MyLogger(Gene.class.getName());

    public Gene(Chain chain){
        this.chain = chain;
        this.logger.info("Created " + this.toString());
    }

    public Chain getChain() {
        this.logger.info("Get chain " + this.chain.toString());
        return this.chain;
    }

    public void setChain(Chain chain){
        this.logger.info("Set chain " + chain.toString());
        this.chain = chain;
    }

    public Nucleotide getNucleotide(Integer pos){
        Nucleotide result = this.chain.getNucleotide(pos);
        this.logger.info("Get nucleotide " + chain.toString());

        return result;
    }

    public void setNucleotide(Integer pos, Nucleotide nucleotide){
        this.logger.info("Set nucleotide " + nucleotide.toString() + "  to pos " + pos.toString());
        this.chain.setNucleotide(pos, nucleotide);
    }

    @Override
    public String toString() {
        return "Gene {" +
                "chain=" + chain +
                '}';
    }
}
