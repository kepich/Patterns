package Source.Nucleotide;


import Source.MyLogger;

public class Nucleotide {
    private NucleotideEnum type;
    private MyLogger logger = new MyLogger(Nucleotide.class.getName());

    public Nucleotide(NucleotideEnum type){
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
}
