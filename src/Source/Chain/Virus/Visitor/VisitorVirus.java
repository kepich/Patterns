package Source.Chain.Virus.Visitor;

import Source.Chain.Virus.CRISPAdenineAdder;
import Source.Chain.Virus.CRISPAdenineSwapper;
import Source.MyLogger;

public abstract class VisitorVirus {
    protected int amount;
    protected MyLogger logger;

    public VisitorVirus(MyLogger logger){
        this.logger = logger;
    }

    public void visit(CRISPAdenineSwapper virus){

    }

    public void visit(CRISPAdenineAdder virus){

    }
}
