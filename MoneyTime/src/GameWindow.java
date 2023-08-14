import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

public class GameWindow implements ActionListener {
	final Random random = new Random();
	final Audio audio = new Audio();
	final Utility utility;

	final JButton answerButton01;
	final JButton answerButton02;
	final JButton answerButton03;
	final JButton answerButton04;

	final JButton RockPaperScissor;
	final JButton oneUpQuestion;
	final JButton FiftyFifty;
	final JButton Audience;

	JLabel mistakeCounter;
	JLabel QuestionLabel;
	JLabel[] labels;

	public GameWindow(final JFrame frame) {
		audio.enteringSound();
		utility = new Utility();
		QuestionLabel = new JLabel(utility.currentQuestion);
		mistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");
		labels = new JLabel[]{
				new JLabel("@FirasAltayeb"),
				new JLabel("100\u00A3"),
				new JLabel("200\u00A3"),
				new JLabel("300\u00A3"),
				new JLabel("500\u00A3"),
				new JLabel("1000\u00A3"),
				new JLabel("2000\u00A3"),
				new JLabel("4000\u00A3"),
				new JLabel("8000\u00A3"),
				new JLabel("16000\u00A3"),
				new JLabel("32000\u00A3"),
				new JLabel("64000\u00A3"),
				new JLabel("125000\u00A3"),
				new JLabel("250000\u00A3"),
				new JLabel("500000\u00A3"),
				new JLabel("1000000\u00A3"),
				new JLabel("c."),
				new JLabel("a."),
				QuestionLabel,
				mistakeCounter,
				new JLabel("d."),
				new JLabel("b."),
		};


		int yAxis = 250;
		int xAxis;
		//the following for loop prints the first 16 labels in the JlabelArray with the same font and foreground but with different bounds.
		for (int i = 0; i <= 16; i++) {
			labels[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			labels[i].setForeground(Color.RED);
			labels[i].setBounds(0, yAxis, 500, 500);
			frame.getContentPane().add(labels[i]);
			yAxis -= 30;

		}

		yAxis = 200;
		xAxis = 250;
		for (int i = 16; i <= 21; i++) {
			labels[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			labels[i].setForeground(Color.WHITE);
			labels[i].setBounds(xAxis, yAxis, 800, 500);
			frame.getContentPane().add(labels[i]);
			yAxis -= 120;
			if (i == 19) {
				yAxis = 200;
				xAxis = 600;
			}
		}

		//------------------------ Answer buttons variables  ------------------------------------------------

		answerButton01 = new JButton(utility.answerOptionArray[0]);
		answerButton02 = new JButton(utility.answerOptionArray[1]);
		answerButton03 = new JButton(utility.answerOptionArray[2]);
		answerButton04 = new JButton(utility.answerOptionArray[3]);

		//JButtonArray holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray = new JButton[4];
		JButtonArray[0] = answerButton01;
		JButtonArray[1] = answerButton02;
		JButtonArray[2] = answerButton03;
		JButtonArray[3] = answerButton04;

		yAxis = 430;
		xAxis = 280;
		//the following for loop prints the buttons in the JButtonArray with the same background,foreground  and font but with different bounds.
		for (int i = 0; i <= 3; i++) {
			JButtonArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray[i].setBounds(xAxis, yAxis, 300, 50);
			JButtonArray[i].setForeground(Color.BLACK);
			JButtonArray[i].setBackground(Color.RED);
			frame.getContentPane().add(JButtonArray[i]);
			if (i == 0) {
				xAxis = 640;
			}
			if (i == 1) {
				xAxis = 280;
				yAxis = 300;
			}
			if (i == 2) {
				xAxis = 640;
			}

		}

		answerButton01.addActionListener(this);
		answerButton02.addActionListener(this);
		answerButton03.addActionListener(this);
		answerButton04.addActionListener(this);

		//------------------------------  Extra buttons -----------------------------------------------------

		RockPaperScissor = new JButton("Rock.Paper.Scissor");
		FiftyFifty = new JButton("50/50");
		Audience = new JButton("Audience");
		oneUpQuestion = new JButton("1-UP Question");

		//JButtonArray2 holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray2 = new JButton[4];
		JButtonArray2[0] = RockPaperScissor;
		JButtonArray2[1] = FiftyFifty;
		JButtonArray2[2] = Audience;
		JButtonArray2[3] = oneUpQuestion;

		xAxis=0;
		//the following for loop prints the buttons in the JButtonArray2 with the same background and foreground but with different bounds.
		for(int i=0;i<=3;i++){
			JButtonArray2[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray2[i].setBounds(xAxis, 0, 250, 30);
			frame.getContentPane().add(JButtonArray2[i]);
			xAxis+=250;
		}

		RockPaperScissor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.cameraSound4();
				new RockPaperScissor(answerButton01, answerButton02, answerButton03, answerButton04, utility);
				RockPaperScissor.setEnabled(false);
			}
		});

		/*disables two wrong answer's buttons,after the button is used the button becomes disabled*/
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.cameraSound2();
				if (answerButton01.getText().equals(utility.correctAnswer)) {
					answerButton02.setEnabled(false);
					answerButton04.setEnabled(false);
				} else if (answerButton02.getText().equals(utility.correctAnswer)) {
					answerButton03.setEnabled(false);
					answerButton01.setEnabled(false);
				} else if (answerButton03.getText().equals(utility.correctAnswer)) {
					answerButton02.setEnabled(false);
					answerButton04.setEnabled(false);
				} else if (answerButton04.getText().equals(utility.correctAnswer)) {
					answerButton01.setEnabled(false);
					answerButton02.setEnabled(false);
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
				if(utility.questionCounter<=8)
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(utility.correctAnswer.equals(utility.answerOptionArray[0]))
					{
						values[0] += 3;
					}
					else if(utility.correctAnswer.equals(utility.answerOptionArray[1]))
					{
						values[1] += 3;
					}
					else if(utility.correctAnswer.equals(utility.answerOptionArray[2]))
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

					if(utility.correctAnswer.equals(utility.answerOptionArray[0]))
					{
						values[0] += 2;
					}
					else if(utility.correctAnswer.equals(utility.answerOptionArray[1]))
					{
						values[1] += 2;
					}
					else if(utility.correctAnswer.equals(utility.answerOptionArray[2]))
					{
						values[2] += 2;
					}
					else 
					{
						values[3] += 2;
					}

				}
				AudienceFrame.getContentPane().add(new AudienceFrame(values, names, "Audience"));
				Audience.setEnabled(false);
			}
		});


		oneUpQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent q) {
				answerButton01.setEnabled(true);
				answerButton02.setEnabled(true);
				answerButton03.setEnabled(true);
				answerButton04.setEnabled(true);
				audio.cameraSound1();
				utility.oneUpQuestion(answerButton01,
						answerButton02,
						answerButton03,
						answerButton04,
						QuestionLabel);
				oneUpQuestion.setEnabled(false);

			}
		});


		/*JLabel img = new JLabel( new ImageIcon("WM2.jpg"));
		img.setBounds(0, 0, 1900, 1100);
		frame.getContentPane().add(img);*/
		//pictureLabel stores the background picture of the game and prints it.
		JLabel pictureLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/assets/offlineM.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img));
		pictureLabel.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(pictureLabel);


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

		JMenuItem easy = new JMenuItem("easy");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem information = new JMenuItem("Information");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem collect = new JMenuItem("Collect Cash");
		JMenuItem[] JMenuItemArray = new JMenuItem[6];
		JMenuItemArray[0] = easy;
		JMenuItemArray[1] = hard;
		JMenuItemArray[2] = restart;
		JMenuItemArray[3] = information;
		JMenuItemArray[4] = exit;
		JMenuItemArray[5] = collect;

		for(int i=0;i<=5;i++){
			JMenuItemArray[i].setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
			JMenuItemArray[i].setAccelerator(KeyStroke.getKeyStroke
					(KeyEvent.VK_1,ActionEvent.ALT_MASK));	
		}

		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(10);
			}

		});

		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(3);
			}

		});

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(5);
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
				if(utility.questionCounter >= 1) {
					audio.applauseSound2();
					switch (utility.questionCounter){
					case 1:	JOptionPane.showMessageDialog(null, "You won 100�");System.exit(0);
					case 2:	JOptionPane.showMessageDialog(null, "You won 200�");System.exit(0);
					case 3:	JOptionPane.showMessageDialog(null, "You won 300�");System.exit(0);
					case 4: JOptionPane.showMessageDialog(null, "You won 500�");System.exit(0);
					case 5:	JOptionPane.showMessageDialog(null, "You won 1000�");System.exit(0);
					case 6:	JOptionPane.showMessageDialog(null, "You won 2000�");System.exit(0);
					case 7:	JOptionPane.showMessageDialog(null, "You won 4000�");System.exit(0);
					case 8:	JOptionPane.showMessageDialog(null, "You won 8000�");System.exit(0);
					case 9:	JOptionPane.showMessageDialog(null, "You won 16000�");System.exit(0);
					case 10: JOptionPane.showMessageDialog(null, "You won 32000�");System.exit(0);
					case 11: JOptionPane.showMessageDialog(null, "You won 64000�");System.exit(0);
					case 12: JOptionPane.showMessageDialog(null, "You won 125000�");System.exit(0);
					case 13: JOptionPane.showMessageDialog(null, "You won 250000�");System.exit(0);
					case 14: JOptionPane.showMessageDialog(null, "You won 500000�");System.exit(0);	
					case 15: JOptionPane.showMessageDialog(null, "You won 1000000�");System.exit(0);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "You have no cash to collect");
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
		menuBar.add(quit);
		frame.setJMenuBar(menuBar);
		frame.pack();
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(utility.correctAnswer)) {
			if (utility.questionCounter <= 15)
				audio.applauseSound1();
			else
				audio.applauseSound2();

			if (utility.oneUpQus) {
				utility.mistakeCounter++;
				mistakeCounter.setText("MISTAKE COUNTER = " + utility.mistakeCounter);
				utility.colorChanger("yellow", labels);
				int randNum = random.nextInt(3) + (3 * utility.questionCounter);
				utility.newQuestion(randNum, answerButton01, answerButton02, answerButton03, answerButton04, QuestionLabel);
				utility.oneUpQus = false;
			} else {
				utility.questionCounter++;
				int randNum = random.nextInt(3) + (3 * utility.questionCounter);
				utility.colorChanger("yellow", labels);
				utility.newQuestion(randNum, answerButton01, answerButton02, answerButton03, answerButton04, QuestionLabel);
			}
		}
		else {
			audio.losingSound();
			utility.mistakeCounter--;
			mistakeCounter.setText("MISTAKE COUNTER = " + utility.mistakeCounter);
			if (utility.mistakeCounter == 0) {
				JOptionPane.showMessageDialog(null, "You have reached the maximum amount of mistakes");
				audio.buzzerSound2();
				restartGame(5);
			}
		}
	}

	public void restartGame(int counter) {
		utility.mistakeCounter = counter;
		utility.questionCounter = 0;
		utility.colorChanger("red", labels);
		int randNum = random.nextInt(3) + (3 * utility.questionCounter);
		utility.newQuestion(randNum, answerButton01, answerButton02,
				answerButton03, answerButton04, QuestionLabel);
		mistakeCounter.setText("MISTAKE COUNTER = " + counter);
		FiftyFifty.setEnabled(true);
		Audience.setEnabled(true);
		oneUpQuestion.setEnabled(true);
		RockPaperScissor.setEnabled(true);
	}
}