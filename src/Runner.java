import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Gene.GeneController;
import Source.Nucleotide.*;
import Source.MyLogger;
import Source.Structure.DNA.DNA;
import Source.Structure.DNA.DNAController;
import Source.Structure.RNA.RNA;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private MyLogger logger = new MyLogger(Runner.class.getName());

    public Runner(){
    }

    public static void main(String[] args){
        Runner runner = new Runner();
        runner.run();
    }

    private void run(){
        logger.info("Started");
        List<Nucleotide> nucleotides1 = new ArrayList<>();

        nucleotides1.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.ADENIN)));
        nucleotides1.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.GUANIN)));
        nucleotides1.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.TIMIN)));
        nucleotides1.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.CITOZIN)));

        Chain chain1 = new Chain(nucleotides1);
        Gene gene1 = new Gene(chain1);

        List<Nucleotide> nucleotides2 = new ArrayList<>();

        nucleotides2.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.CITOZIN)));
        nucleotides2.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.TIMIN)));
        nucleotides2.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.ADENIN)));
        nucleotides2.add(new Nucleotide(NucleotideController.getDNAComplimentary(NucleotideEnum.GUANIN)));

        Chain chain2 = new Chain(nucleotides2);
        Gene gene2 = new Gene(chain2);

        ArrayList<Gene> genes = new ArrayList<>();
        genes.add(gene1);
        genes.add(gene2);
        DNA dna = new DNA(genes);

        dna.replicate();
        dna.split();
        dna.mutate();

        RNA rna = new RNA(genes);

        rna.replicate();
        rna.split();
        rna.mutate();
    }

}
