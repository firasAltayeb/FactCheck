package moneyTime;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class MTOnlineWindow implements ActionListener
{
	
	Random random = new Random();MTOMethods MTOM;MTMethods MTM;
	JLabel copyRight;JLabel L100;JLabel L200;JLabel L300;JLabel L500;JLabel L1000;JLabel L2000;JLabel L4000;
	JLabel L8000;JLabel L16000;JLabel L32000;JLabel L64000;JLabel L125000;JLabel L250000;JLabel L500000;
	JLabel L1000000;JLabel LC;JLabel LA;JLabel QuestionLabel;JLabel lblmistakeCounter;JLabel LD;JLabel LB;
	JButton answerButtonOne;JButton answerButtonTwo;JButton answerButtonThree;JButton answerButtonFour;		

	public MTOnlineWindow(final MTOMethods shortCut,final MTMethods shortCut2){

		MTOM = shortCut;
		MTM = shortCut2;
		//---------------------------- JFrame Implementation  -------------------------------------------
		final JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(1900, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//-----------------------------  Jlabels --------------------------------------------------------

		//JlabelArray holds all the labels used in the class to allow the following for loops to print the labels using less repetitive code.
		JLabel[] JlabelArray = new JLabel[22];
		copyRight = new JLabel("@FirasAltayeb");JlabelArray[0]=copyRight;
		L100 = new JLabel("100\u00A3");JlabelArray[1]=L100;
		L200 = new JLabel("200\u00A3");JlabelArray[2]=L200;
		L300 = new JLabel("300\u00A3");JlabelArray[3]=L300;
		L500 = new JLabel("500\u00A3");JlabelArray[4]=L500;
		L1000 = new JLabel("1000\u00A3");JlabelArray[5]=L1000;
		L2000 = new JLabel("2000\u00A3");JlabelArray[6]=L2000;
		L4000 = new JLabel("4000\u00A3");JlabelArray[7]=L4000;
		L8000 = new JLabel("8000\u00A3");JlabelArray[8]=L8000;
		L16000 = new JLabel("16000\u00A3");JlabelArray[9]=L16000;
		L32000 = new JLabel("32000\u00A3");JlabelArray[10]=L32000;
		L64000 = new JLabel("64000\u00A3");JlabelArray[11]=L64000;
		L125000 = new JLabel("125000\u00A3");JlabelArray[12]=L125000;
		L250000 = new JLabel("250000\u00A3");JlabelArray[13]=L250000;
		L500000 = new JLabel("500000\u00A3");JlabelArray[14]=L500000;
		L1000000 = new JLabel("1000000\u00A3");JlabelArray[15]=L1000000;
		LC= new JLabel("c.");JlabelArray[16]=LC;
		LA = new JLabel("a.");JlabelArray[17]=LA;
		QuestionLabel = new JLabel(MTOM.currentQuestion);JlabelArray[18]=QuestionLabel;
		lblmistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");JlabelArray[19]=lblmistakeCounter;
		LD = new JLabel("d.");JlabelArray[20]=LD;
		LB = new JLabel("b.");JlabelArray[21]=LB;

		int yAxis = 650;
		int xAxis;
		//the following for loop prints the first 16 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=0;i<=16;i++)
		{	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			JlabelArray[i].setForeground(Color.RED);
			JlabelArray[i].setBounds(0, yAxis, 500, 500);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=55;

		}

		yAxis = 600;
		xAxis = 400;
		//the following for loop prints the last 5 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=16;i<=21;i++)
		{	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 30));
			JlabelArray[i].setForeground(Color.WHITE);
			JlabelArray[i].setBounds(xAxis, yAxis, 1500, 300);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=220;
			if(i==19)
			{yAxis=600;
			xAxis=1000;}	
		}

		//------------------------ Answer buttons variables  ------------------------------------------------

		answerButtonOne = new JButton(MTOM.answerOptionArray[0]);
		answerButtonTwo = new JButton(MTOM.answerOptionArray[1]);
		answerButtonThree = new JButton(MTOM.answerOptionArray[2]);
		answerButtonFour = new JButton(MTOM.answerOptionArray[3]);
		
		yAxis=480;
		xAxis=440;
		//JButtonArray holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray = new JButton[4];
		JButtonArray[0] = answerButtonOne;
		JButtonArray[1] = answerButtonTwo;
		JButtonArray[2] = answerButtonThree;
		JButtonArray[3] = answerButtonFour;	
		//the following for loop prints the buttons in the JButtonArray with the same background,foreground  and font but with different bounds.
		for(int i=0;i<=3;i++)
		{
			JButtonArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray[i].setBounds(xAxis, yAxis, 400, 75);
			JButtonArray[i].setForeground(Color.BLACK);
			JButtonArray[i].setBackground(Color.RED);
			frame.getContentPane().add(JButtonArray[i]);
			if(i==0){xAxis=1040;}
			if(i==1)
			{xAxis=440;
			yAxis=700;}
			if(i==2){xAxis=1040;}
	
		}

		answerButtonOne.addActionListener(this);
		answerButtonTwo.addActionListener(this);
		answerButtonThree.addActionListener(this);
		answerButtonFour.addActionListener(this);

		//------------------------------  Extra buttons -----------------------------------------------------

		JButton CollectCashButton = new JButton("Collect Cash");
		final JButton FiftyFifty = new JButton("50/50");
		final JButton Audience = new JButton("Audience");
		JButton ExitB = new JButton("Exit");

		xAxis=0;
		//JButtonArray2 holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray2 = new JButton[4];
		JButtonArray2[0] = CollectCashButton;
		JButtonArray2[1] = FiftyFifty;
		JButtonArray2[2] = Audience;
		JButtonArray2[3] = ExitB;
		//the following for loop prints the buttons in the JButtonArray2 with the same background and foreground but with different bounds.
		for(int i=0;i<=3;i++){
			JButtonArray2[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray2[i].setBounds(xAxis, 0, 480, 40);
			frame.getContentPane().add(JButtonArray2[i]);
			xAxis+=468;
		}
		// Allows the user to exit the game with the current amount of money the user has gained using questionCounter
		CollectCashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch (MTOM.questionCounter){
				case 1:	JOptionPane.showMessageDialog(null, "You won 100£");System.exit(0);
				case 2:	JOptionPane.showMessageDialog(null, "You won 200£");System.exit(0);
				case 3:	JOptionPane.showMessageDialog(null, "You won 300£");System.exit(0);
				case 4: JOptionPane.showMessageDialog(null, "You won 500£");System.exit(0);
				case 5:	JOptionPane.showMessageDialog(null, "You won 1000£");System.exit(0);
				case 6:	JOptionPane.showMessageDialog(null, "You won 2000£");System.exit(0);
				case 7:	JOptionPane.showMessageDialog(null, "You won 4000£");System.exit(0);
				case 8:	JOptionPane.showMessageDialog(null, "You won 8000£");System.exit(0);
				case 9:	JOptionPane.showMessageDialog(null, "You won 16000£");System.exit(0);
				case 10: JOptionPane.showMessageDialog(null, "You won 32000£");System.exit(0);
				case 11: JOptionPane.showMessageDialog(null, "You won 64000£");System.exit(0);
				case 12: JOptionPane.showMessageDialog(null, "You won 125000£");System.exit(0);
				case 13: JOptionPane.showMessageDialog(null, "You won 250000£");System.exit(0);
				case 14: JOptionPane.showMessageDialog(null, "You won 500000£");System.exit(0);	
				case 15: JOptionPane.showMessageDialog(null, "You won 1000000£");System.exit(0);
				}

			}
		});

		/*Changes the background of the current question's correct answer to yellow plus one other random button,
		after the button is used the button becomes disabled*/
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				if (answerButtonOne.getText().equals(MTOM.correctAnswer))
				{
					answerButtonOne.setBackground(Color.YELLOW);
					answerButtonFour.setBackground(Color.YELLOW);
				}

				else if (answerButtonTwo.getText().equals(MTOM.correctAnswer))
				{
					answerButtonTwo.setBackground(Color.YELLOW);
					answerButtonOne.setBackground(Color.YELLOW);
				}

				else if (answerButtonThree.getText().equals(MTOM.correctAnswer))
				{
					answerButtonThree.setBackground(Color.YELLOW);
					answerButtonFour.setBackground(Color.YELLOW);
				}

				else if(answerButtonFour.getText().equals(MTOM.correctAnswer))
				{
					answerButtonFour.setBackground(Color.YELLOW);
					answerButtonTwo.setBackground(Color.YELLOW);
				}

				FiftyFifty.setEnabled(false);
			}
		});

		/*The Audience actions button opens a new frame with a chart indicating the possible answer,
		  if the player has not reached the eighth question yet the chart has a 75% chance of providing
		  the correct answer and if the player has passed the eighth question the chart has a 50%
		  chance of providing the correct answer */
		Audience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				JFrame AudienceFrame = new JFrame();
				AudienceFrame.setSize(700, 500);
				AudienceFrame.setVisible(true);
				double[] values = new double[4];
				String[] names = new String[4];
				names[0] = "A";
				names[1] = "B";
				names[2] = "C";
				names[3] = "D";
				if(MTOMethods.questionCounter<=8)
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[0]))
					{
						values[0] += 10;
					}
					else if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[1]))
					{
						values[1] += 10;
					}
					else if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[2]))
					{
						values[2] += 10;
					}
					else
					{
						values[3] += 10;
					}

				}
				else 
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[0]))
					{
						values[0] += 2;
					}
					else if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[1]))
					{
						values[1] += 2;
					}
					else if(MTOMethods.correctAnswer.equals(MTOMethods.answerOptionArray[2]))
					{
						values[2] += 2;
					}
					else 
					{
						values[3] += 2;
					}

				}
				AudienceFrame.getContentPane().add(new MTAudienceFrame(values, names, "Audience"));
				Audience.setEnabled(false);
			}
		});


		/*When ExitB is clicked the game promotes a frame asking the user if he wants to quit or not
		if the user chose yes the game will close and if the user chose no nothing will happen.*/
		ExitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				Object[] options = { "YES", "NO" };
				int optionButton = JOptionPane.showOptionDialog(frame,
						"Are you sure you wish to quit?", null,
						JOptionPane.PLAIN_MESSAGE,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);

				if (optionButton == JOptionPane.YES_OPTION) {
					System.exit(0);
				}


			}
		});

		//pictureLabel stores the background picture of the game and prints it.
		/*JLabel img = new JLabel( new ImageIcon("WM2.jpg"));
		img.setBounds(0, 0, 1900, 1100);
		frame.getContentPane().add(img);*/
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/WM2.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1900, 1100); 
		frame.getContentPane().add(pictureLabel); 


		//-------------------------- JMenuBar --------------------------------------------------------------

		JMenuBar menuBar = new JMenuBar();

		JMenu difficulty = new JMenu("Difficulty");
		difficulty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		difficulty.setMnemonic(KeyEvent.VK_A);

		JMenu help = new JMenu("Help");
		help.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		help.setMnemonic(KeyEvent.VK_A);
		
		
		JMenu titleScreen = new JMenu("TitleScreen");
		titleScreen.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		titleScreen.setMnemonic(KeyEvent.VK_A);
		titleScreen.addMenuListener(new MenuListener() {
		        public void menuSelected(MenuEvent e){
		        	MTOM.mistakeCounter = 5;
					MTOM.questionCounter = 0;
		        	new MTStartScreen(MTM,MTOM);
		        	frame.dispose();}
		        public void menuDeselected(MenuEvent e){}
		        public void menuCanceled(MenuEvent e){}
		    });

		
		JMenuItem easy = new JMenuItem("easy");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem information = new JMenuItem("Information");

		//JMenuItemArray holds four  JMenuItem mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JMenuItem[] JMenuItemArray = new JMenuItem[4];
		JMenuItemArray[0] = easy;
		JMenuItemArray[1] = hard;
		JMenuItemArray[2] = restart;
		JMenuItemArray[3] = information;
		//the following for loop prints the JMenuItems in the JMenuItemArray with the same font and accelerator but with different bounds.
		for(int i=0;i<=3;i++){
			JMenuItemArray[i].setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
			JMenuItemArray[i].setAccelerator(KeyStroke.getKeyStroke
					(KeyEvent.VK_1,ActionEvent.ALT_MASK));	
		}


		/*The easy menuItem restarts the game with easier difficulty by assigning mistakeCounter to 10 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		easy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				MTOM.mistakeCounter = 10;
				MTOM.questionCounter = 0;
				int randNum = MTOMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				MTOMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 10 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);

			}

		});

		/*The hard menuItem restarts the game with harder difficulty by assigning mistakeCounter to 3 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		hard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				MTOM.mistakeCounter = 3;
				MTOM.questionCounter = 0;
				int randNum = MTOMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				MTOMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER =3  ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);

			}

		});

		/*The restart menuItem restarts the game with the same difficulty by assigning mistakeCounter to 5 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				MTOM.questionCounter = 0;
				MTOM.mistakeCounter = 5;
				int randNum = MTOMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				MTOMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 5 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);

			}

		});
		// Opens the user's browser to a URL page which shows information about the game.
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Desktop.getDesktop().browse(new URL("http://www.gamefaqs.com/gba/582399-who-wants-to-be-a-millionaire/faqs/40043").toURI());
				}
				catch(Exception e)
				{}
			}

		});

		difficulty.add(easy);
		difficulty.add(hard);
		help.add(restart);
		help.add(information);
		menuBar.add(difficulty);
		menuBar.add(help);
		menuBar.add(titleScreen);
		frame.setJMenuBar(menuBar);
		frame.pack();

	}
	/*This action compares the String within the calling button with the correctAnswer String by using .getActionCommand() and .equals, 
	  if the answer within the calling button equals the correct answer all the labels foreground turn yellow and the questionCounter is 
	  increased to indicate the clearing of the level and then a new question with it's answers are fetched using the .newQuestion method.
 	  if the answer within the calling button does not equals the correct answer mistakeCounter is decreased to indicate the decrease in 
 	  attempts and then the .mistakeAdujster method rewrite the label to match the remaining attempt/mistakes number. */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(MTOM.correctAnswer))
		{	
			MTOM.questionCounter++;		
			int randNum = MTOMethods.colorChanger("yellow",L100, L200, L300, L500,
					L1000, L2000, L4000, L8000, L16000, L32000
					,L64000,L125000,L250000, L500000, L1000000);
			MTOMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);

		}
		else
		{
			MTOM.mistakeCounter--;
			MTOMethods.mistakeAdujster(lblmistakeCounter);

		}
	}
}