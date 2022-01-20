import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("Hi I am a quiz bot. You can choose between 4 different quizzes!" );

        Scanner input = new Scanner(System.in);
        QuizBot thisBot = new QuizBot();
        thisBot.addQuiz(QuizBuilder.buildQuiz("impossibleQuiz.txt", "An impossible quiz.", "Impossible"));
        thisBot.addQuiz(QuizBuilder.buildQuiz("challengingMath.txt", "Some challenging math questions.", "Math"));
        thisBot.addQuiz(QuizBuilder.buildQuiz("usGeography.txt", "Quiz about US geography. ","Geography"));
        thisBot.addQuiz(QuizBuilder.buildQuiz("sports.txt", "Quiz about sports.", "Sports"));


        Quiz thisQuiz = null;
        while (thisQuiz == null) {
            System.out.println(thisBot.showQuizzes());
            System.out.println("Pick the quiz you want to take!(Type in the shortname to take that quiz.)");
            String userResponse = input.nextLine();
            if (thisBot.hasQuiz(userResponse)) {
                thisQuiz = thisBot.getQuiz(userResponse);
            }
        }

        while(thisQuiz.hasNextQuestion()) {
            Question q = thisQuiz.getNextQuestion();
            System.out.println(q.getQuestionText());
            String userGuess = input.nextLine();
            if(q.checkAnswer(userGuess) == true) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The answer was " + q.getAnswerText());
            }
        }


    }
}