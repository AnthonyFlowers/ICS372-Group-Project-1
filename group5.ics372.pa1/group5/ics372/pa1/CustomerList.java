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

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(int customerId, String customerName, String customerAddress, String customerPhoneNumber) {
		customerList.add(new Customer(customerId, customerName, customerAddress, customerPhoneNumber));
	}

}
