package Source.Gene;

import Source.Chain.Chain;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GeneController {
    private static Random random = new Random();
    private static MyLogger logger = new MyLogger(GeneController.class.getName());

    public static Gene replicate(Gene gene, Float mutateProbability, Nucleotide[] availableNucleotides){
        logger.info("Replicate gene " + gene.toString() + " with mutation probability " + mutateProbability.toString());
        List<Nucleotide> resultNucleotides = new ArrayList<>();
        Chain chain = gene.getChain();
        for (int i = 0; i < chain.size(); i++)
            if (random.nextFloat() < mutateProbability)
                resultNucleotides.add(getRandomNucleotide(availableNucleotides));
            else
                resultNucleotides.add(chain.getNucleotide(i));


        return new Gene(new Chain(resultNucleotides));
    }

    public static Gene mutate(Gene gene, Float probability, Nucleotide[] availableNucleotides){
        logger.info("Mutate gene " + gene.toString() + " with mutation probability " + probability.toString());
        Chain chain = GeneController.replicate(gene, probability, availableNucleotides).getChain();
        for (int i = 0; i < chain.size(); i++)
            if (random.nextFloat() < probability)
                chain.setNucleotide(i, getRandomNucleotide(availableNucleotides));

        return new Gene(chain);
    }

    private static Nucleotide getRandomNucleotide(Nucleotide[] availableNucleotides){
        return availableNucleotides[Math.abs(random.nextInt()) % availableNucleotides.length];
    }

    public static List<Nucleotide> split(Gene gene){
        logger.info("Split gene " + gene.toString());
        return new ArrayList<>(gene.getChain().getNucleotides());
    }
}
