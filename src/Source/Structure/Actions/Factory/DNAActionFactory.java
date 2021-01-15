package Source.Structure.Actions.Factory;

import Source.Structure.Actions.Split.Impl.DefaultSplit;
import Source.Structure.Actions.Split.Impl.EmptySplit;
import Source.Structure.Actions.Split.Impl.Mutable.DNAMutableSplit;
import Source.Structure.Actions.Split.Splitter.DNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;

public class DNAActionFactory extends ActionFactory {
    @Override
    public Splitter getDefaultSplitter() {
        return new DNASplitter(new DefaultSplit());
    }

    @Override
    public Splitter getEmptySplitter() {
        return new DNASplitter(new EmptySplit());
    }

    @Override
    public Splitter getMutableSplitter() {
        return new DNASplitter(new DNAMutableSplit(new DefaultSplit()));
    }
}
