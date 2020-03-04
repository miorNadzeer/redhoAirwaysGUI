package RedhoAirways;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class ViewSalesClass extends JFrame {

	private JPanel contentPane;
	private String[] flightType = new String[1500];
	private String[] flightClass = new String[1500];
	private String[] flightTo = new String[1500];
	private String[] flightFrom = new String[1500];
	private String[] departDate = new String[1500];
	private String[] returnDate = new String[1500];
	private String[] adult = new String[1500];
	private String[] child = new String[1500];
	private String[] id = new String[1500];
	private String[] idNo = new String[1500];
	private String[] weight = new String[1500];
	private double[] fare = new double[1500];
	private int cnt = 0;
	private double totalFareB = 0.0;
	private double totalFareE = 0.0;
	private int length;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSalesClass frame = new ViewSalesClass();
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
	public ViewSalesClass() {
		setTitle("Redha Airways");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS A555L\\Desktop\\redha logo.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button){
					HomeAdmin ha = new HomeAdmin();
						ha.setVisible(true);
						dispose();
				}
			    else
			    	dispose();
			}
		});
		button.setBounds(215, 278, 89, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(46, 34, 414, 239);
		contentPane.add(panel);
		
		JTextArea textDisplaySalesClass = new JTextArea();
		textDisplaySalesClass.setBounds(10, 11, 394, 217);
		panel.add(textDisplaySalesClass);
		
		/**
		 * Read flight.txt data and perform calculation
		 */
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
			if(flightClass[i].equals("Business")){
				totalFareB = totalFareB + fare[i];
			}
			else if(flightClass[i].equals("Economy")){
				totalFareE = totalFareE + fare[i];
			}
		}
		textDisplaySalesClass.append("FLIGHT CLASS:\n"+
				"\tBusiness\tTotal sales: RM"+totalFareB+"\n"+
				"\tEconomy\tTotal sales: RM"+totalFareE+"\n");

	}
}
