import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVWriter {
    public void writeGames(List<Game> games, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Schrijf de kop van het CSV-bestand
            writer.println("ID;GameTitle;Platform;ReleaseYear;OnSale;Price,Type");

            // Schrijf elk Game-object naar het CSV-bestand
            for (Game game : games) {
                writer.println(
                        game.getId() + ";" +
                                game.getGameTitle() + ";" +
                                game.getPlatform() + ";" +
                                game.getReleaseYear() + ";" +
                                game.isOnSale() + ";" +
                                game.getPrice() + ";" +
                                game.getGameType()
                );
            }

            System.out.println("Gegevens succesvol geschreven naar " + filePath);

        } catch (IOException e) {
            System.out.println("Fout bij het opslaan van game: " + e.getMessage());
        }
    }

    // afblijven - jin
    public void createReview(Review review) {
        try (FileWriter fileWriter = new FileWriter("reviews.csv", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            int reviewID = review.getReviewID();
            int gameID = review.getGameID();
            String username = review.getUsername();
            int gameplayScore = review.getGameplayScore();
            int graphicsScore = review.getGraphicsScore();
            int storylineScore = review.getStorylineScore();

            String comment = review.getComment();

            printWriter.println(reviewID + ";" + gameID + ";" + username + ";" + comment + ";" + gameplayScore + ";" + graphicsScore + ";" + storylineScore);
            System.out.println("Review toegevoegd: " + review);
        } catch (IOException e) {
            System.out.println("Fout bij het schrijven van de review: " + e.getMessage());
        }
    }

    public List<Review> readReviewsForGame(int gameID) {
        List<Review> gameReviews = new ArrayList<>();
        try {
            File file = new File("reviews.csv");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    int reviewID = Integer.parseInt(parts[0]);
                    int gameIDFromCSV = Integer.parseInt(parts[1]);
                    if (gameID == gameIDFromCSV) {
                        String username = parts[2];
                        String comment = parts[3];
                        int rating = Integer.parseInt(parts[4]);
                        int rating2 = Integer.parseInt(parts[5]);
                        int rating3 = Integer.parseInt(parts[6]);

                        Review review = new Review(reviewID, gameID, username, rating, rating2, rating3, comment);
                        gameReviews.add(review);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden: " + e.getMessage());
        }
        return gameReviews;
    }

    public static void writeEnquete(int reviewwID, List<String> answers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("enquetes.csv", true))) {
            writer.print(reviewwID + ";");
            for (String answer : answers) {
                writer.print(answer + ";");
            }
            writer.println("");
            System.out.println("Etiketten succesvol geschreven naar enquetes.csv");
        } catch (IOException e) {
            System.out.println("Fout bij het schrijven naar CSV-bestand: " + e.getMessage());
        }
    }

}
