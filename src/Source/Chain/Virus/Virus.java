package Source.Chain.Virus;

import Source.Chain.Chain;
import Source.Chain.Virus.Visitor.VisitorVirus;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;

public abstract class Virus {
    protected MyLogger logger;
    protected Chain chain;

    public Virus(MyLogger logger, Chain chain){
        this.logger = logger;
        this.chain = chain;
    }

    public abstract void execute(Nucleotide[] nucleotides);

    public abstract void accept(VisitorVirus visitorVirus);
}
