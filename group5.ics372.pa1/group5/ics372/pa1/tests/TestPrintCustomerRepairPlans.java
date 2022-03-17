package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.ClothDryer;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;

public class TestPrintCustomerRepairPlans {

	public static void main(String[] args) {
		testAll();
	}

	private static void testAll() {
		testPrintCustomerRepairPlans();
	}

	private static void testPrintCustomerRepairPlans() {
		Company company = Company.getCompany();
		Customer customer = new Customer(1, "Anthony", "Address", "Phone");
		Appliance appliance = new ClothDryer(1, "Dryer Brand", "Dryer Model", 300.0, 15.0);
		company.addCustomer(customer);
		company.addAppliance(appliance);
		company.enrollCustomerInRepairPlan(1, 1);
		company.enrollCustomerInRepairPlan(1, 1);
		company.enrollCustomerInRepairPlan(1, 1);
		company.printCustomerRepairPlans();
	}
}
