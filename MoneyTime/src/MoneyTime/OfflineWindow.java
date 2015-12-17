package MoneyTime;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
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


public class OfflineWindow implements ActionListener
{

	Random random = new Random();final AudioList audio = new AudioList();
	JLabel copyRight;JLabel L100;JLabel L200;JLabel L300;JLabel L500;JLabel L1000;JLabel L2000;JLabel L4000;
	JLabel L8000;JLabel L16000;JLabel L32000;JLabel L64000;JLabel L125000;JLabel L250000;JLabel L500000;
	JLabel L1000000;JLabel LC;JLabel LA;JLabel QuestionLabel;JLabel lblmistakeCounter;JLabel LD;JLabel LB;
	JButton answerButtonOne;JButton answerButtonTwo;JButton answerButtonThree;JButton answerButtonFour;	
	JButton RockPaperScissor;JButton FiftyFifty;JButton Audience;JButton oneUpQuestion;JButton rescueOptions;

	public OfflineWindow(final JFrame frame){
		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/offlineM.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		frame.setContentPane(pictureLabel);
		frame.setLayout(new GridBagLayout());
		frame.setMinimumSize(new Dimension(1100, 1100));
		
		
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
		QuestionLabel = new JLabel(OnlineWindowMethods.currentQuestion);JlabelArray[16]=QuestionLabel;
		lblmistakeCounter = new JLabel("<html>MISTAKE COUNTER = 5</html>");JlabelArray[17]=lblmistakeCounter;
		LA = new JLabel("a.");JlabelArray[18]=LA;
		LB = new JLabel("b.");JlabelArray[19]=LB;
		LC= new JLabel("c.");JlabelArray[20]=LC;
		LD = new JLabel("d.");JlabelArray[21]=LD;
		
		gbc.gridx = 0;
		int gridy = 0;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.insets = new Insets(10,10,10,10);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		//the following for loop prints the first 16 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=15;i>=0;i--) {	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			JlabelArray[i].setForeground(Color.RED);
			gbc.gridy = gridy;
			frame.add(JlabelArray[i],gbc);
			gridy++;
		}
		
