package Source.Structure.Actions.Factory;

import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Mutate.Impl.EmptyMutate;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Impl.DefaultReplicate;
import Source.Structure.Actions.Replicate.Impl.EmptyReplicate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;

public abstract class ActionFactory {
    public abstract Splitter getDefaultSplitter();
    public abstract Splitter getEmptySplitter();
    public abstract Splitter getMutableSplitter();

    public Replicate getDefaultReplicate(){
        return new DefaultReplicate();
    }

    public Replicate getEmptyReplicate(){
        return new EmptyReplicate();
    }

    public Mutate getDefaultMutate(){
        return new DefaultMutate();
    }

    public Mutate getEmptyMutate(){
        return new EmptyMutate();
    }
}
