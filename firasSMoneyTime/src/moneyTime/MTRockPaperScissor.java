package moneyTime;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MTRockPaperScissor extends JFrame implements ActionListener
{

	Random random = new Random();MTAudio audio = new MTAudio();
	JButton answerButtonOne;JButton answerButtonTwo;
	JButton answerButtonThree;JButton answerButtonFour;		
	JButton rockB;JButton paperB;JButton scissorB;
	JLabel rockL;JLabel paperL;JLabel scissorL;
	
	public MTRockPaperScissor(JButton one,JButton two,JButton three,JButton four)
	{
		setSize(700, 550);
		setVisible(true);
		setLayout(null);
		
		answerButtonOne = one;
		answerButtonTwo = two;
		answerButtonThree = three;
		answerButtonFour = four;
		

		rockB = new JButton("rock");
		rockB.setBounds(150,25,140,140);
		Image rockImg = new ImageIcon(this.getClass().getResource("/rock.png")).getImage();
		rockB.setIcon(new ImageIcon(rockImg));	
		rockB.setOpaque(false);
		rockB.setContentAreaFilled(false);
		rockB.setBorderPainted(false);
		add(rockB);

		paperB = new JButton("paper");
		paperB.setBounds(150,175,140,140);
		Image paperImg = new ImageIcon(this.getClass().getResource("/paper.png")).getImage();
		paperB.setIcon(new ImageIcon(paperImg));	
		paperB.setOpaque(false);
		paperB.setContentAreaFilled(false);
		paperB.setBorderPainted(false);
		add(paperB);

		scissorB = new JButton("scissor");
		scissorB.setBounds(150,325,140,140);
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
		rockL.setBounds(400,25,140,140);
		rockL.setIcon(new ImageIcon(rockImg));	
		add(rockL);

		paperL = new  JLabel("paper");
		paperL.setBounds(400,175,140,140);
		paperL.setIcon(new ImageIcon(paperImg));	
		add(paperL);

		scissorL = new  JLabel("scissor");
		scissorL.setBounds(400,325,140,140);
		scissorL.setIcon(new ImageIcon(scissorImg));
		add(scissorL);

		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1900, 1100); 
		add(pictureLabel); 
		setSize(700,550);
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
		if (answerButtonOne.getText().equals(MTMethods.correctAnswer)
			|| answerButtonOne.getText().equals(MTOMethods.correctAnswer))
		{
			answerButtonTwo.setEnabled(false);
			answerButtonThree.setEnabled(false);
			answerButtonFour.setEnabled(false);
		}

		else if (answerButtonTwo.getText().equals(MTMethods.correctAnswer)
				|| answerButtonTwo.getText().equals(MTOMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonThree.setEnabled(false);
			answerButtonFour.setEnabled(false);
			
		}

		else if (answerButtonThree.getText().equals(MTMethods.correctAnswer)
				|| answerButtonThree.getText().equals(MTOMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonTwo.setEnabled(false);
			answerButtonFour.setEnabled(false);
		}

		else if(answerButtonFour.getText().equals(MTMethods.correctAnswer)
				|| answerButtonFour.getText().equals(MTOMethods.correctAnswer))
		{
			answerButtonOne.setEnabled(false);
			answerButtonTwo.setEnabled(false);
			answerButtonThree.setEnabled(false);
		}

	}
	
}
