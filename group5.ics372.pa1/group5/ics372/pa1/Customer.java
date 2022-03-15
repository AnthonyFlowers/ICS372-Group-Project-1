package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Customer implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	private final long customerID;
	private String name;
	private String address;
	private String phoneNumber;
	private List<Appliance> customerAppliances;
	private List<Appliance> repairPlans;

	public Customer(long nextCustomerId, String name, String address, String phoneNumber) {
		super();
		this.customerID = nextCustomerId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customerAppliances = new ArrayList<Appliance>();
		this.repairPlans = new ArrayList<>();
	}

	public long getCustomerID() {
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

	public void addAppliance(Appliance appliance) {
		customerAppliances.add(appliance);
	}

	// WIP
	// TODO implement removing charges after add the total charges
	public double chargeAllRepairs() {
		Iterator<Appliance> repairs = repairPlans.iterator();
		double totalRepairCosts = 0;
		while (repairs.hasNext()) {
			totalRepairCosts = totalRepairCosts + repairs.next().getRepairPlan();
		}
		return totalRepairCosts;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("ID: %s\t| Name: %s", this.customerID, this.name));
		stringBuilder.append("\t| Address: " + this.address);
		stringBuilder.append("\t| Phone Number: " + this.phoneNumber);
		stringBuilder.append("\t| Service Plan: " + this.getRepairPlans());
		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customerID, name, phoneNumber, repairPlans);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && customerID == other.customerID
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(repairPlans, other.repairPlans);
	}

}