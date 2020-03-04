package RedhoAirways;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin frame = new HomeAdmin();
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
	public HomeAdmin() {
		setTitle("Redha Airways");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setBackground(new Color(50, 205, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewCounterOfficer = new JButton("Sales Report 1");
		btnViewCounterOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnViewCounterOfficer)
			      {
					ViewSalesClass vsc = new ViewSalesClass();
						vsc.setVisible(true);
						dispose();
				}
			    else
			    	dispose();
			}
		});
		btnViewCounterOfficer.setBounds(158, 92, 186, 62);
		contentPane.add(btnViewCounterOfficer);
		
		JButton btnCustomerReport = new JButton("Sales Report 2");
		btnCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCustomerReport)
			      {
					ViewSalesReport vsr = new ViewSalesReport();
						vsr.setVisible(true);
						dispose();
				}
			    else
			    	dispose();
			}
		});
		btnCustomerReport.setBounds(158, 165, 186, 62);
		contentPane.add(btnCustomerReport);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(189, 19, 122, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lbladmin = new JLabel("Admin");
		lbladmin.setBackground(new Color(50, 205, 50));
		lbladmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbladmin.setHorizontalAlignment(SwingConstants.CENTER);
		lbladmin.setBounds(10, 11, 72, 28);
		contentPane.add(lbladmin);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLogOut){
					LoginAdmin la = new LoginAdmin();
						la.setVisible(true);
						dispose();
				}

			}
		});
		btnLogOut.setBounds(158, 238, 186, 62);
		contentPane.add(btnLogOut);
	}

}
