package MoneyTime;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoneyTimeMain extends JFrame {
	public static void main(String[] args){	
		final Audio audio = new Audio();
		audio.enteringSound();
		new Utility();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(1000, 600 ));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		new GameWindow(frame);
	
	}

}
