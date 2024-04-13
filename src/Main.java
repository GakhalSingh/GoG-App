import java.util.Scanner;

import static util.Display.cleanScreen;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Operate operate = new Operate();
        Menu menu = new Menu(operate);
        cleanScreen();

        try {
            while (true) {
                menu.mainMenu();
            }
        } catch (Exception e) {
            System.out.println("Ernstige fout opgetreden! Probeer het later nogmaals.");
            System.out.println("Druk op enter om GoG af te sluiten...");
            scanner.nextLine();
            scanner.close();
        } finally {
            System.exit(0);
        }
    }
}