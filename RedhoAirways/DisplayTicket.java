package RedhoAirways;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DisplayTicket extends JFrame {

	private JPanel contentPane;
	private JTextArea textDisplayTicket;
	private String firstName;
	private String lastName;
	private String ic;
	private String contact;
	private String email;
	private String flightType;
	private String flightClass;
	private String flightFrom;
	private String flightTo;
	private String adult;
	private String child;
	private String id;
	private String idNo;
	private String weight;
	private String fare;
	private JTextArea txtDisplayTicket;
	private String departDate;
	private String returnDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTicket frame = new DisplayTicket();
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
	public DisplayTicket() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setTitle("Redha Airways");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setBounds(0, 0, 611, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTicketDetails = new JLabel("Ticket Details");
		lblTicketDetails.setEnabled(true);
		lblTicketDetails.setBounds(10, 11, 133, 48);
		panel.add(lblTicketDetails);
		
		textDisplayTicket = new JTextArea();
		textDisplayTicket.setLineWrap(true);
		textDisplayTicket.setEditable(true);
		textDisplayTicket.setBounds(49, 70, 516, 234);
		panel.add(textDisplayTicket);
		
		JButton btnAddCust = new JButton("Add Customer");
		btnAddCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAddCust)
			      {
						addFlight af = new addFlight();
						af.setVisible(true);
						dispose();
					}
			      else
						dispose();
			}
		});
		btnAddCust.setBounds(142, 335, 133, 23);
		panel.add(btnAddCust);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnHome){
					HomeStaff hs = new HomeStaff();
						hs.setVisible(true);
						dispose();
				}
			}
		});
		btnHome.setBounds(346, 335, 133, 23);
		panel.add(btnHome);
	
		try{
			BufferedReader inCust = new BufferedReader(new FileReader("Customer.txt"));
			BufferedReader inFlight = new BufferedReader(new FileReader("Flight.txt"));
		
			String inData = null;
			while((inData = inCust.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(inData,"\t");
				firstName = st.nextToken();
				lastName = st.nextToken();
				ic = st.nextToken();
				contact = st.nextToken();
				email = st.nextToken();
			}
			inCust.close();
		
			while((inData = inFlight.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(inData,"\t");
				flightType = st.nextToken();
				flightClass = st.nextToken();
				flightFrom = st.nextToken();
				flightTo = st.nextToken();
				departDate = st.nextToken();
				returnDate = st.nextToken();
				adult = st.nextToken();
				child = st.nextToken();
				id = st.nextToken();
				idNo = st.nextToken();
				weight = st.nextToken();
				fare = st.nextToken();
			}
			inFlight.close();
		}
		catch(FileNotFoundException fe){
	         System.out.println(fe.getMessage());
	      }
	     catch(IOException iox){  
	         System.out.println(iox.getMessage());
	      }
	     catch(Exception e){
	         System.out.println("problem: "+e.getMessage());
	      }
		textDisplayTicket.append("FIRST NAME: "+firstName+"\nLAST NAME: "+lastName+"\n"+
								"FLIGHT DETAILS\n\tDEPART: "+flightFrom+"\n\tTO: "+flightTo+"\n"+
								"\tDEPART DATE: "+departDate+"\n\tRETURN DATE:"+returnDate+"\n"+
								"\tNO. OF ADULT: "+adult+"\n\tNO. OF CHILD: "+child+"\n"+
								"\tTOTAL FARE: RM"+fare);
		
	}
}