package Source.Nucleotide;


import java.util.Random;

public class Nucleotide {
    private NucleotideEnum type;
    private static Random random = new Random();
    private static NucleotideManager nucleotideManager = NucleotideManager.instance();

    public Nucleotide(NucleotideEnum type) {
        this.type = type;
    }

    public NucleotideEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public static Nucleotide[] getDNANucleotides() {
        return new Nucleotide[]{
                nucleotideManager.getNucleotide(NucleotideEnum.ADENIN),
                nucleotideManager.getNucleotide(NucleotideEnum.GUANIN),
                nucleotideManager.getNucleotide(NucleotideEnum.CITOZIN),
                nucleotideManager.getNucleotide(NucleotideEnum.TIMIN),
        };
    }

    public static Nucleotide[] getRNANucleotides() {
        return new Nucleotide[]{
                nucleotideManager.getNucleotide(NucleotideEnum.ADENIN),
                nucleotideManager.getNucleotide(NucleotideEnum.GUANIN),
                nucleotideManager.getNucleotide(NucleotideEnum.CITOZIN),
                nucleotideManager.getNucleotide(NucleotideEnum.URACIL),
        };
    }

    public static Nucleotide getRandomNucleotide(Nucleotide[] availableNucleotides) {
        return availableNucleotides[Math.abs(random.nextInt()) % availableNucleotides.length];
    }
}
