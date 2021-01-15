package Source.Structure.RNA;

import Source.Gene.Gene;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.AcidObject;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class RNAObject extends AcidObject {
    public RNAObject() {
        super(MyLoggerFactory.getLogger(RNAObject.class.getName()));
    }

    @Override
    public RNA createAcid(ArrayList<Gene> genes) {
        this.logger.info("(FACTORY METHOD) Create RNA");
        RNA res = null;
        try {
            res = new RNA(genes);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public Acid createAcid(Nucleotide[] nucleotides) {
        this.logger.info("(FACTORY METHOD) Create RNA");
        RNA res = null;
        try {
            res = new RNA(nucleotides);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return res;
    }
}
