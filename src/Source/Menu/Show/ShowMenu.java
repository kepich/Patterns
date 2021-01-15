package Source.Menu.Show;

import Source.Menu.AppState;
import Source.Menu.StartMenu;

import java.rmi.UnexpectedException;

public class ShowMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        printAcids();
        printGenes();
        printChains();

        System.out.println("Press any key to return to main menu:");
        tempMenu = sc.nextLine();
        return new StartMenu();
    }
}
