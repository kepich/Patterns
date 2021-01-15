package Source.Menu.Add;

import Source.Chain.Chain;
import Source.Chain.Context.ChainContext;
import Source.Menu.AppState;
import Source.Menu.StartMenu;
import Source.Gene.Gene;

import java.rmi.UnexpectedException;

public class AddGeneMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        ChainContext context = new ChainContext(getNucleotidesString());
        Chain res = context.generateChain();
        Gene gene = new Gene(res);
        genes.add(gene);

        return new StartMenu();
    }
}
