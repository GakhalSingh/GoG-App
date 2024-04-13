import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

public class Operate {
    private List<Game> gameList;
    private List<Review> reviewList;
    private List<Enquete> enqueteList;
    private CSVWriter csvWriter;
    private Scanner scanner;

    public Operate() {
        this.gameList = CSVReader.readGames();
        this.reviewList = CSVReader.readReviews();
        this.enqueteList = CSVReader.getEnqueteResponses();
        this.csvWriter = new CSVWriter();
        this.scanner = new Scanner(System.in);
    }
    public List<Game> getGameList() {
        return gameList;
    }

    public List<Review> getReviewList(){
        return reviewList;
    }

    public void addNewReview() {
        System.out.println("Over welk spel wil je een review plaatsen?");
        String gameName = scanner.nextLine();
        Game game = findGameByName(gameName);
        if (game != null) {
            int reviewID = getNextReviewID();
            System.out.println("Geef je gebruikersnaam:");
            String username = scanner.nextLine();
            System.out.println("Geef de gameplay score (1-10):");
            int gameplayScore = Menu.menuKeuze(10, scanner);
            System.out.println("Geef de graphics score (1-10):");
            int graphicsScore = Menu.menuKeuze(10, scanner);
            System.out.println("Geef de storyline score (1-10):");
            int storylineScore = Menu.menuKeuze(10, scanner);
            scanner.nextLine();
            System.out.println("Voeg een opmerking toe:");
            String comment = scanner.nextLine();

            System.out.println("Wil je nog meedoen met onze vragenlijst (Y/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                Enquete enquete = new Enquete(reviewID);
                enquete.startEnquete();

            }
            Review review = new Review(reviewID, game.getId(), username, gameplayScore, graphicsScore, storylineScore, comment);
            reviewList.add(review);
            csvWriter.createReview(review);
            System.out.println("Review succesvol toegevoegd!");
        } else {
            System.out.println("Game niet gevonden.");
        }
    }

    public void showAllReviews() {
        System.out.println(reviewList);
        if (!reviewList.isEmpty()) {
            for (Review review : reviewList) {
                System.out.println(review);
            }
            //TODO een andere versie van displayEnquete maken die dit geeft als er geen parameter is
            System.out.println("Vul een review ID in om de bijbehorende enquete te lezen, " +
                    "toets 0 in om terug te gaan naar het hoofdmenu.");
            int enqueteChoice = Menu.menuKeuze(99999, scanner);
            System.out.println();
            if (enqueteChoice == 0){
                return;
            }
            displayEnquete(enqueteChoice);

        } else {
            System.out.println("Er zijn nog geen reviews toegevoegd.");
        }
    }

    private void displayEnquete(int enqueteChoice) {
        for (Enquete enquete : enqueteList){
            if (enquete.getReviewID() == enqueteChoice){
                int counter = 0;
                for (String question : enquete.getQuestions()){
                    System.out.println(question);
                    System.out.println(enquete.getAnswers().get(counter));
                    System.out.println(String.format("%35s"," ").replace(" ", "="));
                    counter++;
                }
            }
        }
    }

