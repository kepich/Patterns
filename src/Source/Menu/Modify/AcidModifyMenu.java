package Source.Menu.Modify;

import Source.Menu.AppState;
import Source.Structure.Acid.Acid;

import java.rmi.UnexpectedException;

public class AcidModifyMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        this.printAcids();
        if (acids.size() == 0) {
            return new ModifyMenu();
        }

        Acid tempElement = chooseAcid();

        System.out.println("Choose modification:");
        System.out.println("1. Replicate");
        System.out.println("2. Mutate");
        System.out.println("3. Split");
        System.out.println("4. Back");

        AppState result;

        while (true) {
            tempMenu = sc.nextLine();
            switch (tempMenu) {
                case "1" -> {
                    acids.add(tempElement.replicate());
                    result = new AcidModifyMenu();
                }
                case "2" -> {
                    tempElement.mutate();
                    result =  new AcidModifyMenu();
                }
                case "3" -> {
                    chains.add(tempElement.split());
                    result = new AcidModifyMenu();
                }
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

    private Acid chooseAcid() {
        System.out.println("Choose element:");
        int element = sc.nextInt();

        while (element >= acids.size()) {
            System.out.println("Incorrect input! Try again!");
            element = sc.nextInt();
        }

        return acids.get(element);
    }
}
