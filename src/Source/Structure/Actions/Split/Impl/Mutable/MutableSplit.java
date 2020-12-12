package Source.Structure.Actions.Split.Impl.Mutable;

import Source.MyLogger;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Split.Split;

public abstract class MutableSplit implements Split {
    protected Split splitter;
    protected MyLogger logger;
    protected Mutate mutate;


    public MutableSplit(Split splitter, MyLogger logger, Mutate mutate) {
        this.splitter = splitter;
        this.logger = logger;
        this.mutate = mutate;
    }

    @Override
    public String toString() {
        return "MutableSplit{" +
                "splitter=" + splitter +
                '}';
    }
}
