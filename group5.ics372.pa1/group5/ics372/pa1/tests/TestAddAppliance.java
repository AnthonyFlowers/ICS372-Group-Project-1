package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

public class TestAddAppliance {

	public static void main(String[] args) {
		testAll();
	}
	
	public static void testAll() {
		testAddAppliance();
	}

	private static void testAddAppliance() {
		Company company = new Company();
		String applianceName = "ClothWashers";
		String brandName = "Samsung";
		String modelName = "Super Washer";
		String attribute = "0.0";
		company.addAppliance(applianceName, brandName, modelName, attribute);
		System.out.println("Success: an appliance was added successfully.");
	}

}
