package group5.ics372.pa1.tests;

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
			Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);
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
		Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);
		return customer;
	}
}
