package Source.Menu.Modify;

import Source.Chain.Chain;
import Source.Gene.Gene;
import Source.Menu.AppState;
import Source.Nucleotide.Nucleotide;

import java.rmi.UnexpectedException;

public class GeneModifyMenu extends AppState {
    @Override
    public AppState perform() throws UnexpectedException {
        this.printGenes();
        if (genes.size() == 0) {
            return new ModifyMenu();
        }

        Gene tempElement = chooseGene();

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
                    genes.add(tempElement.replicate(chooseProbability(), Nucleotide.getDNANucleotides()));
                    result = new GeneModifyMenu();
                }
                case "2" -> {
                    tempElement.mutate(chooseProbability(), Nucleotide.getDNANucleotides());
                    result =  new GeneModifyMenu();
                }
                case "3" -> {
                    chains.add(new Chain(tempElement.split()));
                    result = new GeneModifyMenu();
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

    private Gene chooseGene() {
        System.out.println("Choose element:");
        int element = sc.nextInt();

        while (element >= genes.size()) {
            System.out.println("Incorrect input! Try again!");
            element = sc.nextInt();
        }

        return genes.get(element);
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
