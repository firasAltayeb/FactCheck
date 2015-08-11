package moneyTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MTRockPaperScissor extends JPanel implements ActionListener
{

	Random random = new Random();
	JButton answerButtonOne;JButton answerButtonTwo;
	JButton answerButtonThree;JButton answerButtonFour;		
	
	public MTRockPaperScissor(JButton one,JButton two,JButton three,JButton four)
	{
		answerButtonOne = one;
		answerButtonTwo = two;
		answerButtonThree = three;
		answerButtonFour = four;	
		
		setLayout(null);

		JButton rockB = new JButton("rock");
		rockB.setBounds(200,100,100,100);
		add(rockB);

		JButton paperB = new JButton("paper");
		paperB.setBounds(200,200,100,100);
		add(paperB);

		JButton scissorB = new JButton("scissor");
		scissorB.setBounds(200,300,100,100);
		add(scissorB);

		rockB.addActionListener(this);
		paperB.addActionListener(this);
		scissorB.addActionListener(this);

		JLabel rockL = new  JLabel("rock");
		rockL.setBounds(400,100,100,100);
		add(rockL);

		JLabel paperL = new  JLabel("paper");
		paperL.setBounds(400,200,100,100);
		add(paperL);

		JLabel scissorL = new  JLabel("scissor");
		scissorL.setBounds(400,300,100,100);
		add(scissorL);


		/*Label pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1900, 1100); 
		add(pictureLabel); 
		setSize(500,500);*/
	}

	public void actionPerformed(ActionEvent e) 
	{
		int randNum = 1;
		if(randNum == 0)
		{
			
		
		}
		if(randNum == 1)
		{
			answerButtonOne.setEnabled(false);
		}
		if(randNum == 2)
		{
			
		}
		
	}
	
}
