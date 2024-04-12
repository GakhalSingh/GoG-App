import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operate operate = new Operate();
        Menu menu = new Menu(operate);
        try {
            while (true) {
                menu.mainMenu();
                int mainMenuVraag = menu.getMenuChoice();

                switch (mainMenuVraag) {
                    case 1:
                        System.out.println("Je hebt gekozen voor Game Review Toevoegen.");
                        menu.addMenu();
                        break;
                    case 2:
                        System.out.println("Je hebt gekozen voor Game Opzoeken.");
                        menu.searchMenu();
                        break;
                    case 3:
                        System.out.println("Je hebt gekozen voor Ranglijst.");
                        menu.orderMenu();
                        break;
                    case 4:
                        System.out.println("Je hebt gekozen voor Sales.");
                        menu.salesMenu();
                        break;
                    case 5:
                        System.out.println("Bedankt voor het gebruik van Gameshop!");
                        menu.closeScanner();
                        System.exit(0);
                    default:
                        System.out.println("Ongeldige keuze. Probeer opnieuw.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}