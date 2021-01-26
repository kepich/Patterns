package Source.Gene;

import Source.Chain.Chain;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;
import java.util.List;

public class Gene {
    private Chain chain;
    private MyLogger logger = MyLoggerFactory.getLogger(Gene.class.getName());

    public Gene(Chain chain) {
        this.chain = chain;
        this.logger.info("Created " + this.toString());
    }

    public Chain getChain() {
        return this.chain;
    }

    public void setChain(Chain chain) {
        this.logger.info("Set chain " + chain.toString());
        this.chain = chain;
    }

    public Gene replicate(Float mutateProbability, Nucleotide[] availableNucleotides) {
        logger.info("Replicate with mutation probability " + mutateProbability.toString());
        return new Gene(this.getChain().replicate(mutateProbability, availableNucleotides));
    }

    public Gene mutate(Float probability, Nucleotide[] availableNucleotides) {
        logger.info("Mutate with mutation probability " + probability.toString());
        Chain chain = this.replicate(probability, availableNucleotides).getChain();
        chain.mutate(probability, availableNucleotides);
        return new Gene(chain);
    }

    public List<Nucleotide> split() {
        this.logger.info("Split " + this.toString());
        return new ArrayList<>(this.getChain().getNucleotides());
    }

    @Override
    public String toString() {
        return "Gene {" +
                "chain=" + chain +
                '}';
    }
}
