package moneyTime;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MTStartScreen extends JFrame
{
	MTStartScreen()
	{
	
		final MTAudio audio = new MTAudio();
		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		
		setContentPane(pictureLabel);
		setLayout(new GridLayout(1,2));
		
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton offlineMode = new JButton("Offline Mode");
		offlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		add(offlineMode);
		offlineMode.setForeground(Color.WHITE);
		offlineMode.setOpaque(false);
		offlineMode.setContentAreaFilled(false);
		offlineMode.setBorderPainted(false);
		add(offlineMode);
		offlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				new MTMethods();
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				new MTOfflineWindow(frame);
				dispose();
			}
		});
		
		JButton onlineMode = new JButton("Online Mode");
		onlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		add(onlineMode);
		onlineMode.setForeground(Color.WHITE);
		onlineMode.setOpaque(false);
		onlineMode.setContentAreaFilled(false);
		onlineMode.setBorderPainted(false);
		add(onlineMode);
		onlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				try {
					new MTOnlineLink();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setSize(1900, 1000);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				new MTOnlineWindow(frame);
				dispose();
			}
		});
		

	}
	
	
}
