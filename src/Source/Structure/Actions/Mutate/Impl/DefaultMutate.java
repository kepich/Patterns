package Source.Structure.Actions.Mutate.Impl;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Mutate;

import java.util.ArrayList;

public class DefaultMutate implements Mutate {
    private MyLogger logger;

    public DefaultMutate() {
        this.logger = new MyLogger(DefaultMutate.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public ArrayList<Gene> mutate(ArrayList<Gene> genes, Float probability, Nucleotide[] availableNucleotides) {
        logger.info("Default mutate " + genes);
        ArrayList<Gene> newGenes = new ArrayList<>();
        for (Gene gene : genes) {
            newGenes.add(gene.mutate(probability, availableNucleotides));
        }

        return newGenes;
    }

    @Override
    public String toString() {
        return "DefaultMutate{" +
                '}';
    }
}
