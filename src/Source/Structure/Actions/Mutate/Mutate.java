package Source.Structure.Actions.Mutate;

import Source.Gene.Gene;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;

public interface Mutate {
    ArrayList<Gene> mutate(ArrayList<Gene> genes, Float probability, Nucleotide[] availableNucleotides);
}
