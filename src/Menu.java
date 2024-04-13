import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Operate operate;
    private Scanner scanner;

    public Menu(Operate operate) {
        this.scanner = new Scanner(System.in);
        this.operate = operate;
    }

    public void mainMenu() {
        System.out.println("**********************************");
        System.out.println("    Welkom bij Gameshop!          ");
        System.out.println("     1. Game Reviews Bekijken     ");
        System.out.println("     2. Game Opzoeken             ");
        System.out.println("     3. Ranglijst                 ");
        System.out.println("     4. Sales                     ");
        System.out.println("     5. Exit                      ");
        System.out.println("**********************************");
        System.out.print  ("        Kies een optie: ");
    }

    public void addMenu() {
        System.out.println("*******************************");
        System.out.println("1. Nieuwe game review toevoegen");
        System.out.println("2. Alle reviews bekijken");
        System.out.println("3. Reviews per game bekijken");
        System.out.println("4. Terug");
        System.out.println("*******************************");
        System.out.print  ("   Kies een optie: ");
        int addMenuChoice = MenuKeuze(4);

        switch (addMenuChoice) {
            case 1:
                operate.addNewReview();
                break;
            case 2:
                System.out.println("Alle reviews van games:");
                operate.showAllReviews();
                break;
            case 3:
                System.out.println("Reviews per game bekijken:");
                operate.showReviewsByGame();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }

    public void searchMenu() {
        System.out.println("*******************************");
        System.out.println("1. Zoek op naam");
        System.out.println("2. Zoek op jaartal");
        System.out.println("3. Zoek op platform");
        System.out.println("4. Alle games bekijken");
        System.out.println("5. Terug");
        System.out.println("*******************************");
        System.out.print  ("   Kies een optie: ");

        int searchMenuChoice = MenuKeuze(5);

        switch (searchMenuChoice) {
            case 1:
                System.out.println("Voer de naam van de game in om te zoeken:");
                String gameName = scanner.nextLine();
                operate.searchByName(gameName);
                break;
            case 2:
                System.out.println("Voer het jaar van de game in om te zoeken:");
                int gameJaar = Menu.MenuKeuze(2030, scanner);
                scanner.nextLine();
                operate.searchByJaar(gameJaar);
                break;
            case 3:
                System.out.println("Voer het Platform van de game in om te zoeken:");
                String gamePlatform = scanner.nextLine();
                operate.searchByPlatform(gamePlatform);
                break;
            case 4:
                operate.showAll();
                break;

            case 5:
                mainMenu();
                break;
        }
    }

    public void orderMenu() {
        System.out.println("******************************");
        System.out.println("1. Gerangschikt op Gemiddele Scroe");
        System.out.println("2. Gerangschikt op ReleaseYear");
        System.out.println ("3. Gerangschikt op Platform");
        System.out.println ("4. Gerangschikt op Type");
        System.out.println ("5. Terug");
        System.out.println("******************************");
        System.out.print  ("   Kies een optie: ");
        int orderMenuChoice = MenuKeuze(4);

        switch (orderMenuChoice) {
            case 1:
                operate.ratingByavgRating();

                break;
            case 2:
                operate.ratingByReleaseYear ();

                break;
            case 3:
                operate.ratingByPlatform();
                break;
            case 4:
                operate.ratingBygameType();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }



    public void salesMenu() {
        System.out.println("*****************************************");
        operate.searchBySale( 100);
        System.out.println("*****************************************");

    }

    public void closeScanner() {
        scanner.close();
    }

    // Deze methode wordt gebruikt om menukeuzes te valideren zodat de app niet crasht als iemand bijv een float invult
    int MenuKeuze(int aantalKeuzes) {
        int menuKeuze;
        while (true) {
            try {
                menuKeuze = scanner.nextInt();
                if ((menuKeuze <= aantalKeuzes) || (menuKeuze >= 1)){
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige keuze, probeer het opnieuw.");
                scanner.nextLine();

            }
        }
        return menuKeuze;
    }

    // static versie van de methode zodat deze kan worden gebruikt door Main en Operate
    public static int MenuKeuze(int aantalKeuzes, Scanner scanner) {
        int menuKeuze;
        while (true) {
            try {
                menuKeuze = scanner.nextInt();
                if ((menuKeuze <= aantalKeuzes) || (menuKeuze >= 1)){
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige keuze, probeer het opnieuw.");
                scanner.nextLine();

            }
        }
        return menuKeuze;
    }
}