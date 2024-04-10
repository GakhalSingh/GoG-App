public class Game {
    private int id;
    private String gameTitle;
    private String platform;
    private int releaseYear;
    private boolean onSale;
    private double price;

    public Game(int id, String gameTitle, String platform, int releaseYear, boolean onSale, double price) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.onSale = onSale;
        this.price = price;
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

    @Override
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ID").append(this.id).append("#").append("\t");
        sb.append("Naam: ").append(this.gameTitle).append("\t\t");
        sb.append("Jaartal: ").append(this.jaartal).append("\t\t");
        sb.append("Auteur: ").append(this.auteur).append("\t\t");
        sb.append("Prijs: ").append(this.prijs).append("\t\t\n\n");
        sb.append("Gameplay: ").append(this.gameplay).append("\n");
        sb.append("Graphics: ").append(this.graphics).append("\n");
        sb.append("Storyline: ").append(this.storyline).append("\n");
        return sb.toString();
    }
}
