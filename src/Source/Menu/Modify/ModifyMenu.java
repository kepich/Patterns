package Source.Menu.Modify;

import Source.Menu.AppState;

import java.rmi.UnexpectedException;

public class ModifyMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        System.out.println("Choose modifying struct:");
        System.out.println("1. Acid");
        System.out.println("2. Gene");
        System.out.println("3. Chain");
        System.out.println("4. Back");

        AppState result = null;

        while (true){
            tempMenu = sc.nextLine();
            switch (tempMenu) {
                case "1" -> result = new AcidModifyMenu();
                case "2" -> result = new GeneModifyMenu();
                case "3" -> result = new ChainModifyMenu();
                case "4" -> result = new ModifyMenu();
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
