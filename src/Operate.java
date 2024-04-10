import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operate {
    private List<Game> gameList;
    private CSVWriter csvWriter;
    private CSVReader csvReader;
    private Scanner scanner;


    public Operate() {
        this.gameList = new ArrayList<>();
        this.csvReader = new CSVReader();
        this.csvWriter = new CSVWriter();
        this.gameList.addAll(csvReader.readGames());
        this.scanner = new Scanner(System.in);
    }

    public void addNewGameReview() {
        System.out.println("Over welk spel wil je een review plaatsen:");
        String gameNaam = scanner.nextLine();
        System.out.println("Wat zou je de game geven (1/5 sterren):");
        int gameRate = scanner.nextInt();
        if (gameRate <= 5 || gameRate >= 1){
            System.out.println("wat kan je er nog over vertellen?");
            String gameReview = scanner.nextLine();
        }
        else{
            System.out.println("de rating was in valid");


    }


    public void searchLogic() {

        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while (true) {
            menu.searchMenu();
            int item = telNoteRegex.menuItemValidate(1,5);
            switch (item) {
                case 1:
                    this.searchByNaam();
                    break;
                case 2:
                    this.searchByJaartal();
                    break;
                case 3:
                    this.searchByAuteur();
                    break;
                case 4:
                    this.showAll();
                    break;
                case 5: return;
            }
        }

    }

    public void orderLogic() {
        System.out.println("Beheeren van opzoeken Ranglijst logic");
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while (true) {
            menu.orderMeun();
            int item = telNoteRegex.menuItemValidate(1,3);
            switch (item) {
                case 1:
                    this.orderBeoordeling();
                    break;
                case 2:
                    this.orderType();
                    break;
                case 3:return;

            }
        }

    }

    public void salesOperation() {
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while (true) {
            menu.salesMenu();
        }

    }
    public void readGamesFromCSV() {
        CSVReader csvReader = new CSVReader();
        List<Game> gamesFromCSV = csvReader.readGames();
        gameList.addAll(gamesFromCSV);
    }

    public void addOperation(){
        // om een review toevoegen
        System.out.println("review toevoegen");
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String naam = telNoteRegex.naamValidate();
        String jaartal = telNoteRegex.jaartalValidate();
        String auteur = telNoteRegex.auteurValidate();

        int prijs = telNoteRegex.prijsValidate();

        Game game = new Game(naam,jaartal,auteur,prijs,gameplay,graphics,storyline);
        this.list.add(game);
        game.setId(this.list.size());

    }

    public void showAll() {
        System.out.println("Alle games in de lijst:");
        for (Game game : gameList) {
            System.out.println(game.toString());
        }
    }


    public void searchByName(String gameName) {
        boolean found = false;
        for (Game game : gameList) {
            if (game.getGameTitle().equalsIgnoreCase(gameName)) {
                System.out.println("Gevonden game:");
                System.out.println(game);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Geen game gevonden met de naam: " + gameName);
        }
    }

    public void searchByAuteur() {

    }

    public void searchByJaartal() {

    }

    public void orderBeoordeling() {
        gameList.sort(new OrderByBeoordeling());
        showAll();
    }

    public void orderType() {
        gameList.sort(new OrderByType());
        showAll();
    }

    static class OrderByBeoordeling implements Comparator<Game> {
        @Override
        public int compare(Game o1, Game o2) {
            return 0;
        }
    }

    static class OrderByType implements Comparator<Game> {
        @Override
        public int compare(Game o1, Game o2) {
            return 0;

        }
    }
}