package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;
import group5.ics372.pa1.DishWasher;
import group5.ics372.pa1.RepairPlan;

public class TestWithdrawRepairPlan {

	public Company company = Company.getCompany();

	public static void main(String[] args) {
		testAll();
	}

	public static void testWithdrawRepairPlan() {
		Customer customer = new Customer(1, "Bob", "Bob", "123");
		Appliance appliance = new DishWasher(1, "Jon", "Jon", 3.65);
		RepairPlan repairPlan = new RepairPlan(1, customer, appliance, 300);
		customer.addRepairPlan(repairPlan);

		System.out.println("Customer: " + customer.getName());
		System.out.println("Repair Plan: " + customer.getRepairPlans().toString());
	}

	public static void testAll() {
		testWithdrawRepairPlan();
	}

}
