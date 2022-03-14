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
		applianceList = new ArrayList<>();
	}

	public void addAppliance(Appliance appliance) {
		applianceList.add(appliance);
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

	/**
	 * Checks if appliance ID exists in applianceList
	 * 
	 * @param applianceID
	 * @return
	 */
	public Appliance search(long applianceID) {
		for (Appliance appliance : applianceList) {
			if (applianceID == appliance.getApplianceID()) {
				System.out.println("Appliance ID Found.");
				return appliance;
			}
		}
		System.out.println("Appliance ID Not Found");
		return null;
	}

	public void print() {
		for (Appliance appliance : applianceList) {
			System.out.println(appliance.toString());
		}
	}

	/**
	 * Get the appliance list stored in the companies catalog
	 * 
	 * @return List<Applaince> applianceList - the list of appliances in this
	 *         companies catalog
	 */
	public List<Appliance> getApplianceList() {
		return applianceList;
	}

	/**
	 * Set this catalogs applianceList
	 * 
	 * @param List<Applaince> applianceList - the value to set this catalogs
	 *                        applianceList to
	 */
	public void setApplianceList(List<Appliance> applianceList) {
		Catalog.applianceList = applianceList;
	}

	@Override
	public String toString() {
		return "\n";
	}

}
