package MoneyTime;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Random;

public class MTMethods 
{

	static MTAudio audio = new MTAudio();
	static Random random = new Random();
	static MTQuestions allQuestions = new MTQuestions();
	static MTAnswers currentQuestionAnswers = new MTAnswers();
	// qusListArray is an array that holds the questions provided by the questionList class.
	static String[] qusListArray = allQuestions.createArray();
	static String[] answerOptionArray;
	static String correctAnswer;
	static String currentQuestion;
	// questionCounter stores the progress of the game, the higher questionCounter becomes the closer end game gets.
	static int questionCounter = 0;
	//mistakeCounter determine the difficulty of the game, the lower the mistakeCounter becomes the harder the game gets. 
	static int mistakeCounter = 5;
	static boolean oneUp;

	public MTMethods()
	{
		int r = random.nextInt(3);
		// currentQuestion is assign a random question from the three first questions
		currentQuestion = qusListArray[r];
		// answerOptionArray is assigned an array which holds the current question's answer options by the using the currentQuestion.
		answerOptionArray = currentQuestionAnswers.getOptions(currentQuestion);
		//correctAnswer is assigned a string which holds the current question's correct answer by the using the currentQuestion.
		correctAnswer = currentQuestionAnswers.getCorrectAnswer(currentQuestion);
	}


	/*The  colorChanger method  initialises randNum to be either 0,1 or 2 and then multiplies it with the questionCounter so that new
	  answer options, questions and correct answers will be assigned to the frame using the new question method The colorChanger method
	  also changes all the JLabels which were received as an arguments to the colour which was received as an argument*/
	public static int colorChanger(String color,JLabel L100,JLabel L200,JLabel L300,JLabel L500,
			JLabel L1000,JLabel L2000,JLabel L4000,JLabel L8000,JLabel L16000,JLabel L32000
			,JLabel L64000,JLabel L125000,JLabel L250000,JLabel L500000,JLabel L1000000)
	{
		int randNum = random.nextInt(3);
		if(color.equalsIgnoreCase("yellow"))
		{
			if(questionCounter <= 15)
			{
				audio.applauseSound1();
			}
			else
			{
				audio.applauseSound2();
			}
			switch (questionCounter){	
			case 1: L100.setForeground(Color.YELLOW); randNum = random.nextInt(3)+3;break;
			case 2: L200.setForeground(Color.YELLOW); randNum = random.nextInt(3)+6;break;
			case 3: L300.setForeground(Color.YELLOW);randNum = random.nextInt(3)+9;break;
			case 4: L500.setForeground(Color.YELLOW);randNum = random.nextInt(3)+12;break;
			case 5: L1000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+15;break;
			case 6: L2000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+18;break;
			case 7: L4000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+21;break;
			case 8: L8000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+24;break;
			case 9: L16000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+27;break;
			case 10: L32000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+30;break;
			case 11: L64000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+33;break;
			case 12: L125000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+36;break;
			case 13: L250000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+39;break;
			case 14: L500000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+42;break;
			case 15: L1000000.setForeground(Color.YELLOW);randNum = random.nextInt(3)+45;break;
			case 16: L1000000.setForeground(Color.YELLOW);
			JOptionPane.showMessageDialog(null, "You won 1000000£");System.exit(0);}
		}
		else if(color.equalsIgnoreCase("red"))
		{
			L100.setForeground(Color.RED);
			L200.setForeground(Color.RED);
			L300.setForeground(Color.RED);
			L500.setForeground(Color.RED);
			L1000.setForeground(Color.RED);
			L2000.setForeground(Color.RED);
			L4000.setForeground(Color.RED);
			L8000.setForeground(Color.RED);
			L16000.setForeground(Color.RED);
			L32000.setForeground(Color.RED);
			L64000.setForeground(Color.RED);
			L125000.setForeground(Color.RED);
			L250000.setForeground(Color.RED);
			L500000.setForeground(Color.RED);
			L1000000.setForeground(Color.RED);
		}
		return randNum;
	}

	/*Assigns currentQuestion to a question based on the integer which is received as an argument
	 and then assigns answerOptionArray and correctAnswer based on the currentQuestion's question,
	 The newQuestion method also assigns the options to the four answer buttons and colours their 
	 background to red to clear the effect of the 50/50 button   */
	public static void newQuestion(int r,JButton answerButtonOne,JButton answerButtonTwo,JButton answerButtonThree,
			JButton answerButtonFour,JLabel questionLabel)
	{
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

	/*The mistakeAdujster method sets lblmistakeCounter text based on the mistakeCounter,
	  The mistakeAdujster method also exits the game once the mistakeCounter integers reaches 0*/
	public static void mistakeAdujster(JLabel lblmistakeCounter)
	{
		if(mistakeCounter == 0)
		{
			audio.buzzerSound2();
		}
		switch (mistakeCounter){	
		case 0: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 0</html>");JOptionPane.showMessageDialog
		(null, "You have reached the maxium amount of mistakes");System.exit(0);
		case 1: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 1</html>");break;
		case 2: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 2</html>");break;
		case 3: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 3</html>");break;
		case 4: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 4</html>");break;
		case 5: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 5</html>");break;
		case 6: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 6</html>");break;
		case 7: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 7</html>");break;
		case 8: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 8</html>");break;
		case 9: lblmistakeCounter.setText("<html>MISTAKE COUNTER = 9</html>");break;
		case 10:lblmistakeCounter.setText("<html>MISTAKE COUNTER = 10</html>");break;
		case 11:lblmistakeCounter.setText("<html>MISTAKE COUNTER = 11</html>");}
	}
	
	/*Sets one up as true to indicate that "1-up question" button is pressed and assigns currentQuestion 
	 to one of the last five  questions and then assigns answerOptionArray and correctAnswer based on the 
	 currentQuestion's question, The newQuestion method also assigns the options to the four answer buttons
	 and colours their background to red to clear the effect of the 50/50 button  */
	public static void oneUpQuestion(JButton answerButtonOne,JButton answerButtonTwo,JButton answerButtonThree,
			JButton answerButtonFour,JLabel questionLabel)
	{
		oneUp = true;
		int r = random.nextInt(5)+43;
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
