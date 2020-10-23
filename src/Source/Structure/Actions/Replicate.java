package Source.Structure.Actions;

import Source.Structure.Acid.Acid;

public interface Replicate {
    Acid replicate(Acid acid, Float mutateProbability);
}
