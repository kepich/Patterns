package Source.Structure.Actions.Split.Impl;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;

public class EmptySplit implements Split {
    private MyLogger logger;

    public EmptySplit() {
        this.logger = MyLoggerFactory.getLogger(EmptySplit.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public Chain split(ArrayList<Gene> genes) {
        logger.info("Empty split " + genes);
        return null;
    }

    @Override
    public String toString() {
        return "EmptySplit{" +
                '}';
    }
}
