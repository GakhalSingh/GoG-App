import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operate {
    private List<Game> gameList;
    private CSVWriter csvWriter;
    private CSVReader csvReader;
    private Scanner scanner;

    public Operate() {
        this.gameList = CSVReader.readGames();
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
            System.out.println("Voer je gebruikersnaam in:");
            String username = scanner.nextLine();

            Game game = null;
            for (Game g : gameList) {
                if (g.getGameTitle().equalsIgnoreCase(gameNaam)) {
                    game = g;
                    break;
                }
            }

            if (game != null) {
                int reviewID = gameList.size() + 1;
                Review review = new Review(reviewID, game.getId(), username, gameRate, gameReview);
                csvWriter.createReview(review);
            } else {
                System.out.println("Geen game gevonden met de naam: " + gameNaam);
            }
        } else {
            System.out.println("De rating was ongeldig.");
        }
    }

    public void showAllReviews() {
        List<Review> reviews = csvReader.readReviews();
        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                System.out.println(review);
            }
        } else {
            System.out.println("Er zijn nog geen reviews toegevoegd.");
        }
    }

    public void showReviewsByGame() {
        System.out.println("Voer de naam van de game in om de reviews te bekijken:");
        String gameName = scanner.nextLine();
        Game game = null;
        for (Game g : gameList) {
            if (g.getGameTitle().equalsIgnoreCase(gameName)) {
                game = g;
                break;
            }
        }
        if (game != null) {
            List<Review> reviews = csvWriter.readReviewsForGame(game.getId());
            if (!reviews.isEmpty()) {
                System.out.println("Reviews voor " + gameName + ":");
                for (Review review : reviews) {
                    System.out.println(review);
                }
            } else {
                System.out.println("Er zijn geen reviews voor " + gameName + ".");
            }
        } else {
            System.out.println("Geen game gevonden met de naam: " + gameName);
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