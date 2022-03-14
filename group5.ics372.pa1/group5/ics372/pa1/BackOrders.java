package group5.ics372.pa1;

public class BackOrders {
	private long backorderID;
	private Customer customer;
	private Appliance appliance;
	private int quantity;

	public BackOrders(long backorderID, Customer customer, Appliance appliance, int quantity) {
		super();
		this.backorderID = backorderID;
		this.customer = customer;
		this.appliance = appliance;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BackOrder ID " + backorderID + "|\tCustomer ID " + customer.getCustomerID() + "|\tAppliance ID "
				+ appliance.getApplianceID() + "|\tQuantity " + quantity;
	}

}
