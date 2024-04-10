import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        System.out.println("**************************");
        System.out.println("    Welkom bij Gameshop!   ");
        System.out.println("     1. Game Toevoegen     ");
        System.out.println("     2. Game Opzoeken      ");
        System.out.println("     3. Ranglijst          ");
        System.out.println("     4. Sales              ");
        System.out.println("     5. Exit               ");
        System.out.println("**************************");
        System.out.print("Kies een optie: ");
    }

    public int getMenuChoice() {
        return scanner.nextInt();
    }

    public void addMenu() {
        System.out.println("*******************************");
        System.out.println("1. Nieuwe game toevoegen");
        System.out.println("2. Alle reviews bekijken");
        System.out.println("3. Terug");
        System.out.println("*******************************");
        System.out.print("Kies een optie: ");
        int addMenuChoice = scanner.nextInt();

        switch (addMenuChoice) {
            case 1:
                // Implementeer logica om een nieuwe game toe te voegen
                break;
            case 2:
                // Implementeer logica om alle reviews te bekijken
                break;
            case 3:
                // Terug naar hoofdmenu
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
        System.out.println("3. Zoek op auteur");
        System.out.println("4. Alle reviews bekijken");
        System.out.println("5. Terug");
        System.out.println("*******************************");
        System.out.print("Kies een optie: ");
        int searchMenuChoice = scanner.nextInt();

        switch (searchMenuChoice) {
            case 1:
                // Implementeer logica voor zoeken op naam
                break;
            case 2:
                // Implementeer logica voor zoeken op jaartal
                break;
            case 3:
                // Implementeer logica voor zoeken op auteur
                break;
            case 4:
                // Implementeer logica om alle reviews te bekijken
                break;
            case 5:
                // Terug naar hoofdmenu
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
        System.out.print("Kies een optie: ");
        int orderMenuChoice = scanner.nextInt();

        switch (orderMenuChoice) {
            case 1:
                // Implementeer logica voor rangschikken op beoordeling
                break;
            case 2:
                // Implementeer logica voor rangschikken op type
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
