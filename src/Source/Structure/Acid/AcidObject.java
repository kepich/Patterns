package Source.Structure.Acid;

import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;

public abstract class AcidObject {
    protected MyLogger logger;
    public AcidObject(MyLogger logger){
        this.logger = logger;
    }

    public abstract Acid createAcid(ArrayList<Gene> genes);
    public abstract Acid createAcid(Nucleotide[] dna1Nucleotides);
}
