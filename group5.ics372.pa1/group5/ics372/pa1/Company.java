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

	public void addCustomer() {

	}

	public void addAppliance(String brandName, String modelName) {
		
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
}
