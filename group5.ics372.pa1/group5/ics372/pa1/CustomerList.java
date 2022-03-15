package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerList implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	private final List<Customer> customerList = new ArrayList<>();

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

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(long nextCustomerId, String customerName, String customerAddress,
			String customerPhoneNumber) {
		customerList.add(new Customer(nextCustomerId, customerName, customerAddress, customerPhoneNumber));
	}

	// Added for troubleshooting
	public void addCustomerObj(Customer customer) {
		customerList.add(customer);
	}
}
