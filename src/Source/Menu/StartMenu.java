package Source.Menu;

import Source.Menu.Add.AddMenu;
import Source.Menu.Show.ShowMenu;

public class StartMenu extends AppState {
    @Override
    public AppState perform() {
        System.out.println("Choose menu:");
        System.out.println("1. Add new stricture");
        System.out.println("2. Show all structures");
        System.out.println("3. Modify structures");
        System.out.println("4. Exit");

        AppState result = null;

        while (true){
            tempMenu = sc.nextLine();
            switch (tempMenu){
                case "1":
                    result = new AddMenu();
                    break;
                case "2":
                    result = new ShowMenu();
                    break;
                case "3":
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
}
