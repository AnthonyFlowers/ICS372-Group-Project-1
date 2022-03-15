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

	// For Testing purposes
	public void addBackOrderObj(BackOrders backorder) {
		backOrdersList.add(backorder);
	}

	// Process 5
	// This method will fulfill the backOrder process
	// 1) It will call upon multiple sub methods, isThereEnoughStock(), findwith
	// BackOrdersID, removeBackorder()
	public void fulfillBackOrder(long backOrderID) {
		BackOrders backOrder;
		backOrder = findWithBackOrdersID(backOrderID);
		if (backOrder != null) {
			if (isThereEnoughStock(backOrder.getQuantity(), backOrder.getAppliance())) {
				System.out.println("BackOrder: " + backOrderID + "\nSuccessfully completed!");
				System.out.println("Removing" + "BackOrderID: " + backOrderID);
				backOrder.getAppliance().removeStock(backOrder.getQuantity());
				removeBackOrder(backOrderID);
				System.out.println("Current Appliance Inventory: " + backOrder.getAppliance().getStock());
			} else {
				System.out.println("BackOrder: " + backOrderID
						+ "\nWas found but there is not enough in stock to fulfill this backorder!");
				System.out.println(backOrder.toString());
				System.out.println("Appliance: " + backOrder.getAppliance().toString());
			}
		} else {
			System.out.println("NOT FOUND:\nBackOrder with ID:" + backOrderID);

		}
	}

	// Process 5
	// 1) Checks backOrder's quantity to see if there is enough in stock
	public boolean isThereEnoughStock(int backOrderQuantity, Appliance backOrderAppliance) {
		if (backOrderQuantity <= backOrderAppliance.getStock()) {
			return true;
		} else {
			return false;
		}
	}

	// Process 5
	// Done - Chatchai
	// 1) find the backOrder obj using given backOrderID
	public BackOrders findWithBackOrdersID(long backOrderID) {
		for (BackOrders tempBackOrders : backOrdersList) {
			if (backOrderID == tempBackOrders.getCustomerID()) {
				System.out.println("Found backOrder with ID:" + tempBackOrders.getBackOrderID());
				return tempBackOrders;
			}
		}
		// System.out.println("NOT FOUND: BackOrder with ID:" + backOrderID);
		return null;
	}

	// Process 5
	// !Warning! This method will immediately remove a backorder without checks!
	// 1) Method Receives long backOrderID
	// 2) Compares input backOrderID with each item in list
	// 3) if matches then remove said object from list
	public boolean removeBackOrder(long backOrderID) {
		for (BackOrders tempBackOrders : backOrdersList) {
			if (backOrderID == tempBackOrders.getBackOrderID()) {
				backOrdersList.remove(tempBackOrders);
				return true;
			}
		}
		return false;
	}

	public void print() {
		for (BackOrders backOrders : backOrdersList) {
			System.out.println(backOrders.toString());
		}
	}
}
