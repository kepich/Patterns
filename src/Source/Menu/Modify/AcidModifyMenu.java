package Source.Menu.Modify;

import Source.Menu.Add.AddMenu;
import Source.Menu.AppState;
import Source.Menu.Modify.Acid.AcidReplicateMenu;
import Source.Menu.Show.ShowMenu;
import Source.Structure.Acid.Acid;

import java.rmi.UnexpectedException;

public class AcidModifyMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        Acid tempElement = chooseAcid();

        System.out.println("Choose modification:");
        System.out.println("1. Replicate");
        System.out.println("2. Mutate");
        System.out.println("3. Split");
        System.out.println("4. Back");

        AppState result = null;

        while (true){
            tempMenu = sc.nextLine();
            switch (tempMenu){
                case "1":
                    result = new AcidReplicateMenu(tempElement);
                    break;
                case "2":
                    result = new AcidMutateMenu(tempElement);
                    break;
                case "3":
                    result = new AcidSplitMenu(tempElement);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Incorrect input! Try again!");
                    continue;
            }
            break;
        }

        return result;
    }

    private Acid chooseAcid(){
        this.printAcids();
        System.out.println("Choose element:");
        int element = sc.nextInt();

        while (element < acids.size()){
            System.out.println("Incorrect input! Try again!");
            element = sc.nextInt();
        }

        return acids.get(element);
    }
}
