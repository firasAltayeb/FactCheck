import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Objects;

public class GameWindow implements ActionListener {
    final Audio audio = new Audio();
    final Utility utility;

    JButton[] optionBtnArray;
    JButton[] topBtnArray;
    JLabel mistakeCounter;
    JLabel QuestionLabel;
    JLabel[] labels;

    public GameWindow(final JFrame frame) {
        audio.enteringSound();
        utility = new Utility();
        labels = new JLabel[utility.amounts.length + 7];
        QuestionLabel = new JLabel(utility.currentQuestion.getQusTxt());
        mistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");

        labels[0] = new JLabel("@FirasAltayeb");
        for (int i = 0; i < utility.amounts.length; i++)
            labels[i + 1] = new JLabel(utility.amounts[i] + "£");
        labels[utility.amounts.length + 1] = new JLabel("c.");
        labels[utility.amounts.length + 2] = new JLabel("a.");
        labels[utility.amounts.length + 3] = QuestionLabel;
        labels[utility.amounts.length + 4] = mistakeCounter;
        labels[utility.amounts.length + 5] = new JLabel("d.");
        labels[utility.amounts.length + 6] = new JLabel("b.");

        int xAxis;
        int yAxis = 250;
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

        final JButton answerButton01 = new JButton(utility.optionArray.get(0).getAnsTxt());
        final JButton answerButton02 = new JButton(utility.optionArray.get(1).getAnsTxt());
        final JButton answerButton03 = new JButton(utility.optionArray.get(2).getAnsTxt());
        final JButton answerButton04 = new JButton(utility.optionArray.get(3).getAnsTxt());

        optionBtnArray = new JButton[4];
        optionBtnArray[0] = answerButton01;
        optionBtnArray[1] = answerButton02;
        optionBtnArray[2] = answerButton03;
        optionBtnArray[3] = answerButton04;

        yAxis = 430;
        xAxis = 280;
        for (int i = 0; i <= 3; i++) {
            optionBtnArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
            optionBtnArray[i].setBounds(xAxis, yAxis, 300, 50);
            optionBtnArray[i].setForeground(Color.BLACK);
            optionBtnArray[i].setBackground(Color.RED);
            frame.getContentPane().add(optionBtnArray[i]);
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

        final JButton rockPaperScissor = new JButton("Rock.Paper.Scissor");
        final JButton fiftyFifty = new JButton("50/50");
        final JButton Audience = new JButton("Audience");
        final JButton oneUpQuestion = new JButton("1-UP Question");

        topBtnArray = new JButton[4];
        topBtnArray[0] = rockPaperScissor;
        topBtnArray[1] = fiftyFifty;
        topBtnArray[2] = Audience;
        topBtnArray[3] = oneUpQuestion;

        xAxis = 0;
        for (int i = 0; i <= 3; i++) {
            topBtnArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
            topBtnArray[i].setBounds(xAxis, 0, 250, 30);
            frame.getContentPane().add(topBtnArray[i]);
            xAxis += 250;
        }

        rockPaperScissor.addActionListener(arg0 -> {
            audio.cameraSound4();
            new RockPaperScissor(answerButton01, answerButton02, answerButton03, answerButton04, utility);
            rockPaperScissor.setEnabled(false);
        });

        fiftyFifty.addActionListener(arg0 -> {
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

            fiftyFifty.setEnabled(false);
        });

        Audience.addActionListener(arg0 -> {
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

            values[0] = utility.random.nextInt(5);
            values[1] = utility.random.nextInt(5);
            values[2] = utility.random.nextInt(5);
            values[3] = utility.random.nextInt(5);

            if (utility.correctAnswer.equals(utility.optionArray.get(0).getAnsTxt())) {
                values[0] += utility.questionCounter <= 8 ? 3 : 2;
            } else if (utility.correctAnswer.equals(utility.optionArray.get(1).getAnsTxt())) {
                values[1] += utility.questionCounter <= 8 ? 3 : 2;
            } else if (utility.correctAnswer.equals(utility.optionArray.get(2).getAnsTxt())) {
                values[2] += utility.questionCounter <= 8 ? 3 : 2;
            } else {
                values[3] += utility.questionCounter <= 8 ? 3 : 2;
            }

            AudienceFrame.getContentPane().add(new AudienceFrame(values, names, "Audience"));
            Audience.setEnabled(false);
        });


        oneUpQuestion.addActionListener(q -> {
            answerButton01.setEnabled(true);
            answerButton02.setEnabled(true);
            answerButton03.setEnabled(true);
            answerButton04.setEnabled(true);
            audio.cameraSound1();
            utility.oneUpQuestion(optionBtnArray, QuestionLabel);
            oneUpQuestion.setEnabled(false);

        });

        JLabel pictureLabel = new JLabel("");
        Image img = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/assets/offlineM.jpg"))).getImage();
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

        for (int i = 0; i <= 5; i++) {
            JMenuItemArray[i].setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
            JMenuItemArray[i].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
        }

        easy.addActionListener(arg0 -> utility.restartGame(10, labels, topBtnArray, mistakeCounter));
        restart.addActionListener(arg0 -> utility.restartGame(5, labels, topBtnArray, mistakeCounter));
        hard.addActionListener(arg0 -> utility.restartGame(3, labels, topBtnArray, mistakeCounter));

        // Opens the user's browser to a URL page which shows general information about the game.
        information.addActionListener(arg0 -> {
            try {
                Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F").toURI());
            } catch (Exception e) {
                System.out.println("exception" + e);
            }
        });

        exit.addActionListener(arg0 -> {
            audio.buzzerSound2();
            Object[] options = {"YES", "NO"};
            int optionButton = JOptionPane.showOptionDialog(frame, "Are you sure you wish to quit?", null, JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            if (optionButton == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        });

        collect.addActionListener(arg0 -> {
            if (utility.questionCounter >= 1) {
                audio.applauseSound2();
                JOptionPane.showMessageDialog(null, "You won " + utility.amounts[utility.questionCounter - 1]);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "You have no cash to collect");
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
            if (utility.questionCounter <= 15) {
                audio.applauseSound1();
            } else {
                audio.applauseSound2();
            }
            if (utility.oneUpQus) {
                utility.mistakeCounter++;
                mistakeCounter.setText("MISTAKE COUNTER = " + utility.mistakeCounter);
                utility.oneUpQus = false;
            } else {
                utility.questionCounter++;
            }
            utility.colorChanger("yellow", labels);
            utility.newQuestion(optionBtnArray, QuestionLabel);
        } else {
            audio.losingSound();
            audio.losingSound();
            utility.mistakeCounter--;
            mistakeCounter.setText("MISTAKE COUNTER = " + utility.mistakeCounter);
            if (utility.mistakeCounter == 0) {
                JOptionPane.showMessageDialog(null, "You have reached the maximum amount of mistakes");
                audio.buzzerSound2();
                utility.restartGame(5, labels, topBtnArray, mistakeCounter);
                utility.newQuestion(optionBtnArray, QuestionLabel);
            }
        }
    }
}