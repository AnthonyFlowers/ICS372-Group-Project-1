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

	public Customer getCustomer() {
		return this.customer;
	}

	public long getBackOrderID() {
		return this.backorderID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public long getCustomerID() {
		return this.customer.getCustomerID();
	}

	public Appliance getAppliance() {
		return this.appliance;
	}

	@Override
	public String toString() {
		return "BackOrder ID " + backorderID + "|\tBrand: " + appliance.getBrand() + "|\tModel:" + appliance.getType()
				+ "|\tCustomer Name: " + customer.getName() + "|\tCustomer ID " + customer.getCustomerID()
				+ "|\tQuantity " + quantity;
	}

}
