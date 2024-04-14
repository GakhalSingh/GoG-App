import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class EnqueteTest {

    /**
     * Test de constructor om te verzekeren dat een Enquete object correct wordt geïnitialiseerd.
     */
    @Test
    public void testConstructor() {
        Enquete enquete = new Enquete(1);
        assertNotNull(enquete, "Het Enquete-object moet worden gemaakt");
        assertEquals(1, enquete.getReviewID(), "ReviewID moet overeenkomen met degene die aan de constructor is doorgegeven");
    }

    /**
     * Test de getQuestions methode om te verzekeren dat het de correcte vragenlijst teruggeeft.
     */
    @Test
    public void testGetQuestions() {
        Enquete enquete = new Enquete(1);
        ArrayList<String> questions = enquete.getQuestions();
        assertNotNull(questions, "Moet een lijst met vragen retourneren");
        assertFalse(questions.isEmpty(), "De vragenlijst mag niet leeg zijn");
    }



}
