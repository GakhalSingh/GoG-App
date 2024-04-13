package util;

import java.io.IOException;

public class Display {
    public static void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Print {
        public static String printUI(String uiString){
            return String.format("║%-30s║", uiString);
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
            System.out.println("le funny dog");
        }
    }

}
