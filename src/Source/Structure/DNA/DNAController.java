package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Gene.GeneController;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideController;

import java.util.ArrayList;
import java.util.List;

public abstract class DNAController {
    private static final Float mutationProbability = 0.1f;
    private static MyLogger logger = new MyLogger(DNAController.class.getName());

    public static DNA replicateDNA(DNA dna){
        logger.info("Replicate DNA " + dna.toString());

        ArrayList<Gene> newGenes = new ArrayList<>();
        for(Gene gene: dna.getGenes()){
            newGenes.add(GeneController.replicate(gene, mutationProbability, NucleotideController.getDNANucleotides()));
        }

        return new DNA(newGenes);
    }

    public static Chain splitDNA(DNA dna){
        List<Nucleotide> nucleotides = new ArrayList<>();
        for (Gene gene: dna.getGenes())
            nucleotides.addAll(gene.getChain().getNucleotides());

        logger.info("Split DNA " + dna.toString() + " to chain " + nucleotides.toString());
        return new Chain(nucleotides);
    }
}
