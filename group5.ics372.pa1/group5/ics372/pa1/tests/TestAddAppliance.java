package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.ClothWasher;
import group5.ics372.pa1.Company;

public class TestAddAppliance {

	public static void main(String[] args) {
		testAll();
	}

	public static void testAll() {
		testAddAppliance();
	}

	private static void testAddAppliance() {
		Company company = Company.getCompany();
		long customerID = 1;
		String applianceName = "ClothWashers";
		String brandName = "Samsung";
		String modelName = "Super Washer";
		double attribute = 0.0;
		Appliance appliance = new ClothWasher(customerID, modelName, modelName, attribute, attribute);
		company.addAppliance(appliance);
		System.out.println("Success: Company was able to add an appliance successfully.");
	}

}
