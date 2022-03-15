package group5.ics372.pa1;

import java.util.Scanner;

public class Interface {
	private final static String DATA_FILE = "company.dat";
	private final static Scanner scanner = new Scanner(System.in);
	private final static String[] applianceOptions = { "ClothWashers", "ClothDryers", "KitchenRanges", "DishWashers",
			"Refrigerators", "Furnaces" };
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
					scanner.nextLine();

				} catch (Exception e) {
					System.out.println("Error encountered");
					scanner.close();
					e.printStackTrace();
					System.exit(0);
				}
			} while (menuSelection < 0 || menuSelection > 16);

			try {
				long customerId;
				long applianceId;
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
					int applianceSelect = 0;
					double repairCost = 0;
					String attribute = null;
					String brandName;
					String modelType;

					System.out.println("Which Appliance would you like to add?");
					System.out.println(
							"| 1. ClothWashers | 2. ClothDryers | 3. KitchenRanges | 4. DishWashers | 5. Refrigerators | 6. Furnaces |");
					try {
						applianceSelect = scanner.nextInt() - 1;
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
					System.out.println("Appliance selected: " + applianceSelect);
					System.out.println("Please enter the cost for the repair plan: ");
					repairCost = scanner.nextDouble();

					// If refrigerator
					if (applianceSelect == 4) {
						double btu = 0;
						System.out.println("Please enter the BTU amount for the Refrigerator");
						btu = scanner.nextDouble();
						company.addApplianceRefrigerator(brandName, modelType, btu);
					} else {
						company.addAppliance(applianceOptions[applianceSelect], brandName, modelType, repairCost);
					}
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
					String customerPhoneNumber = scanner.nextLine().strip();
					company.addCustomer(customerName, customerAddress, customerPhoneNumber);
					System.out.println("Customer added successfully!");
					break;
				case 3: // Finished - Vontha

					System.out.println("Enter Appliance ID.");
					applianceId = scanner.nextLong();
					System.out.println("Enter quantity to add to stock.");
					int quantity = scanner.nextInt();
					company.addToInventory(applianceId, quantity);
					break;

				case 4: // Finished - Vontha

					System.out.println("Enter Customer ID.");
					long customerID = scanner.nextLong();
					System.out.println("Enter Appliance ID.");
					applianceId = scanner.nextLong();
					System.out.println("Enter quantity to purchase.");
					quantity = scanner.nextInt();
					company.purchaseAppliances(customerID, applianceId, quantity);
					break;

				// Done - Chatchai
				// actor inputs customerID
				// system searches for backorders with customerID
				// system checks if the stock for that appliance is available
				// if available then, company will subtract from inventory to fulfill order and
				// give system prompt
				case 5:
					long backOrderIDSelect;
					System.out.println("Initiatiating a Backorder: ");
					System.out.println("Please enter the BackOrder ID...");
					backOrderIDSelect = scanner.nextLong();
					company.fulfillBackOrder(backOrderIDSelect);
					// System.out.println("Process 5: Completed");
					break;

				case 6:
					System.out.println("Enrolling a customer in a repair plan...");
					System.out.print("Enter the id of the customer to add the repair plan to: ");
					customerId = scanner.nextLong();
					System.out.print("Enter the id of the appliance with the repair plan to add: ");
					applianceId = scanner.nextLong();
					try {
						company.enrollCustomerInRepailPlan(customerId, applianceId);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7:
					System.out.println("Withdrawing from Repair Plans: ");
					System.out.println("Please enter the customer id: ");
					customerId = scanner.nextLong();
					System.out.println("Please enter the appliance id: ");
					applianceId = scanner.nextLong();
					company.withdrawRepairPlan(customerId, applianceId);

					break;

				case 8:
					System.out.println("To be implemented");
					break;

				case 9:
					System.out.println("To be implemented");
					break;

				// Finished - Vontha, Chatchai
				// Displays a listing of all Appliance or Specific Appliances
				// User will be prompted to select all or a specific option
				case 10:
					int selectOptionCaseTen = 0;
					System.out.println("Would you like display all or a specific Appliance?");
					System.out.println("1. Select All | 2. Select a Specific Appliance");

					try {
						selectOptionCaseTen = scanner.nextInt();
					} catch (Exception e) {
						System.out.println("Case 10 Error");
					}
					// option 1, list all
					// calls company.printApliances();
					if (selectOptionCaseTen == 1) {
						company.printAppliances();
					}
					// option 2
					// calls company.printSpecificAppliances(int option);
					else if (selectOptionCaseTen == 2) {
						selectOptionCaseTen = 0;
						System.out.println("Which Appliance would you like to display?");
						System.out.println(
								"| 1. ClothWashers | 2. ClothDryers | 3. KitchenRanges | 4. DishWashers | 5. Refrigerators | 6. Furnaces |");
						selectOptionCaseTen = scanner.nextInt() - 1;

						if (selectOptionCaseTen >= 0 && selectOptionCaseTen <= 6) {
							company.printSpecificAppliances(applianceOptions[selectOptionCaseTen]);
						} else {
							System.out.println("You must select from options 1.- 6.");
						}
					} else {
						System.out.println("You must select from options 1. or 2.");
					}
//					needs another method to print only specific appliance type Ex. (ClothWashers).
//					also needs a prompt to choose between the two.
					break;

				case 11:

					break;

				case 12: // Finished - Vontha
					company.printCustomers();
					break;

				case 13: // Finished - Vontha
					company.printBackOrders();
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
		System.out.print("Would you like to try to load a data file from stable storage [Y/N]? ");
		String answer = scanner.nextLine();
		if (answer.toLowerCase().equals("y")) {
			company.loadData(DATA_FILE);
			System.out.println("Loaded data from storage...");
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
