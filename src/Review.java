public class Review {
    private int reviewID;
    private int gameID;
    private String username;
    private int rating;
    private String comment;

    public Review(int reviewID, int gameID, String username, int rating, String comment) {
        this.reviewID = reviewID;
        this.gameID = gameID;
        this.username = username;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", gameID=" + gameID +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
