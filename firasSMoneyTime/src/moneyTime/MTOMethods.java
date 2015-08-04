package moneyTime;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MTOMethods {

	static ArrayList<String> MQuestions; 
	static ArrayList<String> MCorreectAnswers; 
	static ArrayList<String> MAnswersOptions;
	static String[] answerOptionArray = new String[4];
	static MTAudio audio = new MTAudio();
	static Random random = new Random();
	static String correctAnswer;
	static String currentQuestion;
	// questionCounter stores the progress of the game, the higher questionCounter becomes the closer end game gets.
	static int questionCounter = 0;
	//mistakeCounter determine the difficulty of the game, the lower the mistakeCounter becomes the harder the game gets. 
	static int mistakeCounter = 5;

	MTOMethods(ArrayList<String> MQ,ArrayList<String> MCA,ArrayList<String> MAO)
	{
		int r = random.nextInt(5);
		ArrayList<String> MQuestions = MQ;
		ArrayList<String> MCorreectAnswers = MCA;
		ArrayList<String> MAnswersOptions =MAO;
		currentQuestion = MQuestions.get(r);
		answerOptionArray[0] =  MAnswersOptions.get(r*4-4);
		answerOptionArray[1] =  MAnswersOptions.get(r*4-3);
		answerOptionArray[2] =  MAnswersOptions.get(r*4-2);
		answerOptionArray[3] =  MAnswersOptions.get(r*4-1);
		correctAnswer = MCorreectAnswers.get(r);
		
	}

	/*The  colorChanger method  initialises randNum to be either 0,1 or 2 and returns it,  
	The  colorChanger method also changes all the JLabels which were received as an arguments to the colour which was received as an argument*/
	public static int colorChanger(String color,JLabel L100,JLabel L200,JLabel L300,JLabel L500,
			JLabel L1000,JLabel L2000,JLabel L4000,JLabel L8000,JLabel L16000,JLabel L32000
			,JLabel L64000,JLabel L125000,JLabel L250000,JLabel L500000,JLabel L1000000)
	{
		int randNum = random.nextInt(5);
		if(color.equalsIgnoreCase("yellow"))
		{
			//JOptionPane.showMessageDialog(null, "Correct answer");
			audio.winningSound();
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
	
	public static void newQuestion(int r,JButton AnswerButtonOne,JButton AnswerButtonTwo,JButton AnswerButtonThree,
			JButton AnswerButtonFour,JLabel QuestionLabel)
	{

		currentQuestion = MQuestions.get(r);
		answerOptionArray[0] =  MAnswersOptions.get(r*4-4);
		answerOptionArray[1] =  MAnswersOptions.get(r*4-3);
		answerOptionArray[2] =  MAnswersOptions.get(r*4-2);
		answerOptionArray[3] =  MAnswersOptions.get(r*4-1);
		correctAnswer = MCorreectAnswers.get(r);
		QuestionLabel.setText(currentQuestion);
		AnswerButtonOne.setText(answerOptionArray[0]);
		AnswerButtonTwo.setText(answerOptionArray[1]);
		AnswerButtonThree.setText(answerOptionArray[2]);
		AnswerButtonFour.setText(answerOptionArray[3]);
		AnswerButtonOne.setBackground(Color.RED);
		AnswerButtonTwo.setBackground(Color.RED);
		AnswerButtonThree.setBackground(Color.RED);
		AnswerButtonFour.setBackground(Color.RED);

	}
	
	/*The mistakeAdujster method sets lblmistakeCounter text based on the mistakeCounter,
	  The mistakeAdujster method also exits the game once the mistakeCounter integers reaches 0*/
	public static void mistakeAdujster(JLabel lblmistakeCounter)
	{
		//JOptionPane.showMessageDialog(null, "Wrong answer , please try again");

		audio.losingSound();
		switch (mistakeCounter){	
		case 0: lblmistakeCounter.setText("MISTAKE COUNTER =0 ");JOptionPane.showMessageDialog
		(null, "You have reached the maxium amount of mistakes");System.exit(0);
		case 1: lblmistakeCounter.setText("MISTAKE COUNTER =1 ");break;
		case 2: lblmistakeCounter.setText("MISTAKE COUNTER =2 ");break;
		case 3: lblmistakeCounter.setText("MISTAKE COUNTER =3 ");break;
		case 4: lblmistakeCounter.setText("MISTAKE COUNTER =4 ");break;
		case 5: lblmistakeCounter.setText("MISTAKE COUNTER =5 ");break;
		case 6: lblmistakeCounter.setText("MISTAKE COUNTER =6 ");break;
		case 7: lblmistakeCounter.setText("MISTAKE COUNTER =7 ");break;
		case 8: lblmistakeCounter.setText("MISTAKE COUNTER =8 ");break;
		case 9: lblmistakeCounter.setText("MISTAKE COUNTER =9 ");break;
		case 10: lblmistakeCounter.setText("MISTAKE COUNTER =10 ");}
	}
	
	
}	
