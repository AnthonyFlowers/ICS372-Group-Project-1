package group5.ics372.pa1;

public class Refrigerator extends Appliance {
	private double capacity;

	public Refrigerator(long id, String brandName, String modelType, double price, int stock, double repairPlan,
			double capacity) {
		super(id, brandName, modelType);
		this.capacity = capacity;
	}

	/**
	 * @return the capacity
	 */
	public double getCapacity() {
		return capacity;
	}

}
