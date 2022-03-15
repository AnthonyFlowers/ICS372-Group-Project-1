package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;

public class TestEnrollRepairPlan {

	public static void main(String[] args) {
		testAll();
	}

	public static void testAll() {
		testEnrollCustomerInRepairPlan();
	}

	private static void testEnrollCustomerInRepairPlan() {
		// Creates customer with id of 1
		Customer customer = TestCustomer.getBasicCustomer();
		Company company = new Company();
		company.addCustomer(customer.getName(), customer.getAddress(), customer.getPhoneNumber());
		Appliance appliance = TestAppliance.getRepairableAppliance();
		company.addAppliance(appliance);
		company.enrollCustomerInRepailPlan(1, 1);
		assert (company.getCustomers().get(0).getRepairPlans().size() == 1);
		company.enrollCustomerInRepailPlan(1, 1);
		assert (company.getCustomers().get(0).getRepairPlans().size() == 2);
		System.out.println("Success: EnrollRepairPlan was able to add a repair plan to a customer using the Company");
	}
}
