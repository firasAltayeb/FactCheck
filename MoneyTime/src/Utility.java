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


    public void newQuestion(JButton[] optionBtnArray, JLabel questionLabel) {
        int randNum = random.nextInt(3) + (3 * questionCounter);
        currentQuestion = allQuestions.get(randNum);
        optionArray = currentQuestion.getAnsList();
        questionLabel.setText(currentQuestion.getQusTxt());
        correctAnswer = currentQuestion.getCorrectAnswer().getAnsTxt();
        for (int i = 0; i < optionBtnArray.length; i++) {
            optionBtnArray[i].setText(optionArray.get(i).getAnsTxt());
            optionBtnArray[i].setEnabled(true);
        }
    }


    public void oneUpQuestion(JButton[] optionBtnArray, JLabel questionLabel) {
        oneUpQus = true;
        int r = random.nextInt(5) + 43;
        currentQuestion = allQuestions.get(r);
        optionArray = currentQuestion.getAnsList();
        questionLabel.setText(currentQuestion.getQusTxt());
        correctAnswer = currentQuestion.getCorrectAnswer().getAnsTxt();
        for (int i = 0; i < optionBtnArray.length; i++) {
            optionBtnArray[i].setText(optionArray.get(i).getAnsTxt());
            optionBtnArray[i].setBackground(Color.RED);
        }
    }

    public void restartGame(int difficulty, JLabel[] labels, JButton[] jButtonArray2, JLabel ms) {
        questionCounter = 0;
        mistakeCounter = difficulty;
        colorChanger("red", labels);
        ms.setText("MISTAKE COUNTER = " + difficulty);
        for (JButton button : jButtonArray2)
            button.setEnabled(true);
    }
}
