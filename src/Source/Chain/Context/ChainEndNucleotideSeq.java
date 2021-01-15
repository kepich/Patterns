package Source.Chain.Context;

import Source.Chain.Chain;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;

public class ChainEndNucleotideSeq extends ChainState {
    public ChainEndNucleotideSeq(String seq) {
        super(MyLoggerFactory.getLogger(ChainEndNucleotideSeq.class.getName()), seq);
        logger.info("ChainEndNucleotideSeq created");
    }

    @Override
    public ChainState addNucleotide(Chain chain) {
        logger.info("ChainEndNucleotideSeq add nucleotide");
        chain.addNucleotide(new Nucleotide(NucleotideEnum.GUANIN));
        chain.addNucleotide(new Nucleotide(NucleotideEnum.GUANIN));
        chain.addNucleotide(new Nucleotide(NucleotideEnum.GUANIN));
        return null;
    }
}
