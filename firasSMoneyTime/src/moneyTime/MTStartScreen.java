package moneyTime;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MTStartScreen
{
	MTStartScreen()
	{
		final MTAudio audio = new MTAudio();
		final JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(1900, 1100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton offlineMode = new JButton("Offline Mode");
		offlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		offlineMode.setBounds(130, 100, 200, 50);
		offlineMode.setForeground(Color.WHITE);
		offlineMode.setOpaque(false);
		offlineMode.setContentAreaFilled(false);
		offlineMode.setBorderPainted(false);
		frame.getContentPane().add(offlineMode);
		offlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				new MTMethods();
				new MTOfflineWindow();
				frame.dispose();
			}
		});
		
		JButton onlineMode = new JButton("Online Mode");
		onlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		onlineMode.setBounds(130, 200, 200, 50);
		onlineMode.setForeground(Color.WHITE);
		onlineMode.setOpaque(false);
		onlineMode.setContentAreaFilled(false);
		onlineMode.setBorderPainted(false);
		frame.getContentPane().add(onlineMode);
		onlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.enteringSound();
				try {
					new onlineLink();
				} catch (IOException e) {
					e.printStackTrace();
				}
				new MTOnlineWindow();
				frame.dispose();
			}
		});
		
		/*JLabel img = new JLabel(new ImageIcon("WM2.jpg"));
		img.setBounds(0, 0, 500 ,500);
		frame.getContentPane().add(img);*/
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/titleScreen.jpg")).getImage(); 
		//pictureLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1900, 1100); 
		frame.getContentPane().add(pictureLabel); 
		frame.setSize(500,500);
		

	}
	
	
}
