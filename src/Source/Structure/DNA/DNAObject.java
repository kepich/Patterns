package Source.Structure.DNA;

import Source.Gene.Gene;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.AcidObject;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class DNAObject extends AcidObject {
    public DNAObject() {
        super(MyLoggerFactory.getLogger(DNAObject.class.getName()));
    }

    @Override
    public DNA createAcid(ArrayList<Gene> genes) {
        this.logger.info("(FACTORY METHOD) Create DNA");
        DNA res = null;
        try {
            res = new DNA(genes);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public Acid createAcid(Nucleotide[] nucleotides) {
        this.logger.info("(FACTORY METHOD) Create DNA");
        DNA res = null;
        try {
            res = new DNA(nucleotides);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return res;
    }
}
