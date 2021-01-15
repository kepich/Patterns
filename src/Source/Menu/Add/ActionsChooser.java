package Source.Menu.Add;

import Source.Structure.Actions.Factory.ActionFactory;
import Source.Structure.Actions.Mutate.Mutate;
import Source.Structure.Actions.Replicate.Replicate;
import Source.Structure.Actions.Split.Splitter.Splitter;

import java.util.Scanner;

public class ActionsChooser {
    private Scanner sc = new Scanner(System.in);
    protected String tempMenu;
    private ActionFactory actFact;

    public ActionsChooser(ActionFactory actFact){
        this.actFact = actFact;
    }

    public Mutate chooseMutate() {
        System.out.println("Choose replicate method:");
        System.out.println("1. Default");
        System.out.println("2. Empty");

        Mutate result;

        while (true) {
            tempMenu = (sc.nextLine());
            switch (tempMenu) {
                case "1" -> result = actFact.getDefaultMutate();
                case "2" -> result = actFact.getEmptyMutate();
                default -> {
                    System.out.println("Incorrect input! Try again!");
                    continue;
                }
            }
            break;
        }

        return result;
    }

    public Replicate chooseReplicate() {
        System.out.println("Choose replicate method:");
        System.out.println("1. Default");
        System.out.println("2. Empty");

        Replicate result;

        while (true) {
            tempMenu = (sc.nextLine());
            switch (tempMenu) {
                case "1" -> result = actFact.getDefaultReplicate();
                case "2" -> result = actFact.getEmptyReplicate();
                default -> {
                    System.out.println("Incorrect input! Try again!");
                    continue;
                }
            }
            break;
        }

        return result;
    }

    public Splitter chooseSplitter() {
        System.out.println("Choose splitter:");
        System.out.println("1. Default");
        System.out.println("2. Empty");
        System.out.println("3. Mutable");

        Splitter result;

        while (true) {
            tempMenu = sc.nextLine();
            switch (tempMenu) {
                case "1" -> result = actFact.getDefaultSplitter();
                case "2" -> result = actFact.getEmptySplitter();
                case "3" -> result = actFact.getMutableSplitter();
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