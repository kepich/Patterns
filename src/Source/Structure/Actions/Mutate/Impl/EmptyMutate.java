package Source.Structure.Actions.Mutate.Impl;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Mutate;

import java.util.ArrayList;

public class EmptyMutate implements Mutate {
    private MyLogger logger;

    public EmptyMutate() {
        this.logger = MyLoggerFactory.getLogger(EmptyMutate.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public ArrayList<Gene> mutate(ArrayList<Gene> genes, Float probability, Nucleotide[] availableNucleotides) {
        logger.info("Empty mutate " + genes);
        return null;
    }

    @Override
    public String toString() {
        return "EmptyMutate{" +
                '}';
    }
}
