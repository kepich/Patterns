package Source.Structure.Actions.Split;

import Source.Chain.Chain;
import Source.Gene.Gene;

import java.util.ArrayList;

public interface Split {
    Chain split(ArrayList<Gene> genes);
}
