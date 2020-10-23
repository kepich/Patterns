package Source.Structure.Acid;

import Source.Gene.Gene;
import Source.Gene.GeneController;
import Source.Nucleotide.NucleotideController;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

public abstract class AcidController {
    public static ArrayList<Gene> mutate(Acid acid, Float mutateProbability){
        ArrayList<Gene> newGenes = new ArrayList<>();
        for(Gene gene: acid.getGenes()){
            newGenes.add(GeneController.mutate(gene, mutateProbability, NucleotideController.getDNANucleotides()));
        }

        return newGenes;
    }

    public static ArrayList<Gene> replicate(Acid acid, Float mutateProbability) {
        ArrayList<Gene> newGenes = new ArrayList<>();
        for(Gene gene: acid.getGenes()){
            newGenes.add(GeneController.replicate(gene, mutateProbability, NucleotideController.getDNANucleotides()));
        }
        return newGenes;
    }
}
