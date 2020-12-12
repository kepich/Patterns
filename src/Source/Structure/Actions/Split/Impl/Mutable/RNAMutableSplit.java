package Source.Structure.Actions.Split.Impl.Mutable;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;

public class RNAMutableSplit extends MutableSplit {
    public RNAMutableSplit(Split splitter) {
        super(splitter, new MyLogger(RNAMutableSplit.class.getName()), new DefaultMutate());
        this.logger.info("Created RNAMutableSplit");
    }

    @Override
    public Chain split(ArrayList<Gene> genes) {
        this.logger.info("Mutation RNA...");
        ArrayList<Gene> newGenes = mutate.mutate(genes, 0.07f, Nucleotide.getRNANucleotides());
        return this.splitter.split(newGenes);
    }

    @Override
    public String toString() {
        return "RNAMutableSplit{" +
                "mutate=" + mutate +
                ", splitter=" + splitter +
                '}';
    }
}
