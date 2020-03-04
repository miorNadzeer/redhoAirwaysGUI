package RedhoAirways;

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
import java.awt.Color;
import java.awt.Toolkit;

public class LoginAdmin extends JFrame {

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
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setTitle("Redha Airways");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(76, 76, 286, 124);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Username");
		label.setBounds(10, 38, 97, 24);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(10, 73, 97, 24);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 40, 132, 20);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 75, 132, 20);
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLogin){
					boolean action = verifyLogin();
					if(action == true)
					{
						dispose();
						HomeAdmin ha = new HomeAdmin();
						ha.setVisible(true);
					}

				}
			}
		});
		btnLogin.setBounds(112, 211, 89, 23);
		panel.add(btnLogin);
		
		JLabel lblAdminStaff = new JLabel(" ADMIN STAFF");
		lblAdminStaff.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdminStaff.setBounds(155, 28, 134, 37);
		panel.add(lblAdminStaff);	
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button){
					dispose();
					Home h = new Home();
					h.setVisible(true);
				}
			}
		});
		button.setBounds(244, 211, 89, 23);
		panel.add(button);
		
		
	}
	public boolean verifyLogin()
	{
		boolean action = false;
		
			try{
				BufferedReader inStaff = new BufferedReader(new FileReader("C:\\Projects\\Redho\\adminPass.csv"));
				String inData = null;
				String id = null;
				String password = null;
				while((inData = inStaff.readLine()) != null){
					StringTokenizer st = new StringTokenizer(inData,"\t");
					id = st.nextToken();
					password = st.nextToken();

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
