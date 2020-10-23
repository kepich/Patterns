package Source.Structure.RNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.IAcid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class RNAProxy implements IAcid {
    private MyLogger logger;
    private RNA rna;


    public RNAProxy(Nucleotide[] nucleotides) throws UnexpectedException {
        this.logger = new MyLogger(RNAProxy.class.getName());

        ArrayList<Gene> genes = new ArrayList<>();
        int geneSize = 2;

        for (int i = 0; i < nucleotides.length; i += geneSize){
            int tempSize = 0;
            ArrayList<Nucleotide> tempNucleotides = new ArrayList<>();

            while ((i + tempSize) < nucleotides.length && tempSize < geneSize){
                if (nucleotides[i + tempSize].getType() == NucleotideEnum.TIMIN)
                    throw new UnexpectedException("TIMIN is not available for DNA");
                tempNucleotides.add(nucleotides[i + tempSize++]);
            }
            genes.add(new Gene(new Chain(tempNucleotides)));
        }

        this.rna = new RNA(genes);
        this.logger.info("Created " + this.toString());
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        if (position < this.rna.getGenes().size()){
            this.rna.setGene(gene, position);
            this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene " + gene.toString());
        this.rna.addGene(gene);
    }

    @Override
    public Gene getGene(Integer position) {
        if (position < this.rna.getGenes().size()){
            Gene result = this.rna.getGene(position);
            this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
            return result;
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.rna.getGenes();
    }

    @Override
    public Acid replicate() {
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
