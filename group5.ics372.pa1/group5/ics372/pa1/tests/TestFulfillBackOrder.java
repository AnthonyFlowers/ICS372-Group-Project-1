package group5.ics372.pa1.tests;

import group5.ics372.pa1.Appliance;
import group5.ics372.pa1.BackOrders;
import group5.ics372.pa1.BackOrdersList;
import group5.ics372.pa1.Company;
import group5.ics372.pa1.Customer;
import group5.ics372.pa1.DishWasher;

public class TestFulfillBackOrder {
	public static Company company = new Company();

	public static void main(String[] args) {
		testAll();
	}

	public static void testAll() {
		System.out.println("-------------------------------------");
		System.out.println("Testing Not Enough in Stock:");

		testNotEnoughStock();

		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println("Testing Enough in Stock:");

		testEnoughStock();

		System.out.println("-------------------------------------");
	}

	public static void testNotEnoughStock() {
		int stock = 15;
		int backQuantity = 20;

		Customer customer = new Customer(1, "Bob", "Bob St.", "1234556789");
		Appliance appliance = new DishWasher(1, "Bob's Washer", "xr3000", 30.0);
		// -----------------------------------------------------------------
		appliance.addStock(stock);
		BackOrders backorder = new BackOrders(1L, customer, appliance, backQuantity);
		// -----------------------------------------------------------------
		BackOrdersList backOrderList = company.getBackOrdersList();
		backOrderList.addBackOrderObj(backorder);
		company.fulfillBackOrder(1L);
		company.getBackOrdersList().removeBackOrder(1);

	}

	public static void testEnoughStock() {
		int stock = 99;
		int backQuantity = 20;

		Customer customer = new Customer(1, "Bob", "Bob St.", "1234556789");
		Appliance appliance = new DishWasher(1, "Jill's Washer", "xr9000", 35.0);
		// -----------------------------------------------------------------
		appliance.addStock(stock);
		BackOrders backorder = new BackOrders(1L, customer, appliance, backQuantity);
		// -----------------------------------------------------------------
		BackOrdersList backOrderList = company.getBackOrdersList();
		backOrderList.addBackOrderObj(backorder);
		company.fulfillBackOrder(1L);

	}

}
