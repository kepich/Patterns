package Source.Gene;

import Source.Chain.Chain;
import Source.Gene.ChainBuilder.MarkerChainBuilder;
import Source.Gene.Observer.Observer;
import Source.MyLogger;
import Source.MyLoggerFactory;
import Source.Nucleotide.Nucleotide;

import java.util.ArrayList;
import java.util.List;

public class Gene {
    private Chain chain;
    private MyLogger logger = MyLoggerFactory.getLogger(Gene.class.getName());
    private ArrayList<Observer> observers = new ArrayList<>();

    public Gene(Chain chain) {
        this.chain = chain;
        this.logger.info("Created " + this.toString());
    }

    public Gene(ArrayList<Nucleotide> nucleotides, MarkerChainBuilder builder){
        MarkerChainConstructor markerChainConstructor = new MarkerChainConstructor(builder);
        this.chain = markerChainConstructor.construct();
        for (Nucleotide n: nucleotides){
            chain.addNucleotide(n);
        }
        this.logger.info("(Invalid)Created " + this.toString());
    }

    public Chain getChain() {
        return this.chain;
    }

    public void setChain(Chain chain) {
        this.logger.info("Set chain " + chain.toString());
        this.chain = chain;
    }

    public Gene replicate(Float mutateProbability, Nucleotide[] availableNucleotides) {
        logger.info("Replicate with mutation probability " + mutateProbability.toString());
        notifyObservers();
        return new Gene(this.getChain().replicate(mutateProbability, availableNucleotides));
    }

    public Gene mutate(Float probability, Nucleotide[] availableNucleotides) {
        logger.info("Mutate with mutation probability " + probability.toString());
        Chain chain = this.replicate(probability, availableNucleotides).getChain();
        chain.mutate(probability, availableNucleotides);
        notifyObservers();
        return new Gene(chain);
    }

    public List<Nucleotide> split() {
        this.logger.info("Split " + this.toString());
        return new ArrayList<>(this.getChain().getNucleotides());
    }

    @Override
    public String toString() {
        return "Gene {" +
                "chain=" + chain +
                '}';
    }

    public void attach(Observer obs){
        this.logger.info("Attach observer");
        this.observers.add(obs);
    }

    public void dettach(Observer obs){
        this.logger.info("Dettach observer");
        this.observers.remove(obs);
    }

    private void notifyObservers(){
        this.logger.info("Notify all observers");
        for (Observer obs: this.observers){
            obs.update();
        }
    }
}
