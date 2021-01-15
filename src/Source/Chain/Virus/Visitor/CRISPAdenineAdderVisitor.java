package Source.Chain.Virus.Visitor;

import Source.Chain.Virus.CRISPAdenineAdder;
import Source.MyLoggerFactory;

public class CRISPAdenineAdderVisitor extends VisitorVirus {
    public CRISPAdenineAdderVisitor() {
        super(MyLoggerFactory.getLogger(CRISPAdenineAdderVisitor.class.getName()));
        this.logger.info("CRISPAdenineAdderVisitor created");
    }

    @Override
    public void visit(CRISPAdenineAdder virus) {
        this.logger.info("CRISPAdenineAdderVisitor watch virus");
        this.amount++;
    }

    @Override
    public String toString() {
        return "CRISPAdenineAdderVisitor{" +
                "amount=" + amount +
                '}';
    }
}
