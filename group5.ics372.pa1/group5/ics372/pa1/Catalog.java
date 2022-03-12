package group5.ics372.pa1;

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
	//bases off of sequence diagram 1
	//Interface Case1: "Add a single Model" will input new appliances to this list
	private final List<Appliance> appliancesList = new LinkedList();
	
	public Catalog() {
		//not sure what to put in here - Chatchai
	}
	
	//TODO
	public boolean insertAppliance(Appliance appliance) {
		
		if(!doesApplianceExist(appliancesList, appliance)) {
			appliancesList.add(appliance);
			return true;
		}
		else
		{
			System.out.println("Appliance with Brand:\"" + appliance.getBrand() + "\" and Model Type: \"" + appliance.getType() + "\" already exist in the Catalog List.");
			return false;
		}
		
		
	}

	//Checks applianceList to see if the second argument is already in the List
	//if it is return true
	//else return false
	private boolean doesApplianceExist(List<Appliance> appliancesList2, Appliance appliance) {
		Iterator<Appliance> i = appliancesList2.iterator();
		for(Appliance e : appliancesList) {
			if (e.getBrand().toUpperCase() == appliance.getBrand().toUpperCase() && e.getType().toUpperCase() == appliance.getType().toUpperCase()) {
				return true;
			}
		}
		
		return false;
	}
}
