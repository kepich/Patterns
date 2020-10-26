package Source.Nucleotide;


import Source.MyLogger;

import java.util.Random;

public class Nucleotide {
    private NucleotideEnum type;
    private MyLogger logger = new MyLogger(Nucleotide.class.getName());
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
        switch (type) {
            case TIMIN:
                return NucleotideEnum.ADENIN;
            case ADENIN:
                return NucleotideEnum.TIMIN;
            case GUANIN:
                return NucleotideEnum.CITOZIN;
            case CITOZIN:
                return NucleotideEnum.GUANIN;
            default:
                return null;
        }
    }

    public static NucleotideEnum getRNAComplimentary(NucleotideEnum type) {
        switch (type) {
            case TIMIN:
                return NucleotideEnum.ADENIN;
            case ADENIN:
                return NucleotideEnum.TIMIN;
            case GUANIN:
                return NucleotideEnum.URACIL;
            case URACIL:
                return NucleotideEnum.GUANIN;
            default:
                return null;
        }
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
