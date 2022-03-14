package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerList implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	// Made static -Chatchai
	// I feel Company should only have one list -Chatchai
	// Removed static because it would not save correctly
	// The way this class is we should probably just have the company hold the List
	// of customers - Anthony
	// Changed: private List<Customer> customerList;
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

}
