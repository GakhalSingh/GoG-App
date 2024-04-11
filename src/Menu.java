import java.util.Collections;
import java.util.Comparator;
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
    public int getMenuChoice() {

        return scanner.nextInt();
    }
    public void addMenu() {
        System.out.println("*******************************");
        System.out.println("1. Nieuwe game review toevoegen");
        System.out.println("2. Alle reviews bekijken");
        System.out.println("3. Reviews per game bekijken");
        System.out.println("4. Terug");
        System.out.println("*******************************");
        System.out.print  ("   Kies een optie: ");
        int addMenuChoice = scanner.nextInt();

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
        int searchMenuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchMenuChoice) {
            case 1:
                System.out.println("Voer de naam van de game in om te zoeken:");
                String gameName = scanner.nextLine();
                operate.searchByName(gameName);
                break;
            case 2:
                System.out.println("Voer het jaar van de game in om te zoeken:");
                int gameJaar = scanner.nextInt();
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
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }

    public void orderMenu() {
        System.out.println("******************************");
        System.out.println("1. Gerangschikt op Gemiddele Scroe");
        System.out.println("2. Gerangschikt op ReleaseYear");
        System.out.println ("3. Gerangschikt op Platform");
        System.out.println ("4. Terug");
        System.out.println("******************************");
        System.out.print  ("   Kies een optie: ");
        int orderMenuChoice = scanner.nextInt();

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
}