package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerList implements Serializable {
	
	private static final long serialVersionUID = 2022_03_12L;
	
	// Made static -Chatchai
	// I feel Company should only have one list -Chatchai
	// Changed: private List<Customer> customerList;
	private final static List<Customer> customerList = new ArrayList<>();

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(String customerName, String customerAddress, String customerPhoneNumber) {
		customerList.add(new Customer(customerName, customerAddress, customerPhoneNumber));
	}

}
