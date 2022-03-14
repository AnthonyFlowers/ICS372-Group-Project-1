package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.List;

public class BackOrdersList {
	private List<BackOrders> backOrdersList;

	public BackOrdersList() {
		this.backOrdersList = new ArrayList<BackOrders>();
	}

	public List<BackOrders> getBackOrdersList() {
		System.out.println("BackOrdersList");
		return backOrdersList;
	}

	public void addBackOrder(long backOrderId, Customer customer, Appliance appliance, int quantity) {
		backOrdersList.add(new BackOrders(backOrderId, customer, appliance, quantity));
	}

	// Process 5
	// WIP - Chatchai
	public BackOrders findWithCustomerID() {
		for (BackOrders tempBackorders : backOrdersList) {

		}
		return null;
	}

	// Process 5
	// WIP -Chatchai
	// !Warning! This method will immediately remove a backorder without checks!
	public boolean removeBackOrder(long backOrderID) {
		for (BackOrders tempBackOrders : backOrdersList) {

		}

		return false;
	}

	public void print() {
		for (BackOrders backOrders : backOrdersList) {
			System.out.println(backOrders.toString());
		}
	}
}
