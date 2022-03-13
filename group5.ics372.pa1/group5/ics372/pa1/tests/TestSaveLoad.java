package group5.ics372.pa1.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;

/**
 * Class for testing the saving and loading of data for the company
 * 
 * @author Group 5
 * 
 */
public class TestSaveLoad {

	private static List<Customer> testCustomers;

	public static void main(String[] args) {
		testAll();

	}

	public static void testAll() {
		testSaveData();
		testLoadData();
	}

	// Save some test data to a test.dat file -Anthony
	private static void testSaveData() {
		Company company = new Company();
		company.addCustomer("Anthony", "Somewhere", "Number");
		company.addCustomer("John", "Somewhere else", "Another number");
		List<Customer> companyList = company.getCustomers();
		testCustomers = new ArrayList<>(Arrays.asList(new Customer[companyList.size()]));
		Collections.copy(testCustomers, companyList);
		company.saveData("test.dat");
	}

	// Load some data from the test.dat file -Anthony
	private static void testLoadData() {
		Company company = new Company();
		company.loadData("test.dat");
		List<Customer> companyList = company.getCustomers();
		try {
			assert (testCustomers.size() == companyList.size());
			for (int index = 0; index < testCustomers.size(); index++) {
				System.out.println(testCustomers.get(index));
				System.out.println(companyList.get(index));
				assert (testCustomers.get(index).equals(companyList.get(index)));
			}
		} catch (AssertionError e) {
			System.out.println("Failed: did not load the test.dat file correctly");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		}

	}
}
