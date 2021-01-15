package Source.Structure.Acid.Factory;

import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;

public abstract class AcidFact {
    protected MyLogger logger;

    public AcidFact(MyLogger logger){
        this.logger = logger;
    }

    public abstract Mutate getMutator();
    public abstract Replicate getReplicator();
    public abstract Splitter getSplitter();
    public abstract Acid getAcid(Nucleotide[] nucleotides);
}