    public Review getReview(int reviewID){
        try{
            File file = new File("reviews.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                for (Review review : reviewList){
                    if (review.getReviewID() == reviewID){
                        return review;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void showReviewsByGame() {
        System.out.println("Voer de naam van de game in om de reviews te bekijken:");
        String gameName = scanner.nextLine();
        Game game = null;
        for (Game g : gameList) {
            if (g.getGameTitle().equalsIgnoreCase(gameName)) {
                game = g;
                break;
            }
        }
        if (game != null) {
            List<Review> reviews = csvWriter.readReviewsForGame(game.getId());
            if (!reviews.isEmpty()) {
                System.out.println("Reviews voor " + gameName + ":");
                for (Review review : reviews) {
                    System.out.println(review);
                }
            } else {
                System.out.println("Er zijn geen reviews voor " + gameName + ".");
            }
        } else {
            System.out.println("Geen game gevonden met de naam: " + gameName);
        }
    }

    public void searchByName(String gameName) {
        boolean found = false;
        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(gameName)) {
                System.out.println("Gevonden game:");
                System.out.println(game);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Geen game gevonden met de naam: " + gameName);
        }
    }

    public void searchByJaar(int gameJaar) {
        boolean found = false;
        System.out.println("Games uit het jaar " + gameJaar + ":");
        for (Game game : gameList) {
            if (game.getReleaseYear() == gameJaar) {
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen games gevonden uit het jaar " + gameJaar);
        }
    }

    public void searchBySale(int gameOnSale) {
        boolean found = false;
        for (Game game : gameList) {
            if (game.isOnSale() >= 1 && game.isOnSale() <= gameOnSale) {
                System.out.printf("| %3d %s | %20s | € %3.2f |",game.isOnSale(),"%",game.getGameTitle(), game.getPrice());
                System.out.println();
                found = true;

            }
        }

        if (!found) {
            System.out.println("Geen games in de uitverkoop :(");
        }
    }

    public void searchByPlatform(String platform) {
        boolean found = false;
        System.out.println("Games op het platform " + platform + ":");
        for (Game game : gameList) {
            if (game.getPlatform().equalsIgnoreCase(platform)) {
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen games gevonden op het platform " + platform);
        }
    }
    public void searchByType(String type) {
        boolean found = false;
        System.out.println("Games op de type " + type + ":");
        for (Game game : gameList) {
            if (game.getGameType().equalsIgnoreCase(type)) {
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen games gevonden op het platform " + type);
        }
    }

    private Game findGameByName(String gameName) {
        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return null;
    }

    private int getNextReviewID() {
        int maxID = 0;
        for (Review review : reviewList) {
            if (review.getReviewID() > maxID) {
                maxID = review.getReviewID();
            }
        }
        return maxID + 1;
    }

    public void ratingByavgRating() {
        Collections.sort(gameList, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return Double.compare (o2.getAvgRating(), o1.getAvgRating());
            }
        });
        System.out.println ("Rank op basis van Eind Score: ");
        DecimalFormat df = new DecimalFormat("#.0");
        int rank =1;
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        for (Game game : gameList){
            System.out.printf("║ Rank: %-4s ║ %.1f  GameTitle: %-34s ║\n", rank, game.getAvgRating(), game.getGameTitle());
            rank++;

        }
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");

    }

    public void ratingByReleaseYear (){
        Collections.sort(gameList, new Comparator<Game>() {
            @Override
            public int compare(Game g1, Game g2) {
                return Integer.compare(g1.getReleaseYear(), g2.getReleaseYear());
            }
        });
        System.out.println ("Rank op basis van ReleaseYear: ");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        for (Game game : gameList){
            System.out.printf("║ %d ║ GameTitel: %-34s ║\n", game.getReleaseYear(), game.getGameTitle());
        }
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public void ratingByPlatform() {
        Collections.sort(gameList, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return o1.getPlatform().compareTo(o2.getPlatform());
            }
        });
        System.out.println ("Rank op basis van Platform: ");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        for (Game game : gameList){
            System.out.printf("║ %-15s║\tGameTitel:  %-23s║\n", game.getPlatform(), game.getGameTitle());

        }
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public void ratingBygameType(){
        Collections.sort(gameList, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return o1.getGameType().compareTo(o2.getGameType());
            }
        });
        System.out.println ("Rank op basis van Type: ");
        System.out.println("╔══════════════════════════════════════════════════════╗");
        for (Game game : gameList){
            System.out.printf( "║ %-8s║\tGameTitel:  %-30s ║\n", game.getGameType(), game.getGameTitle());

        }
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    public void showAll() {
        System.out.println("Alle games in de lijst:");
        for (Game game : gameList) {
            System.out.println(game);
        }
    }

}