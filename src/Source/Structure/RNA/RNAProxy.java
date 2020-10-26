package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.IAcid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class RNAProxy implements IAcid {
    private MyLogger logger;
    private RNA rna;


    public RNAProxy(Nucleotide[] nucleotides) throws UnexpectedException {
        this.logger = new MyLogger(RNAProxy.class.getName());

        this.logger.info("Created by Nucleotides" + this.toString());
        this.rna = new RNA(nucleotides);
    }

    public RNAProxy(ArrayList<Gene> genes) throws UnexpectedException {
        this.logger = new MyLogger(RNAProxy.class.getName());

        this.logger.info("Created by Genes" + this.toString());
        this.rna = new RNA(genes);
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        this.rna.setGene(gene, position);
        this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene " + gene.toString());
        this.rna.addGene(gene);
    }

    @Override
    public Gene getGene(Integer position) {
        Gene result = this.rna.getGene(position);
        this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
        return result;
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.rna.getGenes();
    }

    @Override
    public Acid replicate() throws UnexpectedException {
        logger.info("Replicate DNA " + this.toString());
        return this.rna.replicate();
    }

    @Override
    public Chain split() {
        logger.info("Split DNA " + this.toString());
        return this.rna.split();
    }

    @Override
    public Acid mutate() {
        this.logger.info("RNA is immutable");
        return this.rna;
    }

    @Override
    public String toString() {
        return "RNAProxy{" +
                "rna=" + rna +
                '}';
    }
}
