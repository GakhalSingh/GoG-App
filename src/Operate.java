import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Operate {
    private List<Game> list;

    public Operate() {
        this.list = new ArrayList<>();
    }

    public void addLogic() {

    }

    public void searchLogic() {

    }

    public void orderLogic() {

    }

    public void addOperation() {

    }

    public void showAll() {

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