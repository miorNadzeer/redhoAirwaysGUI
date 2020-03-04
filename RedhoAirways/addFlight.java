package RedhoAirways;


import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import RedhoAirways.Flight;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.awt.Cursor;

public class addFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textMemberID;
	private final ButtonGroup bgType = new ButtonGroup();
	private final ButtonGroup bgClass = new ButtonGroup();
	private final ButtonGroup bgMember = new ButtonGroup();
	private JTextField textAddWeight;
	private JTextField txtFN;
	private JTextField txtLn;
	private JTextField txtId;
	private JTextField txtCtn;
	private JTextField txtEml;
	private JDateChooser dateDepart;
	private JDateChooser dateReturn;
	//private String flightType;
	//private String flightClass;
	private String flightFrom;
	private String flightTo;
	private boolean memberID;
	private int meal;
	private JSpinner spinnerAdult;
	private JSpinner spinnerChild;
	private JComboBox cbDestination;
	private JComboBox cbFrom;
	private JRadioButton rdbtnBusiness;
	private JRadioButton rdbtnEconomy; 
	private JRadioButton rdbtnRoundTrip; 
	private JRadioButton rdbtnOneWay; 
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFlight frame = new addFlight();
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
	public addFlight() {
		setLocationByPlatform(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setTitle("REDHA AIRWAYS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 612);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Flight Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(31, 70, 381, 479);
		contentPane.add(panel);
		
		JLabel lblFlightType = new JLabel("Flight Type:");
		lblFlightType.setBounds(23, 45, 108, 14);
		panel.add(lblFlightType);
		
		JLabel lblFlightClass = new JLabel("Flight class:");
		lblFlightClass.setBounds(23, 71, 108, 14);
		panel.add(lblFlightClass);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(23, 96, 108, 14);
		panel.add(lblFrom);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(23, 121, 108, 14);
		panel.add(lblDestination);
		
		JLabel lblDateDepart = new JLabel("Date depart");
		lblDateDepart.setBounds(23, 146, 108, 14);
		panel.add(lblDateDepart);
		
		JLabel lblDateReturn = new JLabel("Date return");
		lblDateReturn.setBounds(23, 171, 108, 14);
		panel.add(lblDateReturn);
		
		JLabel lblNoOfPassenger = new JLabel("No. of passenger");
		lblNoOfPassenger.setBounds(23, 196, 108, 14);
		panel.add(lblNoOfPassenger);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setBounds(78, 221, 81, 14);
		panel.add(lblAdult);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setBounds(216, 221, 81, 14);
		panel.add(lblChild);
		
		JPanel panelEconomy = new JPanel();
		panelEconomy.setVisible(false);
		panelEconomy.setBounds(10, 317, 345, 150);
		panel.add(panelEconomy);
		panelEconomy.setLayout(null);
		
		JLabel lblAdditionalWeight = new JLabel("Additional weight(kg)");
		lblAdditionalWeight.setBounds(10, 11, 127, 14);
		panelEconomy.add(lblAdditionalWeight);
		
		JLabel lblInflightMealoptional = new JLabel("Inflight meal (optional)");
		lblInflightMealoptional.setBounds(10, 38, 162, 14);
		panelEconomy.add(lblInflightMealoptional);
		
		JCheckBox chckbxNasiLemakSet = new JCheckBox("Nasi Lemak Set - RM15");
		chckbxNasiLemakSet.setBounds(30, 59, 212, 23);
		panelEconomy.add(chckbxNasiLemakSet);
		
		JCheckBox chckbxMeeGorengSet = new JCheckBox("Mee Goreng Set - RM15");
		chckbxMeeGorengSet.setBounds(30, 85, 211, 23);
		panelEconomy.add(chckbxMeeGorengSet);
		
		JCheckBox chckbxNasiGorengSet = new JCheckBox("Nasi Goreng Set - RM15");
		chckbxNasiGorengSet.setBounds(30, 111, 212, 23);
		panelEconomy.add(chckbxNasiGorengSet);
		
		if(chckbxNasiLemakSet.isSelected() || chckbxMeeGorengSet.isSelected() || chckbxNasiGorengSet.isSelected() ){
			meal = 1;
		}
		else if((chckbxNasiLemakSet.isSelected() && chckbxMeeGorengSet.isSelected())||
				(chckbxNasiLemakSet.isSelected() && chckbxNasiGorengSet.isSelected())||
				(chckbxMeeGorengSet.isSelected() && chckbxNasiGorengSet.isSelected())){
			meal = 2;
		}
		else if(chckbxNasiLemakSet.isSelected() && chckbxMeeGorengSet.isSelected() && chckbxNasiGorengSet.isSelected()){
			meal = 3;
		}
		
		textAddWeight = new JTextField();
		textAddWeight.setBounds(147, 8, 59, 20);
		panelEconomy.add(textAddWeight);
		textAddWeight.setColumns(10);
		
		JLabel lblMembership = new JLabel("Membership");
		lblMembership.setBounds(23, 255, 108, 14);
		panel.add(lblMembership);
		
		JLabel lblMembershipId = new JLabel("Membership ID");
		lblMembershipId.setBounds(23, 292, 108, 14);
		panel.add(lblMembershipId);
		
		rdbtnRoundTrip = new JRadioButton("Round trip");
		rdbtnRoundTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnRoundTrip.isSelected()){
					lblDateReturn.setVisible(true);
					dateReturn.setVisible(true);
				}
			}
		});
		rdbtnRoundTrip.setSelected(true);
		bgType.add(rdbtnRoundTrip);
		rdbtnRoundTrip.setBounds(105, 41, 102, 23);
		panel.add(rdbtnRoundTrip);
		
		rdbtnOneWay = new JRadioButton("One-way");
		rdbtnOneWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnOneWay.isSelected()){
					lblDateReturn.setVisible(false);
					dateReturn.setVisible(false);
				}
			}
		});
		bgType.add(rdbtnOneWay);
		rdbtnOneWay.setBounds(209, 41, 102, 23);
		panel.add(rdbtnOneWay);
		
		rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBusiness.isSelected()){
					panelEconomy.setVisible(false);
				}
			}
		});
		rdbtnBusiness.setSelected(true);
		bgClass.add(rdbtnBusiness);
		rdbtnBusiness.setBounds(105, 67, 102, 23);
		panel.add(rdbtnBusiness);
		
		rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEconomy.isSelected()){
					panelEconomy.setVisible(true);
				}
			}
		});
		bgClass.add(rdbtnEconomy);
		rdbtnEconomy.setBounds(209, 67, 102, 23);
		panel.add(rdbtnEconomy);
		
		cbFrom = new JComboBox();
		cbFrom.setModel(new DefaultComboBoxModel(new String[] {"Kuala Lumpur", "Alor Setar", "Penang", "Kuching", "Kota Kinabalu"}));
		cbFrom.setBounds(134, 93, 138, 20);
		panel.add(cbFrom);
		
		cbDestination = new JComboBox();
		cbDestination.setModel(new DefaultComboBoxModel(new String[] {"Kuala Lumpur", "Alor Setar", "Penang", "Kuching", "Kota Kinabalu"}));
		cbDestination.setBounds(134, 118, 138, 20);
		panel.add(cbDestination);
		
		dateDepart = new JDateChooser();
		dateDepart.setBounds(134, 146, 138, 20);
		panel.add(dateDepart);
		
		dateReturn = new JDateChooser();
		dateReturn.setBounds(134, 171, 138, 20);
		panel.add(dateReturn);

		spinnerAdult = new JSpinner();
		spinnerAdult.setModel(new SpinnerNumberModel(1, 0, 5, 1));
		spinnerAdult.setBounds(134, 213, 73, 31);
		panel.add(spinnerAdult);
		
		spinnerChild = new JSpinner();
		spinnerChild.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spinnerChild.setBounds(260, 213, 73, 31);
		panel.add(spinnerChild);
		
		rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnYes.isSelected()){
					lblMembershipId.setVisible(true);
					textMemberID.setVisible(true);
				}
			}
		});
		rdbtnYes.setSelected(true);
		bgMember.add(rdbtnYes);
		rdbtnYes.setBounds(134, 251, 73, 23);
		panel.add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNo.isSelected()){
					lblMembershipId.setVisible(false);
					textMemberID.setVisible(false);
				}
			}
		});
		bgMember.add(rdbtnNo);
		rdbtnNo.setBounds(209, 251, 70, 23);
		panel.add(rdbtnNo);
		
		textMemberID = new JTextField();
		textMemberID.setBounds(134, 286, 138, 20);
		panel.add(textMemberID);
		textMemberID.setColumns(10);
		
		JPanel panelCustomer = new JPanel();
		panelCustomer.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCustomer.setBounds(422, 70, 334, 213);
		contentPane.add(panelCustomer);
		panelCustomer.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(27, 45, 94, 14);
		panelCustomer.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(27, 70, 94, 14);
		panelCustomer.add(lblLastName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 95, 46, 14);
		panelCustomer.add(lblId);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(27, 120, 46, 14);
		panelCustomer.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 145, 46, 14);
		panelCustomer.add(lblEmail);
		
		txtFN = new JTextField();
		txtFN.setBounds(131, 42, 168, 20);
		panelCustomer.add(txtFN);
		txtFN.setColumns(10);
		
		txtLn = new JTextField();
		txtLn.setColumns(10);
		txtLn.setBounds(131, 67, 168, 20);
		panelCustomer.add(txtLn);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(131, 92, 168, 20);
		panelCustomer.add(txtId);
		
		txtCtn = new JTextField();
		txtCtn.setColumns(10);
		txtCtn.setBounds(131, 117, 168, 20);
		panelCustomer.add(txtCtn);
		
		txtEml = new JTextField();
		txtEml.setColumns(10);
		txtEml.setBounds(131, 142, 168, 20);
		panelCustomer.add(txtEml);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnProceed)
			      {
						saveData();
						JOptionPane.showMessageDialog(null,"Successfully saved!!");
						DisplayTicket dt = new DisplayTicket();
						dt.setVisible(true);
						dispose();
					}
			      else
						dispose();
				}

		});
		btnProceed.setBounds(499, 334, 188, 42);
		contentPane.add(btnProceed);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancel){
					HomeStaff hs = new HomeStaff();
						hs.setVisible(true);
						dispose();
				}

			}
		});
		btnCancel.setBounds(499, 405, 188, 42);
		contentPane.add(btnCancel);
	}
	
	public void saveData()
	{
		Flight fl = new Flight();
		if(rdbtnRoundTrip.isSelected() == true){
			String flightType = rdbtnRoundTrip.getText();
			fl.setFlightType(flightType);
		}
		else if(rdbtnOneWay.isSelected() == true){
			String flightType = rdbtnOneWay.getText();
			fl.setFlightType(flightType);
		}
		
		if(rdbtnBusiness.isSelected() == true){
			String flightClass = rdbtnBusiness.getText();
			fl.setFlightClass(flightClass);
			
		}
		else if(rdbtnEconomy.isSelected() == true){
			String flightClass = rdbtnEconomy.getText();
			fl.setFlightClass(flightClass);
		}
		String flightFrom = (String) cbFrom.getSelectedItem();
		fl.setFlightFrom(flightFrom);
		String flightTo = (String) cbDestination.getSelectedItem();
		fl.setFlightTo(flightTo);
		int adult = (int) spinnerAdult.getValue();
		fl.setAdult(adult);
		int child = (int) spinnerChild.getValue();
		fl.setChild(child);
		if(rdbtnYes.isSelected() == true){
			memberID = true;
			fl.setID(memberID);
		}
		else if(rdbtnNo.isSelected() == false){
			memberID = false;
			fl.setID(memberID);
		}
		
		if(fl.getFlightType() == "Economy"){
			double addWeight = Double.parseDouble(textAddWeight.getText());
			fl.setAddWeight(addWeight);
			fl.setMeal(meal);
		}
		else{
			double addWeight = 0.0;
			meal = 0;
			fl.setAddWeight(addWeight);
			fl.setMeal(meal);
		}
		double fare = fl.ticketCharge();
		String totalChargeFare = String.format("%.2f",fare);
		
		try{
			PrintWriter cust = new PrintWriter(new FileWriter("Customer.txt",true));
			cust.print(txtFN.getText() + "\t" + txtLn.getText() + "\t" + txtId.getText() + "\t" + txtCtn.getText() +
					"\t" + txtEml.getText()+"\n");
			cust.close();
			
			if(dateReturn.getDate() == null){
				PrintWriter flight = new PrintWriter(new FileWriter("Flight.txt",true));
				flight.println(fl.getFlightType() + "\t" + fl.getFlightClass() + "\t" + fl.getFlightFrom() + "\t" + 
							fl.getFlightTo() + "\t" + dateDepart.getDate() + "\tNo date\t" + fl.getAdult() + "\t" + fl.getChild() + "\t" +
							fl.getID() + "\t" + textMemberID.getText() + "\t"+ fl.getAddWeight() + "kg\t" + totalChargeFare);
				flight.close();
			}
			else if(memberID == false){
				PrintWriter flight = new PrintWriter(new FileWriter("Flight.txt",true));
				flight.println(fl.getFlightType() + "\t" + fl.getFlightClass() + "\t" + fl.getFlightFrom() + "\t" + 
							fl.getFlightTo() + "\t" + dateDepart.getDate() + "\t" + dateReturn.getDate() + "\t" + fl.getAdult() + "\t" + fl.getChild() + "\t" +
							fl.getID() + "\tNot member\t"+ fl.getAddWeight() + "kg\t" + totalChargeFare);
				flight.close();
			}
			else if((dateReturn.getDate() == null) && (memberID == false)){
				PrintWriter flight = new PrintWriter(new FileWriter("Flight.txt",true));
				flight.println(fl.getFlightType() + "\t" + fl.getFlightClass() + "\t" + fl.getFlightFrom() + "\t" + 
							fl.getFlightTo() + "\t" + dateDepart.getDate() + "\tNo date\t" + fl.getAdult() + "\t" + fl.getChild() + "\t" +
							fl.getID() + "\tNot a member\t"+ fl.getAddWeight() + "kg\t" + totalChargeFare);
				flight.close();
			}
			else{
				PrintWriter flight = new PrintWriter(new FileWriter("Flight.txt",true));
				flight.println(fl.getFlightType() + "\t" + fl.getFlightClass() + "\t" + fl.getFlightFrom() + "\t" + 
							fl.getFlightTo() + "\t" + dateDepart.getDate() + "\t" + dateReturn.getDate() + "\t" + fl.getAdult() + "\t" + fl.getChild() + "\t" +
							fl.getID() + "\t" + textMemberID.getText() + "\t"+ fl.getAddWeight() + "kg\t" + totalChargeFare);
				flight.close();
			}
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
	}
}
