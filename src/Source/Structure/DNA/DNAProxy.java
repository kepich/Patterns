package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.IAcid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class DNAProxy implements IAcid {
    private final MyLogger logger;
    private DNA dna;


    public DNAProxy(Nucleotide[] nucleotides) throws UnexpectedException {
        this.logger = MyLoggerFactory.getLogger(DNAProxy.class.getName());
        this.dna = new DNA(nucleotides);
        this.logger.info("Created by Nucleotides" + this.toString());
    }

    public DNAProxy(ArrayList<Gene> genes) throws UnexpectedException {
        this.logger = MyLoggerFactory.getLogger(DNAProxy.class.getName());
        this.dna = new DNA(genes);
        this.logger.info("Created by Genes" + this.toString());
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        this.dna.setGene(gene, position);
        this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene " + gene.toString());
        this.dna.addGene(gene);
    }

    @Override
    public Gene getGene(Integer position) {
        Gene result = this.dna.getGene(position);
        this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
        return result;
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.dna.getGenes();
    }

    @Override
    public Acid replicate() throws UnexpectedException {
        logger.info("Replicate DNA " + this.toString());
        return this.dna.replicate();
    }

    @Override
    public Chain split() {
        logger.info("Split DNA " + this.toString());
        return this.dna.split();
    }

    @Override
    public Acid mutate() throws UnexpectedException {
        logger.info("Mutate DNA " + this.toString());
        return this.dna.mutate();
    }

    @Override
    public String toString() {
        return "DNAProxy{" +
                "dna=" + dna +
                '}';
    }
}
