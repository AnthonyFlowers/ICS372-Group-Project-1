package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

public class TestListAppliances {
	private static Company company = new Company();

	public static void main(String[] args) {

		addApplianceOne();
		addApplianceTwo();
		TestPrintAppliances();
		TestPrintSpecificAppliances();

	}

	private static void TestPrintAppliances() {
		System.out.println("TestPrintAppliances: ");
		company.printAppliances();
	}

	private static void TestPrintSpecificAppliances() {
		System.out.println("TestPrintSpecificAppliances: ");
		String className = "ClothWashers";
		company.printSpecificAppliances(className);

	}

	private static void addApplianceOne() {
		long customerID = 1;
		String applianceName = "ClothWashers";
		String brandName = "Bob's Washers";
		String modelName = "Super Washer";
		double attribute = 100.0;
		company.addAppliance(applianceName, brandName, modelName, attribute);
		System.out.println("Success: an appliance was added successfully.");
	}

	private static void addApplianceTwo() {
		long customerID = 1;
		String applianceName = "ClothDryers";
		String brandName = "Kate's Dryers";
		String modelName = "miniDryer 3000";
		double attribute = 0.0;
		company.addAppliance(applianceName, brandName, modelName, attribute);
		System.out.println("Success: an appliance was added successfully.");
	}

}
