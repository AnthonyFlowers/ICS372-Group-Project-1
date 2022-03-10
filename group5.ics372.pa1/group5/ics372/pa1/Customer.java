package group5.ics372.pa1;

import java.util.List;

public class Customer {
	private int customerID;
	private String name;
	private String address;
	private String phoneNumber;
	private List<Appliance> repairPlans;

	public Customer(int customerID, String name, String address, String phoneNumber) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Appliance> getRepairPlans() {
		return repairPlans;
	}

	public void addRepairPlan(Appliance appliance) {
		this.repairPlans.add(appliance);

	}
}
