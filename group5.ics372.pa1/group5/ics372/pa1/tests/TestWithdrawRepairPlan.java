package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;
import group5.ics372.pa1.DishWasher;
import group5.ics372.pa1.RepairPlan;

public class TestWithdrawRepairPlan {

	public Company company = new Company();

	public static void main(String[] args) {
		TestWithdrawRepairPlan();
	}

	public static void TestWithdrawRepairPlan() {
		Customer customer = new Customer(1, "Bob", "Bob", "123");
		Appliance appliance = new DishWasher(1, "Jon", "Jon");
		RepairPlan repairPlan = new RepairPlan(1, customer, appliance, 300);
		customer.addRepairPlan(repairPlan);

		System.out.println("Customer: " + customer.getName());
		System.out.println("Repair Plan: " + customer.getRepairPlans().toString());
	}

}
