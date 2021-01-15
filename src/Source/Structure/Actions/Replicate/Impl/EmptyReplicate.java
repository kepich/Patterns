package Source.Structure.Actions.Replicate.Impl;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Replicate.Replicate;

import java.util.ArrayList;

public class EmptyReplicate implements Replicate {
    private MyLogger logger;

    public EmptyReplicate() {
        this.logger = MyLoggerFactory.getLogger(EmptyReplicate.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public ArrayList<Gene> replicate(ArrayList<Gene> genes, Float mutateProbability, Nucleotide[] availableNucleotides) {
        this.logger.info("Empty replication " + genes);
        return null;
    }

    @Override
    public String toString() {
        return "EmptyReplicate{" +
                '}';
    }
}
