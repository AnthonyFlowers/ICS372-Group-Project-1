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
	// I could probably make this code smaller or do this entirely in customer
	/**
	 * #1 First loop: Itterates through customerList #2 Second Loop: itterates
	 * throught the customer's repairPlans List. #2 Second Loop: add repairPlan cost
	 * to total returning repairCosts. No repair plans will be represented by 0.
	 * 
	 */
	public double chargeRepairAll() {
		double totalRepairCharges = 0;
		// #1
		Iterator<Customer> customer = customerList.getCustomerList().iterator();
		while (customer.hasNext()) {
			totalRepairCharges += customer.next().chargeAllRepairs();
		}
		return totalRepairCharges;
	}
}
