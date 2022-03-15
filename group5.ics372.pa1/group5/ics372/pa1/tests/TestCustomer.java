package group5.ics372.pa1.tests;

import java.util.ArrayList;
import java.util.List;

import group5.ics372.pa1.Customer;

public class TestCustomer {
	public static void main(String[] args) {
		testAll();
	}

	public static void testAll() {
		testCreateCustomer();
		testReadCustomerData();
		testUpdateCustomerData();
	}

	// Test updating a customers data
	private static void testUpdateCustomerData() {
		try {
			String updatedCustomerName = "George Washington";
			String updatedCustomerAddress = "1600 Pennsylvania Avenue NW, Washington, DC 20500";
			String updatedCustomerPhoneNumber = "(202) 456-1111";
			Customer customer = getBasicCustomer();
			customer.setName(updatedCustomerName);
			customer.setAddress(updatedCustomerAddress);
			customer.setPhoneNumber(updatedCustomerPhoneNumber);
			assert (customer.getName().equals(updatedCustomerName));
			assert (customer.getAddress().equals(updatedCustomerAddress));
			assert (customer.getPhoneNumber().equals(updatedCustomerPhoneNumber));
			System.out.println("Success: Customer information was updated correctly.");
		} catch (AssertionError e) {
			System.out.println("Failed: Customer information was not updated currectly.");
			System.out.println(e.getStackTrace()[0]);
		}

	}

	// Test reading a customers data
	private static void testReadCustomerData() {
		try {
			String customerName = "Anthony Flowers";
			String customerAddress = "700 E 7th St, St Paul, MN 55106";
			String customerPhoneNumber = "(651) 793-1300";
			Customer customer = new Customer(1, customerName, customerAddress, customerPhoneNumber);
			assert (customer.getName().equals(customerName));
			assert (customer.getAddress().equals(customerAddress));
			assert (customer.getPhoneNumber().equals(customerPhoneNumber));
			System.out.println("Success: Customer information was added and is correct.");
		} catch (AssertionError e) {
			System.out.println("Failed: Customer information was not added correctly.");
			System.out.println(e.getStackTrace()[0]);
		}
	}

	// Test creating a customer
	private static void testCreateCustomer() {
		try {
			getBasicCustomer();
			System.out.println("Success: Customer was created successfully.");
		} catch (Exception e) {
			System.out.println("Failed: Customer was not created successfully.");
			System.out.println(e.getStackTrace()[0]);
		}
	}

	// Create a basic customer with some data
	private static Customer getBasicCustomer() {
		String customerName = "Anthony Flowers";
		String customerAddress = "700 E 7th St, St Paul, MN 55106";
		String customerPhoneNumber = "(651) 793-1300";
		Customer customer = new Customer(1, customerName, customerAddress, customerPhoneNumber);
		return customer;
	}
	
	public static List<Customer> getCustomerList(){
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(1, "Name 1", "Address 1", "Phone 1"));
		customerList.add(new Customer(2, "Name 2", "Address 2", "Phone 2"));
		customerList.add(new Customer(3, "Name 3", "Address 3", "Phone 3"));
		customerList.add(new Customer(4, "Name 4", "Address 4", "Phone 4"));
		customerList.add(new Customer(5, "Name 5", "Address 5", "Phone 5"));
		customerList.add(new Customer(6, "Name 6", "Address 6", "Phone 6"));
		return customerList;
	}
}
