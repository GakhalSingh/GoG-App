import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operate operate = new Operate();
        Menu menu = new Menu(operate);
        Regex regex = new Regex();
        try {
            while (true) {
                menu.mainMenu();
                int mainMenuVraag = menu.getMenuChoice();

                switch (mainMenuVraag) {
                    case 1:
                        System.out.println("Je hebt gekozen voor Game Toevoegen.");
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