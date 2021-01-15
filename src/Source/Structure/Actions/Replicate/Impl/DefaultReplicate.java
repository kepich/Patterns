package Source.Structure.Actions.Replicate.Impl;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Replicate.Replicate;

import java.util.ArrayList;

public class DefaultReplicate implements Replicate {
    private MyLogger logger;

    public DefaultReplicate() {
        this.logger = MyLoggerFactory.getLogger(DefaultReplicate.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public ArrayList<Gene> replicate(ArrayList<Gene> genes, Float mutateProbability, Nucleotide[] availableNucleotides) {
        this.logger.info("Default replication " + genes);
        ArrayList<Gene> newGenes = new ArrayList<>();
        for (Gene gene : genes) {
            newGenes.add(gene.replicate(mutateProbability, availableNucleotides));
        }
        return newGenes;
    }

    @Override
    public String toString() {
        return "DefaultReplicate{" +
                '}';
    }
}