		gbc.gridx = 1;
		gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		
		//the following for loop prints the remaining labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=16;i<JlabelArray.length;i++) {	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			JlabelArray[i].setForeground(Color.WHITE);
			gbc.gridy = gridy;
			frame.add(JlabelArray[i],gbc);
			//the following push labels 16-21 one cell to the right 
			if(i==16){
				gridy+=2;
			} else{
			gridy++;}
		}
	
		//------------------------ Answer buttons variables  ------------------------------------------------

		answerButtonOne = new JButton(OnlineWindowMethods.answerOptionArray[0]);
		answerButtonTwo = new JButton(OnlineWindowMethods.answerOptionArray[1]);
		answerButtonThree = new JButton(OnlineWindowMethods.answerOptionArray[2]);
		answerButtonFour = new JButton(OnlineWindowMethods.answerOptionArray[3]);
		rescueOptions = new JButton("rescue options");
		RockPaperScissor = new JButton("Rock.Paper.Scissor");
		FiftyFifty = new JButton("50/50");
		Audience = new JButton("Audience");
		oneUpQuestion = new JButton("1-UP Question");

		
		gbc.gridx = 2;
		gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		//JButtonArray holds the buttons mentioned above to allow the following for loop to print the buttons using less repetitive code.
		JButton[] JButtonArray = new JButton[9];
		JButtonArray[0] = answerButtonOne;
		JButtonArray[1] = answerButtonTwo;
		JButtonArray[2] = answerButtonThree;
		JButtonArray[3] = answerButtonFour;	
		JButtonArray[4] = rescueOptions;
		JButtonArray[5] = RockPaperScissor;
		JButtonArray[6] = FiftyFifty;
		JButtonArray[7] = Audience;
		JButtonArray[8] = oneUpQuestion;
		
		//the following for loop prints the buttons in the JButtonArray with the same background,foreground  and font but with different bounds.
		for(int i=0;i<JButtonArray.length;i++)
		{
			JButtonArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray[i].setForeground(Color.BLACK);
			JButtonArray[i].setBackground(Color.RED);
			gbc.gridy = gridy;
			frame.add(JButtonArray[i],gbc);
			gridy++;
			
		}
		answerButtonOne.addActionListener(this);
		answerButtonTwo.addActionListener(this);
		answerButtonThree.addActionListener(this);
		answerButtonFour.addActionListener(this);

		//------------------------------  Extra buttons -----------------------------------------------------
		
		RockPaperScissor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.cameraSound4();
				new RockPaperScissorWindow(answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour);
				RockPaperScissor.setEnabled(false);
			}
		});

		/*disables two wrong answer's buttons,after the button is used the button becomes disabled*/
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				audio.cameraSound2();
				if (answerButtonOne.getText().equals(OnlineWindowMethods.correctAnswer))
				{
					answerButtonTwo.setEnabled(false);
					answerButtonFour.setEnabled(false);
				}

				else if (answerButtonTwo.getText().equals(OnlineWindowMethods.correctAnswer))
				{
					answerButtonThree.setEnabled(false);
					answerButtonOne.setEnabled(false);
				}

				else if (answerButtonThree.getText().equals(OnlineWindowMethods.correctAnswer))
				{
					answerButtonTwo.setEnabled(false);
					answerButtonFour.setEnabled(false);
				}

				else if(answerButtonFour.getText().equals(OnlineWindowMethods.correctAnswer))
				{
					answerButtonOne.setEnabled(false);
					answerButtonTwo.setEnabled(false);
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
				audio.chargeSound();
				JFrame AudienceFrame = new JFrame();
				AudienceFrame.setSize(700, 500);
				AudienceFrame.setVisible(true);
				double[] values = new double[4];
				String[] names = new String[4];
				names[0] = "A";
				names[1] = "B";
				names[2] = "C";
				names[3] = "D";
				if(OnlineWindowMethods.questionCounter<=8)
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[0]))
					{
						values[0] += 3;
					}
					else if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[1]))
					{
						values[1] += 3;
					}
					else if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[2]))
					{
						values[2] += 3;
					}
					else
					{
						values[3] += 3;
					}

				}
				else 
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[0]))
					{
						values[0] += 2;
					}
					else if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[1]))
					{
						values[1] += 2;
					}
					else if(OnlineWindowMethods.correctAnswer.equals(OnlineWindowMethods.answerOptionArray[2]))
					{
						values[2] += 2;
					}
					else 
					{
						values[3] += 2;
					}

				}
				AudienceFrame.getContentPane().add(new AudienceWindow(values, names, "Audience"));
				Audience.setEnabled(false);
			}
		});


		oneUpQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent q) 
			{
				answerButtonOne.setEnabled(true);
				answerButtonTwo.setEnabled(true);
				answerButtonThree.setEnabled(true);
				answerButtonFour.setEnabled(true);
				audio.cameraSound1();
				OnlineWindowMethods.oneUpQuestion(answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				oneUpQuestion.setEnabled(false);

			}
		});

		//-------------------------- JMenuBar --------------------------------------------------------------

		JMenuBar menuBar = new JMenuBar();

		JMenu difficulty = new JMenu("Difficulty");
		difficulty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		difficulty.setMnemonic(KeyEvent.VK_A);

		JMenu help = new JMenu("Help");
		help.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		help.setMnemonic(KeyEvent.VK_A);

		JMenu quit = new JMenu("Quit");
		quit.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		quit.setMnemonic(KeyEvent.VK_A);

		/*allows the user to return to the title screen where the user can chose
		  to play either the online mode or the offline mode,MTM and MTOM are passed
		  as arguments because they are required to open either the online or offline 
		  modes and then the current frame is disposed to not allow multiple frame to
		  be open in the same time.*/
		JMenu titleScreen = new JMenu("TitleScreen");
		titleScreen.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		titleScreen.setMnemonic(KeyEvent.VK_A);
		titleScreen.addMenuListener(new MenuListener() {
			public void menuSelected(MenuEvent e) {
				OnlineWindowMethods.mistakeCounter = 5;
				OnlineWindowMethods.questionCounter = 0;
				new StartWindow();
				frame.dispose();}
			public void menuDeselected(MenuEvent e){}
			public void menuCanceled(MenuEvent e){}
		});


		JMenuItem easy = new JMenuItem("easy");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem information = new JMenuItem("Information");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem collect = new JMenuItem("Collect Cash");
		//JMenuItemArray holds four  JMenuItem mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JMenuItem[] JMenuItemArray = new JMenuItem[6];
		JMenuItemArray[0] = easy;
		JMenuItemArray[1] = hard;
		JMenuItemArray[2] = restart;
		JMenuItemArray[3] = information;
		JMenuItemArray[4] = exit;
		JMenuItemArray[5] = collect;

		//the following for loop prints the JMenuItems in the JMenuItemArray with the same font and accelerator but with different bounds.
		for(int i=0;i<=5;i++){
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
				OnlineWindowMethods.mistakeCounter = 10;
				OnlineWindowMethods.questionCounter = 0;
				int randNum = OnlineWindowMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				OnlineWindowMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("<html>MISTAKE COUNTER = 10</html>");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
				oneUpQuestion.setEnabled(true);
				RockPaperScissor.setEnabled(true);
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
				OnlineWindowMethods.mistakeCounter = 3;
				OnlineWindowMethods.questionCounter = 0;
				int randNum = OnlineWindowMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				OnlineWindowMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("<html>MISTAKE COUNTER = 3</html>");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
				oneUpQuestion.setEnabled(true);
				RockPaperScissor.setEnabled(true);
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
				OnlineWindowMethods.questionCounter = 0;
				OnlineWindowMethods.mistakeCounter = 5;
				int randNum = OnlineWindowMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				OnlineWindowMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("<html>MISTAKE COUNTER = 5</html>");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
				oneUpQuestion.setEnabled(true);
				RockPaperScissor.setEnabled(true);
			}

		});
		// Opens the user's browser to a URL page which shows general information about the game.
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F").toURI());
				}
				catch(Exception e)
				{}
			}

		});

		/*When exit is clicked the game promotes a frame asking the user if he wants to quit or not
		if the user chose yes the game will close and if the user chose no nothing will happen.*/
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				audio.buzzerSound2();
				Object[] options = { "YES", "NO" };
				int optionButton = JOptionPane.showOptionDialog(frame,
						"Are you sure you wish to quit?", null,
						JOptionPane.PLAIN_MESSAGE,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);

				if (optionButton == JOptionPane.YES_OPTION) {System.exit(0);}

			}
		});

		// Allows the user to exit the game with the current amount of money the user has gained using questionCounter
		collect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				audio.applauseSound2();
				switch (OnlineWindowMethods.questionCounter){
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


		difficulty.add(easy);
		difficulty.add(hard);
		help.add(restart);
		help.add(information);
		quit.add(collect);
		quit.add(exit);
		menuBar.add(difficulty);
		menuBar.add(help);
		menuBar.add(titleScreen);
		menuBar.add(quit);
		frame.setJMenuBar(menuBar);
		frame.pack();
	}

	/*This action compares the calling button text with the correctAnswer by using both "e.getActionCommand()" and ".equals" methods,
	  if oneUp is set as true and the user correctly answers the current question the user gains an attempt by increasing his mistakeCounter 
	  and then all the labels foreground turn yellow by using the ".colorChanger" method after that a new question with it's answers are fetched 
	  using the ".newQuestion" method and oneUp is set as false to allow the game to run normally. when oneUp is set as false and the user correctly 
	  answers the current question all the labels foreground turn yellow by using the ".colorChanger" method and then a new question with 
	  it's answers are fetched using the ".newQuestion" method and the questionCounter is increased to indicate the clearing of the level.
 	  if the answer within the calling button does not equals the correct answer mistakeCounter is decreased to indicate the decrease in 
 	  attempts and then the ".mistakeAdujster" method rewrite the label to match the remaining attempts number. */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(OnlineWindowMethods.correctAnswer)){
			if(OnlineWindowMethods.oneUp){
				OnlineWindowMethods.mistakeCounter++;
				OnlineWindowMethods.mistakeAdujster(lblmistakeCounter);
				int randNum = OnlineWindowMethods.colorChanger("yellow",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				OnlineWindowMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				OnlineWindowMethods.oneUp = false;
			}
			else{
				OnlineWindowMethods.questionCounter++;		
				int randNum = OnlineWindowMethods.colorChanger("yellow",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				OnlineWindowMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);}
		}
		else{
			audio.losingSound();
			OnlineWindowMethods.mistakeCounter--;
			OnlineWindowMethods.mistakeAdujster(lblmistakeCounter);
		}
	}

}