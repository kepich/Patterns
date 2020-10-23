package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Chain.ChainController;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.AcidController;

import java.util.ArrayList;

public class RNA extends Acid{
    public RNA(ArrayList<Gene> genes){
        this.replicate = (acid, mutateProbability) -> new RNA(AcidController.replicate(acid, mutateProbability));
        this.mutate = null;
        this.split = ChainController::split;

        this.mutate = null;

        this.genes = genes;
        this.logger = new MyLogger(RNA.class.getName());
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
    public RNA mutate(){
        this.logger.info("RNA is immutable");
        return this;
    }

    @Override
    public RNA replicate(){
        logger.info("Replicate RNA " + this.toString());
        return (RNA) replicate.replicate(this,0.05f);
    }

    public Chain split(){
        Chain result = split.split(this);
        logger.info("Split RNA " + this.toString() + " to chain " + result.toString());
        return result;
    }

    @Override
    public String toString() {
        return "RNA {" +
                "genes=" + genes +
                '}';
    }
}
