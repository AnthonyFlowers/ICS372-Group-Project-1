package group5.ics372.pa1.appliances;

public class Refrigerator extends Appliance {
	private static final long serialVersionUID = 2022_03_17L;

	private double capacity;

	public Refrigerator(long nextApplianceId, String brandName, String modelType, double price, double capacity) {
		super(nextApplianceId, brandName, modelType, price);
		this.capacity = capacity;
	}

	/**
	 * @return the capacity
	 */
	public double getCapacity() {
		return capacity;
	}

}
