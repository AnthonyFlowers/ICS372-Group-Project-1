package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the products the company sells
 * 
 * @author Group 5
 *
 */
public class Catalog {
	// bases off of sequence diagram 1
	// Interface Case1: "Add a single Model" will input new appliances to this list
	private static List<Appliance> applianceList;

	public Catalog() {
		applianceList = new ArrayList<>();
	}

	public void addAppliance(Appliance appliance) {
		if (!applianceAlreadyIn(appliance)) {
			System.out.println("HERERE");
			applianceList.add(appliance);
		}

	}

	public boolean applianceAlreadyIn(Appliance appliance) {
		for (Appliance e : applianceList) {
			if (e.getBrand().toUpperCase().equals(appliance.getBrand().toUpperCase())
					&& e.getType().toUpperCase().equals(appliance.getType().toUpperCase())) {
				// System.out.println("THIS APPLIANCE MODEL IS ALREADY IN THE CATALOG!");
				return true;
			}
		}
		// System.out.println("THIS APPLIANCE MODEL IS NOT IN THE CATALOG!");
		return false;
	}

	public List<Appliance> getApplianceList() {
		return applianceList;
	}

}
