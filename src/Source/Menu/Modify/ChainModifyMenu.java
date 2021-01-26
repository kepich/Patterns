package Source.Menu.Modify;

import Source.Chain.Chain;
import Source.Menu.AppState;
import Source.Nucleotide.Nucleotide;

import java.rmi.UnexpectedException;

public class ChainModifyMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        this.printChains();
        if (chains.size() == 0) {
            return new ModifyMenu();
        }

        Chain tempElement = chooseChain();

        System.out.println("Choose modification:");
        System.out.println("1. Replicate");
        System.out.println("2. Mutate");
        System.out.println("3. Back");

        AppState result;

        while (true) {
            tempMenu = sc.nextLine();
            switch (tempMenu) {
                case "1":
                    chains.add(tempElement.replicate(chooseProbability(), Nucleotide.getDNANucleotides()));
                    result = new GeneModifyMenu();
                    break;
                case "2":
                    tempElement.mutate(chooseProbability(), Nucleotide.getDNANucleotides());
                    result =  new GeneModifyMenu();
                    break;
                case "3":
                    result = new ModifyMenu();
                    break;
                default:{
                    System.out.println("Incorrect input! Try again!");
                    continue;
                }
            }
            break;
        }

        return result;
    }

    private Chain chooseChain() {
        System.out.println("Choose element:");
        int element = sc.nextInt();

        while (element >= chains.size()) {
            System.out.println("Incorrect input! Try again!");
            element = sc.nextInt();
        }

        tempMenu = sc.nextLine();
        return chains.get(element);
    }

    private float chooseProbability() {
        System.out.println("Enter probability:");
        float element = sc.nextFloat();

        while (element > 1) {
            System.out.println("Incorrect input! Try again!");
            element = sc.nextFloat();
        }

        return element;
    }
}
