package Source.Menu.Add;

import Source.Chain.Chain;
import Source.Chain.Context.ChainContext;
import Source.Menu.AppState;
import Source.Menu.StartMenu;

import java.rmi.UnexpectedException;

public class AddChainMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        ChainContext context = new ChainContext(getNucleotidesString());
        Chain res = context.generateChain();
        chains.add(res);

        return new StartMenu();
    }
}
