package group5.ics372.pa1;

import java.util.List;

public class CustomerList {
	// Made static -Chatchai
	// I feel Company should only have one list -Chatchai
	// Changed: private List<Customer> customerList;
	private static List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

}
