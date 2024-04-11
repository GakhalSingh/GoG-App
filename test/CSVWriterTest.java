import static org.junit.jupiter.api.Assertions.*;

class CSVWriterTest {

    @org.junit.jupiter.api.Test
    void writeGames() {
    }

    @org.junit.jupiter.api.Test
    void createReview() {
    }

    @org.junit.jupiter.api.Test
    void readReviewsForGame() {
    }

    @org.junit.jupiter.api.Test
    void writeEnquete() {
    }

    @org.junit.jupiter.api.Test
    void writeUser() {
        User testUser = new User("joris2710","supergeheim");
        try{
            CSVWriter.writeUser(testUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}