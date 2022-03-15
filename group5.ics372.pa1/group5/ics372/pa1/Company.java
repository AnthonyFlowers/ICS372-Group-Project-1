package group5.ics372.pa1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	/**
	 * Add an appliance to this companies catalog
	 * 
	 * @param appliance - the Appliance to add
	 */
	public void addAppliance(Appliance appliance) {
		catalog.addAppliance(appliance);
	}

	// Process 1
	// meant to handle create of a Refrigerator Appliance
	public void addApplianceRefrigerator(String brandName, String modelName, double BTU) {
		Appliance newApp = createClassRefrigerator(brandName, modelName, BTU);
		catalog.addAppliance(newApp);
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

//	public void addBackOrder(Customer customer, Appliance appliance, int quantity) {
//		backOrdersList.addBackOrder(nextBackOrderId++, customer, appliance, quantity);
//	}

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
		if (customer != null && appliance != null && appliance.canBackOrder()) {
			if (appliance.removeStock(quantity)) {
				customer.addAppliance(appliance);
				System.out.println("Purchase completed.");
			} else {
				System.out.println(appliance.getStock() + " appliances delivered.");
				System.out.println(quantity - appliance.getStock() + " appliances have been backordered.");
				System.out.println("BackOrder created.\nID = " + nextBackOrderId);
				backOrdersList.addBackOrder(nextBackOrderId++, customer, appliance, quantity - appliance.getStock());
				customer.addAppliance(appliance);
				appliance.removeStock(appliance.getStock());
			}
		} else if (appliance.canBackOrder() == false) {
			System.out.println("This appliance cannot be backordered.");
		} else {
			System.out.println("Invalid customer or appliance id.");
		}
	}

	// Process 1
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
		System.out.println("Failed to create class");
		return null;
	}

	// Process 1
	// create'sClass for special Appliances
	private Appliance createClassRefrigerator(String brandName, String modelName, double BTU) {
		return new Refrigerator(nextApplianceId++, brandName, modelName, BTU);
	}

	// Process 5
	// Done - Chatchai
	public void fulfillBackOrder(long backOrderID) {
		backOrdersList.fulfillBackOrder(backOrderID);
	}

	/**
	 * Enroll a customer in a repair plan for a single appliance. The user id and
	 * the eligible appliance id are input.
	 * 
	 * @param customerId  - the id of the customer to add the repair plan to
	 * @param applianceId - the id of the appliance with a repair plan
	 * 
	 * @throws IllegalArgumentException if an appliance with the passed applianceId
	 *                                  is not found
	 * @throws IllegalArgumentException if a customer with the passed customerId is
	 *                                  not found
	 * @throws IllegalArgumentException if the found appliance does not have a
	 *                                  repair plan
	 */
	public void enrollCustomerInRepailPlan(long customerId, long applianceId) throws IllegalArgumentException {
		Appliance appliance = getApplianceById(applianceId);
		Customer customer = customerList.getCustomerById(customerId);
		if (appliance == null) {
			throw new IllegalArgumentException(String.format("Appliance with the id %s does not exist.", applianceId));
		} else if (customer == null) {
			throw new IllegalArgumentException(String.format("Customer with the id %s does not exist.", customerId));
		} else if (!appliance.hasRepairPlan()) {
			throw new IllegalArgumentException(
					String.format("Appliance with the id %s does not have a repair plan.", applianceId));
		}
		customer.addRepairPlan(appliance);
	}

	// Get appliance from the catalog by id
	private Appliance getApplianceById(long applianceId) {
		for (Appliance appliance : catalog.getApplianceList()) {
			if (appliance.getApplianceID() == applianceId) {
				return appliance;
			}
		}
		return null;
	}

	// Process 7
	public void withdrawRepairPlan(long customerId, long applianceId) {
		// get customer from customerList
		Customer tempCustomer = customerList.getCustomer(customerId);
		List<RepairPlan> customerRepairPlans = tempCustomer.getRepairPlans();

		for (RepairPlan repairPlanIterator : customerRepairPlans) {
			long tempCustomerId = repairPlanIterator.getCustomer().getCustomerID();
			long tempApplianceId = repairPlanIterator.getAppliance().getApplianceID();
			if (tempCustomerId == customerId && tempApplianceId == applianceId) {
				customerRepairPlans.remove(repairPlanIterator);
			}
		}

	}

	/**
	 * Load this companies data from a saved file
	 * 
	 * @param String dataFile - the path to the file to load from
	 */
	// We can suppress this because we know the data type that will be gotten
	@SuppressWarnings("unchecked")
	public void loadData(String dataFile) {
		try (FileInputStream fin = new FileInputStream(new File(dataFile));
				ObjectInputStream oin = new ObjectInputStream(fin)) {
			this.catalog = (Catalog) oin.readObject();
			this.customerList = (CustomerList) oin.readObject();
			this.nextCustomerId = (long) oin.readObject();
			this.catalog.setApplianceList((List<Appliance>) oin.readObject());
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
			oos.writeObject(this.catalog.getApplianceList());
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

	// Process 10
	public void printAppliances() {
		System.out.println("Appliances:");
		catalog.print();
	}

	// Process 10
	// applianceObj.getClass().toString().replaceFirst("class group5.ics372.pa1.",
	// "")
	public void printSpecificAppliances(String className) {
		System.out.println(className + " Appliances: ");

		// 1) runs though catalog.applianceList
		// 2) convert's its actualType's name into string and compares it with the input
		// String className
		// 3) if match then print display of the appliance's details
		for (Appliance app : catalog.getApplianceList()) {
			String currentAppNameStr = app.getClass().toString().replaceFirst("class group5.ics372.pa1.", "");
			if (currentAppNameStr.toUpperCase().equals(className.toUpperCase())) {
				System.out.println(app.toString());
			}
		}
	}

	public void printBackOrders() {
		System.out.println("BackOrders:");
		backOrdersList.print();
	}

	public List<Customer> getCustomers() {
		return customerList.getCustomerList();
	}

	public BackOrdersList getBackOrdersList() {
		System.out.println("Company");
		return backOrdersList;
	}

	public List<Appliance> getAppliances() {
		return catalog.getApplianceList();
	}
}
