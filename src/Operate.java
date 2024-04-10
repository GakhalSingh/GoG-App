import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Operate {
    private List<Game> gameList;
    private Scanner scanner;


    public Operate() {
        this.gameList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addLogic() {
        System.out.println("Voer de naam van de game in:");
        String naam = scanner.nextLine();
        System.out.println("Voer het jaartal van de game in:");
        int jaartal = scanner.nextInt();
        scanner.nextLine(); // Consumeer de newline na de int
        System.out.println("Voer de auteur van de game in:");
        String auteur = scanner.nextLine();
        System.out.println("Voer de beoordeling van de game in:");
        double beoordeling = scanner.nextDouble();
        scanner.nextLine(); // Consumeer de newline na de double
        System.out.println("Voer het type van de game in:");
        String type = scanner.nextLine();

        Game newGame = new Game(naam, jaartal, auteur, beoordeling, type);
        gameList.add(newGame);
        System.out.println("Game succesvol toegevoegd!");
    }

    public void searchLogic() {

    }

    public void orderLogic(Comparator<Game> comparator) {
        gameList.sort(comparator);
        showAll();
    }

    public void addOperation() {
        addLogic();
    }

    public void showAll() {
        System.out.println("Alle games in de lijst:");
        for (Game game : gameList) {
            System.out.println(game.toString());
        }
    }


    public void searchByNaam() {

    }

    public void searchByAuteur() {

    }

    public void searchByJaartal() {

    }

    public void orderBeoordeling() {
        gameList.sort(new OrderByBeoordeling());
        showAll();
    }

    public void orderType() {
        gameList.sort(new OrderByType());
        showAll();
    }

    static class OrderByBeoordeling implements Comparator<Game> {
        @Override
        public int compare(Game o1, Game o2) {
            return Double.compare(o1.getBeoordeling(), o2.getBeoordeling());
        }
    }

    static class OrderByType implements Comparator<Game> {
        @Override
        public int compare(Game o1, Game o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }
}