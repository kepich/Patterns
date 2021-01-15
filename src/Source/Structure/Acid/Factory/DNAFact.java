package Source.Structure.Acid.Factory;

import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Impl.DefaultReplicate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Impl.DefaultSplit;
import Source.Structure.Actions.Split.Impl.Mutable.DNAMutableSplit;
import Source.Structure.Actions.Split.Splitter.DNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;
import Source.Structure.DNA.DNA;

import java.rmi.UnexpectedException;

public class DNAFact extends AcidFact {
    public DNAFact() {
        super(MyLoggerFactory.getLogger(DNAFact.class.getName()));
        logger.info("(FACT) DNAFact created");
    }

    @Override
    public Mutate getMutator() {
        logger.info("(FACT) Get Default mutator");
        return new DefaultMutate();
    }

    @Override
    public Replicate getReplicator() {
        logger.info("(FACT) Get Default replicator");
        return new DefaultReplicate();
    }

    @Override
    public Splitter getSplitter() {
        logger.info("(FACT) Get Mutable splitter");
        return new DNASplitter(new DNAMutableSplit(new DefaultSplit()));
    }

    @Override
    public DNA getAcid(Nucleotide[] nucleotides) {
        logger.info("(FACT) Get DNA splitter");
        DNA res = null;
        try {
            res = new DNA(
                    nucleotides,
                    getReplicator(),
                    getMutator(),
                    getSplitter()
            );
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return res;
    }
}
