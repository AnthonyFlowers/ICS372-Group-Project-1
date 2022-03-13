package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the products the company sells
 * 
 * @author Group 5
 *
 */
public class Catalog implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	// bases off of sequence diagram 1
	// Interface Case1: "Add a single Model" will input new appliances to this list
	private static List<Appliance> applianceList;

	public Catalog() {
		// not sure what to put in here - Chatchai
		applianceList = new ArrayList<>(); // experimenting with linked
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
		if (applianceList.isEmpty()) {
			applianceList.add(appliance);
			return true;
		} else if (!doesApplianceExist(appliance)) {
			applianceList.add(appliance);
			return true;
		} else {
			System.out.println("Appliance with Brand:\"" + appliance.getBrand() + "\" and Model Type: \""
					+ appliance.getType() + "\" already exist in the Catalog List.");
			return false;
		}

	}

	public List<Appliance> getApplianceList() {
		return applianceList;
	}

	// Checks applianceList to see if the second argument is already in the List
	// if it is return true
	// else return false
	// not working keeps saying reference is null
	private boolean doesApplianceExist(Appliance appliance) {
		System.out.println("appList size:" + applianceList.size()); // troubleeshooting this
		return false;
	}
}
