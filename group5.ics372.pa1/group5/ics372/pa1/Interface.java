
package group5.ics372.pa1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import group5.ics372.pa1.tests.TestBed;

/**
 * This class is the main interface for the actor to interact with the Company.
 * This class will allow multiple options for the actor to select in accordance
 * with the business processes.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class Interface {
	private final static String DATA_FILE = "company.dat";
	private final static Scanner scanner = new Scanner(System.in);
	private final static String[] applianceOptions = { "ClothWashers", "ClothDryers", "KitchenRanges", "DishWashers",
			"Refrigerators", "Furnaces" };
	private static Company company;

	public static void main(String[] args) {
		company = Company.getCompany();
		int menuSelection = -1;

		loadData();
		do {
			do {
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

					/**
					 * Business Process 1: Add a single Model.
					 */
				case 1:
					int applianceSelect;
					double repairCost;
					String brandName;
					String modelType;
					double price;
					double capacity;
					int btu;

					System.out.println("Which Appliance would you like to add?");
					System.out.println(
							"| 1. ClothWashers | 2. ClothDryers | 3. KitchenRanges | 4. DishWashers | 5. Refrigerators | 6. Furnaces |");
					try {
						applianceSelect = scanner.nextInt();
						scanner.nextLine();
						System.out.println("select: " + applianceSelect);
						if (applianceSelect < 1 || applianceSelect > 6) {
							do {
								System.out.println("Invalid input. Try again.");
								applianceSelect = scanner.nextInt();
								scanner.nextLine(); // clear current line being read
							} while (applianceSelect < 1 || applianceSelect > 6);
						}
						System.out.println("You chose appliance \"" + applianceOptions[applianceSelect - 1] + "\"");
						System.out.println("Enter brand name: ");
						brandName = scanner.nextLine();
						System.out.println("Enter model name: ");
						modelType = scanner.nextLine();
						System.out.println("Enter price: ");
						price = scanner.nextDouble();
						scanner.nextLine();
						switch (applianceSelect) {
						case 1: // Cloth Washer
							System.out.println("Enter repair cost: ");
							repairCost = scanner.nextDouble();
							scanner.nextLine();
							company.addClothWasher(brandName, modelType, price, repairCost);
							break;
						case 2: // Cloth Dryer
							System.out.println("Enter repair cost: ");
							repairCost = scanner.nextDouble();
							scanner.nextLine();
							company.addClothDryer(brandName, modelType, price, repairCost);
							break;
						case 3: // Kitchen Range
							company.addKitchenRange(brandName, modelType, price);
							break;
						case 4: // Dishwasher
							company.addDishWasher(brandName, modelType, price);
							break;
						case 5: // Refrigerator
							System.out.println("Enter capacity: ");
							capacity = scanner.nextDouble();
							scanner.nextLine();
							company.addRefrigerator(brandName, modelType, price, capacity);
							break;
						case 6: // Furnace
							System.out.println("Enter btu output: ");
							btu = scanner.nextInt();
							scanner.nextLine();
							company.addFurnace(brandName, modelType, price, btu);
							break;
						}
					} catch (Exception e) {
						System.out.println("Case 1 Error");
					}
					break;

				/**
				 * Business Process 2: Add a single customer.
				 */
				case 2:
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
				/**
				 * Business Process 3: Add to inventory for a single model.
				 */
				case 3:

					System.out.println("Enter Appliance ID.");
					applianceId = scanner.nextLong();
					scanner.nextLine();
					System.out.println("Enter quantity to add to stock.");
					int quantity = scanner.nextInt();
					scanner.nextLine();
					company.addToInventory(applianceId, quantity);
					break;

				/**
				 * Business Process 4: Purchases one ore more models for a single customer.
				 */
				case 4: // Finished - Vontha
					String enterMore = "Y";
					do {
						System.out.println("Enter Customer ID.");
						long customerID = scanner.nextLong();
						scanner.nextLine();
						System.out.println("Enter Appliance ID.");
						applianceId = scanner.nextLong();
						scanner.nextLine();
						System.out.println("Enter quantity to purchase.");
						quantity = scanner.nextInt();
						scanner.nextLine();
						company.purchaseAppliances(customerID, applianceId, quantity);
						System.out.println("Would you like to add another purchase entry? [Y/N]");
						enterMore = scanner.nextLine();
					} while (enterMore.equalsIgnoreCase("y"));
					break;

				/**
				 * Business Process 5: Fulfill a single backorder.
				 */
				case 5:
					long backOrderIDSelect;
					System.out.println("Initiatiating a Backorder: ");
					System.out.println("Please enter the BackOrder ID...");
					backOrderIDSelect = scanner.nextLong();
					scanner.nextLine();
					company.fulfillBackOrder(backOrderIDSelect);
					break;
				/**
				 * Business Process 6: Enroll a customer in a repair plan for a single
				 * appliance.
				 */
				case 6:
					System.out.println("Enrolling a customer in a repair plan...");
					System.out.print("Enter the id of the customer to add the repair plan to: ");
					customerId = scanner.nextLong();
					scanner.nextLine();
					System.out.print("Enter the id of the appliance with the repair plan to add: ");
					applianceId = scanner.nextLong();
					scanner.nextLine();
					try {
						company.enrollCustomerInRepairPlan(customerId, applianceId);
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;
				/**
				 * Business Process 7: Withdraw customer from a repair plan for a single
				 * appliance.
				 */
				case 7:
					System.out.println("Withdrawing from Repair Plans: ");
					System.out.println("Please enter the customer id: ");
					customerId = scanner.nextLong();
					scanner.nextLine();
					System.out.println("Please enter the appliance id: ");
					applianceId = scanner.nextLong();
					scanner.nextLine();
					company.withdrawRepairPlan(customerId, applianceId);
					break;
				/**
				 * Business Process 8: Charge all repair plans.
				 */
				case 8:
					System.out.println("---------------------------------------------");
					System.out.println("Do you wish to charge all customer repairs?");
					System.out.println("---------------------------------------------");
					System.out.println("| 1. Charge All Customers | 2. Cancel return to main menu |");
					menuSelection = scanner.nextInt();
					scanner.nextLine();
					if (menuSelection == 1) {
						System.out.println("All customers will be charged for their repair plans");
						company.chargeAllRepairs();
					} else if (menuSelection == 2) {
						System.out.println("Customers not charged...Returning to main menu");
					} else {
						System.out.println("Please select options 1 or 2.");
					}
					break;
				/**
				 * Business Process 9: Print revenue from all sales and repair plans.
				 */
				case 9:
					company.printRevenue();
					break;

				/**
				 * Business Process 10: List all or some types of appliances.
				 */
				case 10:
					int selectOptionCaseTen = 0;
					System.out.println("Would you like display all or a specific Appliance?");
					System.out.println("1. Select All | 2. Select a Specific Appliance");

					try {
						selectOptionCaseTen = scanner.nextInt();
						scanner.nextLine();
					} catch (Exception e) {
						System.out.println("Case 10 Error");
					}
					if (selectOptionCaseTen == 1) {
						company.printAppliances();
					} else if (selectOptionCaseTen == 2) {
						selectOptionCaseTen = 0;
						System.out.println("Which Appliance would you like to display?");
						System.out.println(
								"| 1. ClothWashers | 2. ClothDryers | 3. KitchenRanges | 4. DishWashers | 5. Refrigerators | 6. Furnaces |");
						selectOptionCaseTen = scanner.nextInt() - 1;
						scanner.nextLine();

						if (selectOptionCaseTen >= 0 && selectOptionCaseTen <= 6) {
							company.printSpecificAppliances(applianceOptions[selectOptionCaseTen]);
						} else {
							System.out.println("You must select from options 1.- 6.");
						}
					} else {
						System.out.println("You must select from options 1. or 2.");
					}
					break;
				/**
				 * Business Process 11: List all users in repair plans.
				 */
				case 11:
					company.printCustomerRepairPlans();
					break;
				/**
				 * Business Process 12: List customers.
				 */
				case 12:
					company.printCustomers();
					break;
				/**
				 * Business Process 13: List all backorders: appliance brand, model, customer
				 * name, and quantity.
				 */
				case 13:
					company.printBackOrders();
					break;
				/**
				 * Business Process 14: Save to disk.
				 */
				case 14:
					saveData();
					break;

				case 15:
					System.out.println("Option | Description");
					System.out.println("0.\t Exit the system.");
					System.out.println("1.\t Add an appliance to the companies catalog.");
					System.out.println("2.\t Add a customer to the companies customer list.");
					System.out.println("3.\t Add inventory for an appliance.");
					System.out.println("4.\t Enter a purchase for a customer.");
					System.out.println("5.\t Fullfill a backorder.");
					System.out.println("6.\t Enroll a customer in a repair plan.");
					System.out.println("7.\t Withdraw a customer from a repair plan.");
					System.out.println("8.\t Charge all current repair plans.");
					System.out.println("9.\t Print the revenue from all sales and repair plans.");
					System.out.println("10.\t List current appliances in the catalog.");
					System.out.println("11.\t List all users that have repair plans.");
					System.out.println("12.\t List all customers.");
					System.out.println("13.\t List all current backorders.");
					System.out.println("14.\t Save the companies data to disk.");
					System.out.println("15.\t Shows this help message.");
					break;
				}
				waitToContinue();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menuSelection != 0);
		scanner.close();
	}

	private static void waitToContinue() {
		System.out.print("Press enter to continue...");
		scanner.nextLine();
	}

	/**
	 * Method to save the current company data to stable storage -Anthony
	 */
	private static void saveData() {
		System.out.println("Saving the current data!");
		try {
			company.saveData(DATA_FILE);
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

	/**
	 * Method to load previously saved data from stable storage -Anthony
	 */
	private static void loadData() {
		System.out.print("Would you like to try to load a data file from stable storage [Y/N]? ");
		String answer = scanner.nextLine();
		if (answer.toLowerCase().equals("y")) {
			company.loadData(DATA_FILE);
			System.out.println("Loaded data from storage...");
		} else {
			System.out.print("Would you like to load the test bed [Y/N]? ");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("y")) {
				TestBed.loadTestBed();
				TestBed.runTests();
			}
		}
	}

	/**
	 * This method returns the Appliance's class name as a string.
	 * 
	 * @return the appliance class as a string
	 */
	private static String getApplianceOption() {
		System.out.println("---select an appliance---");
		int option = -1;
		do {
			for (int index = 0; index < applianceOptions.length; index++) {
				System.out.println(String.format("%d : %s", index + 1, applianceOptions[index]));
			}
			option = scanner.nextInt();
			scanner.nextLine();
		} while (0 < option && option < applianceOptions.length + 1);

		return "";
	}

}
