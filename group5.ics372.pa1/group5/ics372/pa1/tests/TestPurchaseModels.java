package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

// Testing for 4 - Vontha
// In Progress
public class TestPurchaseModels {

	public static void main(String[] args) {
		Company company = new Company();
		company.addCustomer("Vontha", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addCustomer("Vontha2", "Apple Valley", "6122275181");
		company.addAppliance("ClothDryers", "Samsung", "Dryer");
		company.addAppliance("ClothWashers", "Samsung", "Washer");
		company.addToInventory(1, 2);
		company.printCustomers();
		company.printAppliances();
		company.purchaseAppliances(1, 2, 0);
		company.purchaseAppliances(1, 0, 0);
	}

}
