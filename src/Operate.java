import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operate {
    private List<Game> gameList;
    private CSVWriter csvWriter;
    private CSVReader csvReader;
    private Scanner scanner;

    public Operate() {
        this.gameList = new ArrayList<>();
        this.csvReader = new CSVReader();
        this.csvWriter = new CSVWriter();
        this.scanner = new Scanner(System.in);
    }
    public List<Game> getGameList() {
        return gameList;
    }

    public void addNewGameReview() {
        System.out.println("Over welk spel wil je een review plaatsen:");
        String gameNaam = scanner.nextLine();
        System.out.println("Wat zou je de game geven (1/5 sterren):");
        int gameRate = scanner.nextInt();
        scanner.nextLine();
        if (gameRate >= 1 && gameRate <= 5) {
            System.out.println("Wat kan je er nog over vertellen?");
            String gameReview = scanner.nextLine();
            // Voeg logica toe om review aan het spel toe te voegen
        } else {
            System.out.println("De rating was ongeldig.");
        }
    }
    public void searchByName(String gameName) {
        boolean found = false;
        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(gameName)) {
                System.out.println("Gevonden game:");
                System.out.println(game);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Geen game gevonden met de naam: " + gameName);
        }
    }
    public void searchByJaar(int gameJaar) {
        boolean found = false;
        System.out.println("Games uit het jaar " + gameJaar + ":");
        for (Game game : gameList) {
            if (game.getReleaseYear() == gameJaar) {
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen games gevonden uit het jaar " + gameJaar);
        }
    }
    public void searchByPlatform(String platform) {
        boolean found = false;
        System.out.println("Games op het platform " + platform + ":");
        for (Game game : gameList) {
            if (game.getPlatform().equalsIgnoreCase(platform)) {
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen games gevonden op het platform " + platform);
        }
    }


    public void showAll() {
        System.out.println("Alle games in de lijst:");
        for (Game game : gameList) {
            System.out.println(game);
        }
    }

}
