import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSVWriterTest {

    /**
     * Test om te controleren of de 'writeGames' methode een bestand succesvol creëert.
     * Dit is belangrijk om te verzekeren dat de applicatie in staat is om data persistent te maken
     * in de vorm van een CSV-bestand, wat een basisfunctionaliteit is van de CSVWriter.
     */
    @Test
    public void testFileCreation() throws IOException {
        List<Game> games = Arrays.asList(new Game(1, "TestGame", "PC", 2021, 85, 59.99, "Action"));
        String filePath = "test_games.csv";
        CSVWriter writer = new CSVWriter();
        writer.writeGames(games, filePath);

        File file = new File(filePath);
        assertTrue(file.exists(), "File wordt gemaakt.");
        file.delete();
    }

    /**
     * Test om te verzekeren dat de inhoud van het geschreven bestand correct is.
     * Dit controleert of de 'writeGames' methode de gegevens correct formatteert en correct
     * naar het bestand schrijft, wat cruciaal is voor de data-integriteit.
     */
    @Test
    public void testFileContent() throws IOException {
        List<Game> games = Arrays.asList(new Game(1, "TestGame", "PC", 2021, 85, 8.9985, "Action"));
        String filePath = "test_games_content.csv";
        CSVWriter writer = new CSVWriter();
        writer.writeGames(games, filePath);

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String header = reader.readLine();
        String firstLine = reader.readLine();
        assertEquals("ID;GameTitle;Platform;ReleaseYear;OnSale;Pric;Type", header, "Header moet verwacht op format.");
        assertEquals("1;TestGame;PC;2021;85;1.3497750000000002;Action", firstLine, "Content moet verwacht op format.");

        reader.close();
        new File(filePath).delete(); // Cleanup after test
    }

}



