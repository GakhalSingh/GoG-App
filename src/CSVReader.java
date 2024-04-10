import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static List<Game> readGames() {
        List<Game> list = new ArrayList<>();
        try {
            File file = new File("GoG-App/games.csv");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] parts = data.split(";");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String gameTitle = parts[1];
                    String platform = parts[2];
                    int releaseYear = Integer.parseInt(parts[3]);
                    boolean onSale = Boolean.parseBoolean(parts[4]);
                    double price = Double.parseDouble(parts[5]);

                    Game game = new Game(id, gameTitle, platform, releaseYear, onSale, price);
                    list.add(game);
                } else {
                    System.out.println("Ongeldige rij: " + data);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSV bestand niet gevonden 😔");
        }
        return list;
    }

    public List<Review> readReviews() {
        List<Review> reviews = new ArrayList<>();
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
                    int gameID = Integer.parseInt(parts[1]);
                    String username = parts[2];
                    int rating = Integer.parseInt(parts[3]);
                    String comment = parts[4];

                    Review review = new Review(reviewID, gameID, username, rating, comment);
                    reviews.add(review);
                } else {
                    System.out.println("Ongeldige rij: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden 🥲");
        }
        return reviews;
    }

    // dit is om te testen delete nadat we klaar zijn
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<Game> games = csvReader.readGames();
        List<Review> reviews = csvReader.readReviews();

        for (Game game : games) {
            System.out.println(game);
        }

        for (Review review : reviews) {
            System.out.println(review);
        }
    }
}
