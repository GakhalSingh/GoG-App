import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        String gameNaam = scanner.nextLine().trim(); // Ingevoerde naam van het spel

        // Zoek het spel in de lijst op basis van de ingevoerde naam
        Game selectedGame = null;
        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(gameNaam)) {
                selectedGame = game;
                break;
            }
        }

        if (selectedGame == null) {
            System.out.println("Spel niet gevonden.");
            return;
        }

        int newReviewId = csvReader.getNextReviewId();

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
        System.out.println("Wat kan je er nog over vertellen?");
        String gameReview = scanner.nextLine();
        csvWriter.addReviewToCSV(newReviewId, selectedGame.getId(), gameRate, gameReview);

        System.out.println("Review succesvol toegevoegd!");
    }
    public void showGameReviews(String gameName) {
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVReader.REVIEW_CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    int gameId = Integer.parseInt(parts[1]);
                    String reviewGameName = getGameTitleById(gameId);
                    if (reviewGameName.equalsIgnoreCase(gameName)) {
                        int reviewId = Integer.parseInt(parts[0]);
                        int rating = Integer.parseInt(parts[2]);
                        String review = parts[3];
                        System.out.println("Review ID: " + reviewId);
                        System.out.println("Rating: " + rating + " sterren");
                        System.out.println("Review: " + review);
                        found = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fout bij het lezen van het review CSV-bestand: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Geen reviews gevonden voor de game: " + gameName);
        }
    }

    private String getGameTitleById(int gameId) {
        for (Game game : gameList) {
            if (game.getId() == gameId) {
                return game.getGameTitle();
            }
        }
        return "";
    }

    public void searchByName(String gameName) {
        boolean found = false;
        String normalizedGameName = gameName.trim(); // Verwijder eventuele spaties rond de ingevoerde naam

        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(normalizedGameName)) {
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
