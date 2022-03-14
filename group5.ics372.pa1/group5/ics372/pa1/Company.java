package group5.ics372.pa1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * This class holds each business process the company can perform
 * 
 * @author Group 5
 *
 */
public class Company {

	private long nextCustomerId;
	private long nextApplianceId;
	private long nextBackOrderId;
	private Catalog catalog;
	private CustomerList customerList;
	private BackOrdersList backOrdersList;

	/**
	 * Initialize a company with a new default Catalog and CustomerList
	 */
	public Company() {
		this.nextApplianceId = 1;
		this.nextCustomerId = 1;
		this.nextBackOrderId = 1;
		this.catalog = new Catalog();
		this.customerList = new CustomerList();
		this.backOrdersList = new BackOrdersList();
	}

	// possibly change to boolean - chatchai
	// Process 1
	/**
	 * Add an appliance to the companies catalog
	 * 
	 * @param String className - the name of the appliance
	 * @param String brandName - the brand of the appliance
	 * @param String modelName - the model of the appliance
	 */
	public void addAppliance(String className, String brandName, String modelName) {
		if (className == null || brandName == null || modelName == null)
			System.out.println("No null inputs in adding model");
		else {
			Appliance newApp = createClass(className, brandName, modelName);
			catalog.addAppliance(newApp);
		}
	}

	// Process 2
	/**
	 * Add a new customer to the customer list
	 * 
	 * @param String customerName - the name of the customer
	 * @param String customerAddress - the address of the customer
	 * @param String customerPhoneNumber - the phone number of the customer
	 */
	public void addCustomer(String customerName, String customerAddress, String customerPhoneNumber) {
		customerList.addCustomer(nextCustomerId++, customerName, customerAddress, customerPhoneNumber);
	}

	public void addBackOrder(Customer customer, Appliance appliance, int quantity) {
		backOrdersList.addBackOrder(nextBackOrderId++, customer, appliance, quantity);
	}

	// Process 3
	public void addToInventory(long applianceID, int quantity) {
		Appliance appliance = catalog.search(applianceID);
		if (appliance == null) {
			System.out.println("Cannot add stock.");
		} else {
			appliance.addStock(quantity);
		}
	}

	// Process 4 in progress
	public void purchaseAppliances(long customerID, long applianceID, int quantity) {
		Customer customer = customerList.search(customerID);
		Appliance appliance = catalog.search(applianceID);
		if (customer != null && appliance != null) {
			if (appliance.removeStock(quantity)) {
//				customer.addRepairPlan(appliance);
				System.out.println("Purchase completed.");
			} else {
				System.out.println("Not enough stock.");
			}
		} else {
			System.out.println("Invalid customer or appliance id.");
		}
	}

	// First loop iterates through all customer
	// Second loop done in customer, it iterates through all repairPlans and returns
	// the charge
	// the method finally returns the total charge
	public double chargeRepairAll() {
		double totalRepairCharges = 0;
		Iterator<Customer> customer = customerList.getCustomerList().iterator();
		while (customer.hasNext()) {
			totalRepairCharges += customer.next().chargeAllRepairs(); // This is done in Customer.java
		}
		return totalRepairCharges;
	}

	// This will be used in Company.java to create the appropriate classes
	// Give this method the name of the class you want and it'd return the
	// appropriate class
	private Appliance createClass(String className, String brandName, String modelName) {
		if ("ClothWashers".equalsIgnoreCase(className)) {
			return new ClothWashers(nextApplianceId++, brandName, modelName);
		} else if ("ClothDryers".equalsIgnoreCase(className)) {
			return new ClothDryers(nextApplianceId++, brandName, modelName, 0.0);
		} else if ("KitchenRanges".equalsIgnoreCase(className)) {
			return new KitchenRanges(nextApplianceId++, brandName, modelName);
		} else if ("DishWashers".equalsIgnoreCase(className)) {
			return new DishWashers(nextApplianceId++, brandName, modelName);
		} else if ("Furnaces".equalsIgnoreCase(className)) {
			return new Furnaces(nextApplianceId++, brandName, modelName);
		}
		// else if(className.toUpperCase() == "Refrigerators".toUpperCase()) {
		// return new Refrigerator(brandName, modelName);
		// }
		System.out.println("Failed to create class");
		return null;
	}

	/**
	 * Load this companies data from a saved file
	 * 
	 * @param String dataFile - the path to the file to load from
	 */
	public void loadData(String dataFile) {
		try (FileInputStream fin = new FileInputStream(new File(dataFile));
				ObjectInputStream oin = new ObjectInputStream(fin)) {
			this.catalog = (Catalog) oin.readObject();
			this.customerList = (CustomerList) oin.readObject();
			this.nextCustomerId = (int) oin.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the data file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed to load the data file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem loading the data from the file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		}
	}

	/**
	 * Save this companies data to a data file
	 * 
	 * @param String dataFile - the path to the file to save to
	 */
	public void saveData(String dataFile) {
		try (FileOutputStream fos = new FileOutputStream(new File(dataFile));
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(this.catalog);
			oos.writeObject(this.customerList);
			oos.writeObject(this.nextCustomerId);
		} catch (FileNotFoundException e) {
			System.out.println("The data file was not found...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem writing the data file...");
			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		}
	}

	public void printCustomers() {
		System.out.println("Customers:");
		customerList.print();
	}

	public void printAppliances() {
		System.out.println("Appliances:");
		catalog.print();
	}

	public List<Customer> getCustomers() {

		return customerList.getCustomerList();
	}

	public List<Appliance> getAppliances() {
		return catalog.getApplianceList();
	}
}
