import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    String title; //example: "How much do you know about World War II?"
    String shortTitle; //example: "wwii"
    List<Question> questions = new ArrayList<>();

    Question currentQuestion;

    public Quiz() {
    }

    public Quiz(String title, String shortTitle) {
        this.title = title;
        this.shortTitle = shortTitle;
    }

    public boolean hasNextQuestion() {
        return questions.size() > 0;
    }

    public Question getNextQuestion() {
        //First, get the current question and save it in a variable.
        Question result = currentQuestion;
        //Set the current question to the next one in line.
        if (questions.size() > 0) {
            setCurrentQuestion(questions.remove(0));
        } else {
            currentQuestion = null;
        }
        return result;
    }

    public void setCurrentQuestion(Question q) {
        currentQuestion = q;
    }

    public void addQuestion(String q, String a) {
        questions.add(new Question(q,a));
    }

    public void takeQuiz() {
        for (Question q : questions ){
            System.out.println(q.getQuestionText());
            Scanner scan = new Scanner(System.in);
            String response = scan.nextLine();
            if(q.checkAnswer(response)) {
                System.out.println("That is correct!");
            } else {
                System.out.println("Oops!");
            }
        }
    }
}
