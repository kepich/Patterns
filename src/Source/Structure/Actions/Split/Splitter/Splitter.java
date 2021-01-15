package Source.Structure.Actions.Split.Splitter;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;

public abstract class Splitter {
    Split splitterImpl;
    protected MyLogger logger;

    public Splitter(Split splitter, MyLogger logger) {
        this.splitterImpl = splitter;
        this.logger = logger;
        this.logger.info("Splitter created");
    }

    public Chain split(ArrayList<Gene> genes){
        this.logger.info("Split (Splitter)");
        return splitterImpl.split(genes);
    }
}
