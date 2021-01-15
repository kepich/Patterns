package Source.Nucleotide;

public enum NucleotideEnum {
    ADENIN,
    GUANIN,
    TIMIN,
    CITOZIN,
    URACIL;

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
}
