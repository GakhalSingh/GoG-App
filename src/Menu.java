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
        System.out.println("     1. Game Review Toevoegen     ");
        System.out.println("     2. Game Opzoeken             ");
        System.out.println("     3. Ranglijst                 ");
        System.out.println("     4. Sales                     ");
        System.out.println("     5. Exit                      ");
        System.out.println("**********************************");
        System.out.print  ("        Kies een optie: ");
    }public int getMenuChoice() {

        return scanner.nextInt();
    }

    public void addMenu() {
        System.out.println("*******************************");
        System.out.println("1. Nieuwe game review toevoegen");
        System.out.println("2. Alle reviews bekijken");
        System.out.println("3. Terug");
        System.out.println("*******************************");
        System.out.print  ("   Kies een optie: ");
        int addMenuChoice = scanner.nextInt();

        switch (addMenuChoice) {
            case 1:
                operate.addNewGameReview();
                break;
            case 2:
                operate.readGamesFromCSV();
                System.out.println("Alle reviews van games:");
                operate.showAll();
                break;
            case 3:
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

        switch (searchMenuChoice) {
            case 1:
                System.out.println("Voer de naam van de game in om te zoeken:");
                String gameName = scanner.nextLine();
                operate.searchByName(gameName);
                break;
            case 2:
                System.out.println("Voer het jaar van de game in om te zoeken:");
                int gameJaar = scanner.nextInt();
                operate.searchByJaar(gameJaar);
                break;
            case 3:
                operate.searchByAuteur();
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
        System.out.println("1. Gerangschikt op beoordeling");
        System.out.println("2. Gerangschikt op type");
        System.out.println("3. Terug");
        System.out.println("******************************");
        System.out.print  ("   Kies een optie: ");
        int orderMenuChoice = scanner.nextInt();

        switch (orderMenuChoice) {
            case 1:
                operate.orderBeoordeling();
                break;
            case 2:
                operate.orderType();
                break;
            case 3:
                // Terug naar hoofdmenu
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }


    public void salesMenu() {
        System.out.println("******************************");
        // Implementeer logica voor het tonen van het salesmenu
    }

    public void closeScanner() {
        scanner.close();
    }
}
