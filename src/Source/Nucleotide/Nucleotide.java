package Source.Nucleotide;


import Source.MyLogger;

public class Nucleotide {
    private NucleotideEnum type;
    private MyLogger logger = new MyLogger(Nucleotide.class.getName());

    public Nucleotide(NucleotideEnum type){
        this.type = type;
        this.logger.info("Created " + this.toString());
    }

    public NucleotideEnum getType() {
        this.logger.info("Get type: type=" + this.type.name());
        return type;
    }

    @Override
    public String toString() {
        return "Nucleotide {" +
                "type=" + type +
                '}';
    }
}
