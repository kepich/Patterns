package Source.Chain.Context;

import Source.Chain.Chain;
import Source.MyLogger;

public abstract class ChainState {
    protected String stringTail;
    protected MyLogger logger;

    public ChainState(MyLogger logger, String seq){
        this.logger = logger;
        this.stringTail = seq;
    }

    public abstract ChainState addNucleotide(Chain chain);
}
