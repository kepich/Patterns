package Source.Structure.Acid;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Actions.Mutate;
import Source.Structure.Actions.Replicate;
import Source.Structure.Actions.Split;

import java.util.ArrayList;

public abstract class Acid implements IAcid{
    protected ArrayList<Gene> genes;
    protected MyLogger logger;
    protected Replicate replicate;
    protected Split split;
    protected Mutate mutate;
}
