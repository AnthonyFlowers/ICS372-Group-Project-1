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
	private long nextRepairPlanId;
	private double repairRevenue;
	private double salesRevenue;
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
		this.nextRepairPlanId = 1;
		this.repairRevenue = 0;
		this.salesRevenue = 0;
		this.catalog = new Catalog();
		this.customerList = new CustomerList();
		this.backOrdersList = new BackOrdersList();
	}

	// Process 1
	public void addClothWasher(String brandName, String modelType, double price, double repairCost) {
		catalog.addAppliance(new ClothWasher(nextApplianceId++, brandName, modelType, price, repairCost));
		System.out.println("ClothWasher has been added.");
	}

	public void addClothDryer(String brandName, String modelType, double price, double repairCost) {
		catalog.addAppliance(new ClothDryer(nextApplianceId++, brandName, modelType, price, repairCost));
		System.out.println("ClothDryer has been added.");
	}

	public void addKitchenRange(String brandName, String modelType, double price) {
		catalog.addAppliance(new KitchenRange(nextApplianceId++, brandName, modelType, price));
		System.out.println("KitchenRange has been added.");
	}

	public void addDishWasher(String brandName, String modelType, double price) {
		catalog.addAppliance(new DishWasher(nextApplianceId++, brandName, modelType, price));
		System.out.println("DishWasher has been added.");
	}

	public void addRefrigerator(String brandName, String modelType, double price, double capacity) {
		catalog.addAppliance(new Refrigerator(nextApplianceId++, brandName, modelType, price, capacity));
		System.out.println("Refrigerator has been added.");
	}

	public void addFurnace(String brandName, String modelType, double price, int btu) {
		catalog.addAppliance(new Furnace(nextApplianceId++, brandName, modelType, price, btu));
		System.out.println("Furnace has been added.");
	}

	/**
	 * Add an appliance to this companies catalog
	 * 
	 * @param appliance - the Appliance to add
	 */
	public void addAppliance(Appliance appliance) {
		catalog.addAppliance(appliance);
	}
	// Process 1 end

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

	public void addCustomer(Customer customer) {
		this.customerList.addCustomer(customer);
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
		if (customer != null && appliance != null && appliance.canBackOrder()) {
			if (appliance.removeStock(quantity)) {
				this.addSalesRevenue(appliance.getPrice() * quantity);
				customer.addAppliance(appliance);
				System.out.println("Purchase completed.");
			} else {
				this.addSalesRevenue(appliance.getPrice() * quantity);
				System.out.println(appliance.getStock() + " appliances delivered.");
				System.out.println(quantity - appliance.getStock() + " appliances have been backordered.");
				System.out.println("BackOrder created.\nID = " + nextBackOrderId);
				backOrdersList.addBackOrder(nextBackOrderId++, customer, appliance, quantity - appliance.getStock());
				customer.addAppliance(appliance);
				appliance.removeStock(appliance.getStock());
			}
		} else if (customer != null && appliance != null && appliance.canBackOrder() == false) {
			this.addSalesRevenue(appliance.getPrice() * appliance.getStock());
			customer.addAppliance(appliance);
			appliance.removeStock(appliance.getStock());
			System.out.println("This appliance cannot be backordered. Remaining stock sold to customer.");
		} else {
			System.out.println("Invalid customer or appliance id.");
		}
	}

	// Process 5
	// Done - Chatchai
	public void fulfillBackOrder(long backOrderID) {
		backOrdersList.fulfillBackOrder(backOrderID);
	}

	// Process 6
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
	public void enrollCustomerInRepairPlan(long customerId, long applianceId) throws IllegalArgumentException {
		Appliance appliance = getApplianceById(applianceId);
		Customer customer = customerList.getCustomerById(customerId);
		if (appliance == null) {
			throw new IllegalArgumentException(String.format("Appliance with the id %s does not exist.", applianceId));
		} else if (customer == null) {
			throw new IllegalArgumentException(String.format("Customer with the id %s does not exist.", customerId));
		} else if (!appliance.hasRepairPlan) { // changed - Chatchai
			throw new IllegalArgumentException(
					String.format("Appliance with the id %s does not have a repair plan.", applianceId));
		}
		long tempCusId = customer.getCustomerID();
		long tempAppId = appliance.getApplianceID();
		double tempRepairCost = appliance.getRepairCost();
		customer.addRepairPlan(new RepairPlan(nextRepairPlanId++, customer, appliance, tempRepairCost));
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
		Customer customer = customerList.getCustomer(customerId);
		System.out.println(customer);
		List<RepairPlan> customerRepairPlans = customer.getRepairPlans();
		RepairPlan toBeRemovedPlan = new RepairPlan(0, null, null, 0.0);

		for (RepairPlan repairPlanIterator : customerRepairPlans) {
			long tempCustomerId = repairPlanIterator.getCustomer().getCustomerID();
			long tempApplianceId = repairPlanIterator.getAppliance().getApplianceID();
			if (tempCustomerId == customerId && tempApplianceId == applianceId) {
				toBeRemovedPlan = repairPlanIterator;
			}
		}
		if (toBeRemovedPlan.getAppliance() != null) {
			System.out.println("The repair plan below has been removed. ");
			System.out.println(customerRepairPlans.toString());
			customerRepairPlans.remove(toBeRemovedPlan);
		} else {
			System.out.println("The system could not find an repair plan with the Customer and Appliance Id");
		}

	}

	// Process 8
	public void chargeAllRepairs() {
		this.repairRevenue = customerList.chargeAllRepairs();
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
//			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed to load the data file...");
//			System.out.println(e.getStackTrace()[0]);
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("There was a problem loading the data from the file...");
//			System.out.println(e.getStackTrace()[0]);
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

	// Process 9
	public void printRevenue() {
		System.out.println(String.format("Sales revenue: %.2f", salesRevenue));
		System.out.println(String.format("Repair revenue: %.2f", repairRevenue));
	}

	public void addSalesRevenue(double amount) {
		this.salesRevenue += amount;
	}

	public void addRepairRevenue(double amount) {
		this.repairRevenue += amount;
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

	// Process 12
	public void printCustomers() {
		System.out.println("Customers:");
		customerList.print();
	}

	// Process 13
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
