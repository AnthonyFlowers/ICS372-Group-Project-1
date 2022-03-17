package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Serializable. The class represents of list of customer.
 * The class will be created and held within Company. The class helps Company
 * manipulated Customers with serveral methods.
 * 
 * @author Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class CustomerList implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	private final List<Customer> customerList;
	private final List<RepairPlan> repairPlans;

	/**
	 * Constructor for CustomerList Two List: customerList and RepairPlans are
	 * created and holds the corresponding classes for the Company.
	 */
	public CustomerList() {
		customerList = new ArrayList<>();
		repairPlans = new ArrayList<>();
	}

	/**
	 * Checks if customers ID exists in customerList
	 * 
	 * @param customerID
	 * @return
	 */
	public Customer search(long customerID) {
		for (Customer customer : customerList) {
			if (customerID == customer.getCustomerID()) {
				return customer;
			}
		}
		return null;
	}

	/**
	 * Prints the customers held by CustomerList.
	 */
	public void print() {
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}
	}

	/**
	 * Charges all the customer held by CustomerList for their repair plans.
	 * 
	 * @return the amount of total charges as "double total".
	 */
	public double chargeAllRepairs() {
		double total = 0;
		for (Customer customer : customerList) {
			for (RepairPlan repairPlan : customer.getRepairPlans()) {
				customer.chargeRepair(repairPlan);
			}
			total += customer.getTotalRepairCharges();
			System.out.println("Customer :" + customer.getName() + " ID: " + customer.getCustomerID()
					+ " TotalRepairCharges : " + customer.getTotalRepairCharges());
		}
		return total;
	}

	/**
	 * Get the customer list
	 * 
	 * @return List<Customer> - the list of customers
	 */
	public List<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * Add a customer to this customer list
	 * 
	 * @param nextCustomerId      - the nextCustomerId to hand out
	 * @param customerName        - the new customers name
	 * @param customerAddress     - the new customers address
	 * @param customerPhoneNumber - the new customers phone number
	 */
	public void addCustomer(long nextCustomerId, String customerName, String customerAddress,
			String customerPhoneNumber) {
		customerList.add(new Customer(nextCustomerId, customerName, customerAddress, customerPhoneNumber));
	}

	/**
	 * Adds a Customer Object to the customerList.
	 * 
	 * @param customer Object to be added to the customerList
	 */
	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}

	/**
	 * Adds the repair plan to the Customer and the companies repair plan list.
	 * 
	 * @param customer   - the Customer to add the RepairPlan to
	 * @param repairPlan - the RepairPlan to add to the customer and the companies
	 *                   list
	 */
	public void addCustomerRepairPlan(Customer customer, RepairPlan repairPlan) {
		customer.addRepairPlan(repairPlan);
		repairPlans.add(repairPlan);
	}

	/**
	 * Removes the repair plan from its Customer and the companies repair plan list.
	 * 
	 * @param toBeRemovedPlan - the RepairPlan to be removed
	 */
	public void withdrawCustomerRepairPlan(RepairPlan toBeRemovedPlan) {
		Customer customer = toBeRemovedPlan.getCustomer();
		customer.removeRepairPlan(toBeRemovedPlan);
		repairPlans.remove(toBeRemovedPlan);
	}

}
