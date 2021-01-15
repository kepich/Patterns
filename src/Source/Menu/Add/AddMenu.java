package Source.Menu.Add;

import Source.Menu.AppState;
import Source.Structure.Actions.Factory.DNAActionFactory;
import Source.Structure.Actions.Factory.RNAActionFactory;

public class AddMenu extends AppState {
    @Override
    public AppState perform() {
        System.out.println("Choose struct:");
        System.out.println("1. RNA");
        System.out.println("2. DNA");
        System.out.println("3. Gene");
        System.out.println("4. Chain");
        System.out.println("5. Back");

        AppState result;

        while (true){
            tempMenu = sc.nextLine();
            switch (tempMenu) {
                case "1" -> result = new AddAcidMenu(new RNAActionFactory());
                case "2" -> result = new AddAcidMenu(new DNAActionFactory());
                case "3" -> result = new AddGeneMenu();
                case "4" -> result = new AddChainMenu();
                default -> {
                    System.out.println("Incorrect input! Try again!");
                    continue;
                }
            }
            break;
        }

        return result;
    }
}
