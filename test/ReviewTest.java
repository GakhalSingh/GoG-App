import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void testGetAvgRating() {
        // Setup: creëer een Review instantie met bekende waarden
        Review review = new Review(1, 1, "User", 8, 7, 9, "Great game!");

        // Berekening van het verwachte gemiddelde
        double expectedAverage = (8 + 7 + 9) / 3.0;

        // Assert: controleer of de getAvgRating methode het verwachte gemiddelde teruggeeft
        assertEquals(expectedAverage, review.getAvgRating(), 0.01, "De gemiddelde rating moet correct berekend worden.");
    }
}
