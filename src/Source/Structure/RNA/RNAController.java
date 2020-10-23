package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Gene.GeneController;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideController;

import java.util.ArrayList;
import java.util.List;

public class RNAController {
    private static final Float mutationProbability = 0.1f;
    private static MyLogger logger = new MyLogger(RNAController.class.getName());

    public static RNA replicateRNA(RNA rna){
        logger.info("Replicate RNA " + rna.toString());

        ArrayList<Gene> newGenes = new ArrayList<>();
        for(Gene gene: rna.getGenes()){
            newGenes.add(GeneController.replicate(gene, mutationProbability, NucleotideController.getDNANucleotides()));
        }

        return new RNA(newGenes);
    }

    public static Chain splitRNA(RNA rna){
        List<Nucleotide> nucleotides = new ArrayList<>();
        for (Gene gene: rna.getGenes())
            nucleotides.addAll(gene.getChain().getNucleotides());

        logger.info("Split RNA " + rna.toString() + " to chain " + nucleotides.toString());
        return new Chain(nucleotides);
    }
}
