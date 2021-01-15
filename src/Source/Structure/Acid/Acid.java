package Source.Structure.Acid;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Actions.ActionPack;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;
import jdk.jshell.spi.ExecutionControl;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public abstract class Acid implements IAcid {
    protected ArrayList<Gene> genes;
    protected MyLogger logger;
    protected ActionPack actionPack;

    public Acid(Replicate replicate, Mutate mutate, Splitter splitter, MyLogger logger) {
        this.actionPack = new ActionPack(replicate, mutate, splitter);
        this.logger = logger;
    }

    protected void validateGenes(ArrayList<Gene> genes) throws ExecutionControl.NotImplementedException, UnexpectedException {
        throw new ExecutionControl.NotImplementedException("validateGenes() is not implemented");
    }
}
