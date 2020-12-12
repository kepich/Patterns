package Source.Nucleotide;


import java.util.Random;

public class Nucleotide {
    private NucleotideEnum type;
    private static Random random = new Random();

    public Nucleotide(NucleotideEnum type) {
        this.type = type;
    }

    public NucleotideEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Nucleotide {" +
                "type=" + type +
                '}';
    }

    public static NucleotideEnum getDNAComplimentary(NucleotideEnum type) {
        return switch (type) {
            case TIMIN -> NucleotideEnum.ADENIN;
            case ADENIN -> NucleotideEnum.TIMIN;
            case GUANIN -> NucleotideEnum.CITOZIN;
            case CITOZIN -> NucleotideEnum.GUANIN;
            default -> null;
        };
    }

    public static NucleotideEnum getRNAComplimentary(NucleotideEnum type) {
        return switch (type) {
            case TIMIN -> NucleotideEnum.ADENIN;
            case ADENIN -> NucleotideEnum.TIMIN;
            case GUANIN -> NucleotideEnum.URACIL;
            case URACIL -> NucleotideEnum.GUANIN;
            default -> null;
        };
    }

    public static Nucleotide[] getDNANucleotides() {
        return new Nucleotide[]{
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.GUANIN),
                new Nucleotide(NucleotideEnum.CITOZIN),
                new Nucleotide(NucleotideEnum.TIMIN),
        };
    }

    public static Nucleotide[] getRNANucleotides() {
        return new Nucleotide[]{
                new Nucleotide(NucleotideEnum.ADENIN),
                new Nucleotide(NucleotideEnum.GUANIN),
                new Nucleotide(NucleotideEnum.CITOZIN),
                new Nucleotide(NucleotideEnum.URACIL),
        };
    }

    public static Nucleotide getRandomNucleotide(Nucleotide[] availableNucleotides) {
        return availableNucleotides[Math.abs(random.nextInt()) % availableNucleotides.length];
    }
}
