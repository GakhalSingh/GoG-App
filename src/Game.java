public class Game {
    private int id;
    private String gameTitle;
    private String platform;
    private int releaseYear;
    private boolean onSale;
    private double price;
    private double avgRating;

    public Game(int id, String gameTitle, String platform, int releaseYear, boolean onSale, double price) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.onSale = onSale;
        this.price = price;
        setAvgRating();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvgRating(){
        int reviewcount = 0;
        double avgRating = 0;
        for (Review review : CSVReader.readReviews()){
            if (review.getGameID() == this.id){
                avgRating += review.getAvgRating();
                reviewcount++;
            }
        }
        if (reviewcount != 0){
            this.avgRating = avgRating / reviewcount;
        }
    }
    public double getAvgRating(){
        return avgRating;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", platform='" + platform + '\'' +
                ", releaseYear=" + releaseYear +
                ", onSale=" + onSale +
                ", price=" + price +
                '}';
    }
}
