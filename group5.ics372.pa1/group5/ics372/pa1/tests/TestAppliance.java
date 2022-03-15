package group5.ics372.pa1.tests;

import java.util.ArrayList;
import java.util.List;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.ClothDryers;
import group5.ics372.pa1.DishWashers;

/**
 * Class for testing the Appliance classes
 * 
 * @author Group 5
 *
 */
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
			ClothDryers appliance = new ClothDryers(1, brandName, modelType, monthlyPayment);
			assert (appliance.getBrand().equals(brandName));
			assert (appliance.getType().equals(modelType));
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
		ClothDryers appliance = new ClothDryers(1, applianceType, brandName, monthlyPayment);
		return appliance;
	}
	
	public static List<Appliance> getTestAppliances(){
		List<Appliance> applianceList = new ArrayList<>();
		applianceList.add(new ClothDryers(1, "Brand 1", "Model 1", 15.0));
		applianceList.add(new ClothDryers(2, "Brand 2", "Model 2", 30.0));
		applianceList.add(new DishWashers(3, "Brand 3", "Model 3"));
		return applianceList;
	}
	
	public static Appliance getRepairableAppliance() {
		Appliance appliance = new ClothDryers(1, "Brand 1", "Model 1", 15.0);
		return appliance ;
	}
}
