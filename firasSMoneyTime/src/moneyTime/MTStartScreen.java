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
		setVisible(true);
		setMinimumSize(new Dimension(1900, 1100));
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
				new MTMethods();
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(1900, 1000));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				new MTOfflineWindow(frame);
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
					new MTOnlineLink();
				} catch (IOException e) {
					e.printStackTrace();
				}
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(1900, 1000));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				new MTOnlineWindow(frame);
				dispose();
			}
		});
		
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1900, 1100); 
		getContentPane().add(pictureLabel); 
		setSize(500,500);
		

	}
	
	
}
