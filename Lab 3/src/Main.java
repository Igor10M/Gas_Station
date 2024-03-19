import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GasStation gasStation = new GasStation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gasStation.displayMenu();

            System.out.println("Do you want to display the menu again? (yes/no)");
            String userAnswer = scanner.next().toLowerCase();

            if (userAnswer.equals("no")) {
                break;
            }
        }
    }
}