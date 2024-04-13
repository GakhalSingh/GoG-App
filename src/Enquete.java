import java.util.ArrayList;
import java.util.Scanner;

public class Enquete {
    private final int reviewID;
    private final ArrayList<String> questions;
    private ArrayList<String> answers;

    public Enquete(int reviewID) {
        this.reviewID = reviewID;
        this.questions = CSVReader.getEnqueteQuestions();
        this.answers = new ArrayList<>();
    }
    public int getReviewID(){
        return reviewID;
    }
    public ArrayList<String> getQuestions(){
        return questions;
    }
    public ArrayList<String> getAnswers(){
        return answers;
    }
    public void setAnswers(ArrayList<String> answers){
        this.answers = answers;
    }

    public void startEnquete() {
        Scanner scanner = new Scanner(System.in);
        for (String question : questions) {
            System.out.println(question);
            String answer = scanner.nextLine();
            answers.add(answer);
        }
        System.out.println("Bedankt voor het invullen van de enquete!");
        CSVWriter.writeEnquete(reviewID,answers);
    }

}
