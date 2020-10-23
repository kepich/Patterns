package Source.Chain;

import Source.Gene.Gene;
import Source.Gene.GeneController;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;

import java.util.ArrayList;
import java.util.List;

public abstract class ChainController {
    public static Chain split(Acid acid) {
        List<Nucleotide> nucleotides = new ArrayList<>();
        for (Gene gene: acid.getGenes())
            nucleotides.addAll(GeneController.split(gene));

        return new Chain(nucleotides);
    }
}
