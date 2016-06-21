package MoneyTime;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class StartScreen extends JFrame
{
	StartScreen()
	{
		final Audio audio = new Audio();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton offlineMode = new JButton("Offline Mode");
		offlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		offlineMode.setBounds(130, 100, 200, 50);
		offlineMode.setForeground(Color.WHITE);
		offlineMode.setOpaque(false);
		offlineMode.setContentAreaFilled(false);
		offlineMode.setBorderPainted(false);
		getContentPane().add(offlineMode);

		offlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				new Methods();
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(1000, 600 ));
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				
				new OfflineWindow(frame);
				dispose();
			}
		});
		
		JButton onlineMode = new JButton("Online Mode");
		onlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		onlineMode.setBounds(130, 200, 200, 50);
		onlineMode.setForeground(Color.WHITE);
		onlineMode.setOpaque(false);
		onlineMode.setContentAreaFilled(false);
		onlineMode.setBorderPainted(false);
		getContentPane().add(onlineMode);
		
		onlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				try {
					new OnlineLink();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(1000, 600 ));
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				new OnlineWindow(frame);
				dispose();
			}
		});
		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/TitleScreen.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1000, 1000); 
		getContentPane().add(pictureLabel); 
		
		setSize(500,500);
		setResizable(false);
		

	}
	
	
}
