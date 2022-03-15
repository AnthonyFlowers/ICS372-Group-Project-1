package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

// Testing for 4 - Vontha
// In Progress
public class TestPurchaseModels {

	public static void main(String[] args) {
		Company company = new Company();
		double attribute = 10;
		company.addCustomer("Vontha", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addAppliance("ClothDryers", "Samsung", "Dryer", attribute);
		company.addAppliance("ClothWashers", "Samsung", "Washer", attribute);
		company.addAppliance("Furnaces", "Samsung", "Furnace", attribute);
		company.addToInventory(2, 2);
		company.printCustomers();
		company.printAppliances();
		company.purchaseAppliances(1, 2, 5);
		company.purchaseAppliances(2, 3, 4);
//		company.purchaseAppliances(1, 0, 0);
		company.printAppliances();
		company.printBackOrders();
	}

}
