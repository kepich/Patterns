package Source.Chain.Virus;

import Source.Chain.Chain;
import Source.Chain.Virus.Visitor.VisitorVirus;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;

public class CRISPAdenineSwapper extends Virus {
    public CRISPAdenineSwapper(Chain chain) {
        super(MyLoggerFactory.getLogger(CRISPAdenineSwapper.class.getName()), chain);
        this.logger.info("(COMMAND) CRISPAdenineSwapper created");
    }

    @Override
    public void execute(Nucleotide[] nucleotides) {
        this.logger.info("(COMMAND) CRISPAdenineSwapper execute");
        int pos = 0;
        for(int i = 0; (i < this.chain.size()) && (pos < nucleotides.length); i++){
            if (this.chain.getNucleotide(i).getType() == NucleotideEnum.ADENIN){
                this.chain.setNucleotide(i, nucleotides[pos++]);
            }
        }

    }

    @Override
    public void accept(VisitorVirus visitorVirus) {
        visitorVirus.visit(this);
    }
}
