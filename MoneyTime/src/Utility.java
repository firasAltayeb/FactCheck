import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class Utility {
    int[] amounts = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000,
            32000, 64000, 125000, 250000, 500000, 1000000};
    Random random = new Random();
    int questionCounter = 0;
    int mistakeCounter = 5;
    boolean oneUpQus;

    List<QuestionModel> allQuestions;
    List<AnswerModel> optionArray;
    QuestionModel currentQuestion;
    String correctAnswer;

    public Utility() {
        allQuestions = QuestionsProvider.getQuizQuestions();
        currentQuestion = allQuestions.get(random.nextInt(3));
        correctAnswer = currentQuestion.getCorrectAnswer().getAnsTxt();
        optionArray = currentQuestion.getAnsList();
    }


    public void colorChanger(String color, JLabel[] labels) {
        if (color.equalsIgnoreCase("yellow")) for (int i = 0; i < labels.length; i++) {
            if (i <= questionCounter) labels[i].setForeground(Color.yellow);
        }
        else if (color.equalsIgnoreCase("red")) for (JLabel label : labels)
            label.setForeground(Color.red);
    }


    public void newQuestion(JButton answerButtonOne, JButton answerButtonTwo, JButton answerButtonThree
            , JButton answerButtonFour, JLabel questionLabel) {
        int randNum = random.nextInt(3) + (3 * questionCounter);
        currentQuestion = allQuestions.get(randNum);
        optionArray = currentQuestion.getAnsList();
        questionLabel.setText(currentQuestion.getQusTxt());
        correctAnswer = currentQuestion.getCorrectAnswer().getAnsTxt();
        answerButtonOne.setText(optionArray.get(0).getAnsTxt());
        answerButtonTwo.setText(optionArray.get(1).getAnsTxt());
        answerButtonThree.setText(optionArray.get(2).getAnsTxt());
        answerButtonFour.setText(optionArray.get(3).getAnsTxt());
        answerButtonOne.setEnabled(true);
        answerButtonTwo.setEnabled(true);
        answerButtonThree.setEnabled(true);
        answerButtonFour.setEnabled(true);
    }


    public void oneUpQuestion(JButton answerButtonOne, JButton answerButtonTwo, JButton answerButtonThree,
                              JButton answerButtonFour, JLabel questionLabel) {
        oneUpQus = true;
        int r = random.nextInt(5) + 43;
        currentQuestion = allQuestions.get(r);
        optionArray = currentQuestion.getAnsList();
        questionLabel.setText(currentQuestion.getQusTxt());
        correctAnswer = currentQuestion.getCorrectAnswer().getAnsTxt();
        answerButtonOne.setText(optionArray.get(0).getAnsTxt());
        answerButtonTwo.setText(optionArray.get(1).getAnsTxt());
        answerButtonThree.setText(optionArray.get(2).getAnsTxt());
        answerButtonFour.setText(optionArray.get(3).getAnsTxt());
        answerButtonOne.setBackground(Color.RED);
        answerButtonTwo.setBackground(Color.RED);
        answerButtonThree.setBackground(Color.RED);
        answerButtonFour.setBackground(Color.RED);
    }

}
