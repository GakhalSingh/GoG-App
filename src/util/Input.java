package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import static util.Display.cleanScreen;

public class Input {

    // deze functie dwingt een positieve int input af
    public static int intKeuze(Scanner scanner) {
        int intKeuze;
        while (true) {
            try {
                intKeuze = scanner.nextInt();
                if (intKeuze >= 1) {
                    scanner.nextLine();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige keuze, probeer het opnieuw.");
                cleanScreen();
                scanner.nextLine();

            }
        }
        return intKeuze;
    }

    public static int navigate(){
        return 1;
    }

    // simpele loop om het programma op de gebruiker te laten wachten
    public static void waitForUser(Scanner scanner){
        System.out.print("Druk op enter om door te gaan. > ");
        scanner.nextLine();
    }
}