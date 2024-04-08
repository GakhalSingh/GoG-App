public class Menu {
    public void mainMenu() {
        System.out.println ("**************************");
        System.out.println("    Welkom naar Gameshop!  ");
        System.out.println("     1. Game Toevoegen     ");
        System.out.println("     2. Game Opzoeken      ");
        System.out.println("     3.    Ranglijst       ");
        System.out.println("     4.     Sales          ");
        System.out.println("     5.      Exit          ");
    }

    public void addMenu() {
        System.out.println ("*******************************");
        System.out.println ("1. Nieuwe game review toevoegen");
        System.out.println ("2.   Alle reviews bekijken     ");
        System.out.println ("3.          Terug              ");
    }

    public void searchMenu() {
        System.out.println ("******************************");
        System.out.println ("1.        Zoek op naam         ");
        System.out.println ("2.       Zoek op jaartal       ");
        System.out.println ("3.       Zoek op  auteur       ");
        System.out.println ("4.    Alle reviews bekijken    ");
        System.out.println ("5.            Terug            ");
    }

    public void salesMenu(){
        System.out.println ("******************************");
    }

    public void orderMeun(){
        System.out.println ("******************************");
        System.out.println ("1. Gerangschikt op beoordeling");
        System.out.println ("2.    Gerangschikt op type    ");
        System.out.println ("3.             Terug           ");
    }
}
