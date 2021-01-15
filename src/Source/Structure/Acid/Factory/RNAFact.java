package Source.Structure.Acid.Factory;

import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Impl.EmptyMutate;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Impl.DefaultReplicate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Impl.EmptySplit;
import Source.Structure.Actions.Split.Splitter.RNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;
import Source.Structure.RNA.RNA;

import java.rmi.UnexpectedException;

public class RNAFact extends AcidFact {
    public RNAFact() {
        super(MyLoggerFactory.getLogger(RNAFact.class.getName()));
        logger.info("(FACT) RNAFact created");
    }

    @Override
    public Mutate getMutator() {
        logger.info("(FACT) Get Empty mutator");
        return new EmptyMutate();
    }

    @Override
    public Replicate getReplicator() {
        logger.info("(FACT) Get Default replicator");
        return new DefaultReplicate();
    }

    @Override
    public Splitter getSplitter() {
        logger.info("(FACT) Get Empty splitter");
        return new RNASplitter(new EmptySplit());
    }

    @Override
    public RNA getAcid(Nucleotide[] nucleotides) {
        logger.info("(FACT) Get RNA splitter");
        RNA res = null;
        try {
            res = new RNA(
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
