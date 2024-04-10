public class Game {
    private int id;
    private String naam;
    private int jaartal;
    private String auteur;
    private double beoordeling;
    private String type;

    public Game(String naam, int jaartal, String auteur, double beoordeling, String type) {
        this.id = id;
        this.naam = naam;
        this.jaartal = jaartal;
        this.auteur = auteur;
        this.beoordeling = beoordeling;
        this.type = type;
    }

    public int getId() {
        return id;
    }public String getNaam() {
        return naam;
    }public int getJaartal() {
        return jaartal;
    }public String getAuteur() {
        return auteur;
    }public double getBeoordeling() {
        return beoordeling;
    }public String getType() {
        return type;
    }public void setId(int id) {
        this.id = id;
    }public void setNaam(String naam) {
        this.naam = naam;
    }public void setJaartal(int jaartal) {
        this.jaartal = jaartal;
    }public void setAuteur(String auteur) {
        this.auteur = auteur;
    }public void setBeoordeling(double beoordeling) {
        this.beoordeling = beoordeling;
    }public void setType(String type) {
        this.type = type;
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
