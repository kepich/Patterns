package Source.Chain.Context;

import Source.Chain.Chain;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;

public class ChainStartNucleotideSeq extends ChainState {
    public ChainStartNucleotideSeq(String seq) {
        super(MyLoggerFactory.getLogger(ChainStartNucleotideSeq.class.getName()), seq);
        logger.info("ChainStartNucleotideSeq created");
    }

    @Override
    public ChainState addNucleotide(Chain chain) {
        logger.info("ChainStartNucleotideSeq add nucleotide");
        if(this.stringTail.isEmpty()){
            return null;
        } else {
            logger.info("" + this.stringTail.charAt(0));
            chain.addNucleotide(
                    switch (this.stringTail.charAt(0)){
                        case 'G' -> new Nucleotide(NucleotideEnum.GUANIN);
                        case 'C' -> new Nucleotide(NucleotideEnum.CITOZIN);
                        case 'T' -> new Nucleotide(NucleotideEnum.TIMIN);
                        case 'U' -> new Nucleotide(NucleotideEnum.URACIL);
                        default -> new Nucleotide(NucleotideEnum.ADENIN);
                    }
            );
            return new ChainAddingNucleotideSeq(this.stringTail.substring(1));
        }
    }
}
