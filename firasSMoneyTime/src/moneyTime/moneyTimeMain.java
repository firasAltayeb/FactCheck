package moneyTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class moneyTimeMain {

	static questionList allQuestions = new questionList();
	static answers currentQuestionNumber = new answers();
	static moneyTimeAudio audio = new moneyTimeAudio();
	static Random random = new Random();
	static String[] qusListArray = allQuestions.createArray();
	static String[] answersOptions;
	static String correctAnswer;
	static String currentQuestion; 
	static int questionCounter;
	static int mistakeCounter = 5;



	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				new moneyTimeMain();

			}
		});
	}





	public moneyTimeMain(){

		//---------------------------- First Implementation of the values -------------------------------
		final int r = random.nextInt(3);
		currentQuestion = qusListArray[r];
		answersOptions = currentQuestionNumber.getOptions(currentQuestion);
		correctAnswer = currentQuestionNumber.getAnswer(currentQuestion);

		//---------------------------- JFrame Implementation  -------------------------------------------
		final JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(new Color(255, 0, 0));
		frame.setMinimumSize(new Dimension(1100, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//-----------------------------  Jlabels --------------------------------------------------------


		final JLabel L100 = new JLabel("100\u00A3");
		L100.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L100.setForeground(Color.RED);
		L100.setBackground(Color.WHITE);
		L100.setBounds(0, 450, 130, 40);
		frame.getContentPane().add(L100);


		final JLabel L200 = new JLabel("200\u00A3");
		L200.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L200.setForeground(Color.RED);
		L200.setBackground(Color.WHITE);
		L200.setBounds(0, 420, 130, 40);
		frame.getContentPane().add(L200);


		final JLabel L300 = new JLabel("300\u00A3");
		L300.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L300.setForeground(Color.RED);
		L300.setBackground(Color.WHITE);
		L300.setBounds(0, 390, 130, 40);
		frame.getContentPane().add(L300);


		final JLabel L500 = new JLabel("500\u00A3");
		L500.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L500.setForeground(Color.RED);
		L500.setBackground(Color.WHITE);
		L500.setBounds(0, 360, 140, 40);
		frame.getContentPane().add(L500);


		final JLabel L1000 = new JLabel("1000\u00A3");
		L1000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L1000.setForeground(Color.RED);
		L1000.setBackground(Color.WHITE);
		L1000.setBounds(0, 330, 130, 40);
		frame.getContentPane().add(L1000);


		final JLabel L2000 = new JLabel("2000\u00A3");
		L2000.setForeground(Color.RED);
		L2000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L2000.setBackground(Color.WHITE);
		L2000.setBounds(0, 300, 130, 40);
		frame.getContentPane().add(L2000);


		final JLabel L4000 = new JLabel("4000\u00A3");
		L4000.setForeground(Color.RED);
		L4000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L4000.setBackground(Color.WHITE);
		L4000.setBounds(0, 270, 130, 40);
		frame.getContentPane().add(L4000);


		final JLabel L8000 = new JLabel("8000\u00A3");
		L8000.setForeground(Color.RED);
		L8000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L8000.setBackground(Color.WHITE);
		L8000.setBounds(0, 240, 130, 40);
		frame.getContentPane().add(L8000);


		final JLabel L16000 = new JLabel("16000\u00A3");
		L16000.setForeground(Color.RED);
		L16000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L16000.setBackground(Color.WHITE);
		L16000.setBounds(0, 210, 130, 40);
		frame.getContentPane().add(L16000);


		final JLabel L32000 = new JLabel("32000\u00A3");
		L32000.setForeground(Color.RED);
		L32000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L32000.setBackground(Color.WHITE);
		L32000.setBounds(0, 180, 130, 40);
		frame.getContentPane().add(L32000);


		final JLabel L64000 = new JLabel("64000\u00A3");
		L64000.setForeground(Color.RED);
		L64000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L64000.setBackground(Color.WHITE);
		L64000.setBounds(0, 150, 130, 40);
		frame.getContentPane().add(L64000 );


		final JLabel L125000 = new JLabel("125000\u00A3");
		L125000.setForeground(Color.RED);
		L125000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L125000.setBackground(Color.WHITE);
		L125000.setBounds(0, 120, 130, 40);
		frame.getContentPane().add(L125000);


		final JLabel L250000 = new JLabel("250000\u00A3");
		L250000.setForeground(Color.RED);
		L250000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L250000.setBackground(Color.WHITE);
		L250000.setBounds(0, 90, 130, 40);
		frame.getContentPane().add(L250000);


		final JLabel L500000 = new JLabel("500000\u00A3");
		L500000.setForeground(Color.RED);
		L500000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L500000.setBackground(Color.WHITE);
		L500000.setBounds(0, 60, 130, 40);
		frame.getContentPane().add(L500000);


		final JLabel L1000000 = new JLabel("1000000\u00A3");
		L1000000.setForeground(Color.RED);
		L1000000.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		L1000000.setBackground(Color.WHITE);
		L1000000.setBounds(0, 30, 130, 40);
		frame.getContentPane().add(L1000000);


		JLabel lblA = new JLabel("a.");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(96, 323, 49, 59);
		frame.getContentPane().add(lblA);

		JLabel lblb = new JLabel("b.");
		lblb.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblb.setForeground(Color.WHITE);
		lblb.setBounds(573, 327, 49, 59);
		frame.getContentPane().add(lblb);

		JLabel lblc = new JLabel("c.");
		lblc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblc.setForeground(Color.WHITE);
		lblc.setBounds(96, 451, 49, 51);
		frame.getContentPane().add(lblc);

		JLabel lblD = new JLabel("d.");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblD.setForeground(Color.WHITE);
		lblD.setBounds(568, 454, 54, 44);
		frame.getContentPane().add(lblD);

		final JLabel QuestionLabel = new JLabel(currentQuestion);
		QuestionLabel.setForeground(Color.WHITE);
		QuestionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuestionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		QuestionLabel.setBounds(142, 153, 947, 93);
		frame.getContentPane().add(QuestionLabel);

		final JLabel lblmistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");
		lblmistakeCounter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblmistakeCounter.setForeground(Color.RED);
		lblmistakeCounter.setBounds(270, 60, 270, 30);
		frame.getContentPane().add(lblmistakeCounter);

		//------------------------ Answer buttons variables  ------------------------------------------------

		final JButton AnswerButtonOne = new JButton(answersOptions[0]);
		AnswerButtonOne.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton AnswerButtonTwo = new JButton(answersOptions[1]);
		AnswerButtonTwo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton AnswerButtonThree = new JButton(answersOptions[2]);
		AnswerButtonThree.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton AnswerButtonFour = new JButton(answersOptions[3]);		
		AnswerButtonFour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));


		//------------------------------- Answer button one -------------------------------------------------

		AnswerButtonOne.setBounds(142, 327, 302, 55);
		AnswerButtonOne.setForeground(Color.BLACK);
		AnswerButtonOne.setBackground(Color.RED);
		frame.getContentPane().add(AnswerButtonOne);

		AnswerButtonOne.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {


				if (AnswerButtonOne.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);

				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);


				}


			}
		});

		//--------------------------------- Answer button two -----------------------------------------------

		AnswerButtonTwo.setBounds(623, 327, 302, 55);
		AnswerButtonTwo.setForeground(Color.BLACK);
		AnswerButtonTwo.setBackground(Color.RED);
		frame.getContentPane().add(AnswerButtonTwo);

		AnswerButtonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (AnswerButtonTwo.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);



				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);
				}


			}
		});

		//-------------------------------- Answer button three ----------------------------------------------

		AnswerButtonThree.setBounds(142, 447, 302, 51);
		AnswerButtonThree.setForeground(Color.BLACK);
		AnswerButtonThree.setBackground(Color.RED);
		frame.getContentPane().add(AnswerButtonThree);

		AnswerButtonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (AnswerButtonThree.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);


				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);

				}

			}
		});

		//--------------------------------- Answer button four ----------------------------------------------

		AnswerButtonFour.setBounds(623, 447, 302, 51);
		AnswerButtonFour.setForeground(Color.BLACK);
		AnswerButtonFour.setBackground(Color.RED);
		frame.getContentPane().add(AnswerButtonFour); 

		AnswerButtonFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (AnswerButtonFour.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);

				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);
				}

			}
		});


		//------------------------------  Extra buttons -----------------------------------------------------
		JButton CollectCashButton = new JButton("Collect Cash");
		CollectCashButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		CollectCashButton.setBounds(810, 0, 270, 30);
		frame.getContentPane().add(CollectCashButton);
		CollectCashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				audio.winningSound();

				switch (questionCounter){

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

		final JButton FiftyFifty = new JButton("50/50");
		FiftyFifty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		FiftyFifty.setBounds(270, 0, 270, 30);
		frame.getContentPane().add(FiftyFifty);
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				if (AnswerButtonOne.getText().equals(correctAnswer))
				{
					AnswerButtonOne.setBackground(Color.YELLOW);
					AnswerButtonFour.setBackground(Color.YELLOW);
				}


				else if (AnswerButtonTwo.getText().equals(correctAnswer))
				{
					AnswerButtonTwo.setBackground(Color.YELLOW);
					AnswerButtonOne.setBackground(Color.YELLOW);
				}


				else if (AnswerButtonThree.getText().equals(correctAnswer))
				{
					AnswerButtonThree.setBackground(Color.YELLOW);
					AnswerButtonFour.setBackground(Color.YELLOW);
				}


				else if(AnswerButtonFour.getText().equals(correctAnswer))
				{
					AnswerButtonFour.setBackground(Color.YELLOW);
					AnswerButtonTwo.setBackground(Color.YELLOW);
				}

				FiftyFifty.setEnabled(false);
			}
		});


		final JButton Audience = new JButton("Audience");
		Audience.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		Audience.setBounds(540, 0, 270, 30);
		frame.getContentPane().add(Audience);
		Audience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	


				JFrame AudienceFrame = new JFrame();
				AudienceFrame.setSize(400, 300);
				AudienceFrame.setVisible(true);
				double[] values = new double[4];
				String[] names = new String[4];
				values[0] = random.nextInt(15);
				names[0] = "A";

				values[1] = random.nextInt(15);
				names[1] = "B";

				values[2] = random.nextInt(15);
				names[2] = "C";

				values[3] = random.nextInt(15);
				names[3] = "D";

				AudienceFrame.getContentPane().add(new ChartPanel(values, names, "Audience"));

				Audience.setEnabled(false);

			}
		});


		JButton ExitB = new JButton("Exit");
		ExitB.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		ExitB.setBounds(0, 0, 270, 30);
		frame.getContentPane().add(ExitB);
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

		JLabel pictureLabel = new JLabel("");
		pictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
		Image img = new ImageIcon(this.getClass().getResource("/WM.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img));
		pictureLabel.setBounds(0, 30, 1080, 523);
		frame.getContentPane().add(pictureLabel);


		//-------------------------- JMenu Bar --------------------------------------------------------------

		JMenuBar menuBar = new JMenuBar();
		
		JMenu difficulty = new JMenu("Difficulty");
		difficulty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		difficulty.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem easy = new JMenuItem("easy");
		easy.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		easy.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		easy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				mistakeCounter = 10;
				questionCounter = 0;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 10 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
			
			}

		});


		JMenuItem hard = new JMenuItem("Hard");
		hard.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		hard.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		hard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				mistakeCounter = 3;
				questionCounter = 0;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER =3  ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
				
			}

		});

		difficulty.add(easy);
		difficulty.add(hard);
		menuBar.add(difficulty);

		JMenu help = new JMenu("Help");
		help.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		help.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem restart = new JMenuItem("Restart");
		restart.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		restart.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				questionCounter = 0;
				mistakeCounter = 5;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,AnswerButtonOne,AnswerButtonTwo,AnswerButtonThree,AnswerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 5 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);

			}

		});

		JMenuItem information = new JMenuItem("Information");
		information.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		information.setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_1,ActionEvent.ALT_MASK));
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(frame, "<html>For more information please vist "
						+ "\n http://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F ");
			}

		});

		help.add(restart);
		help.add(information);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);


	}



}
