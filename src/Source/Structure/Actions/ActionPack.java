package Source.Structure.Actions;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;

import java.util.ArrayList;

public class ActionPack {
    private final MyLogger logger;
    private final Replicate replicate;
    private final Mutate mutate;
    private final Splitter splitter;

    public ActionPack(Replicate replicate, Mutate mutate, Splitter splitter){
        this.replicate = replicate;
        this.mutate = mutate;
        this.splitter = splitter;
        this.logger = MyLoggerFactory.getLogger(ActionPack.class.getName());
        this.logger.info("ActionPack created");
    }

    public ArrayList<Gene> mutate(ArrayList<Gene> genes, Float probability, Nucleotide[] availableNucleotides){
        this.logger.info("(INIDERCTION) mutate");
        return this.mutate.mutate(genes, probability, availableNucleotides);
    }

    public ArrayList<Gene> replicate(ArrayList<Gene> genes, Float mutateProbability, Nucleotide[] availableNucleotides){
        this.logger.info("(INIDERCTION) replicate");
        return this.replicate.replicate(genes, mutateProbability, availableNucleotides);
    }

    public Chain split(ArrayList<Gene> genes){
        this.logger.info("(INIDERCTION) split");
        return this.splitter.split(genes);
    }

}
