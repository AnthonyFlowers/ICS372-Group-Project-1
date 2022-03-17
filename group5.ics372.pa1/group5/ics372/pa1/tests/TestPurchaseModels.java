package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

// Testing for 4 - Vontha
// In Progress
public class TestPurchaseModels {

	public static void main(String[] args) {
		testAll();
	}

	public static void testPurchaseAppliance() {
		Company company = Company.getCompany();
		company.addCustomer("Vontha", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addClothDryer("Samsung", "Dryer", 50.0, 50.0);
		company.addClothWasher("Samsung", "Washer", 60.0, 90);
		company.addFurnace("Samsung", "Furnace", 70.0, 1000);
		company.addToInventory(2, 2);
		company.addToInventory(3, 2);
		company.purchaseAppliances(1, 2, 5);
		company.purchaseAppliances(2, 3, 4);
		company.purchaseAppliances(4, 0, 0);
//		company.printBackOrders();
	}

	public static void testAll() {
		testPurchaseAppliance();
	}

}
