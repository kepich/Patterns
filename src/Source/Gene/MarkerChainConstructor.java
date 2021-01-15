package Source.Gene;

import Source.Chain.Chain;
import Source.Gene.ChainBuilder.MarkerChainBuilder;
import Source.MyLogger;
import Source.MyLoggerFactory;

public class MarkerChainConstructor {
    private MyLogger logger;
    private MarkerChainBuilder builder;

    public MarkerChainConstructor(MarkerChainBuilder builder){
        this.logger = MyLoggerFactory.getLogger(MarkerChainConstructor.class.getName());
        this.builder = builder;
        this.logger.info("Created MarkerChainConstructor");
    }

    public Chain construct(){
        builder.addStartNucleotide();
        builder.addAlphaNucleotide();
        builder.addBetaNucleotide();
        builder.addFinishNucleotide();

        return builder.getResult();
    }
}
