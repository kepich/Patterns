package Source.Structure.Acid;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Split;
import jdk.jshell.spi.ExecutionControl;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public abstract class Acid implements IAcid {
    protected ArrayList<Gene> genes;
    protected MyLogger logger;
    protected Replicate replicate;
    protected Split split;
    protected Mutate mutate;

    protected void validateGenes(ArrayList<Gene> genes) throws ExecutionControl.NotImplementedException, UnexpectedException {
        throw new ExecutionControl.NotImplementedException("validateGenes() is not implemented");
    }
}
