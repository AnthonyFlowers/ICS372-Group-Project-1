package group5.ics372.pa1;

import group5.ics372.pa1.appliances.Appliance;

/**
 * This class represents a RepairPlan within the Company. An Appliance and
 * Customer object will be linked with the RepairPlan Class.
 * 
 * @author Chatchai Xiong, Anthony Flowers, Vontha Chan
 */
public class RepairPlan {
	private long id;
	private Customer customer;
	private Appliance appliance;
	private double cost;

	/**
	 * Constructor for RepairPlan
	 * 
	 * @param id
	 * @param customer
	 * @param appliance
	 * @param cost
	 */
	public RepairPlan(long id, Customer customer, Appliance appliance, double cost) {
		this.id = id;
		this.customer = customer;
		this.appliance = appliance;
		this.cost = cost;
	}

	/**
	 * Sets the cost attribute for the Repair Plan.
	 * 
	 * @param cost the input value to which RepairPlan's cost will be set to
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Adds a reference appliance to this RepairPlan.
	 * 
	 * @param appliance the reference Appliance object to be added to this
	 *                  RepairPlan.
	 */
	public void addAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	/**
	 * Returns the reference Customer of this RepairPlan.
	 * 
	 * @return the reference Customer to be returned
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the reference Appliance of this RepairPlan
	 * 
	 * @return the reference Appliance
	 */
	public Appliance getAppliance() {
		return this.appliance;
	}

	/**
	 * Returns the cost of this RepairPlan
	 * 
	 * @return the cost of the repairPlan.
	 */
	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "RepairPlan ID " + id + "|\tCustomerName: " + customer.getName() + "|\tCustomerID:"
				+ customer.getCustomerID() + "|\tAppliance Class: " + appliance.getClass() + "|\tAppliance ID: "
				+ appliance.getApplianceID();
	}

	/**
	 * Initiates a charge on the reference Customer. The Customer will be charged
	 * for this RepairPlan's cost attribute.
	 */
	public void chargeRepair() {
		customer.chargeRepair(this);
	}
}
