package Source.Structure.Actions;

import Source.Structure.Acid.Acid;

public interface Mutate {
    Acid mutate(Acid acid, Float probability);
}
