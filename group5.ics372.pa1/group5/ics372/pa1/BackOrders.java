package group5.ics372.pa1;

import group5.ics372.pa1.appliances.Appliance;

/**
 * This class represents the BackOrder object. This class will be created and
 * held in a List within Company.
 * 
 * @author Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class BackOrders {
	private long backorderID;
	private Customer customer;
	private Appliance appliance;
	private int quantity;

	/**
	 * Constructor for BackOrder
	 * 
	 * @param backorderID - input value for the BackOrder's ID
	 * @param customer    - input value for the BackOrder's customer reference
	 *                    object
	 * @param appliance   - input value for the BackOrder's appliance reference
	 *                    object
	 * @param quantity    - input value for the BackOrder's quantity
	 */
	public BackOrders(long backorderID, Customer customer, Appliance appliance, int quantity) {
		super();
		this.backorderID = backorderID;
		this.customer = customer;
		this.appliance = appliance;
		this.quantity = quantity;
	}

	/**
	 * Returns the reference customer.
	 * 
	 * @return the reference customer.
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Returns the BackOrder's Id.
	 * 
	 * @return BackOrder's ID.
	 */
	public long getBackOrderID() {
		return this.backorderID;
	}

	/**
	 * Returns BackOrder's quantity.
	 * 
	 * @return Backorder's quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Returns the customer ID from Back Order's reference customer.
	 * 
	 * @return the customer ID from Back Order's reference customer
	 */
	public long getCustomerID() {
		return this.customer.getCustomerID();
	}

	/**
	 * Return BackOrder's reference appliance.
	 * 
	 * @return BackOrder's reference appliance.
	 */
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
