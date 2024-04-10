import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Operate {
    private List<Game> list;

    public Operate() {
        this.list = new ArrayList<>();
    }

    public void addLogic() {
        // Game toevoegen

        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while (true) {
            menu.addMenu();
            int item = telNoteRegex.menuItemValidate(1,3);
            switch (item) {
                case 1:
                    this.addOperation();
                    break;
                case 2:
                    this.showAll();
                    break;
                case 3: return;
            }
        }

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
        System.out.println ("alle game te zien");
    }

    public void searchByNaam() {


    }

    public void searchByAuteur() {

    }

    public void searchByJaartal() {

    }

    public void orderBeoordeling() {

    }

    public void orderType() {

    }

    class OrderByBeoordeling implements Comparator<Game> {

        @Override
        public int compare(Game o1, Game o2) {
            return 0;
        }
    }

    class OrderByType implements Comparator<Game> {

        @Override
        public int compare(Game o1, Game o2) {
            return 0;

        }

    }
}