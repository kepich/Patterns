package Source.Structure.Actions.Factory;

import Source.Structure.Actions.Split.Impl.DefaultSplit;
import Source.Structure.Actions.Split.Impl.EmptySplit;
import Source.Structure.Actions.Split.Impl.Mutable.RNAMutableSplit;
import Source.Structure.Actions.Split.Splitter.RNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;

public class RNAActionFactory extends ActionFactory {
    @Override
    public Splitter getDefaultSplitter() {
        return new RNASplitter(new DefaultSplit());
    }

    @Override
    public Splitter getEmptySplitter() {
        return new RNASplitter(new EmptySplit());
    }

    @Override
    public Splitter getMutableSplitter() {
        return new RNASplitter(new RNAMutableSplit(new DefaultSplit()));
    }
}
