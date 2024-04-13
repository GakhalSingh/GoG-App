public class Review {
    private int reviewID;
    private int gameID;
    private String username;
    private int gameplayScore;
    private int graphicsScore;
    private int storylineScore;
    private String comment;

    public Review(int reviewID, int gameID, String username, int gameplayScore, int graphicsScore, int storylineScore, String comment) {
        this.reviewID = reviewID;
        this.gameID = gameID;
        this.username = username;
        this.gameplayScore = gameplayScore;
        this.graphicsScore = graphicsScore;
        this.storylineScore = storylineScore;
        this.comment = comment;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGameplayScore() {
        return gameplayScore;
    }

    public void setGameplayScore(int gameplayScore) {
        this.gameplayScore = gameplayScore;
    }

    public int getGraphicsScore() {
        return graphicsScore;
    }

    public void setGraphicsScore(int graphicsScore) {
        this.graphicsScore = graphicsScore;
    }

    public int getStorylineScore() {
        return storylineScore;
    }

    public void setStorylineScore(int storylineScore) {
        this.storylineScore = storylineScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getAvgRating() {
        return (gameplayScore + graphicsScore + storylineScore) / 3.0;
    }

    @Override
    public String toString() {
        return "Review ID: " + reviewID + "\n" +
                "Game ID: " + gameID + "\n" +
                "Gebruikersnaam: " + username + "\n" +
                "Gameplay Score: " + gameplayScore + "\n" +
                "Graphics Score: " + graphicsScore + "\n" +
                "Storyline Score: " + storylineScore + "\n" +
                "Opmerking: " + comment + "\n";
    }
}
