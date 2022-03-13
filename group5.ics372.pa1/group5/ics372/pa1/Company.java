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

	private int nextCustomerId;
	private Catalog catalog;
	private CustomerList customerList;
	private long nextApplianceId;

	/**
	 * Initialize a company with a new default Catalog and CustomerList
	 */
	public Company() {
		this.nextApplianceId = 1;
		this.nextCustomerId = 1;
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
		customerList.addCustomer(nextCustomerId++, customerName, customerAddress, customerPhoneNumber);
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
			return new ClothWashers(nextApplianceId, brandName, modelName);
		} else if (className.toUpperCase().equals("ClothDryers".toUpperCase())) {
			return new ClothDryers(nextApplianceId, brandName, modelName, 0.0);
		} else if (className.toUpperCase().equals("KitchenRanges".toUpperCase())) {
			return new KitchenRanges(nextApplianceId, brandName, modelName);
		} else if (className.toUpperCase().equals("DishWashers".toUpperCase())) {
			return new DishWashers(nextApplianceId, brandName, modelName);
		} else if (className.toUpperCase().equals("Furnaces".toUpperCase())) {
			return new Furnaces(nextApplianceId, brandName, modelName);
		} else if (className.toUpperCase().equals("Refrigerators".toUpperCase())) { // Needs work because Refrigerators
			return new Refrigerator(nextApplianceId, brandName, modelName, 0.0);
		}
		return null;
	}

	/**
	 * Load this companies data from a saved file
	 * 
	 * @param String ataFile - the path to the file to load from
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

	public List<Customer> getCustomers() {
		return customerList.getCustomerList();
	}
}
