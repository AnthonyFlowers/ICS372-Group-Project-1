package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;
import group5.ics372.pa1.DishWasher;
import group5.ics372.pa1.RepairPlan;

public class TestChargeAllRepairs {
	private static Company company = new Company();

	public static void main(String[] args) {
		testChargeRepair();
	}

	public static void testChargeRepair() {
		Customer customer = new Customer(1, "Bob", "Bob", "123");
		Customer customer2 = new Customer(2, "Dee", "Bob", "123");
		Appliance appliance = new DishWasher(1, "Jon", "Jon", 10.0);
		Appliance appliance2 = new DishWasher(2, "J", "Jo", 15.0);
		RepairPlan repairPlan = new RepairPlan(1, customer, appliance, 300);
		RepairPlan repairPlan2 = new RepairPlan(2, customer, appliance2, 100);
		customer.addRepairPlan(repairPlan);
		customer.chargeRepair(repairPlan2);
		customer2.addRepairPlan(repairPlan2);

		company.addCustomer(customer);
		company.addCustomer(customer2);
		company.chargeAllRepairs();
		company.printRevenue();

	}

	public static void testAll() {
		testChargeRepair();
	}

}
