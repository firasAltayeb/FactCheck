package MoneyTime;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RockPaperScissor extends JFrame implements ActionListener
{

	Random random = new Random();Audio audio = new Audio();
	JButton answerButtonOne;JButton answerButtonTwo;
	JButton answerButtonThree;JButton answerButtonFour;		
	JButton rockB;JButton paperB;JButton scissorB;
	JLabel rockL;JLabel paperL;JLabel scissorL;
	
	public RockPaperScissor(JButton one,JButton two,JButton three,JButton four)
	{
		
		setVisible(true);
		setLayout(null);
		
		answerButtonOne = one;
		answerButtonTwo = two;
		answerButtonThree = three;
		answerButtonFour = four;
		
		JLabel instruction = new JLabel("Please choose a hand you want to play with!!");
		instruction.setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
		instruction.setForeground(Color.WHITE);
		instruction.setBounds(15,15,800,30);
		add(instruction);
		
		JLabel Player = new JLabel("Player");
		Player.setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
		Player.setForeground(Color.WHITE);
		Player.setBounds(60,60,400,30);
		add(Player);
		
		JLabel computer = new JLabel("computer");
		computer.setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
		computer.setForeground(Color.WHITE);
		computer.setBounds(300,60,400,30);
		add(computer);

		rockB = new JButton("rock");
		rockB.setBounds(60,120,140,140);
		Image rockImg = new ImageIcon(this.getClass().getResource("/rock.png")).getImage();
		rockB.setIcon(new ImageIcon(rockImg));	
		rockB.setOpaque(false);
		rockB.setContentAreaFilled(false);
		rockB.setBorderPainted(false);
		add(rockB);

		paperB = new JButton("paper");
		paperB.setBounds(60,270,140,140);
		Image paperImg = new ImageIcon(this.getClass().getResource("/paper.png")).getImage();
		paperB.setIcon(new ImageIcon(paperImg));	
		paperB.setOpaque(false);
		paperB.setContentAreaFilled(false);
		paperB.setBorderPainted(false);
		add(paperB);

		scissorB = new JButton("scissor");
		scissorB.setBounds(60,420,140,140);
		Image scissorImg = new ImageIcon(this.getClass().getResource("/scissor.png")).getImage();
		scissorB.setIcon(new ImageIcon(scissorImg));	
		scissorB.setOpaque(false);
		scissorB.setContentAreaFilled(false);
		scissorB.setBorderPainted(false);
		add(scissorB);

		rockB.addActionListener(this);
		paperB.addActionListener(this);
		scissorB.addActionListener(this);

		rockL = new  JLabel("rock");
		rockL.setBounds(300,120,140,140);
		rockL.setIcon(new ImageIcon(rockImg));	
		add(rockL);

		paperL = new  JLabel("paper");
		paperL.setBounds(300,270,140,140);
		paperL.setIcon(new ImageIcon(paperImg));	
		add(paperL);

		scissorL = new  JLabel("scissor");
		scissorL.setBounds(300,420,140,140);
		scissorL.setIcon(new ImageIcon(scissorImg));
		add(scissorL);

		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1000, 1000); 
		add(pictureLabel); 
		setSize(500,600);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) 
	{
		audio.cameraSound1();
		int randNum = random.nextInt(3);
		if(randNum == 0)
		{
			if (e.getActionCommand().equals("rock"))
			{
				paperB.setVisible(false);
				paperL.setVisible(false);
				scissorB.setVisible(false);
				rockL.setVisible(false);
			}
			if (e.getActionCommand().equals("paper"))
			{
				rockB.setVisible(false);
				paperL.setVisible(false);
				scissorB.setVisible(false);
				scissorL.setVisible(false);
			}
			if (e.getActionCommand().equals("scissor"))
			{
				rockB.setVisible(false);
				rockL.setVisible(false);
				paperB.setVisible(false);
				scissorL.setVisible(false);
			}
			JOptionPane.showMessageDialog(null, "You win");
			enabler();
			dispose();
		}
		
		if(randNum == 1)
		{
			if (e.getActionCommand().equals("rock"))
			{
				paperB.setVisible(false);
				scissorL.setVisible(false);
				scissorB.setVisible(false);
				rockL.setVisible(false);
			}
			if (e.getActionCommand().equals("paper"))
			{
				rockB.setVisible(false);
				rockL.setVisible(false);
				paperL.setVisible(false);
				scissorB.setVisible(false);
				
			}
			if (e.getActionCommand().equals("scissor"))
			{
				rockB.setVisible(false);
				paperB.setVisible(false);
				paperL.setVisible(false);
				scissorL.setVisible(false);
			}
			JOptionPane.showMessageDialog(null, "You lose");
			dispose();
		}
		
		if(randNum == 2)
		{
			if (e.getActionCommand().equals("rock"))
			{
				paperB.setVisible(false);
				paperL.setVisible(false);
				scissorL.setVisible(false);
				scissorB.setVisible(false);
				
			}
			if (e.getActionCommand().equals("paper"))
			{
				rockB.setVisible(false);
				rockL.setVisible(false);
				scissorL.setVisible(false);
				scissorB.setVisible(false);
				
			}
			if (e.getActionCommand().equals("scissor"))
			{
				rockB.setVisible(false);
				rockL.setVisible(false);
				paperB.setVisible(false);
				paperL.setVisible(false);
				
			}
			JOptionPane.showMessageDialog(null, "Try again please");
			rockB.setVisible(true);
			rockL.setVisible(true);
			paperB.setVisible(true);
			paperL.setVisible(true);
			scissorL.setVisible(true);
			scissorB.setVisible(true);
			
		}	
	}
	
	
	public void enabler() 
	{	
		if (answerButtonOne.getText().equals(Methods.correctAnswer)
			|| answerButtonOne.getText().equals(OnlineMethods.correctAnswer))
		{
			answerButtonTwo.setEnabled(false);
			answerButtonThree.setEnabled(false);
			answerButtonFour.setEnabled(false);
		}

		else if (answerButtonTwo.getText().equals(Methods.correctAnswer)
				|| answerButtonTwo.getText().equals(OnlineMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonThree.setEnabled(false);
			answerButtonFour.setEnabled(false);
			
		}

		else if (answerButtonThree.getText().equals(Methods.correctAnswer)
				|| answerButtonThree.getText().equals(OnlineMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonTwo.setEnabled(false);
			answerButtonFour.setEnabled(false);
		}

		else if(answerButtonFour.getText().equals(Methods.correctAnswer)
				|| answerButtonFour.getText().equals(OnlineMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonTwo.setEnabled(false);
			answerButtonThree.setEnabled(false);
		}

	}
	
}
