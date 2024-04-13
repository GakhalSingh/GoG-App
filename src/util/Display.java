package util;

import java.io.IOException;

public class Display {

    /** cleanScreen maakt gebruik van de Windows Terminal/CMD en leegt deze,
     * waardoor we een nette applicatie kunnen houden.
     */
    public static void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Print {
        // PrintUI zorgt ervoor dat strings altijd mooi in het menu passen
        public static String printUI(String uiString){
            return String.format("║ %-37s ║", uiString);
        }

        public static void printInvader(){
            System.out.println("    ##          ##");
            System.out.println("      ##      ##");
            System.out.println("    ##############");
            System.out.println("  ####  ######  ####");
            System.out.println("######################");
            System.out.println("##  ##############  ##");
            System.out.println("##  ##          ##  ##");
            System.out.println("      ####  ####");
            System.out.println(" ");
        }
        public static void printDoge() {
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
        }
    }

}
