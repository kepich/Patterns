package Source.Structure.Actions.Split.Impl.Mutable;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;

public class DNAMutableSplit extends MutableSplit {
    public DNAMutableSplit(Split splitter) {
        super(splitter, MyLoggerFactory.getLogger(DNAMutableSplit.class.getName()), new DefaultMutate());
        this.logger.info("Created DNAMutableSplit");
    }

    @Override
    public Chain split(ArrayList<Gene> genes) {
        this.logger.info("Mutation DNA...");
        ArrayList<Gene> newGenes = mutate.mutate(genes, 0.07f, Nucleotide.getDNANucleotides());
        return this.splitter.split(newGenes);
    }

    @Override
    public String toString() {
        return "DNAMutableSplit{" +
                "mutate=" + mutate +
                ", splitter=" + splitter +
                '}';
    }
}
