package Source.Gene.ChainBuilder;

import Source.MyLoggerFactory;
import Source.Nucleotide.NucleotideEnum;
import Source.Nucleotide.NucleotideManager;

public class RNAInvalidChainMarkerBuilder extends MarkerChainBuilder {
    public RNAInvalidChainMarkerBuilder() {
        super(MyLoggerFactory.getLogger(RNAInvalidChainMarkerBuilder.class.getName()));
        this.logger.info("DNAInvalidChainMarkerBuilder created");
    }

    @Override
    public void addStartNucleotide() {
        this.logger.info("Add start nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.GUANIN));
    }

    @Override
    public void addAlphaNucleotide() {
        this.logger.info("Add alpha nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.CITOZIN));
    }

    @Override
    public void addBetaNucleotide() {
        this.logger.info("Add beta nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.CITOZIN));

    }

    @Override
    public void addFinishNucleotide() {
        this.logger.info("Add finish nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.URACIL));
    }
}
