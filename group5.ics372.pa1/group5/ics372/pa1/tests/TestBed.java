package group5.ics372.pa1.tests;

import java.util.List;

import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;
import group5.ics372.pa1.Interface;
import group5.ics372.pa1.appliances.Appliance;
import group5.ics372.pa1.appliances.ClothDryer;
import group5.ics372.pa1.appliances.ClothWasher;
import group5.ics372.pa1.appliances.DishWasher;
import group5.ics372.pa1.appliances.Furnace;
import group5.ics372.pa1.appliances.KitchenRange;
import group5.ics372.pa1.appliances.Refrigerator;

/**
 * This is the TestBed of the application. Tests are run here to ensure the
 * application functions correctly.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class TestBed extends Interface {

	private static Company company;
	private static Customer[] testCustomers;
	private static Appliance[] testAppliances;

	public static void main(String[] args) {
		company = Company.getCompany();
		loadTestBed();
		runTests();
//		Interface.main(args);
	}

	private static void runTests() {
		testAppliancesAddedCorrectly();
		testCustomersAddedCorrectly();
		testAddInventory();
		testPurchaseModel();
		testFulfillBackOrder();
		testEnrollCustomerRepairPlan();
		testWithdrawCustomerFromRepairPlan();
		testChargeAllRepairPlans();
		testPrintRevenue();
	}

	// Process 9
	private static void testPrintRevenue() {
		// TODO Auto-generated method stub

	}

	// Process 8
	private static void testChargeAllRepairPlans() {
		// TODO Auto-generated method stub

	}

	// Process 7
	private static void testWithdrawCustomerFromRepairPlan() {
		// TODO Auto-generated method stub

	}

	// Process 6
	private static void testEnrollCustomerRepairPlan() {
		company.addToInventory(2L, 5);
		company.purchaseAppliances(4L, 2L, 1);
		company.enrollCustomerInRepairPlan(4L, 2L);
		company.chargeAllRepairs();
		Customer customer = company.getCustomerById(4L);
		assert (customer.getTotalRepairCharges() == company.getApplianceById(2L).getRepairCost());

	}

	// Process 5
	private static void testFulfillBackOrder() {
		company.addToInventory(3L, 1);
		company.purchaseAppliances(2L, 3L, 2);
		company.fulfillBackOrder(1L);
	}

	// Process 4
	private static void testPurchaseModel() {
		company.addToInventory(2L, 10);
		company.purchaseAppliances(1L, 2L, 2);
		Appliance appliance = company.getApplianceById(2L);
		Customer customer = company.getCustomerById(1L);
		assert (customer.getTotalRevenueSpent() != 0.0);
	}

	// Process 3
	private static void testAddInventory() {
		company.addToInventory(1L, 5);
		Appliance appliance = company.getApplianceById(1L);
		assert (appliance.getStock() == 5);
	}

	private static void testCustomersAddedCorrectly() {
		List<Customer> customers = company.getCustomers();
		assert (testCustomers.length == customers.size());
		for (int index = 0; index < testCustomers.length; index++) {
			assert (testCustomers[index] == customers.get(index));
		}
	}

	private static void testAppliancesAddedCorrectly() {
		List<Appliance> appliances = company.getAppliances();
		assert (testAppliances.length == appliances.size());
		for (int index = 0; index < testAppliances.length; index++) {
			assert (testAppliances[index] == appliances.get(index));
		}
	}

	private static void loadTestBed() {
		testCustomers = getTestCustomers();
		testAppliances = getTestAppliances();
		for (Customer customer : testCustomers) {
			company.addCustomer(customer);
		}
		for (Appliance appliance : testAppliances) {
			company.addAppliance(appliance);
		}
	}

	// Initialize 5 test customers
	private static Customer[] getTestCustomers() {
		Customer[] customers = new Customer[5];
		customers[0] = new Customer(1, "Anthony", "Address 1, 1st Ave.", "111-111-1111");
		customers[1] = new Customer(2, "Vontha", "Address 2, 2nd Ave.", "222-222-2222");
		customers[2] = new Customer(3, "Chatchai", "Address 3, 3rd Ave.", "333-333-3333");
		customers[3] = new Customer(4, "Peter", "Address 5, 5th Ave.", "444-444-4444");
		customers[4] = new Customer(5, "Joe", "Address 6, 6th Ave.", "555-555-5555");
		return customers;
	}

	// Initialize 20 appliances for testing
	private static Appliance[] getTestAppliances() {
		Appliance[] appliances = new Appliance[20];
		appliances[0] = new ClothDryer(1, "Samsung", "Dryer", 350.0, 5.0);
		appliances[1] = new ClothDryer(2, "Whirlpool", "Dryer", 150.0, 5.0);
		appliances[2] = new ClothWasher(3, "Samsung", "Washer", 200.0, 3.0);
		appliances[3] = new ClothWasher(4, "Whirlpool", "Washer", 240.0, 3.0);
		appliances[4] = new ClothWasher(5, "GE", "Washer", 290.0, 3.0);
		appliances[5] = new DishWasher(6, "Samsung", "Dish Washer", 400.0);
		appliances[6] = new DishWasher(7, "Samsung", "Better Dish Washer", 250.0);
		appliances[7] = new DishWasher(8, "GE", "Dish Washer", 320.0);
		appliances[8] = new DishWasher(9, "GE", "Better Dish Washer", 200.0);
		appliances[9] = new Furnace(10, "Samsung", "Furnace", 500.0, 60_000);
		appliances[10] = new Furnace(11, "Samsung", "Better Furnace", 1000.0, 80_000);
		appliances[11] = new Furnace(12, "Samsung", "Even Better Furnace", 3500.0, 100_000);
		appliances[12] = new Furnace(13, "GE", "Furnace", 500.0, 50_000);
		appliances[13] = new Furnace(14, "GE", "Better Furnace", 500.0, 80_000);
		appliances[14] = new KitchenRange(15, "Samsung", "Kitchen Range", 400.0);
		appliances[15] = new KitchenRange(16, "Samsung", "Better Range", 700.0);
		appliances[16] = new KitchenRange(17, "Wirlpool", "Kitchen Range", 350.0);
		appliances[17] = new Refrigerator(18, "Whirlpool", "Refrigerator", 250.0, 15.0);
		appliances[18] = new Refrigerator(19, "GE", "Refrigerator", 400.0, 18.0);
		appliances[19] = new Refrigerator(20, "Colder Refrigerator", "GE", 800.0, 25.0);
		return appliances;
	}
}