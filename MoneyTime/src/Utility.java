import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Utility {

	 Answers currentQuestionAnswers = new Answers();
	 Questions allQuestions = new Questions();
	 Random random = new Random();
	 String[] qusListArray = allQuestions.createArray();
	 String[] answerOptionArray;
	 String correctAnswer;
	 String currentQuestion;
	 int questionCounter = 0;
	 int mistakeCounter = 5;
	 boolean oneUpQus;

	public Utility() {
		currentQuestion = qusListArray[random.nextInt(3)];
		answerOptionArray = currentQuestionAnswers.getOptions(currentQuestion);
		correctAnswer = currentQuestionAnswers.getCorrectAnswer(currentQuestion);
	}


	public  void colorChanger(String color, JLabel[] labels) {
		if (color.equalsIgnoreCase("yellow"))
			for (int i = 0; i < labels.length; i++) {
				if (i <= questionCounter)
					labels[i].setForeground(Color.yellow);
			}
		else if (color.equalsIgnoreCase("red"))
			for (JLabel label : labels)
				label.setForeground(Color.red);
	}

	/*Assigns currentQuestion to a question based on the integer which is received as an argument
	 and then assigns answerOptionArray and correctAnswer based on the currentQuestion's question,
	 The newQuestion method also assigns the options to the four answer buttons and colours their 
	 background to red to clear the effect of the 50/50 button   */
	public  void newQuestion(int r, JButton answerButtonOne, JButton answerButtonTwo, JButton
			answerButtonThree,
								   JButton answerButtonFour, JLabel questionLabel) {
		currentQuestion = qusListArray[r];
		answerOptionArray = currentQuestionAnswers.getOptions(currentQuestion);
		correctAnswer = currentQuestionAnswers.getCorrectAnswer(currentQuestion);
		questionLabel.setText(currentQuestion);
		answerButtonOne.setText(answerOptionArray[0]);
		answerButtonTwo.setText(answerOptionArray[1]);
		answerButtonThree.setText(answerOptionArray[2]);
		answerButtonFour.setText(answerOptionArray[3]);
		answerButtonOne.setEnabled(true);
		answerButtonTwo.setEnabled(true);
		answerButtonThree.setEnabled(true);
		answerButtonFour.setEnabled(true);
	}

	/*Sets one up as true to indicate that "1-up question" button is pressed and assigns currentQuestion 
	 to one of the last five  questions and then assigns answerOptionArray and correctAnswer based on the 
	 currentQuestion's question, The newQuestion method also assigns the options to the four answer buttons
	 and colours their background to red to clear the effect of the 50/50 button  */
	public  void oneUpQuestion(JButton answerButtonOne, JButton answerButtonTwo, JButton answerButtonThree,
									 JButton answerButtonFour, JLabel questionLabel) {
		oneUpQus = true;
		int r = random.nextInt(5) + 43;
		currentQuestion = qusListArray[r];
		answerOptionArray = currentQuestionAnswers.getOptions(currentQuestion);
		correctAnswer = currentQuestionAnswers.getCorrectAnswer(currentQuestion);
		questionLabel.setText(currentQuestion);
		answerButtonOne.setText(answerOptionArray[0]);
		answerButtonTwo.setText(answerOptionArray[1]);
		answerButtonThree.setText(answerOptionArray[2]);
		answerButtonFour.setText(answerOptionArray[3]);
		answerButtonOne.setBackground(Color.RED);
		answerButtonTwo.setBackground(Color.RED);
		answerButtonThree.setBackground(Color.RED);
		answerButtonFour.setBackground(Color.RED);
	}


}
