import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Operate operate = new Operate();
        Menu menu = new Menu(operate);

        try {
            while (true) {
                menu.mainMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}