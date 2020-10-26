package Source.Structure.Actions.Replicate;

import Source.Gene.Gene;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;

public interface Replicate {
    ArrayList<Gene> replicate(ArrayList<Gene> genes, Float mutateProbability, Nucleotide[] availableNucleotides);
}
