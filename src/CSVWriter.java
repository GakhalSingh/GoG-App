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
            writer.println("ID;GameTitle;Platform;ReleaseYear;OnSale;Price");
            for (Game game : games) {
                writer.println(
                        game.getId() + ";" +
                                game.getGameTitle() + ";" +
                                game.getPlatform() + ";" +
                                game.getReleaseYear() + ";" +
                                game.isOnSale() + ";" +
                                game.getPrice()
                );
            }
            System.out.println("Gegevens succesvol geschreven naar " + filePath);
        } catch (IOException e) {
            System.out.println("Fout bij het schrijven naar CSV-bestand: " + e.getMessage());
        }
    }

    // afblijven - jin
    public void createReview(Review review) {
        try (FileWriter fileWriter = new FileWriter("GoG-App/reviews.csv", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            int reviewID = review.getReviewID();
            int gameID = review.getGameID();
            String username = review.getUsername();
            int rating = review.getRating();
            String comment = review.getComment();

            printWriter.println(reviewID + ";" + gameID + ";" + username + ";" + rating + ";" + comment);
            System.out.println("Review toegevoegd: " + review);
        } catch (IOException e) {
            System.out.println("Fout bij het schrijven van de review: " + e.getMessage());
        }
    }

    public List<Review> readReviewsForGame(int gameID) {
        List<Review> gameReviews = new ArrayList<>();
        try {
            File file = new File("GoG-App/reviews.csv");
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int reviewID = Integer.parseInt(parts[0]);
                    int gameIDFromCSV = Integer.parseInt(parts[1]);
                    if (gameID == gameIDFromCSV) {
                        String username = parts[2];
                        int rating = Integer.parseInt(parts[3]);
                        String comment = parts[4];

                        Review review = new Review(reviewID, gameID, username, rating, comment);
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
}