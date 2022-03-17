package group5.ics372.pa1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import group5.ics372.pa1.appliances.Appliance;
import group5.ics372.pa1.appliances.ClothDryer;
import group5.ics372.pa1.appliances.ClothWasher;
import group5.ics372.pa1.appliances.DishWasher;
import group5.ics372.pa1.appliances.Furnace;
import group5.ics372.pa1.appliances.KitchenRange;
import group5.ics372.pa1.appliances.Refrigerator;

/**
 * This Class hold all of the business process for the Company. The interface
 * will interact through to Company to accomplish business tasks. The Company
 * will create and hold: -customerList -catalog -backORdersList and
 * corresponding methods to manipulate the objects in the list.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
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

    private static Company company;

    /**
     * Initialize a company with a new default Catalog and CustomerList
     */
    private Company() {
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

    public static Company getCompany() {
	if (company == null) {
	    company = new Company();
	}
	return company;
    }

    /**
     * Creates and adds a ClothWasher object to the Company's Catalog. ClothWashers
     * will have a Repair Cost associated with it.
     * 
     * @param brandName
     * @param modelType
     * @param price
     * @param repairCost
     */
    public void addClothWasher(String brandName, String modelType, double price, double repairCost) {
	catalog.addAppliance(new ClothWasher(nextApplianceId++, brandName, modelType, price, repairCost));
	System.out.println("ClothWasher has been added.");
    }

    /**
     * Creates and adds a ClothDryer object to the Company's Catalog. ClothDryer
     * will have a Repair Cost associated with it.
     * 
     * @param brandName
     * @param modelType
     * @param price
     * @param repairCost
     */
    public void addClothDryer(String brandName, String modelType, double price, double repairCost) {
	catalog.addAppliance(new ClothDryer(nextApplianceId++, brandName, modelType, price, repairCost));
	System.out.println("ClothDryer has been added.");
    }

    /**
     * Creates and adds a KitchenRange object to the Company's Catalog.
     * 
     * @param brandName
     * @param modelType
     * @param price
     */
    public void addKitchenRange(String brandName, String modelType, double price) {
	catalog.addAppliance(new KitchenRange(nextApplianceId++, brandName, modelType, price));
	System.out.println("KitchenRange has been added.");
    }

    /**
     * Creates and adds a DishWasher object to the Company's Catalog.
     * 
     * @param brandName
     * @param modelType
     * @param price
     */
    public void addDishWasher(String brandName, String modelType, double price) {
	catalog.addAppliance(new DishWasher(nextApplianceId++, brandName, modelType, price));
	System.out.println("DishWasher has been added.");
    }

    /**
     * Creates and adds a Refrigerator object to the Company's Catalog. Refrigerator
     * will have an extra capacity attribute associated with it.
     * 
     * @param brandName
     * @param modelType
     * @param price
     * @param capacity
     */
    public void addRefrigerator(String brandName, String modelType, double price, double capacity) {
	catalog.addAppliance(new Refrigerator(nextApplianceId++, brandName, modelType, price, capacity));
	System.out.println("Refrigerator has been added.");
    }

    /**
     * Creates and adds a Furnace object to the Company's Catalog. Furnace will have
     * an extra BTU attribute associated with it.
     * 
     * @param brandName
     * @param modelType
     * @param price
     * @param btu
     */
    public void addFurnace(String brandName, String modelType, double price, int btu) {
	catalog.addAppliance(new Furnace(nextApplianceId++, brandName, modelType, price, btu));
	System.out.println("Furnace has been added.");
    }

    /**
     * Add an Appliance object to the Company's Catalog.
     * 
     * @param appliance - the Appliance Object to add
     */
    public void addAppliance(Appliance appliance) {
	catalog.addAppliance(appliance);
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

    /**
     * Adds a Customer Object to the Company's CustomerList.
     * 
     * @param customer Customer Object to add
     */
    public void addCustomer(Customer customer) {
	this.customerList.addCustomer(customer);
    }

    /**
     * Given an appliance id and a quanity the method finds the associated appliance
     * within Catalog and adds an inventory amount to an appliance.
     * 
     * @param applianceID Id used to search for the associated Appliance object
     * @param quantity    the inventory amount to be added to the associated
     *                    Appliance object
     */
    public void addToInventory(long applianceID, int quantity) {
	Appliance appliance = catalog.search(applianceID);
	if (appliance == null) {
	    System.out.println("Cannot add stock.");
	} else {
	    appliance.addStock(quantity);
	}
    }

    /**
     * Given a customer id, appliance id and quantity. The method purchases the
     * associated amount and adds inputs it to the customer's inventory.
     * 
     * @param customerID  Id used to find the associated Customer Object
     * @param applianceID Id used to find the associated Appliance Object
     * @param quantity    the amount of of stock to purchase for the customer of the
     *                    appliance
     */
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

    /**
     * 
     * @param backOrderID
     */
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
	Customer customer = customerList.search(customerId);
	if (appliance == null) {
	    throw new IllegalArgumentException(String.format("Appliance with the id %s does not exist.", applianceId));
	} else if (customer == null) {
	    throw new IllegalArgumentException(String.format("Customer with the id %s does not exist.", customerId));
	} else if (!appliance.hasRepairPlan()) { // changed - Chatchai
	    throw new IllegalArgumentException(
		    String.format("Appliance with the id %s does not have a repair plan.", applianceId));
	} else {
	    RepairPlan repairPlan = new RepairPlan(nextRepairPlanId++, customer, appliance, appliance.getRepairCost());
	    customerList.addCustomerRepairPlan(customer, repairPlan);
	}
    }

    /**
     * Given an appliance id, company will search its Catalog and return the
     * appliance if found.
     * 
     * @param applianceId the id used to search for the corresponding Appliance
     *                    Object in Catalog
     * @return the Appliance object if found.
     */
    private Appliance getApplianceById(long applianceId) {
	for (Appliance appliance : catalog.getApplianceList()) {
	    if (appliance.getApplianceID() == applianceId) {
		return appliance;
	    }
	}

	/**
	 * Creates and adds a DishWasher object to the Company's Catalog.
	 * 
	 * @param brandName
	 * @param modelType
	 * @param price
	 */
	public void addDishWasher(String brandName, String modelType, double price) {
		catalog.addAppliance(new DishWasher(nextApplianceId++, brandName, modelType, price));
		System.out.println("DishWasher has been added.");
	}

	/**
	 * Creates and adds a Refrigerator object to the Company's Catalog. Refrigerator
	 * will have an extra capacity attribute associated with it.
	 * 
	 * @param brandName
	 * @param modelType
	 * @param price
	 * @param capacity
	 */
	public void addRefrigerator(String brandName, String modelType, double price, double capacity) {
		catalog.addAppliance(new Refrigerator(nextApplianceId++, brandName, modelType, price, capacity));
		System.out.println("Refrigerator has been added.");
	}

	/**
	 * Creates and adds a Furnace object to the Company's Catalog. Furnace will have
	 * an extra BTU attribute associated with it.
	 * 
	 * @param brandName
	 * @param modelType
	 * @param price
	 * @param btu
	 */
	public void addFurnace(String brandName, String modelType, double price, int btu) {
		catalog.addAppliance(new Furnace(nextApplianceId++, brandName, modelType, price, btu));
		System.out.println("Furnace has been added.");
	}

	/**
	 * Add an Appliance object to the Company's Catalog.
	 * 
	 * @param appliance - the Appliance Object to add
	 */
	public void addAppliance(Appliance appliance) {
		catalog.addAppliance(appliance);
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

	/**
	 * Adds a Customer Object to the Company's CustomerList.
	 * 
	 * @param customer Customer Object to add
	 */
	public void addCustomer(Customer customer) {
		this.customerList.addCustomer(customer);
	}

	/**
	 * Given an appliance id and a quanity the method finds the associated appliance
	 * within Catalog and adds an inventory amount to an appliance.
	 * 
	 * @param applianceID Id used to search for the associated Appliance object
	 * @param quantity    the inventory amount to be added to the associated
	 *                    Appliance object
	 */
	public void addToInventory(long applianceID, int quantity) {
		Appliance appliance = catalog.search(applianceID);
		if (appliance == null) {
			System.out.println("Cannot add stock.");
		} else {
			appliance.addStock(quantity);
		}
	}

	/**
	 * Given a customer id, appliance id and quantity. The method purchases the
	 * associated amount and adds inputs it to the customer's inventory.
	 * 
	 * @param customerID  Id used to find the associated Customer Object
	 * @param applianceID Id used to find the associated Appliance Object
	 * @param quantity    the amount of of stock to purchase for the customer of the
	 *                    appliance
	 */
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

	/**
	 * 
	 * @param backOrderID
	 */
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
		Customer customer = customerList.search(customerId);
		if (appliance == null) {
			throw new IllegalArgumentException(String.format("Appliance with the id %s does not exist.", applianceId));
		} else if (customer == null) {
			throw new IllegalArgumentException(String.format("Customer with the id %s does not exist.", customerId));
		} else if (!appliance.hasRepairPlan()) { // changed - Chatchai
			throw new IllegalArgumentException(
					String.format("Appliance with the id %s does not have a repair plan.", applianceId));
		} else {
			RepairPlan repairPlan = new RepairPlan(nextRepairPlanId++, customer, appliance, appliance.getRepairCost());
			customerList.addCustomerRepairPlan(customer, repairPlan);
		}
	}

	/**
	 * Given an appliance id, company will search its Catalog and return the
	 * appliance if found.
	 * 
	 * @param applianceId the id used to search for the corresponding Appliance
	 *                    Object in Catalog
	 * @return the Appliance object if found.
	 */
	private Appliance getApplianceById(long applianceId) {
		for (Appliance appliance : catalog.getApplianceList()) {
			if (appliance.getApplianceID() == applianceId) {
				return appliance;
			}
		}
		return null;
	}

	/**
	 * Given a customer id and appliance id. Company searches for the customer and
	 * removes the customer from the repair plan with the corresponding appliance
	 * id.
	 * 
	 * @param customerId  the Id used to find the customer
	 * @param applianceId the id used to find the appliance.
	 */
	public void withdrawRepairPlan(long customerId, long applianceId) {
		Customer customer = customerList.search(customerId);
		List<RepairPlan> customerRepairPlans = customer.getRepairPlans();
		RepairPlan toBeRemovedPlan = null;

		for (RepairPlan repairPlan : customerRepairPlans) {
			long repairPlanCustomerId = repairPlan.getCustomer().getCustomerID();
			long repairPlanApplianceId = repairPlan.getAppliance().getApplianceID();
			if (repairPlanCustomerId == customerId && repairPlanApplianceId == applianceId) {
				toBeRemovedPlan = repairPlan;
				break;
			}
		}
		if (toBeRemovedPlan != null) {
			System.out.println("The repair plan below has been removed. ");
			customerList.withdrawCustomerRepairPlan(toBeRemovedPlan);
//			customerRepairPlans.remove(toBeRemovedPlan);
	} else {
	    System.out.println("The system could not find an repair plan with the Customer and Appliance Id");
	}

    }

    /**
     * Company charges all customers for their repair plans and tallies up the total
     * revenue.
     */
    public void chargeAllRepairs() {
	this.repairRevenue += customerList.chargeAllRepairs();
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
     * @throws IOException           - if there is a problem reading the file
     * @throws FileNotFoundException - if the data file does not exist
     */
    public void saveData(String dataFile) throws FileNotFoundException, IOException {
	try (FileOutputStream fos = new FileOutputStream(new File(dataFile));
		ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	    oos.writeObject(this.catalog);
	    oos.writeObject(this.customerList);
	    oos.writeObject(this.nextCustomerId);
	    oos.writeObject(this.catalog.getApplianceList());
	}
    }

    /**
     * Company prints the revenue from it's sales and repairs.
     */
    public void printRevenue() {
	System.out.println(String.format("Sales revenue: %.2f", salesRevenue));
	System.out.println(String.format("Repair revenue: %.2f", repairRevenue));
    }

    /**
     * Given a sales amount company adds it to the culmalative sales revenue.
     * 
     * @param amount
     */
    public void addSalesRevenue(double amount) {
	this.salesRevenue += amount;
    }

    /**
     * Given a revenue amount Company adds it to the culmalative repair revenue.
     * 
     * @param amount
     */
    public void addRepairRevenue(double amount) {
	this.repairRevenue += amount;
    }

    /**
     * Company prints all it's Appliances.
     */
    public void printAppliances() {
	System.out.println("Appliances:");
	catalog.print();
    }

    /**
     * Company prints the Appliance subclass based on the Appliance name given.
     * 
     * @param className the name of an Appliance subtype
     */
    public void printSpecificAppliances(String className) {
	System.out.println(className + " Appliances: ");
	for (Appliance app : catalog.getApplianceList()) {
	    String currentAppNameStr = app.getClass().toString().replaceFirst("class group5.ics372.pa1.", "");
	    if (currentAppNameStr.toUpperCase().equals(className.toUpperCase())) {
		System.out.println(app.toString());
	    }
	}
    }

    /**
     * Company prints all it's customers.
     */
    public void printCustomers() {
	System.out.println("Customers:");
	customerList.print();
    }

    /**
     * Company prints all it's Back orders.
     */
    public void printBackOrders() {
	System.out.println("BackOrders:");
	backOrdersList.print();
    }

    /**
     * Company return it's list of Customers.
     * 
     * @return customer list
     */
    public List<Customer> getCustomers() {
	return customerList.getCustomerList();
    }

    /**
     * Company returns its list of BackOrders.
     * 
     * @return backOrderList
     */
    public BackOrdersList getBackOrdersList() {
	System.out.println("Company");
	return backOrdersList;
    }

    /**
     * Company return it's list of Appliances
     * 
     * @return applianceList
     */
    public List<Appliance> getAppliances() {
	return catalog.getApplianceList();
    }

    /**
     * Customer print's all its repair plans.
     */
    public void printCustomerRepairPlans() {
	System.out.println("Showing Customer Repair Plans...");
	for (Customer customer : customerList.getCustomerList()) {
	    System.out.println(String.format("Customer: %s Address: %s Phone: %s ID: %s Balance: %s",
		    customer.getName(), customer.getAddress(), customer.getPhoneNumber(), customer.getCustomerID(),
		    customer.getTotalRepairCharges()));
	    System.out.println("The customer has a repair plan for these appliances:");
	    for (RepairPlan repairPlan : customer.getRepairPlans()) {
		Appliance planAppliance = repairPlan.getAppliance();
		System.out.println(
			String.format("Brand: %s Model: %s", planAppliance.getBrand(), planAppliance.getType()));
	    }
	}
    }

}
