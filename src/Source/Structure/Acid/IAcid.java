package Source.Structure.Acid;

import Source.Chain.Chain;
import Source.Gene.Gene;

import java.util.ArrayList;

public interface IAcid {
    void setGene(Gene gene, Integer position);
    void addGene(Gene gene);
    Gene getGene(Integer position);
    ArrayList<Gene> getGenes();
    Acid replicate();
    Chain split();
    Acid mutate();
}
