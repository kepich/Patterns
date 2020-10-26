import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.DNA.DNAProxy;
import Source.Structure.RNA.RNAProxy;

import java.rmi.UnexpectedException;

public class Runner {
    private MyLogger logger = new MyLogger(Runner.class.getName());

    public Runner() {
    }

    public static void main(String[] args) {
        Runner runner = new Runner();

        try {
            runner.run();
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    private void run() throws UnexpectedException {
        logger.info("Started");
        Nucleotide[] dnaNucleotides = {
                new Nucleotide(NucleotideEnum.CITOZIN),
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.GUANIN),
                new Nucleotide(NucleotideEnum.CITOZIN),
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.GUANIN),
                new Nucleotide(NucleotideEnum.TIMIN)
        };
        DNAProxy dna = new DNAProxy(dnaNucleotides);

        dna.replicate();
        dna.split();
        dna.mutate();

        Nucleotide[] rnaNucleotides = {
                new Nucleotide(NucleotideEnum.URACIL),
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.URACIL),
                new Nucleotide(NucleotideEnum.CITOZIN),
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.GUANIN),
                new Nucleotide(NucleotideEnum.URACIL)
        };
        RNAProxy rna = new RNAProxy(rnaNucleotides);
        rna.replicate();
        rna.split();
        rna.mutate();
    }

}
