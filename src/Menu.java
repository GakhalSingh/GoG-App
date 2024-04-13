import util.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

import static util.Display.Print.printInvader;
import static util.Display.Print.printUI;
import static util.Display.cleanScreen;

public class Menu {
    private Operate operate;
    private Scanner scanner;

    public Menu(Operate operate) {
        this.scanner = new Scanner(System.in);
        this.operate = operate;
    }

    public void mainMenu() {
        printInvader();
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      Welkom bij Gameshop!    ║");
        System.out.println("║ 1. Game Reviews Bekijken     ║");
        System.out.println("║ 2. Game Opzoeken             ║");
        System.out.println(printUI(" 2,5. damn"));
        System.out.println("║ 3. Ranglijst                 ║");
        System.out.println("║ 4. Sales                     ║");
        System.out.println("║ 5. Exit                      ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("~ ~ ~  Kies een optie :  ~ ~ ~");
        int mainMenuVraag = menuKeuze(5);
        cleanScreen();

        switch (mainMenuVraag) {
            case 1:
                System.out.println("Je hebt gekozen voor Game Review Toevoegen.");
                reviewMenu();
                break;
            case 2:
                System.out.println("Je hebt gekozen voor Game Opzoeken.");
                searchMenu();
                break;
            case 3:
                System.out.println("Je hebt gekozen voor Ranglijst.");
                orderMenu();
                break;
            case 4:
                System.out.println("Games in de uitverkoop:");
                salesMenu();
                break;
            case 5:
                System.out.println("Bedankt voor het gebruik van Gameshop!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
    }

    public void reviewMenu() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║ 1. Nieuwe game review toevoegen ║");
        System.out.println("║ 2. Alle reviews bekijken        ║");
        System.out.println("║ 3. Reviews per game bekijken    ║");
        System.out.println("║ 4. Terug                        ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("~ ~ ~  ~ Kies een optie :  ~ ~ ~ ~");
        int addMenuChoice = menuKeuze(4);
        cleanScreen();

        switch (addMenuChoice) {
            case 1:
                operate.addNewReview();
                break;
            case 2:
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("║🎮🌟 Bekijk wat gamers zeggen! 🌟🎮║");
                System.out.println("╚════════════════════════════════════╝");

                operate.showAllReviews();
                break;
            case 3:
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("🔍🎮 Bekijk de reviews per spel! 🎮🔍");
                System.out.println("╚════════════════════════════════════╝");
                operate.showReviewsByGame();
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("╔════════════════════════════════════╗");
                System.out.println("║Ongeldige keuze. Probeer opnieuw 🥲.║");
                System.out.println("╚════════════════════════════════════╝");

                break;
        }
    }

    public void searchMenu() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        🔍    Zoekmenu    🔎          ║");
        System.out.println("║ 1. Zoek op naam                      ║");
        System.out.println("║ 2. Zoek op jaartal                   ║");
        System.out.println("║ 3. Zoek op platform                  ║");
        System.out.println("║ 4. Alle games bekijken               ║");
        System.out.println("║ 5. Terug                             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("   Kies een optie: ");

        int searchMenuChoice = menuKeuze(5);
        cleanScreen();

        switch (searchMenuChoice) {
            case 1:
                System.out.println("Voer de naam van de game in om te zoeken:");
                String gameName = scanner.nextLine();
                operate.searchByName(gameName);
                break;
            case 2:
                System.out.println("Voer het jaar van de game in om te zoeken:");
                int gameJaar = Input.intKeuze(scanner);
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
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║1. Gerangschikt op Gemiddelde Score   ║");
        System.out.println("║2. Gerangschikt op ReleaseYear        ║");
        System.out.println("║3. Gerangschikt op Platform           ║");
        System.out.println("║4. Gerangschikt op Type               ║");
        System.out.println("║5. Terug                              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("   Kies een optie: ");

        int orderMenuChoice = menuKeuze(4);
        cleanScreen();

        switch (orderMenuChoice) {
            case 1:
                operate.ratingByAvgRating();
                break;
            case 2:
                operate.ratingByReleaseYear();
                break;
            case 3:
                operate.ratingByPlatform();
                break;
            case 4:
                operate.ratingByGameType();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("dat was geen optie maat");
                System.out.println("░░░░░░░█▐▓▓░████▄▄▄█▀▄▓▓▓▌█");
                System.out.println("░░░░░▄█▌▀▄▓▓▄▄▄▄▀▀▀▄▓▓▓▓▓▌█");
                System.out.println("░░░▄█▀▀▄▓█▓▓▓▓▓▓▓▓▓▓▓▓▀░▓▌█");
                System.out.println("░░█▀▄▓▓▓███▓▓▓███▓▓▓▄░░▄▓▐█▌");
                System.out.println("░█▌▓▓▓▀▀▓▓▓▓███▓▓▓▓▓▓▓▄▀▓▓▐█");
                System.out.println("▐█▐██▐░▄▓▓▓▓▓▀▄░▀▓▓▓▓▓▓▓▓▓▌█▌");
                System.out.println("█▌███▓▓▓▓▓▓▓▓▐░░▄▓▓███▓▓▓▄▀▐█");
                System.out.println("█▐█▓▀░░▀▓▓▓▓▓▓▓▓▓██████▓▓▓▓▐█");
                System.out.println("▌▓▄▌▀░▀░▐▀█▄▓▓██████████▓▓▓▌█▌");
                System.out.println("▌▓▓▓▄▄▀▀▓▓▓▀▓▓▓▓▓▓▓▓█▓█▓█▓▓▌█▌");
                System.out.println("█▐▓▓▓▓▓▓▄▄▄▓▓▓▓▓▓█▓█▓█▓█▓▓▓▐█");
                break;
        }
    }


    public void salesMenu() {
        System.out.println("╔══════════════════════════════════════╗");
        operate.searchBySale(100);
        System.out.println("╚══════════════════════════════════════╝");

    }

    // Deze methode wordt gebruikt om menukeuzes te valideren zodat de app niet vastloopt als iemand bijv. een float invult
    private int menuKeuze(int aantalKeuzes) {
        int menuKeuze;
        while (true) {
            try {
                menuKeuze = scanner.nextInt();
                if ((menuKeuze <= aantalKeuzes) || (menuKeuze >= 1)) {
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige keuze, probeer het opnieuw.");
                cleanScreen();
                scanner.nextLine();
            }
        }
        return menuKeuze;
    }

    // static versie van de methode zodat deze kan worden gebruikt door Main en Operate
    public static int menuKeuze(int aantalKeuzes, Scanner scanner) {
        int menuKeuze;
        while (true) {
            try {
                menuKeuze = scanner.nextInt();
                if ((menuKeuze <= aantalKeuzes) || (menuKeuze >= 1)) {
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige keuze, probeer het opnieuw.");
                cleanScreen();
                scanner.nextLine();

            }
        }
        return menuKeuze;
    }

}