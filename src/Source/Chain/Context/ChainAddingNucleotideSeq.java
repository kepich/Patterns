package Source.Chain.Context;

import Source.Chain.Chain;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;

public class ChainAddingNucleotideSeq extends ChainState {
    public ChainAddingNucleotideSeq(String seq) {
        super(MyLoggerFactory.getLogger(ChainStartNucleotideSeq.class.getName()), seq);
        logger.info("ChainAddingNucleotideSeq created");
    }

    @Override
    public ChainState addNucleotide(Chain chain) {
        logger.info("ChainAddingNucleotideSeq add nucleotide");
        if(this.stringTail.isEmpty()){
            return new ChainEndNucleotideSeq("");
        } else {
            logger.info("" + this.stringTail.charAt(0));
            switch (this.stringTail.charAt(0)){
                case 'G':
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.GUANIN));
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.CITOZIN));
                case 'C':
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.GUANIN));
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.ADENIN));
                case 'T':
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.TIMIN));
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.TIMIN));
                case 'U':
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.URACIL));
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.URACIL));
                default:
                    chain.addNucleotide(new Nucleotide(NucleotideEnum.ADENIN));
            }
            return new ChainAddingNucleotideSeq(this.stringTail.substring(1));
        }
    }
}
