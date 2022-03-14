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

	public void print() {
		for (BackOrders backOrders : backOrdersList) {
			System.out.println(backOrders.toString());
		}
	}
}
