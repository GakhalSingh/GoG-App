import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static List<Game> readGames() {
        List<Game> list = new ArrayList<>();
        try {
            File file = new File("games.csv");
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
                    int onSale = Integer.parseInt(parts[4]);
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

    public static List<Review> readReviews() {
        List<Review> reviews = new ArrayList<>();
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
                    int gameID = Integer.parseInt(parts[1]);
                    String username = parts[2];
                    String comment = parts[3];
                    int gameplayScore = Integer.parseInt(parts[4]);
                    int graphicsScore = Integer.parseInt(parts[5]);
                    int storylineScore = Integer.parseInt(parts[6]);
                    Review review = new Review(reviewID, gameID, username, gameplayScore, graphicsScore, storylineScore, comment);
                    reviews.add(review);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden: " + e.getMessage());
        }
        return reviews;
    }

    public static ArrayList<String> getEnqueteQuestions(){
        ArrayList<String> enqueteQuestions = new ArrayList<>();
        try {
            File file = new File("enqueteVragen.txt");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                for (String part : parts) {
                    enqueteQuestions.add(part);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden: " + e.getMessage());
        }
        return enqueteQuestions;
    }
}