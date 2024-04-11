import java.util.*;

public class Operate {
    private List<Game> gameList;
    private List<Review> reviewList;
    private CSVWriter csvWriter;
    private CSVReader csvReader;
    private Scanner scanner;

    public Operate() {
        this.gameList = CSVReader.readGames();
        this.csvReader = new CSVReader();
        this.csvWriter = new CSVWriter();
        this.scanner = new Scanner(System.in);
    }
    public List<Game> getGameList() {
        return gameList;
    }

    public void addNewReview() {
        System.out.println("Over welk spel wil je een review plaatsen?");
        String gameName = scanner.nextLine();
        Game game = findGameByName(gameName);
        if (game != null) {
            System.out.println("Geef je gebruikersnaam:");
            String username = scanner.nextLine();
            System.out.println("Geef de gameplay score (1-10):");
            int gameplayScore = scanner.nextInt();
            System.out.println("Geef de graphics score (1-10):");
            int graphicsScore = scanner.nextInt();
            System.out.println("Geef de storyline score (1-10):");
            int storylineScore = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Voeg een opmerking toe:");
            String comment = scanner.nextLine();

            Review review = new Review(getNextReviewID(), game.getId(), username, gameplayScore, graphicsScore, storylineScore, comment);
            reviewList.add(review);
            csvWriter.createReview(review);
            System.out.println("Review succesvol toegevoegd!");
        } else {
            System.out.println("Game niet gevonden.");
        }
    }

    public void showAllReviews() {
        List<Review> reviews = csvReader.readReviews();
        System.out.println(reviews);
        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                System.out.println(review);
            }
        } else {

            System.out.println("Er zijn nog geen reviews toegevoegd.");
        }
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

    }

    public void ratingByReleaseYear (){
        Collections.sort(this.gameList, new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return o1.getReleaseYear() - o2.getReleaseYear();
            }
        });
    }
    public void showAll() {
        System.out.println("Alle games in de lijst:");
        for (Game game : gameList) {
            System.out.println(game);
        }
    }

}