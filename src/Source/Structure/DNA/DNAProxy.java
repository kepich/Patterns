package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLogger;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.Acid.Acid;
import Source.Structure.Acid.IAcid;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class DNAProxy implements IAcid {
    private final MyLogger logger;
    private DNA dna;


    public DNAProxy(Nucleotide[] nucleotides) throws UnexpectedException {
        this.logger = new MyLogger(DNAProxy.class.getName());

        ArrayList<Gene> genes = new ArrayList<>();
        int geneSize = 4;

        for (int i = 0; i < nucleotides.length; i += geneSize){
            int tempSize = 0;
            ArrayList<Nucleotide> tempNucleotides = new ArrayList<>();

            while (((i + tempSize) < nucleotides.length) && tempSize < geneSize){
                if (nucleotides[i + tempSize].getType() == NucleotideEnum.URACIL)
                    throw new UnexpectedException("URACIL is not available for DNA");

                tempNucleotides.add(nucleotides[i + tempSize++]);
            }
            genes.add(new Gene(new Chain(tempNucleotides)));
        }

        this.dna = new DNA(genes);

        this.logger.info("Created " + this.toString());
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        if (position < this.dna.getGenes().size()){
            this.dna.setGene(gene, position);
            this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void addGene(Gene gene) {
        this.logger.info("Add gene " + gene.toString());
        this.dna.addGene(gene);
    }

    @Override
    public Gene getGene(Integer position) {
        if (position < this.dna.getGenes().size()){
            Gene result = this.dna.getGene(position);
            this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
            return result;
        }else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.dna.getGenes();
    }

    @Override
    public Acid replicate() {
        logger.info("Replicate DNA " + this.toString());
        return this.dna.replicate();
    }

    @Override
    public Chain split() {
        logger.info("Split DNA " + this.toString());
        return this.dna.split();
    }

    @Override
    public Acid mutate() {
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
