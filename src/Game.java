public class Game {
    private int id;
    private String naam;
    private String jaartal;
    private String auteur;

    public Game(String naam, String jaartal, String auteur) {

        this.naam = naam;
        this.jaartal = jaartal;
        this.auteur = auteur;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getJaartal() {
        return jaartal;
    }

    public void setJaartal(String jaartal) {
        this.jaartal = jaartal;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ID").append(this.id).append("#").append("\t");
        sb.append("Naam: ").append(this.naam).append("\t\t");
        sb.append("Jaartal: ").append(this.jaartal).append("\t\t");
        sb.append("Auteur: ").append(this.auteur).append("\t\t");
        return sb.toString();
    }
}
