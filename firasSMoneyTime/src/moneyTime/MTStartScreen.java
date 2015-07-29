package moneyTime;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MTStartScreen extends JFrame 
{
	
	MTStartScreen(final MTMethods MTM )
	{
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel JP = new JPanel();
		getContentPane().add(JP);
		JButton offlineMode = new JButton("Offline Mode");
		offlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		//offlineMode.setBounds(10, 100, 10, 10);
		offlineMode.setForeground(Color.BLACK);
		offlineMode.setBackground(Color.WHITE);
		JP.add(offlineMode);
		offlineMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new MTOfflineWindow(MTM);
				//System.exit(0);
			}
		});
		
		JButton onlineMode = new JButton("Online Mode");
		onlineMode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		//onlineMode.setBounds(10, 100, 10, 10);
		onlineMode.setForeground(Color.BLACK);
		onlineMode.setBackground(Color.WHITE);
		JP.add(onlineMode);
		
		
		/*ImageIcon picture = new ImageIcon("WM.jpg");
		JLabel img = new JLabel(picture);
		img.setHorizontalAlignment(SwingConstants.LEFT);
		img.setBounds(0, 50, 50, 50);
		JP.add(img);*/
		
		//pack();
	}
	
	
}
