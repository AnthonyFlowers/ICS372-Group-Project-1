package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.List;

public class BackOrdersList {
	private static List<BackOrders> backOrdersList = new ArrayList<>();

	public static List<BackOrders> getBackOrdersList() {
		return backOrdersList;
	}

	public void addBackOrder(long backOrderId, Customer customer, Appliance appliance, int quantity) {
		this.backOrdersList.add(new BackOrders(backOrderId, customer, appliance, quantity));	
	}
}
