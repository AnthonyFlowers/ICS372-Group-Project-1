package group5.ics372.pa1;

import java.util.Iterator;

/**
 * This class holds each business process the company can perform
 * 
 * @author Group 5
 *
 */
public class Company {

	private final Catalog catalog;
	private final CustomerList customerList;

	public Company() {
		this.catalog = new Catalog();
		this.customerList = new CustomerList();
	}

	public void addCustomer(String customerName, String customerAddress, String customerPhoneNumber) {
		customerList.addCustomer(customerName, customerAddress,customerPhoneNumber);
	}

	//possibly change to boolean - chatchai
	public void addAppliance(String className, String brandName, String modelName) {
		Appliance newApp = createClass(className, brandName, modelName);
		catalog.insertAppliance(newApp);
	}

	// WIP - Chatchai
	// First loop iterates through all customer
	// Second loop done in customer, it iterates through all repairPlans and returns the charge
    // the method finally returns the total charge
	public double chargeRepairAll() {
		double totalRepairCharges = 0;
		Iterator<Customer> customer = customerList.getCustomerList().iterator();
		while (customer.hasNext()) {
			totalRepairCharges += customer.next().chargeAllRepairs();  //This is done in Customer.java
		}
		return totalRepairCharges;
	}
	
	//This will be used in Company.java to create the appropriate classes
	//Give this method the name of the class you want and it'd return the appropriate class
	private Appliance createClass(String className, String brandName, String modelName) {
		if(className.toUpperCase() == "ClothWashers".toUpperCase()){ 
			return new ClothWashers(brandName, modelName);
		}
		else if(className.toUpperCase() == "ClothDryers".toUpperCase()) {
			return new ClothDryers(brandName, modelName);
		}
		else if(className.toUpperCase() == "KitchenRanges".toUpperCase()) {
			return new KitchenRanges(brandName, modelName);
		}
		else if(className.toUpperCase() == "DishWashers".toUpperCase()) {
			return new DishWashers(brandName, modelName);
		}
		else if(className.toUpperCase() == "Furnaces".toUpperCase()) {
			return new Furnaces(brandName, modelName);
		}
		//else if(className.toUpperCase() == "Refrigerators".toUpperCase()) {
		//	return new Refrigerator(brandName, modelName);
		//}
		return null;
		
	}
}
