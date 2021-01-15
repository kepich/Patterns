package Source.Chain.Virus;

import Source.Chain.Chain;
import Source.Chain.Virus.Visitor.VisitorVirus;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;

public class CRISPAdenineAdder extends Virus {
    public CRISPAdenineAdder(Chain chain) {
        super(MyLoggerFactory.getLogger(CRISPAdenineAdder.class.getName()), chain);
        this.logger.info("(COMMAND) CRISPAdenineAdder created");
    }

    @Override
    public void execute(Nucleotide[] nucleotides) {
        this.logger.info("(COMMAND) CRISPAdenineAdder execute");
        int pos = 0;
        for(int i = 0; (i < this.chain.size()) && (pos < nucleotides.length); i++){
            if (this.chain.getNucleotide(i).getType() == NucleotideEnum.ADENIN){
                this.chain.addNucleotide(nucleotides[pos++]);
            }
        }
    }

    @Override
    public void accept(VisitorVirus visitorVirus) {
        visitorVirus.visit(this);
    }
}
