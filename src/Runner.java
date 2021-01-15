import Source.Chain.Chain;
import Source.Chain.Context.ChainAddingNucleotideSeq;
import Source.Chain.Context.ChainContext;
import Source.Chain.Context.ChainEndNucleotideSeq;
import Source.Chain.Context.ChainStartNucleotideSeq;
import Source.Menu.AppState;
import Source.Menu.StartMenu;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.NucleotideManager;

import java.rmi.UnexpectedException;

public class Runner {
    private MyLogger logger = MyLoggerFactory.getLogger(Runner.class.getName());

    public Runner() {
    }

    public static void main(String[] args) {
        Runner runner = new Runner();

        try {
            runner.run();
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
    }

    private void run() throws UnexpectedException {
        logger.info("Started");

        MyLoggerFactory.getLogger(ChainContext.class.getName()).disable();
        MyLoggerFactory.getLogger(NucleotideManager.class.getName()).disable();
        MyLoggerFactory.getLogger(MyLoggerFactory.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainEndNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainAddingNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(ChainStartNucleotideSeq.class.getName()).disable();
        MyLoggerFactory.getLogger(Chain.class.getName()).disable();

        AppState menu = new StartMenu();

        while (menu != null){
            menu = menu.perform();
        }


        /*ChainContext context = new ChainContext("ACA");
        Chain res = context.generateChain();
        logger.info("***************************");

        Nucleotide[] nucleotides = {
                NucleotideManager.instance().getNucleotide(NucleotideEnum.TIMIN),
                NucleotideManager.instance().getNucleotide(NucleotideEnum.CITOZIN),
                NucleotideManager.instance().getNucleotide(NucleotideEnum.GUANIN),
                NucleotideManager.instance().getNucleotide(NucleotideEnum.TIMIN),
                NucleotideManager.instance().getNucleotide(NucleotideEnum.CITOZIN),
        };
        VisitorVirus swapperV = new CRISPAdenineSwapperVisitor();
        VisitorVirus swapperA = new CRISPAdenineAdderVisitor();

        Virus v1 = new CRISPAdenineSwapper(res);
        v1.accept(swapperV);
        v1.accept(swapperA);
        this.logger.info(swapperV.toString());
        this.logger.info(swapperA.toString());

        Virus v2 = new CRISPAdenineSwapper(res);
        v2.accept(swapperV);
        v2.accept(swapperA);
        this.logger.info(swapperV.toString());
        this.logger.info(swapperA.toString());

        Virus v3 = new CRISPAdenineAdder(res);
        v3.accept(swapperV);
        v3.accept(swapperA);
        this.logger.info(swapperV.toString());
        this.logger.info(swapperA.toString());*/


        /*
        logger.info(res.toString());
        swapper.execute(nucleotides);
        logger.info(res.toString());*/

        /*Chain.Memento mem = res.createMemento();
        logger.info(res.toString());
        res.mutate(0.9f, Nucleotide.getDNANucleotides());
        logger.info(res.toString());
        res.resetState(mem);
        logger.info(res.toString());*/

        /*Gene gene = new Gene(res);
        logger.info("***************************");


        Observer obs1 = new MutateObserver();
        Observer obs2 = new MutateObserver();

        gene.attach(obs1);
        gene.mutate(0.5f, Nucleotide.getDNANucleotides());
        gene.attach(obs2);
        gene.mutate(0.5f, Nucleotide.getDNANucleotides());

        logger.info("Obs1.res=" + obs1.getCounter());
        logger.info("Obs1.res=" + obs2.getCounter());*/


        /*NucleotideManager nucleotideManager = NucleotideManager.instance();
        Gene gene;
        ArrayList<Nucleotide> nucleotides = new ArrayList<>();

        nucleotides.add(
                nucleotideManager.getNucleotide(NucleotideEnum.CITOZIN)
        );nucleotides.add(
                nucleotideManager.getNucleotide(NucleotideEnum.ADENIN)
        );

        gene = new Gene(nucleotides, new DNAInvalidChainMarkerBuilder());
        logger.info(gene.toString());*/


        //NucleotideManager nucleotideManager = NucleotideManager.instance();

        /*Nucleotide[] dna1Nucleotides = {
                nucleotideManager.getNucleotide(NucleotideEnum.CITOZIN),
                nucleotideManager.getNucleotide(NucleotideEnum.ADENIN),
        };
        DNAFact fact = new DNAFact();
        DNA dna1 = fact.getAcid(dna1Nucleotides);
        DNA dna2 = dna1.cloneObj();
        logger.info(dna2.toString());*/

        //DefaultRandomGenerator defaultRandomGenerator1 = new DefaultRandomGenerator();
        //DefaultRandomGenerator defaultRandomGenerator2 = defaultRandomGenerator1.cloneObj();

        //defaultRandomGenerator1.setStatus(true);

        //logger.info(defaultRandomGenerator1.toString());
        //logger.info(defaultRandomGenerator2.toString());

        //AcidObject acidObject = new DNAObject();

        //Acid dna1 = acidObject.createAcid(dna1Nucleotides);

        /*Nucleotide[] dna2Nucleotides = {
                nucleotideManager.getNucleotide(NucleotideEnum.GUANIN),
                nucleotideManager.getNucleotide(NucleotideEnum.CITOZIN),
        };

        DNA dna2 = new DNA(dna2Nucleotides);

        dna2.split();*/

        /*ArrayList<IAcid> acides = new ArrayList<>();
        acides.add(dna1);
        acides.add(dna2);

        Genome genome = new Genome(acides);

        genome.replicate();*/
    }

}
