
package group5.ics372.pa1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import group5.ics372.pa1.appliances.Appliance;

/**
 * This class implements Serializable, which is a set. This class represents a
 * Catalog of Appliances. The catalog holds all of the appliances in the
 * company. Along with the associated methods to manipulate them.
 * 
 * @author Chatchai Xiong, Anthoy Flowers, Vontha Chan
 *
 */
public class Catalog implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	private static List<Appliance> applianceList;

	/**
	 * Constructor for Catalog it will also create a list of Appliances.
	 */
	public Catalog() {
		applianceList = new ArrayList<>();
	}

	/**
	 * This methods adds and Appliance object to the Catalog's Appliance list.
	 * 
	 * @param appliance Appliance object to be added to the Catalog's applianceList.
	 */
	public void addAppliance(Appliance appliance) {
		applianceList.add(appliance);
	}

	/**
	 * Checks if appliance ID exists in applianceList. Searches for the Appliance
	 * with the given input Appliance ID and returns it.
	 * 
	 * @param applianceID ID value in which the Catalog will use to search for
	 *                    corresponding Appliance.
	 * @return the Appliance that matches the corresponding input ID.
	 */
	public Appliance search(long applianceID) {
		for (Appliance appliance : applianceList) {
			if (applianceID == appliance.getApplianceID()) {
				return appliance;
			}
		}
		return null;
	}

	/**
	 * Prints the Catalog's list of appliances.
	 */
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
