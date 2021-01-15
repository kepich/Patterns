package Source.Menu.Modify.Acid;

import Source.Menu.AppState;
import Source.Structure.Acid.Acid;

import java.rmi.UnexpectedException;

public class AcidReplicateMenu extends AppState {
    private Acid acid;
    public AcidReplicateMenu(Acid acid){
        this.acid = acid;
    }

    @Override
    public AppState perform() throws UnexpectedException {
        acids.add(this.acid.replicate());
        return null;
    }
}
