package group5.ics372.pa1;

import java.util.ArrayList;
import java.util.List;

import group5.ics372.pa1.appliances.Appliance;

/**
 * This class represents the List of BackOrders. The class will be held and
 * created within Company. The class has several methods to help manipulate
 * BackOrder Objects.
 * 
 * @author Chatchai Xiong. Vontha Chan, Anthony Flowers
 *
 */
public class BackOrdersList {
	private List<BackOrders> backOrdersList;

	/**
	 * Constructor for BackOrderLists Creates a List to hold BackOrder Objects.
	 */
	public BackOrdersList() {
		this.backOrdersList = new ArrayList<BackOrders>();
	}

	/**
	 * Returns the BackOrder List held in BackOrderList
	 * 
	 * @return the BackOrder List held in BackOrderList
	 */
	public List<BackOrders> getBackOrdersList() {
		System.out.println("BackOrdersList");
		return backOrdersList;
	}

	/**
	 * Creates a BackOrder Object and adds it to the the BackOrder list.
	 * 
	 * @param backOrderId the Id of the BackOrder to be created
	 * @param customer    the Customer reference object of the BackOrder to be
	 *                    created
	 * @param appliance   the Appliance reference object of the BackOrder to be
	 *                    created
	 * @param quantity    the quantity of the BackOrder to be created
	 */
	public void addBackOrder(long backOrderId, Customer customer, Appliance appliance, int quantity) {
		backOrdersList.add(new BackOrders(backOrderId, customer, appliance, quantity));
	}

	/**
	 * Adds a BackOrder Object to the BackOrder List.
	 * 
	 * @param backorder the BackOrder object to be added/
	 */
	public void addBackOrder(BackOrders backorder) {
		backOrdersList.add(backorder);
	}

	/**
	 * The method fulfills the backOrder process for a single BackOrder within the
	 * list. The method is given a BackOrderID and it searches for it till found. If
	 * found and there is enough inventory the BackOrder will be processed and
	 * removed.
	 * 
	 * @param backOrderID the BackOrder ID used to search for the corresponding
	 *                    backOrder.
	 */
	public void fulfillBackOrder(long backOrderID) {
		BackOrders backOrder;
		backOrder = findWithBackOrdersID(backOrderID);
		if (backOrder != null) {

			System.out.println("BackOrder: " + backOrderID + "\nSuccessfully completed!");
			System.out.println("Removing" + "BackOrderID: " + backOrderID);
			removeBackOrder(backOrderID);
			System.out.println("Current Appliance Inventory: " + backOrder.getAppliance().getStock());
		} else {
			System.out.println("NOT FOUND:\nBackOrder with ID:" + backOrderID);

		}
	}

	/**
	 * The method compares a BackOrder quantity with an Appliance inventory. If the
	 * quantity is less then or equal to the inventory then the method returns true.
	 * Otherwise it returns false.
	 * 
	 * @param backOrderQuantity  the BackOrder quantity
	 * @param backOrderAppliance the Appliance quantity
	 * @return boolean based on whether BackOrder quantity is less then or equal to
	 *         Appliance inventory.
	 */
	public boolean isThereEnoughStock(int backOrderQuantity, Appliance backOrderAppliance) {
		if (backOrderQuantity <= backOrderAppliance.getStock()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Finds a BackOrder object and returns it from Company's BackOrder List, given
	 * a backOrderID.
	 * 
	 * @param backOrderID the BackOrder ID used to search for the BackOrder Object
	 * @return the BackOrder object that matches input ID.
	 */
	public BackOrders findWithBackOrdersID(long backOrderID) {
		for (BackOrders tempBackOrders : backOrdersList) {
			if (backOrderID == tempBackOrders.getBackOrderID()) {
				System.out.println("System: Found backOrder with ID:" + tempBackOrders.getBackOrderID());
				return tempBackOrders;
			}
		}
		return null;
	}

	/**
	 * Removes a BackOrder the BackOrderList with a given BackOrder ID.
	 * 
	 * @param backOrderID the ID used to find and remove the BackOrder the BackOrder
	 *                    list
	 * @return boolean based on whether said ID matched corresponding BackOrder in
	 *         the list.
	 */
	public boolean removeBackOrder(long backOrderID) {
		for (BackOrders tempBackOrders : backOrdersList) {
			if (backOrderID == tempBackOrders.getBackOrderID()) {
				backOrdersList.remove(tempBackOrders);
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints the backOrders from the BackOrder's List.
	 */
	public void print() {
		for (BackOrders backOrders : backOrdersList) {
			System.out.println(backOrders.toString());
		}
	}
}
