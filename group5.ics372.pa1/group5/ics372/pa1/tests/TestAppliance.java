package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.ClothDryers;

public class TestAppliance {

	public static void main(String[] args) {
		testAll();
	}

	public static void testAll() {
		testCreateAppliance();
		testReadApplianceData();
	}

	// Test reading an appliances data
	private static void testReadApplianceData() {
		try {
			String brandName = "Samsung";
			String modelType = "ClothDryers";
			Double monthlyPayment = 15.0;
			ClothDryers appliance = new ClothDryers(brandName, modelType, monthlyPayment);
			assert (appliance.getBrandName().equals(brandName));
			assert (appliance.getModelType().equals(modelType));
			assert (appliance.getMonthlyPayment().equals(monthlyPayment));
			System.out.println("Success: Appliance information was added and is correct.");
		} catch (AssertionError e) {
			System.out.println("Failed: Appliance information was not added correctly.");
			System.out.println(e.getStackTrace()[0]);
		}
	}

	// Test creating an appliance
	private static void testCreateAppliance() {
		try {
			Appliance appliance = createClothDryer();
			assert (appliance.getClass() == ClothDryers.class);
			System.out.println("Success: Appliance was created successfully.");
		} catch (AssertionError e) {
			System.out.println("Failed: Appliance was not created successfully.");
			System.out.println(e.getStackTrace()[0]);
		}
	}

	// Create a ClothDryer with some data
	private static ClothDryers createClothDryer() {
		String applianceType = "ClothDryers";
		String brandName = "Samsung";
		Double monthlyPayment = 15.0;
		ClothDryers appliance = new ClothDryers(applianceType, brandName, monthlyPayment);
		return appliance;
	}
}
