package Source.Structure.DNA;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;
import Source.Nucleotide.NucleotideEnum;
import Source.Structure.Acid.Acid;
import Source.Structure.Actions.Mutate.Impl.DefaultMutate;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Impl.DefaultReplicate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Impl.DefaultSplit;
import Source.Structure.Actions.Split.Impl.Mutable.DNAMutableSplit;
import Source.Structure.Actions.Split.Splitter.DNASplitter;
import Source.Structure.Actions.Split.Splitter.Splitter;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class DNA extends Acid implements Cloneable{
    public DNA(Nucleotide[] nucleotides, Replicate replicate, Mutate mutate, Splitter splitter) throws UnexpectedException {
        super(
                replicate,
                mutate,
                splitter,
                MyLoggerFactory.getLogger(DNA.class.getName())
        );

        ArrayList<Gene> genes = new ArrayList<>();
        int geneSize = 4;

        for (int i = 0; i < nucleotides.length; i += geneSize) {
            int tempSize = 0;
            ArrayList<Nucleotide> tempNucleotides = new ArrayList<>();

            while (((i + tempSize) < nucleotides.length) && tempSize < geneSize) {
                tempNucleotides.add(nucleotides[i + tempSize++]);
            }
            genes.add(new Gene(new Chain(tempNucleotides)));
        }
        validateGenes(genes);
        this.genes = genes;
        this.logger.info("Created " + this.toString());
    }

    public DNA(ArrayList<Gene> genes) throws UnexpectedException {
        super(
                new DefaultReplicate(),
                new DefaultMutate(),
                new DNASplitter(new DNAMutableSplit(new DefaultSplit())),
                MyLoggerFactory.getLogger(DNA.class.getName())
        );
        validateGenes(genes);

        this.genes = genes;
        this.logger.info("Created " + this.toString());
    }

    public DNA(Nucleotide[] nucleotides) throws UnexpectedException {
        super(
                new DefaultReplicate(),
                new DefaultMutate(),
                new DNASplitter(new DefaultSplit()),
                MyLoggerFactory.getLogger(DNA.class.getName())
        );

        ArrayList<Gene> genes = new ArrayList<>();
        int geneSize = 4;

        for (int i = 0; i < nucleotides.length; i += geneSize) {
            int tempSize = 0;
            ArrayList<Nucleotide> tempNucleotides = new ArrayList<>();

            while (((i + tempSize) < nucleotides.length) && tempSize < geneSize) {
                tempNucleotides.add(nucleotides[i + tempSize++]);
            }
            genes.add(new Gene(new Chain(tempNucleotides)));
        }
        validateGenes(genes);
        this.genes = genes;
        this.logger.info("Created " + this.toString());
    }

    protected void validateGenes(ArrayList<Gene> genes) throws UnexpectedException {
        for (Gene gene : genes) {
            for (Nucleotide nucleotide : gene.getChain().getNucleotides()) {
                if (nucleotide.getType() == NucleotideEnum.URACIL)
                    throw new UnexpectedException("URACIL is not available for DNA");
            }
        }
    }

    @Override
    public void setGene(Gene gene, Integer position) {
        if (position < this.getGenes().size()) {
            this.genes.set(position, gene);
            this.logger.info("Set gene " + gene.toString() + " on position " + position.toString());
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public Gene getGene(Integer position) {
        if (position < this.getGenes().size()) {
            Gene result = this.genes.get(position);
            this.logger.info("Get gene " + result.toString() + " on position " + position.toString());
            return result;
        } else
            throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void addGene(Gene gene) {
        this.genes.add(gene);
        this.logger.info("Add gene " + gene.toString());
    }

    @Override
    public ArrayList<Gene> getGenes() {
        return this.genes;
    }

    @Override
    public DNA replicate() throws UnexpectedException {
        logger.info("Replicate DNA " + this.toString());
        return new DNA(actionPack.replicate(this.getGenes(), 0.05f, Nucleotide.getDNANucleotides()));
    }

    @Override
    public Chain split() {
        Chain result = actionPack.split(this.getGenes());
        logger.info("Split DNA " + this.toString() + " to chain " + result.toString());
        return result;
    }

    @Override
    public DNA mutate() throws UnexpectedException {
        DNA result = new DNA(actionPack.mutate(this.getGenes(), 0.05f, Nucleotide.getDNANucleotides()));
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
