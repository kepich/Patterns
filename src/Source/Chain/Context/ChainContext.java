package Source.Chain.Context;

import Source.Chain.Chain;
import Source.MyLogger;
import Source.MyLoggerFactory;

import java.util.ArrayList;

public class ChainContext {
    private MyLogger logger;
    private String seq;
    public ChainContext(String seq){
        this.seq = seq;
        this.logger = MyLoggerFactory.getLogger(ChainContext.class.getName());
        logger.info("ChainContext created");
    }

    public Chain generateChain(){
        logger.info("ChainContext generateChain");
        Chain res = new Chain(new ArrayList<>());
        ChainState chainState = new ChainStartNucleotideSeq(this.seq);
        while (chainState != null){
            logger.info("ChainContext next state");
            chainState = chainState.addNucleotide(res);
        }

        return res;
    }
}
