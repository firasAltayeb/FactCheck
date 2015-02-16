package moneyTime;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class moneyTimeMethods extends moneyTimeMain
{
	 
	
	public static int colorChanger(String color,JLabel L100,JLabel L200,JLabel L300,JLabel L500,
			JLabel L1000,JLabel L2000,JLabel L4000,JLabel L8000,JLabel L16000,JLabel L32000
			,JLabel L64000,JLabel L125000,JLabel L250000,JLabel L500000,JLabel L1000000)
	{
		int randNum = random.nextInt(3);

		if(color.equalsIgnoreCase("yellow"))
		{

			JOptionPane.showMessageDialog(null, "Correct answer");
		
		
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

		if(color.equalsIgnoreCase("red"))
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

		currentQuestion = qusListArray[r];
		answersOptions = currentQuestionNumber.getOptions(currentQuestion);
		correctAnswer = currentQuestionNumber.getAnswer(currentQuestion);
		QuestionLabel.setText(currentQuestion);
		AnswerButtonOne.setText(answersOptions[0]);
		AnswerButtonTwo.setText(answersOptions[1]);
		AnswerButtonThree.setText(answersOptions[2]);
		AnswerButtonFour.setText(answersOptions[3]);
		AnswerButtonOne.setBackground(Color.RED);
		AnswerButtonTwo.setBackground(Color.RED);
		AnswerButtonThree.setBackground(Color.RED);
		AnswerButtonFour.setBackground(Color.RED);

	}


	public static void mistakeAdujster(JLabel lblmistakeCounter)
	{
		JOptionPane.showMessageDialog(null, "Wrong answer , please try again");
		
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
