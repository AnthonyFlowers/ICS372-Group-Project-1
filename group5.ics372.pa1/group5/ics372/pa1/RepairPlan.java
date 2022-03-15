package group5.ics372.pa1;

public class RepairPlan {
	private long id;
	private Customer customer;
	private Appliance appliance;
	private double cost;

	public RepairPlan(long id, Customer customer, Appliance appliance, double cost) {
		this.id = id;
		this.customer = customer;
		this.appliance = appliance;
		this.cost = cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void addAppliance(Appliance appliance) {
		this.appliance = appliance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Appliance getAppliance() {
		return this.appliance;
	}

	public double getCost() {
		return cost;
	}

	public String toString() {
		return "RepairPlan ID " + id + "|\tCustomerName: " + customer.getName() + "|\tCustomerID:"
				+ customer.getCustomerID() + "|\tAppliance Class: " + appliance.getClass() + "|\tAppliance ID: "
				+ appliance.getApplianceID();
	}
}
