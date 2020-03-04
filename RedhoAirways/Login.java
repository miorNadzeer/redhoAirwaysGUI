package RedhoAirways;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Point;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String name;
	private String ic;
	private String id;
	private String password;
	private String flightType;
	private String flightClass;
	private String flightFrom;
	private String flightTo;
	private String departDate;
	private String returnDate;
	private String adult;
	private String child;
	private String idNo;
	private String weight;
	private String fare;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setLocation(new Point(7, 5));
		setPreferredSize(new Dimension(4, 4));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setTitle("Redha Airways");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(76, 76, 286, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 38, 97, 24);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 73, 97, 24);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(117, 40, 132, 20);
		panel.add(textField);
		textField.setColumns(10);
		
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
		btnLogin.setBounds(104, 211, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("LOGIN STAFF");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLogin.setBounds(155, 28, 134, 37);
		contentPane.add(lblLogin);
		
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
		btnCancel.setBounds(230, 211, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public boolean verifyLogin()
	{
		boolean action = false;
		
			try{
				BufferedReader inStaff = new BufferedReader(new FileReader("C:\\Projects\\Redho\\Staff.txt"));
				String inData = null;
				while((inData = inStaff.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(inData,"\t");
					id = st.nextToken();
					password = st.nextToken();
					name = st.nextToken();
					ic = st.nextToken();
				}
				inStaff.close();
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
	               
				

			}
			catch(IOException iox){
				JOptionPane.showMessageDialog(null,iox.getMessage());
				action = false;
			}
			return action;
	}

}
