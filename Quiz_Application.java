
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int correctAnswerIndex;

    Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
class QuizGame {
    private List<Question> questions;
    private int score;
    private static final int TIME_LIMIT = 10; // seconds

    public QuizGame() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of USA?",
                new String[]{"1. Berlin", "2. Washington", "3. Madrid", "4. Rome"},
                1));
        questions.add(new Question("What is old name of mumbai?",
                new String[]{"1. karnavati", "2. Bombay", "3. calicut", "4. shambhajinagar"},
                1));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"},
                1));
        // Add more questions as needed
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            boolean answered = askQuestion(question, scanner);
            if (!answered) {
                System.out.println("Time's up! Moving to the next question.");
            }
        }
        displayResults();
        scanner.close();
    }

    private boolean askQuestion(Question question, Scanner scanner) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        final boolean[] answered = {false};
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered[0]) {
                    System.out.println("Time's up!");
                }
            }
        }, TIME_LIMIT * 1000);

        System.out.print("Your answer (1-4): ");
        int answer = -1;
        try {
            answer = Integer.parseInt(scanner.nextLine()) - 1;
            answered[0] = true;
            timer.cancel();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
        }

        if (answered[0] && answer == question.correctAnswerIndex) {
            score++;
            System.out.println("Correct!\n");
        } else if (answered[0]) {
            System.out.println("Incorrect!\n");
        }

        return answered[0];
    }

    private void displayResults() {
        System.out.println("Quiz Finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        System.out.println(("-".repeat(15)));
        System.out.println("|"+" QUIZ GAME "+"|");
        System.out.println(("-".repeat(15)+"\n"));


        QuizGame quizGame = new QuizGame();
        quizGame.startQuiz();
    }
}
