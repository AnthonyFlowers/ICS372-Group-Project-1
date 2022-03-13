package group5.ics372.pa1;

import java.util.Iterator;
import java.util.List;

/**
 * This class holds each business process the company can perform
 * 
 * @author Group 5
 *
 */
public class Company {

	private final Catalog catalog;
	private final CustomerList customerList;

	/**
	 * Initialize a company with a new default Catalog and CustomerList
	 */
	public Company() {
		this.catalog = new Catalog();
		this.customerList = new CustomerList();
	}

	/**
	 * Add a new customer to the customer list
	 * 
	 * @param String customerName - the name of the customer
	 * @param String customerAddress - the address of the customer
	 * @param String customerPhoneNumber - the phone number of the customer
	 */
	public void addCustomer(String customerName, String customerAddress, String customerPhoneNumber) {
		customerList.addCustomer(customerName, customerAddress, customerPhoneNumber);
	}

	// Used in: Case 1.
	// Add an appliance to the companies catalog
	//
	// 2) else inputs are not null. The inputs will be used to create the
	// appropriate class, brandname and modeltype object.
	// 3) The return object will be added to the company's catalog applianceList
	public void addAppliance(String className, String brandName, String modelName) {
		if (className == null || brandName == null || modelName == null)
			System.out.println("No null inputs in adding model");
		else {
			Appliance newAppliance = createClass(className, brandName, modelName);
			List<Appliance> catalogApplianceList = catalog.getApplianceList();
			if (!catalog.applianceAlreadyIn(newAppliance)) {
				catalogApplianceList.add(newAppliance);
			} else {
				System.out.println("Class: " + newAppliance.getType() + "Brand: " + newAppliance.getBrand() + "Type: "
						+ newAppliance.getType());
				System.out.println("APPLIANCE ALREADY IN CATALOG! NOT ADDING TO CATALOG");
			}
		}
	}

	/**
	 * WIP - chatchai xiong
	 * 
	 * @return
	 */
	public double chargeRepairAll() {
		double totalRepairCharges = 0;
		Iterator<Customer> customer = customerList.getCustomerList().iterator();
		while (customer.hasNext()) {
			totalRepairCharges += customer.next().chargeAllRepairs(); // This is done in Customer.java
		}
		return totalRepairCharges;
	}

	// Used in: Case 1.
	// Creates an Appliance Object with the appropriate actual Class type.
	// 1)Compares the input String className with the Appliance sub Class Names
	// 2)If match create and return an object with the appropriate Class Type with
	// brandNames and ModelType
	private Appliance createClass(String className, String brandName, String modelName) {
		if (className.toUpperCase().equals("ClothWashers".toUpperCase())) {
			return new ClothWashers(brandName, modelName);
		} else if (className.toUpperCase().equals("ClothDryers".toUpperCase())) {
			return new ClothDryers(brandName, modelName, 0.0);
		} else if (className.toUpperCase().equals("KitchenRanges".toUpperCase())) {
			return new KitchenRanges(brandName, modelName);
		} else if (className.toUpperCase().equals("DishWashers".toUpperCase())) {
			return new DishWashers(brandName, modelName);
		} else if (className.toUpperCase().equals("Furnaces".toUpperCase())) {
			return new Furnaces(brandName, modelName);
		} else if (className.toUpperCase().equals("Refrigerators".toUpperCase())) { // Needs work because Refrigerators
			return new Refrigerator(brandName, modelName, 0.0);
		}
		return null;
	}
}
