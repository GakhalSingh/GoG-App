import java.util.ArrayList;
import java.util.Scanner;

public class Enquete {
    private int reviewID;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public Enquete(int reviewID) {
        this.reviewID = reviewID;
        this.questions = CSVReader.getEnqueteQuestions();
    }
    public void startEnquete() {
        Scanner scanner = new Scanner(System.in);
        for (String question : questions) {
            System.out.println(question);
            String answer = scanner.nextLine();
            answers.add(answer);
        }
        System.out.println("Bedankt voor het invullen van de enquete!");
        CSVWriter.writeEnquete(answers);
    }


}
