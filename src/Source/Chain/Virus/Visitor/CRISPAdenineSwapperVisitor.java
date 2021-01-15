package Source.Chain.Virus.Visitor;

import Source.Chain.Virus.CRISPAdenineSwapper;
import Source.MyLoggerFactory;

public class CRISPAdenineSwapperVisitor extends VisitorVirus {
    public CRISPAdenineSwapperVisitor() {
        super(MyLoggerFactory.getLogger(CRISPAdenineSwapperVisitor.class.getName()));
        this.logger.info("CRISPAdenineSwapperVisitor created");
    }

    @Override
    public void visit(CRISPAdenineSwapper virus) {
        this.logger.info("CRISPAdenineSwapperVisitor watch virus");
        this.amount++;
    }

    @Override
    public String toString() {
        return "CRISPAdenineSwapperVisitor{" +
                "amount=" + amount +
                '}';
    }
}
