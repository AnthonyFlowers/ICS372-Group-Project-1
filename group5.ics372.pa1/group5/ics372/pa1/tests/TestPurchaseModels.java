package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

// Testing for 4 - Vontha
public class TestPurchaseModels {

	public static void main(String[] args) {
		Company company = new Company();
		company.addCustomer("Vontha", "Apple Valley", "6122275181");
		company.addAppliance("ClothDryers", "Samsung", "Dryer");
		System.out.println(company.getCustomers());
		System.out.println(company.getAppliances());
	}

}
