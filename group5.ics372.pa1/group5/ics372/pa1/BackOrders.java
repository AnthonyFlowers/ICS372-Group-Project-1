package group5.ics372.pa1;

public class BackOrders {
	long backorderID;
	Customer customer;
	Appliance appliance;
	int quantity;
	
	public BackOrders(long backorderID, Customer customer, Appliance appliance, int quantity) {
		super();
		this.backorderID = backorderID;
		this.customer = customer;
		this.appliance = appliance;
		this.quantity = quantity;
	}
	
}
