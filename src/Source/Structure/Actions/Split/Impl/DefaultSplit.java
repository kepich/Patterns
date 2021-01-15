package Source.Structure.Actions.Split.Impl;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;
import java.util.List;

public class DefaultSplit implements Split {
    private MyLogger logger;

    public DefaultSplit() {
        this.logger = MyLoggerFactory.getLogger(DefaultSplit.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public Chain split(ArrayList<Gene> genes) {
        logger.info("Default split " + genes);
        List<Nucleotide> nucleotides = new ArrayList<>();
        for (Gene gene : genes)
            nucleotides.addAll(gene.split());

        return new Chain(nucleotides);
    }

    @Override
    public String toString() {
        return "DefaultSplit{" +
                '}';
    }
}
