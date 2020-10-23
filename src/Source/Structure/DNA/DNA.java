package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Chain.ChainController;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.AcidController;

import java.util.ArrayList;

public class DNA extends Acid{
    public DNA(ArrayList<Gene> genes){
        this.replicate = (acid, mutateProbability) -> new DNA(AcidController.replicate(acid, mutateProbability));
        this.mutate = (acid, mutateProbability) -> new DNA(AcidController.mutate(acid, mutateProbability));
        this.split = ChainController::split;

        this.genes = genes;
        this.logger = new MyLogger(DNA.class.getName());
        this.logger.info("Created " + this.toString());
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        this.logger.info("Set gene " + gene.toString() + " to position " + position.toString());
    }

    @Override
    public Gene getGene(Integer position) {
        if (position < this.genes.size()){
            Gene result = this.genes.get(position);
            this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
            return result;
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene " + gene.toString());
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.genes;
    }

    @Override
    public DNA replicate(){
        logger.info("Replicate DNA " + this.toString());
        return (DNA) replicate.replicate(this,0.05f);
    }

    @Override
    public Chain split(){
        Chain result = split.split(this);
        logger.info("Split DNA " + this.toString() + " to chain " + result.toString());
        return result;
    }

    @Override
    public DNA mutate(){
        DNA result =(DNA) mutate.mutate(this, 0.05f);
        logger.info("Mutate DNA " + this.toString() + " to chain " + result.toString());
        return result;
    }

    @Override
    public String toString() {
        return "DNA {" +
                "genes=" + genes +
                '}';
    }
}
