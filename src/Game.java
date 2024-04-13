public class Game {
    private int id;
    private String gameTitle;
    private String platform;
    private int releaseYear;
    private int onSale;
    private double price;
    private double avgRating;
    private String gameType;

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Game(int id, String gameTitle, String platform, int releaseYear, int onSale, double price, String gameType) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.onSale = onSale;
        this.price = price;
        this.gameType = gameType;
        refreshPrice();
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

    public int isOnSale() {
        return onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
    }

    public double getPrice() {
        return price;
    }

    public void refreshPrice() {
        if (onSale != 0) {
            this.price = price - (price * (onSale*0.01));
        }
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
