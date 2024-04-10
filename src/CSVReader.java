import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public List<Game> readGames() {
        List<Game> list = new ArrayList<>();
        try {
            File file = new File("GoG-App1\\games.csv");
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
    }}