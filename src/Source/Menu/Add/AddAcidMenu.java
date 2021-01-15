package Source.Menu.Add;

import Source.Chain.Chain;
import Source.Chain.Context.ChainContext;
import Source.Menu.AppState;
import Source.Menu.StartMenu;
import Source.Gene.Gene;
import Source.Structure.Actions.Factory.ActionFactory;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;
import Source.Structure.RNA.RNA;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

public class AddAcidMenu extends AppState {
    private final ActionsChooser actionsChooser;
    
    public AddAcidMenu(ActionFactory actFact){
        actionsChooser = new ActionsChooser(actFact);
    }

    @Override
    public AppState perform() throws UnexpectedException {
        Splitter splitter = actionsChooser.chooseSplitter();
        Replicate replicate = actionsChooser.chooseReplicate();
        Mutate mutate = actionsChooser.chooseMutate();

        ChainContext context = new ChainContext(getNucleotidesString());
        Chain res = context.generateChain();
        Gene gene = new Gene(res);
        ArrayList<Gene> list = new ArrayList<>();
        list.add(gene);
        
        acids.add(new RNA(list, replicate, mutate, splitter));
        return new StartMenu();
    }
}
