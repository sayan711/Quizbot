import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuizBuilder {


    public static Quiz buildQuiz(String filepath, String name, String shortName) {
        Quiz thisQuiz = new Quiz(name, shortName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String nextLine;

            while((nextLine = reader.readLine()) != null) {
                String q = nextLine;
                String a = reader.readLine();
                thisQuiz.addQuestion(q,a);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        thisQuiz.currentQuestion = thisQuiz.questions.remove(0);
        return thisQuiz;
    }
}
