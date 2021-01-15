package Source.Structure.Actions.Split.Splitter;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Structure.Actions.Split.Split;

import java.util.ArrayList;

public class DNASplitter extends Splitter {
    public DNASplitter(Split splitter) {
        super(splitter, MyLoggerFactory.getLogger(DNASplitter.class.getName()));
    }

    @Override
    public Chain split(ArrayList<Gene> genes) {
        return super.split(genes);
    }
}
