import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {
    public void writeGames(List<Game> games, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Schrijf de kop van het CSV-bestand
            writer.println("ID;GameTitle;Platform;ReleaseYear;OnSale;Price");

            // Schrijf elk Game-object naar het CSV-bestand
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
}