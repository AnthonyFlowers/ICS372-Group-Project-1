package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerList implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	private final List<Customer> customerList;
	private final List<RepairPlan> repairPlans;

	public CustomerList() {
		customerList = new ArrayList<>();
		;
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
				System.out.println("Customer ID Found.");
				return customer;
			}
		}
		System.out.println("Customer ID Not Found.");
		return null;
	}

	public void print() {
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}
	}

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

	public Customer getCustomer(long customerId) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerId) {
				return customer;
			}
		}
		return null;
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

	public void addCustomer(Customer customer) {
		this.customerList.add(customer);
	}

	/**
	 * Finds a customer by the customerId
	 * 
	 * @param customerId - the customerId of the customer to find
	 * @return Customer - the customer with the passed customerId or null if not
	 *         found
	 */
	public Customer getCustomerById(long customerId) {
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == customerId) {
				return customer;
			}
		}
		return null;
	}

	// Added for troubleshooting
	public void addCustomerObj(Customer customer) {
		customerList.add(customer);
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
