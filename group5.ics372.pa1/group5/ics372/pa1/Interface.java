package group5.ics372.pa1;

import java.util.Scanner;

public class Interface {
	private final static String DATA_FILE = "company.dat";
	private final static Scanner scanner = new Scanner(System.in);
	private final static String[] applianceOptions = { "ClothWashers", "ClothDryers", "KitchenRanges", "DishWashers",
			"Refrigerator", "Furnace" };
	private static Company company;

	public static void main(String[] args) {
		company = new Company();
//		Scanner scnr = new Scanner(System.in);
		int menuSelection = -1;

		loadData();
		do {
			do { // Get menu selection, if it is not a valid selection display error and
					// wait for // valid selection
				try {
					System.out.println("---Enter a selection---");
					System.out.println("0 : Exit program");
					System.out.println("1 : Add a single model");
					System.out.println("2 : Add a single customer");
					System.out.println("3 : Add to inventory for a single model");
					System.out.println("4 : Purchase one or more models for a single customer");
					System.out.println("5 : Fulfill a single backorder");
					System.out.println("6 : Enroll a customer in a repair plan for a single appliance");
					System.out.println("7 : Withdraw customer from a repair plan for a single appliance");
					System.out.println("8 : Charge all repair plans");
					System.out.println("9 : Print revenue from all sales and repair plans");
					System.out.println("10 : List all or some types of appliances");
					System.out.println("11 : List all users in repair plans");
					System.out.println("12 : List customers");
					System.out.println("13 : List all backorders");
					System.out.println("14 : Save data to disk");
					System.out.println("15 : Help");

					menuSelection = scanner.nextInt();
					// scanner.nextLine();

				} catch (Exception e) {
					System.out.println("Error encountered");
					scanner.close();
					e.printStackTrace();
					System.exit(0);
				}
			} while (menuSelection < 0 || menuSelection > 16);

			try {

				switch (menuSelection) {
				case 0:
					System.out.println("Exiting");
					scanner.close();
					System.exit(0);
					// ----------------------------------------------------------------------------------
					// add a single model into the Catalog's list
					// 1) The interface will determine the, Class Name, BrandName, and ModelType
					// 2) Those three variables will be passed into Company, which will create a
					// class depending on the interface inputs
					// 3) Catalog will then insert the newly created object into it's list pass from
					// Company
				case 1: // I'll do this one - Chatchai
					int applianceSelect = -1;
					String brandName;
					String modelType;

					System.out.println("Which Appliance would you like to add?");
					System.out.println(
							"| 1.ClothWashers | 2.ClothDryers | 3.KitchenRanges | 4.DishWashers | 5.Refrigerator | 6.Furnace |");
					try {
						applianceSelect += scanner.nextInt();
						// scanner.close();
					} catch (Exception e) {
						System.out.println("Case 1 Error");
					}
					scanner.nextLine(); // use to consume \n
					System.out.println("You chose appliance \"" + applianceOptions[applianceSelect] + "\"");
					System.out.println(
							"Please enter the name for the " + applianceOptions[applianceSelect] + "'s brand name.");

					brandName = scanner.nextLine().strip();

					System.out.println(
							"Please enter the name for the " + applianceOptions[applianceSelect] + "'s model type.");
					modelType = scanner.nextLine().strip();

					// System.out.println("The Brand Name is: " + brandName);
					// System.out.println("The Model Type is: " + modelType);
					// System.out.println("applianceOptions: " + applianceOptions[applianceSelect]);
					// System.out.println("applianceSelect: " + applianceOptions[applianceSelect]);
					company.addAppliance(applianceOptions[applianceSelect], brandName, modelType);
					System.out.println("Case 1 ran success. System Successfully closed.");
					break;
				// ----------------------------------------------------------------------------------
				// add a single customer to the customer list
				// 1) The interface will ask for the customers Name, Address, and phone number
				// 2) The three variables will be used to create a new customer object
				// 3) The data is passed to the customer and added to the customer list
				case 2: // -Anthony
					System.out.println("Adding a new customer.");
					System.out.print("Enter the customers name: ");
					String customerName = scanner.nextLine().strip();
					System.out.print("Enter the customers address: ");
					String customerAddress = scanner.nextLine().strip();
					System.out.print("Enter the customers phone number: ");
					String customerPhoneNumber = scanner.next().strip();
					company.addCustomer(customerName, customerAddress, customerPhoneNumber);
					System.out.println("Customer added successfully!");

				case 3: // Finished - Vontha

					System.out.println("Enter Appliance ID.");
					long applianceID = scanner.nextLong();
					System.out.println("Enter quantity to add to stock.");
					int quantity = scanner.nextInt();
					company.addToInventory(applianceID, quantity);
					break;

				case 4: // Finished - Vontha

					System.out.println("Enter Customer ID.");
					long customerID = scanner.nextLong();
					System.out.println("Enter Appliance ID.");
					applianceID = scanner.nextLong();
					System.out.println("Enter quantity to purchase.");
					quantity = scanner.nextInt();
					company.purchaseAppliances(customerID, applianceID, quantity);
					break;

				case 5:
					System.out.println("To be implemented");
					break;

				case 6:
					System.out.println("To be implemented");
					break;

				case 7:
					System.out.println("To be implemented");
					break;

				case 8:
					System.out.println("To be implemented");
					break;

				case 9:
					System.out.println("To be implemented");
					break;

				case 10:
					System.out.println("To be implemented");
					break;

				case 11:
					System.out.println("To be implemented");
//					prints all appliances
					company.printAppliances();
//					needs another method to print only specific appliance type Ex. (ClothWashers).
//					also needs a prompt to choose between the two.
					break;

				case 12:
					// Just need to add details about service plan to Customer toString method.
					// - Vontha
					System.out.println("To be implemented");
					company.printCustomers();
					break;

				case 13:
					System.out.println("To be implemented");
					break;

				case 14: // -Anthony
					saveData();
					break;

				case 15:
					System.out.println("To be implemented");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menuSelection != 0);
		scanner.close();
	}

	/**
	 * Method to save the current company data to stable storage -Anthony
	 */
	private static void saveData() {
		System.out.println("Saving the current data!");
		company.saveData(DATA_FILE);
	}

	/**
	 * Method to load previously saved data from stable storage -Anthony
	 */
	private static void loadData() {
		System.out.println("Would you like to try to load a data file from stable storage?");
		System.out.print("Y|N\n");
		String answer = scanner.nextLine();
		if (answer.toLowerCase().equals("Y")) {
			company.loadData(DATA_FILE);
		}
	}

	private static Appliance getApplianceInfo() {
		// what type of appliance?

		// get specific appliance info
		return null;
	}

	private static String getApplianceOption() {
		System.out.println("---select an appliance---");
		int option = -1;
		do {
			for (int index = 0; index < applianceOptions.length; index++) {
				System.out.println(String.format("%d : %s", index + 1, applianceOptions[index]));
			}
			option = scanner.nextInt();
		} while (0 < option && option < applianceOptions.length + 1);

		return "";

	}

}
