package RedhoAirways;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class LoginStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStaff frame = new LoginStaff();
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
	public LoginStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(98, 76, 286, 124);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Username");
		label.setBounds(10, 38, 97, 24);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(10, 73, 97, 24);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 40, 132, 20);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 75, 132, 20);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnLogin){
					boolean action = verifyLogin();
					if(action == true)
					{
						dispose();
						HomeStaff hs = new HomeStaff();
						hs.setVisible(true);
					}
				}
			}
		});
		btnLogin.setBounds(108, 211, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancel){
					dispose();
					Home h = new Home();
					h.setVisible(true);
				}
			}
		});
		btnCancel.setBounds(247, 211, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel label_2 = new JLabel("LOGIN STAFF");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_2.setBounds(168, 28, 134, 37);
		contentPane.add(label_2);
	}
	
	public boolean verifyLogin()
	{
		boolean action = false;
		
			try{
				BufferedReader inStaff = new BufferedReader(new FileReader("C:\\Projects\\Redho\\Staff.csv"));
				String inData = null;
				String id = null;
				String password = null;
				String name;
				String ic;
				while((inData = inStaff.readLine()) != null){
					StringTokenizer st = new StringTokenizer(inData,"\t");
					id = st.nextToken();
					password = st.nextToken();
					name = st.nextToken();
					ic = st.nextToken();
				}
				
				String userName = textField.getText();
				String passWord = new String(passwordField.getPassword());
				
				String getUser = id;
				String getPass = password;
				if (userName.equalsIgnoreCase(getUser) && passWord.equalsIgnoreCase(getPass))
	            {
						JOptionPane.showMessageDialog(null,"Login Successful");
						action = true;
				   }
					else
	            {
						JOptionPane.showMessageDialog(null,"Invalid User name or Password");
						action = false;
	            }
	               
				inStaff.close();

			}
			catch(IOException iox){
				JOptionPane.showMessageDialog(null,iox.getMessage());
				action = false;
			}
			return action;
	}
}
