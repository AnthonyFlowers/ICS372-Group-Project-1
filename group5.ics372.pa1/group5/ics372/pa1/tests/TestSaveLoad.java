package group5.ics372.pa1.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		Company company = Company.getCompany();
		company.addCustomer("Anthony", "Somewhere", "Number");
		company.addCustomer("John", "Somewhere else", "Another number");
		List<Customer> customerList = company.getCustomers();
		testCustomers = new ArrayList<>(Arrays.asList(new Customer[customerList.size()]));
		Collections.copy(testCustomers, customerList);
		try {
			company.saveData("test.dat");
			System.out.println("Success: Company saved some test data to the test.dat file!");
		} catch (FileNotFoundException e) {
			System.out.println("The data file was not found...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem writing the data file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (AssertionError e) {
			System.out.println("Failed: Company was not able to save data to the test.dat file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		}
	}

	// Load some data from the test.dat file -Anthony
	private static void testLoadData() {
		Company company = Company.getCompany();
		company.loadData("test.dat");
		List<Customer> customerList = company.getCustomers();
		try {
			assert (testCustomers.size() == customerList.size());
			for (int index = 0; index < testCustomers.size(); index++) {
				assert (testCustomers.get(index).equals(customerList.get(index)));
			}
			System.out.println("Success: Company loaded test.dat file and the data is correct!");
		} catch (AssertionError e) {
			System.out.println("Failed: Company did not load the test.dat file correctly...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		}

	}
}
