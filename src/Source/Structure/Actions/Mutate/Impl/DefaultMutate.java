package Source.Structure.Actions.Mutate.Impl;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Mutate.RandomGenerators.DefaultRandomGenerator;
import Source.Structure.Actions.Mutate.RandomGenerators.GaussianRandomGenerator;
import Source.Structure.Actions.Mutate.RandomGenerators.IRandomGenerator;

import java.util.ArrayList;

public class DefaultMutate implements Mutate {
    private MyLogger logger;
    private IRandomGenerator generator;

    public DefaultMutate() {
        this.logger = MyLoggerFactory.getLogger(DefaultMutate.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public ArrayList<Gene> mutate(ArrayList<Gene> genes, Float probability, Nucleotide[] availableNucleotides) {
        logger.info("Default mutate " + genes);
        ArrayList<Gene> newGenes = new ArrayList<>();

        if (probability > 0.03){
            this.generator = new DefaultRandomGenerator();
        } else{
            this.generator = new GaussianRandomGenerator();
        }

        for (Gene gene : genes) {
            newGenes.add(gene.mutate(this.generator.getRandomFloat(), availableNucleotides));
        }

        return newGenes;
    }

    @Override
    public String toString() {
        return "DefaultMutate{" +
                '}';
    }
}
