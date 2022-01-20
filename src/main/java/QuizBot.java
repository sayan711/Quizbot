import java.util.HashMap;
import java.util.Map;

/**
 * QuizBot presents a series of Question Banks. The user can choose
 */
public class QuizBot {
    Map<String, Quiz> quizzes;

    public QuizBot() {
        quizzes = new HashMap<>();
    }

    public void addQuiz(Quiz quiz) {
        quizzes.put(quiz.shortTitle, quiz);
    }

    public boolean hasQuiz(String key) {
        return quizzes.containsKey(key);
    }

    public Quiz getQuiz(String key) {
        return quizzes.get(key);
    }

    public String showQuizzes() {
        String result = "";
        for (Quiz q: quizzes.values()) {
            result += q.shortTitle + " : " + q.title + "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return "QuizBot{" +
                "quizzes=" + quizzes +
                '}';
    }
}
