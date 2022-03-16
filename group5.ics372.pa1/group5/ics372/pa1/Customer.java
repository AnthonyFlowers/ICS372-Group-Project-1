
package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class implements Serializable, which is a set. This class represents a
 * Customer within the Company. A Customer will hold personal data along with
 * two list of appliance and Repair Plans.
 * 
 * @author Chatchai Xiong, Anthony Flowers, Vontha Chan
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 2022_03_12L;

    private final long customerID;
    private String name;
    private String address;
    private String phoneNumber;
    private List<Appliance> customerAppliances;
    private List<RepairPlan> repairPlans;
    private double totalRepairCharges;

    /**
     * Constructor for Customer. This constructor will create a customer with the
     * given inputs.
     * 
     * @param nextCustomerId Input for the Customer's ID
     * @param name           Input for the Customer's name.
     * @param address        Input for the Customer's address
     * @param phoneNumber    Input for the Customer's phone number
     */
    public Customer(long nextCustomerId, String name, String address, String phoneNumber) {
	super();
	this.customerID = nextCustomerId;
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.customerAppliances = new ArrayList<Appliance>();
	this.repairPlans = new ArrayList<>();
	this.totalRepairCharges = 0;
    }

    /**
     * The method will increase the Customer's total repair charges with the given
     * input amount.
     * 
     * @param addCharge This input will increase the customer's totalCharge.
     */
    public void addRepairCharges(double addCharge) {
	this.totalRepairCharges += addCharge;
    }

    /**
     * The method will return the Customer's total repair charges.
     * 
     * @return total amount charges made by repairs on the customer.
     */
    public double getTotalRepairCharges() {
	return this.totalRepairCharges;
    }

    /**
     * Returns the customer's Id.
     * 
     * @return the customer's ID
     */
    public long getCustomerID() {
	return customerID;
    }

    /**
     * Returns the customer's name.
     * 
     * @return the customer's name.
     */
    public String getName() {
	return name;
    }

    /**
     * Sets the customer's name.
     * 
     * @param name The name that the customer's name will be set to
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Returns the customer's address.
     * 
     * @return the customer's address
     */
    public String getAddress() {
	return address;
    }

    /**
     * Sets the customer's address with given input.
     * 
     * @param address the value that the customer's address will be set to
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * Returns the customer's phone number.
     * 
     * @return the customer's phone number.
     */
    public String getPhoneNumber() {
	return phoneNumber;
    }

    /**
     * Sets the customer's phone number to input.
     * 
     * @param phoneNumber value the customer's phone number will be set to.
     */
    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the customer list of repair plans.
     * 
     * @return the customer's list of repair plans.
     */
    public List<RepairPlan> getRepairPlans() {
	return repairPlans;
    }

    /**
     * Adds a repair plan to the customer's repair plan list.
     * 
     * @param repairPlan object to be added to the customer's repair plans list.
     */
    public void addRepairPlan(RepairPlan repairPlan) {
	this.repairPlans.add(repairPlan);
    }

    /**
     * Charges the customer based on the input RepairPlan object. The customer's
     * totalRepairCharges will be increased by the input's cost amount.
     * 
     * @param repairPlan This object's "double cost" attribute will be added to the
     *                   customer's total repair charges.
     */
    public void chargeRepair(RepairPlan repairPlan) {
	totalRepairCharges += repairPlan.getCost();
    }

    /**
     * The given RepairPlan object will be removed from the customer's repairPlans
     * list.
     * 
     * @param repairPlan The object to be removed from the customer's repairPlans
     *                   list.
     */
    public void removeRepairPlan(RepairPlan repairPlan) {
	RepairPlan removeRepairPlan = new RepairPlan(0, null, null, 0);
	for (RepairPlan tempRepairPlan : repairPlans) {
	    if (repairPlan.equals(tempRepairPlan)) {
		removeRepairPlan = tempRepairPlan;
	    }
	}

	if (repairPlan.equals(removeRepairPlan)) {
	    repairPlans.remove(repairPlan);
	} else {
	    System.out.println("Could not find repair plan");
	}

    }

    /**
     * Adds and Appliance to the Customer's Appliance list.
     * 
     * @param appliance the appliance to be added to the customer's
     *                  customerAppliance list
     */
    public void addAppliance(Appliance appliance) {
	customerAppliances.add(appliance);
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