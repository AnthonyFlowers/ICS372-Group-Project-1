package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds each business process the company can perform
 * 
 * @author Group 5
 *
 */
public class Company {

	private final List<Appliance> applianceList;
	private final CustomerList customerList;

	public Company() {
		this.applianceList = new ArrayList<>();
		this.customerList = new CustomerList();
	}

	public boolean addCustomer() {
		return false;
	}

	
	public void addAppliance(String brandName, String modelName) {
//		applianceList.add()
	}
}
