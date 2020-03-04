package RedhoAirways;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HomeStaff extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStaff frame = new HomeStaff();
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
	public HomeStaff() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setTitle("Redha Airways");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaff.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblStaff.setBackground(new Color(50, 205, 50));
		lblStaff.setBounds(10, 11, 72, 28);
		contentPane.add(lblStaff);
		
		JLabel label_1 = new JLabel("HOME");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBackground(new Color(240, 255, 255));
		label_1.setBounds(187, 41, 122, 62);
		contentPane.add(label_1);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAddCustomer)
			      {
					addFlight aF = new addFlight();
					aF.setVisible(true);
					dispose();
			      }
			}
		});
		btnAddCustomer.setBounds(155, 112, 186, 62);
		contentPane.add(btnAddCustomer);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLogOut){
					Login lg = new Login();
					lg.setVisible(true);
					dispose();
				}
			}
		});
		btnLogOut.setBounds(155, 185, 186, 62);
		contentPane.add(btnLogOut);
	}

}
