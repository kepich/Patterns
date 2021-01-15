package Source.Structure.Acid.Genome;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.IAcid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class Genome implements IAcid {
    private ArrayList<IAcid> childs;
    private MyLogger logger;

    public Genome(ArrayList<IAcid> childs){
        this.childs = childs;
        this.logger = MyLoggerFactory.getLogger(Genome.class.getName());
        this.logger.info("Genome created");
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        this.logger.info("Set gene to position " + position.toString() + " in genome");
        int tempPos = position;
        boolean isCorrect = false;

        for(IAcid acid: this.childs){
            try {
                acid.setGene(gene, tempPos);
                isCorrect = true;
                break;
            } catch (IndexOutOfBoundsException e){
                tempPos -= acid.getGenes().size();
            }
        }

        if (!isCorrect){
            this.logger.info("Incorrect position " + position.toString() + " in genome to set gene");
        }
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene in the end of last acid");
        this.childs.get(this.childs.size() - 1).addGene(gene);
    }

    @Override
    public Gene getGene(Integer position) {
        this.logger.info("Get gene on position " + position.toString() + " from genome");
        int tempPos = position;
        boolean isCorrect = false;
        Gene res = null;

        for(IAcid acid: this.childs){
            try {
                res = acid.getGene(tempPos);
                isCorrect = true;
                break;
            } catch (IndexOutOfBoundsException e){
                tempPos -= acid.getGenes().size();
            }
        }

        if (!isCorrect){
            this.logger.info("Incorrect position " + position.toString() + " in genome to get gene");
        }

        return res;
    }

    @Override
    public ArrayList<Gene> getGenes() {
        this.logger.info("Get genes on position from genome");
        ArrayList<Gene> res = new ArrayList<>();

        for(IAcid acid: this.childs){
            res.addAll(acid.getGenes());
        }
        return res;
    }

    @Override
    public IAcid replicate() throws UnexpectedException {
        this.logger.info("Replicate acids in genome");
        ArrayList<IAcid> resAcids = new ArrayList<>();
        for (IAcid child: this.childs){
            resAcids.add(child.replicate());
        }

        return new Genome(resAcids);
    }

    @Override
    public Chain split() {
        this.logger.info("Split acids in genome");
        ArrayList<Nucleotide> resNucleotides = new ArrayList<>();

        for (IAcid child: this.childs){
            resNucleotides.addAll(child.split().getNucleotides());
        }
        return new Chain(resNucleotides);
    }

    @Override
    public IAcid mutate() throws UnexpectedException {
        this.logger.info("Mutate acids in genome");
        ArrayList<IAcid> resAcids = new ArrayList<>();
        for (IAcid child: this.childs){
            resAcids.add(child.mutate());
        }

        return new Genome(resAcids);
    }
}
