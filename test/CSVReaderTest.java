import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class CSVReaderTest {

    /**
     * Test om te verzekeren dat de methode geen uitzondering gooit als het bestand bestaat.
     * Dit verzekert dat het pad naar het bestand correct is ingesteld en dat het bestand toegankelijk is
     * tijdens het testen.
     */
    @Test
    public void testFileExists() {
        assertDoesNotThrow(() -> CSVReader.readGames());
    }

    /**
     * Test om te controleren of de header van het CSV-bestand correct wordt genegeerd.
     * Dit is belangrijk om te verzekeren dat geen onnodige of incorrecte data als objecten wordt gelezen.
     */
    @Test
    public void testHeaderIgnored() {
        List<Game> games = CSVReader.readGames();
        assertFalse(games.isEmpty(), "The games list should not be empty.");
        // Voeg hier specifieke controles toe om te bevestigen dat de header niet als een Game object wordt gelezen
    }

    /**
     * Test om te verzekeren dat elke rij uit het CSV-bestand correct wordt geparseerd naar een Game object.
     * Dit controleert of de data correct wordt geïnterpreteerd en dat de Game objecten correct worden aangemaakt.
     */
    @Test
    public void testDataParsing() {
        List<Game> games = CSVReader.readGames();
        assertNotNull(games);
        assertTrue(games.get(0) instanceof Game, "First item should be a Game instance.");
        // Voeg meer gedetailleerde tests toe gebaseerd op verwachte waarden.
    }


}

