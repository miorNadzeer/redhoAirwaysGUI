package RedhoAirways;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Home extends JFrame{

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setLocationByPlatform(true);
		setName("LoginPage");
		setTitle("REDHA AIRWAYS");
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRedhoAirways = new JLabel("Redha Airways");
		lblRedhoAirways.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRedhoAirways.setBounds(87, 29, 253, 85);
		contentPane.add(lblRedhoAirways);
		
		JButton btnLogin = new JButton("STAFF LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Login lg = new Login();
					lg.setVisible(true);
					
			}
		});
		btnLogin.setBounds(56, 131, 151, 54);
		contentPane.add(btnLogin);
		
		JButton btnAdminLogin = new JButton("ADMIN LOGIN");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginAdmin la = new LoginAdmin();
				la.setVisible(true);
			}
		});
		btnAdminLogin.setBounds(229, 131, 151, 54);
		contentPane.add(btnAdminLogin);
	}
}
