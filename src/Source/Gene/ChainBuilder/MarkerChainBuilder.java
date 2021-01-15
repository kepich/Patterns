package Source.Gene.ChainBuilder;

import Source.Chain.Chain;
import Source.MyLogger;

import java.util.ArrayList;

public abstract class MarkerChainBuilder {
    protected Chain result;
    protected MyLogger logger;

    public MarkerChainBuilder(MyLogger logger){
        this.logger = logger;
        this.result = new Chain(new ArrayList<>());
    }

    public abstract void addStartNucleotide();
    public abstract void addAlphaNucleotide();
    public abstract void addBetaNucleotide();
    public abstract void addFinishNucleotide();

    public Chain getResult(){
        this.logger.info("(Builder) Get result");
        return result;
    }
}
