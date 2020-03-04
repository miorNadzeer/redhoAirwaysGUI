package RedhoAirways;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class ViewSalesReport extends JFrame {

	private JPanel contentPane;
	private double[] fare = new double[1500];
	private String[] weight = new String[1500];
	private String[] idNo = new String[1500];
	private String[] child = new String[1500];
	private String[] id = new String[1500];
	private String[] adult = new String[1500];
	private String[] returnDate = new String[1500];
	private String[] departDate = new String[1500];
	private String[] flightTo = new String[1500];
	private String[] flightFrom = new String[1500];
	private String[] flightClass = new String[1500];
	private String[] flightType = new String[1500];
	private double totalFareKL = 0.0;
	private double totalFareKDH = 0.0;
	private double totalFarePNG = 0.0;
	private double totalFareKCH = 0.0;
	private double totalFareBKI = 0.0;
	private double totalFare = 0.0;
	int length = 0;
	private JTextArea textDisplaySales;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSalesReport frame = new ViewSalesReport();
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
	public ViewSalesReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setTitle("Redha Airways");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textDisplaySales = new JTextArea();
		textDisplaySales.setBounds(10, 11, 394, 217);
		panel.add(textDisplaySales);
		textDisplaySales.setLineWrap(true);
		textDisplaySales.setEditable(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					HomeAdmin ha = new HomeAdmin();
						ha.setVisible(true);
						dispose();
				}
			    else
			    	dispose();
			}
		});
		btnBack.setBounds(183, 285, 89, 23);
		contentPane.add(btnBack);
		
		try{
			BufferedReader inFlight = new BufferedReader(new FileReader("Flight.txt"));
			
			String inData = null;
			int i = 0;
			
			while((inData = inFlight.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(inData,"\t");
				flightType[i] = st.nextToken();
				flightClass[i] = st.nextToken();
				flightFrom[i] = st.nextToken();
				flightTo[i] = st.nextToken();
				departDate[i] = st.nextToken();
				returnDate[i] = st.nextToken();
				adult[i] = st.nextToken();
				child[i] = st.nextToken();
				id[i] = st.nextToken();
				idNo[i] = st.nextToken();
				weight[i] = st.nextToken();
				fare[i] = Double.parseDouble(st.nextToken());
				i++;
			}
			length = i;
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
		for(int i=0;i<length;i++){
	         if(flightFrom[i].equals("Kuala Lumpur") )
	         {
	            totalFareKL = totalFareKL + fare[i];
	         }
	         else if(flightFrom[i].equals("Alor Setar"))
	         {
	            totalFareKDH = totalFareKDH + fare[i];
	         }
	         else if(flightFrom[i].equals("Penang"))
	         {
	            totalFarePNG = totalFarePNG + fare[i];
	         }
	         else if(flightFrom[i].equals("Kuching"))
	         {
	            totalFareKCH = totalFareKCH + fare[i];
	         }
	         else if(flightFrom[i].equals("Kota Kinabalu"))
	         {
	            totalFareBKI = totalFareBKI + fare[i];
	         }
	    }
		totalFare = totalFareKL + totalFareKDH + totalFarePNG + totalFareKCH + totalFareBKI ;
		textDisplaySales.append("FLIGHT FROM:\n"+
									"\tKuala Lumpur\tTotal sales: RM"+totalFareKL+"\n"+
									"\tAlor Setar\tTotal sales: RM"+totalFareKDH+"\n"+
									"\tPenang\tTotal sales: RM"+totalFarePNG+"\n"+
									"\tKuching\tTotal sales: RM"+totalFareKCH+"\n"+
									"\tKota Kinabalu\tTotal sales: RM"+totalFareBKI+"\n\n"+
									"TOTAL FARE: RM"+totalFare);
	
	}

		
}
