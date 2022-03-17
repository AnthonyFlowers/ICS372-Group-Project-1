package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.ClothDryer;
import group5.ics372.pa1.ClothWasher;
import group5.ics372.pa1.Company;

public class TestListAppliances {
	private static Company company = Company.getCompany();

	public static void main(String[] args) {
		testAll();
	}

	private static void testPrintAppliances() {
		System.out.println("TestPrintAppliances: ");
		company.printAppliances();
	}

	private static void testPrintSpecificAppliances() {
		System.out.println("TestPrintSpecificAppliances: ");
		String className = "ClothWashers";
		company.printSpecificAppliances(className);

	}

	private static void addApplianceOne() {
		long customerID = 1;
		String applianceName = "ClothWashers";
		String brandName = "Bob's Washers";
		String modelName = "Super Washer";
		Appliance appliance = new ClothWasher(1, brandName, modelName, 300, 12.0);
		company.addAppliance(appliance);
		System.out.println("Success: an appliance was added successfully.");
	}

	private static void addApplianceTwo() {
		long customerID = 1;
		String applianceName = "ClothDryers";
		String brandName = "Kate's Dryers";
		String modelName = "miniDryer 3000";
		Appliance appliance = new ClothDryer(1, brandName, modelName, 150.0, 5.0);
		company.addAppliance(appliance);
		System.out.println("Success: an appliance was added successfully.");
	}

	public static void testAll() {
		addApplianceOne();
		addApplianceTwo();
		testPrintAppliances();
		testPrintSpecificAppliances();
	}

}
