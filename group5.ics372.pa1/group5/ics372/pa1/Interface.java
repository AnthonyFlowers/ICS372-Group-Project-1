package group5.ics372.pa1;

import java.util.Scanner;

public class Interface {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int menuSelection = -1;

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

					menuSelection = scnr.nextInt();
					scnr.nextLine();

				} catch (Exception e) {
					System.out.println("Error encountered");
					scnr.close();
					e.printStackTrace();
					System.exit(0);
				}
			} while (menuSelection < 0 || menuSelection > 16);

			try {
				switch (menuSelection) {
				case 0:
					System.out.println("Exiting");
					scnr.close();
					System.exit(0);

				case 1:
					System.out.println("To be implemented");
					break;

				case 2:
					System.out.println("To be implemented");
					break;

				case 3:
					System.out.println("To be implemented");
					break;

				case 4:
					System.out.println("To be implemented");
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
					break;

				case 12:
					System.out.println("To be implemented");
					break;

				case 13:
					System.out.println("To be implemented");
					break;

				case 14:
					System.out.println("To be implemented");
					break;

				case 15:
					System.out.println("To be implemented");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (menuSelection != 0);

		scnr.close();

	}

}
