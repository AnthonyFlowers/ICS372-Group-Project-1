package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
	private final List<Appliance> applianceList;

	public Catalog() {
		// not sure what to put in here - Chatchai
		applianceList = new ArrayList<>();
	}

	// TODO
	/**
	 * Add an appliance to this catalog
	 * 
	 * @param Appliance appliance - the appliance to add
	 * @return boolean - true if the appliance was added successfully false
	 *         otherwise
	 */
	public boolean addAppliance(Appliance appliance) {
		if (!doesApplianceExist(appliance)) {
			applianceList.add(appliance);
			return true;
		} else {
			System.out.println("Appliance with Brand:\"" + appliance.getBrand() + "\" and Model Type: \""
					+ appliance.getType() + "\" already exist in the Catalog List.");
			return false;
		}

	}

	// Checks applianceList to see if the second argument is already in the List
	// if it is return true
	// else return false
	private boolean doesApplianceExist(Appliance appliance) {
		for (Appliance e : applianceList) {
			if (e.getBrand().toUpperCase() == appliance.getBrand().toUpperCase()
					&& e.getType().toUpperCase() == appliance.getType().toUpperCase()) {
				return true;
			}
		}
		return false;
	}
}
