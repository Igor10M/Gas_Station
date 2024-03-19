import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface GasStationItem {
    void displayDetails();
    boolean isChocolate();
    boolean isSandwich();
    boolean isCoffee();
    boolean isGas();
}

public class GasStation {
    // ArrayList for Gas Goods
    private List<GasStationItem> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private double totalGas = 5000;

    // Menu
    public void displayMenu() {
        System.out.println("=====================================");
        System.out.println("Gas Station Management");
        System.out.println("1 - Add a chocolate bar");
        System.out.println("2 - Add a sandwich");
        System.out.println("3 - Add gas");
        System.out.println("4 - Add coffee");
        System.out.println("5 - Display all chocolate bars");
        System.out.println("6 - Compare two chocolate bars and display which one is healthier");
        System.out.println("7 - Display all sandwiches");
        System.out.println("8 - Compare two sandwiches and display which one is cheaper");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addChocolate();
                break;
            case 2:
                addSandwich();
                break;
            case 3:
                addGas();
                break;
            case 4:
                addCoffee();
                break;
            case 5:
                displayAllChocolates();
                break;
            case 6:
                compareChocolates();
                break;
            case 7:
                displayAllSandwiches();
                break;
            case 8:
                compareSandwiches();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
        }
    }

    private void addChocolate() {
        System.out.println("Enter the name of the chocolate: ");
        String name = scanner.next();
        System.out.println("Enter the calories of " + name);
        int calories = scanner.nextInt();
        System.out.println("Enter the expiry date of " + name);
        String expiryDate = scanner.next();

        Chocolate chocolate = new Chocolate(expiryDate, calories, name);
        items.add(chocolate);
    }

    private void addSandwich() {
        String size;
        do {
            System.out.println("Enter the size of the sandwich (small, medium, large): ");
            size = scanner.next().toLowerCase();
        } while (!size.equals("small") && !size.equals("medium") && !size.equals("large"));

        String type;
        do {
            System.out.println("Enter the type of the sandwich (chicken, meat, vegie): ");
            type = scanner.next().toLowerCase();
        } while (!type.equals("chicken") && !type.equals("meat") && !type.equals("vegie"));

        System.out.println("Enter the calories of the " + size + " " + type + " sandwich: ");
        int calories = scanner.nextInt();

        System.out.println("Enter the expiry date of the sandwich: ");
        String expiryDate = scanner.next();

        System.out.println("Enter the price of the " + size + " " + type + " sandwich: ");
        double price = scanner.nextInt();

        Sandwich sandwich = new Sandwich(expiryDate, calories, size, type, price);
        items.add(sandwich);
    }

    private void addCoffee() {
        String size;
        do {
            System.out.println("Enter the size of the coffee (small, medium, large): ");
            size = scanner.next().toLowerCase();
        } while (!size.equals("small") && !size.equals("medium") && !size.equals("large"));

        System.out.println("Enter the calories of the coffee: ");
        int calories = scanner.nextInt();

        System.out.println("Enter the expiry date of the coffee: ");
        String expiryDate = scanner.next();

        Coffee coffee = new Coffee(expiryDate, calories, size);
        items.add(coffee);
    }

    private void addGas() {
        System.out.println("Enter the amount of gas: ");
        double liters = scanner.nextDouble();
        if (liters <= totalGas) {
            totalGas -= liters;
            Gas gas = new Gas(liters);
            items.add(gas);
        } else {
            System.out.println("Not enough gas available. Available gas: " + totalGas + " liters.");
        }
    }

    private void displayAllChocolates() {
        for (GasStationItem item : items) {
            if (item.isChocolate()) {
                item.displayDetails();
            }
        }
    }

    private void compareChocolates() {
        System.out.println("Enter the name of the first chocolate bar: ");
        String name1 = scanner.next();
        System.out.println("Enter the name of the second chocolate bar: ");
        String name2 = scanner.next();

        Chocolate firstChocolate = null;
        Chocolate secondChocolate = null;

        for (GasStationItem item : items) {
            if (item.isChocolate()) {
                Chocolate chocolate = (Chocolate) item;
                if (chocolate.getName().equals(name1)) {
                    firstChocolate = chocolate;
                } else if (chocolate.getName().equals(name2)) {
                    secondChocolate = chocolate;
                }
            }
        }

        if (firstChocolate == null || secondChocolate == null) {
            System.out.println("One or both chocolate bars not found.");
        } else {
            String healthier;
            if (firstChocolate.getCalories() < secondChocolate.getCalories()) {
                healthier = firstChocolate.getName();
            } else {
                healthier = secondChocolate.getName();
            }
            System.out.println("The healthier chocolate bar is: " + healthier);
        }
    }

    private void displayAllSandwiches() {
        for (GasStationItem item : items) {
            if (item.isSandwich()) {
                item.displayDetails();
            }
        }
    }

    private void compareSandwiches() {
        // Display all sandwiches and their indexes
        int index = 0;
        List<Sandwich> sandwichList = new ArrayList<>();
        System.out.println("List of sandwiches:");
        for (GasStationItem item : items) {
            if (item.isSandwich()) {
                Sandwich sandwich = (Sandwich) item;
                System.out.println(index + ": " + sandwich.getSize() + " " + sandwich.getTypeOfSandwich() + " sandwich with " + sandwich.getCalories() + " calories.");
                sandwichList.add(sandwich);
                index++;
            }
        }

        // Get user choice for comparison
        System.out.println("Enter the number of the first sandwich: ");
        int choice1 = scanner.nextInt();
        System.out.println("Enter the number of the second sandwich: ");
        int choice2 = scanner.nextInt();

        // Validate choices
        if (choice1 < 0 || choice1 >= sandwichList.size() || choice2 < 0 || choice2 >= sandwichList.size()) {
            System.out.println("Invalid sandwich number.");
            return;
        }

        // Compare the chosen sandwiches
        Sandwich firstSandwich = sandwichList.get(choice1);
        Sandwich secondSandwich = sandwichList.get(choice2);

        if (firstSandwich.getPrice() < secondSandwich.getPrice()) {
            System.out.println("The cheaper sandwich is the " + firstSandwich.getSize() + " " + firstSandwich.getTypeOfSandwich());
        } else {
            System.out.println("The cheaper sandwich is the " + secondSandwich.getSize() + " " + secondSandwich.getTypeOfSandwich());
        }
    }

}
