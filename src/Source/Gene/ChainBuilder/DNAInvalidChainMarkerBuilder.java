package Source.Gene.ChainBuilder;

import Source.MyLoggerFactory;
import Source.Nucleotide.NucleotideEnum;
import Source.Nucleotide.NucleotideManager;

public class DNAInvalidChainMarkerBuilder extends MarkerChainBuilder {
    public DNAInvalidChainMarkerBuilder() {
        super(MyLoggerFactory.getLogger(DNAInvalidChainMarkerBuilder.class.getName()));
        this.logger.info("DNAInvalidChainMarkerBuilder created");
    }

    @Override
    public void addStartNucleotide() {
        this.logger.info("Add start nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.ADENIN));
    }

    @Override
    public void addAlphaNucleotide() {
        this.logger.info("Add alpha nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.GUANIN));
    }

    @Override
    public void addBetaNucleotide() {
        this.logger.info("Add beta nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.GUANIN));

    }

    @Override
    public void addFinishNucleotide() {
        this.logger.info("Add finish nucleotide");
        this.result.addNucleotide(NucleotideManager.instance().getNucleotide(NucleotideEnum.TIMIN));
    }
}
