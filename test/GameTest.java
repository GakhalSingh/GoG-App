import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {

    // Deze test verifieert de `refreshPrice`-methode om er zeker van te zijn dat een korting correct wordt toegepast

    @Test
    public void testRefreshPrice() {
        Game game = new Game(1, "Test Game", "PC", 2021, 10, 100.0, "RPG"); // 10% sale
        game.refreshPrice();
        assertEquals(81.0, game.getPrice(), 0.01);
    }

    // Deze test controleert of de standaardprijs ongewijzigd blijft als er geen verkoop is.

    @Test
    public void testPriceNoSale() {
        Game game = new Game(1, "Test Game", "PC", 2021, 0, 100.0, "RPG"); // No sale
        game.refreshPrice();
        assertEquals(100.0, game.getPrice(), 0.01);
    }
}
