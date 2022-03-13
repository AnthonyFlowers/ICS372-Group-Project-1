package group5.ics372.pa1;

public class Refrigerator extends Appliance {
	private double capacity;

	public Refrigerator(String brandName, String modelType, double capacity) {
		super(brandName, modelType);
		this.capacity = capacity;
	}

	/**
	 * @return the capacity
	 */
	public double getCapacity() {
		return capacity;
	}

}
