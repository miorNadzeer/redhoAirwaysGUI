package RedhoAirways;

import java.sql.Date;

public class Flight {
	
	private String flightType;
	private String flightClass;
	private String flightFrom;
	private String flightTo;
	private Date departDate;
	private String departTime;
	private Date returnDate;
	private String returnTime;
	private int adult;
	private int child;
	private double addWeight;
	private int meal;
	private String nationality;
	private String id;
	private String officer;
	private boolean ID;
	
	
	public String getFlightType() {
		return flightType;
	}
	
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	
	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getFlightFrom() {
		return flightFrom;
	}
	
	public void setFlightFrom(String flightFrom) {
		this.flightFrom = flightFrom;
	}
	
	public String getFlightTo() {
		return flightTo;
	}
	
	public void setFlightTo(String flightTo) {
		this.flightTo = flightTo;
	}
	
	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	
	public int getAdult() {
		return adult;
	}
	
	public void setAdult(int adult) {
		this.adult = adult;
	}
	
	public int getChild() {
		return child;
	}
	
	public void setChild(int child) {
		this.child = child;
	}
	
	public double getAddWeight() {
		return addWeight;
	}

	public void setAddWeight(double addWeight) {
		this.addWeight = addWeight;
	}

	public int getMeal() {
		return meal;
	}

	public void setMeal(int meal) {
		this.meal = meal;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer = officer;
	}
	
	public boolean getID() {
		return ID;
	}

	public void setID(boolean ID) {
		this.ID = ID;
	}
	
	public double ticketCharge(){
		double ticketAdult = 0.0;
		double ticketChild = 0.0;
		double totalCharge = 0.0;
		
		if(((flightFrom.equals("Kuala Lumpur"))&&(flightTo.equals("Alor Setar")))||
				((flightFrom.equals("Alor Setar"))&&(flightTo.equals("Kuala Lumpur")))){
				ticketAdult = 50.0;
			}
			else if(((flightFrom.equals("Kuala Lumpur"))&&(flightTo.equals("Penang")))||
					((flightFrom.equals("Penang"))&&(flightTo.equals("Kuala Lumpur")))){
				ticketAdult = 45.0;
			}
			else if(((flightFrom.equals("Kuala Lumpur"))&&(flightTo.equals("Kuching")))||
					((flightFrom.equals("Kuching"))&&(flightTo.equals("Kuala Lumpur")))){
				ticketAdult = 75.0;
			}
			else if(((flightFrom.equals("Kuala Lumpur"))&&(flightTo.equals("Kota Kinabalu")))||
					((flightFrom.equals("Kota Kinabalu"))&&(flightTo.equals("Kuala Lumpur")))){
				ticketAdult = 80.0;
			}
			else if(((flightFrom.equals("Alor Setar"))&&(flightTo.equals("Penang")))||
					((flightFrom.equals("Penang"))&&(flightTo.equals("Alor Setar")))){
				ticketAdult = 35.0;
			}
			else if(((flightFrom.equals("Alor Setar"))&&(flightTo.equals("Kuching")))||
					((flightFrom.equals("Kuching"))&&(flightTo.equals("Alor Setar")))){
				ticketAdult = 100.0;
			}
			else if(((flightFrom.equals("Alor Setar"))&&(flightTo.equals("Kota Kinabalu")))||
					((flightFrom.equals("Kota Kinabalu"))&&(flightTo.equals("Alor Setar")))){
				ticketAdult = 120.0;
			}
			else if(((flightFrom.equals("Penang"))&&(flightTo.equals("Kuching")))||
					((flightFrom.equals("Kuching"))&&(flightTo.equals("Penang")))){
				ticketAdult = 95.0;
			}
			else if(((flightFrom.equals("Penang"))&&(flightTo.equals("Kota Kinabalu")))||
					((flightFrom.equals("Kota Kinabalu"))&&(flightTo.equals("Penang")))){
				ticketAdult = 100.0;
			}
			else if(((flightFrom.equals("Kuching"))&&(flightTo.equals("Kota Kinabalu")))||
					((flightFrom.equals("Kota Kinabalu"))&&(flightTo.equals("Kuching")))){
				ticketAdult = 50.0;
			}
		ticketChild = 0.7 * ticketAdult;
		
		if(flightType == "Round Trip"){
			ticketAdult = ticketAdult * 2;
			ticketChild = ticketChild * 2;
		}	
		
		if(flightClass == "Economy"){
			double chargeMeal = 0.0;
			double chargeWeight = 0.0;
			double airportTax = 15.0;
			if(meal == 1){
				chargeMeal = 15.0;
			}
			else if(meal == 2){
			chargeMeal = 30.0;
			}
			else if(meal == 3){
			chargeMeal = 45.0;
			}
		
			if((addWeight > 5)&&(addWeight < 10.0)){
				chargeWeight = 10.0;
			}
			else if((addWeight >= 10.0)&&(addWeight <=30.0)){
				chargeWeight = 30.0;
			}
			else if(addWeight > 30.0){
				chargeWeight = 50.0;
			}
			totalCharge = (ticketAdult * adult)+(ticketChild * child) + chargeWeight + chargeMeal + airportTax ;
		}
		else if(flightClass == "Business" ){
			totalCharge = ((ticketAdult * adult)+(ticketChild * child)) * 2;
		}
		
		if(nationality == "Malaysia"){
			totalCharge = 0.9 * totalCharge;
		}
		return totalCharge;
	}

		
}
