package moneyTime;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MTStartScreen
{
	MTStartScreen(final MTMethods MTM )
	{
		final JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon picture = new ImageIcon("WM2.jpg");
		JLabel img = new JLabel(picture);
		img.setBounds(0, 0, 500 ,500);
		frame.setContentPane(img);
		
		JButton offlineMode = new JButton("Offline Mode");
		offlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		offlineMode.setBounds(130, 100, 200, 50);
		offlineMode.setForeground(Color.WHITE);
		offlineMode.setOpaque(false);
		offlineMode.setContentAreaFilled(false);
		offlineMode.setBorderPainted(false);
		frame.getContentPane().add(offlineMode);
		offlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new MTOfflineWindow(MTM);
				frame.dispose();
			}
		});
		
		JButton onlineMode = new JButton("Online Mode");
		onlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		onlineMode.setBounds(130, 200, 200, 50);
		onlineMode.setForeground(Color.WHITE);
		onlineMode.setOpaque(false);
		onlineMode.setContentAreaFilled(false);
		onlineMode.setBorderPainted(false);
		frame.getContentPane().add(onlineMode);
		frame.pack();
	}
	
	
}
