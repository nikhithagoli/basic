import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private String correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctAnswer1, final int maxMarks1,
             final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = choices[correctAnswer1 - 1].split(" ")[1];
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;

    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        String[] ch = choice.split(" ");
        if (this.correctAnswer.equals(ch[1])) {
            return true;
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int ten = 10;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[ten];
        size = 0;

    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * resizes.
     */
    public void resize() {
        questions =  Arrays.copyOf(questions, questions.length * 2);
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        if (size == questions.length) {
            resize();
        }
        questions[size++] = q;


    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int five = 5, four = 4, three = 3;
        if (q >= 1) {
            for (int i = 0; i < q; i++) {
                String l = scan.nextLine();
                String[] ques = l.split(":");
                if (ques.length == five && ques[0].length() != 0 && ques[1].length() != 0
                        && ques[2].length() != 0 && ques[3].length() != 0 && ques[4].length() != 0) {
                    String[] choices = ques[1].split(",");
                    if (choices.length >= 2) {
                        if (Integer.parseInt(ques[2]) >= 1
                                && Integer.parseInt(ques[2]) <= choices.length) {
                            if (Integer.parseInt(ques[three]) > 0) {
                                if (Integer.parseInt(ques[four]) <= 0) {
                                    quiz.addQuestion(new Question(ques[0], choices,
                                                                  Integer.parseInt(ques[2]),
                                                                  Integer.parseInt(ques[three]),
                                                                  Integer.parseInt(ques[four])));
                                } else {
                                    System.out.println("Invalid penalty for "
                                                       + ques[0]);
                                }
                            } else {
                                System.out.println("Invalid max marks for "
                                                   + ques[0]);
                            }
                        } else {
                            System.out.println("Error! Correct answer "
                                               + "choice number is out of range for " + ques[0]);
                        }
                    } else {
                        System.out.println(ques[0]
                                           + " does not have enough answer choices");
                    }
                } else {
                    System.out.println("Error! Malformed question");
                }
            }

        } else {
            System.out.println("Quiz does not have questions");
        }
        if (quiz.size() == q && q > 0) {
            System.out.println(Integer.toString(q) + " are added to the quiz");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText()
                               + "(" + quiz.getQuestion(i).getMaxMarks() + ")");
            String[] c = quiz.getQuestion(i).getChoice();
            for (int j = 0; j < c.length - 1; j++) {
                System.out.print(c[j] + "\t");
            }
            System.out.print(c[c.length - 1]);
            System.out.println();
            System.out.println();
            quiz.getQuestion(i).setResponse(scan.nextLine());
        }

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        int total = 0;
        if (quiz.size() > 0) {
            for (int i = 0; i < quiz.size(); i++) {
                Question que = quiz.getQuestion(i);
                System.out.println(que.getQuestionText());
                if (que.evaluateResponse(que.getResponse())) {
                    System.out.println(" Correct Answer! - Marks Awarded: "
                                       + que.getMaxMarks());
                    total += que.getMaxMarks();
                } else {
                    System.out.println(" Wrong Answer! - Penalty: "
                                       + que.getPenalty());
                    total += que.getPenalty();
                }
            }
            System.out.println("Total Score: " + total);
        }
    }

}
