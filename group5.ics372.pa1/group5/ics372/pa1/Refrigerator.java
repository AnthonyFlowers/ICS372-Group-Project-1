package group5.ics372.pa1;

/**
 * This class extends Appliance. This class has a special/additional attribute
 * called capacity that only Refrigerator sub-types have.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class Refrigerator extends Appliance {
    private double capacity;

    /**
     * Constructor for Refrigerator. The constructor will also build a
     * special/additional attribute "capacity"/
     * 
     * @param nextApplianceId the next id availiable from the list of Ids
     * @param brandName       the brand name of this object
     * @param modelType       the model type of this object
     * @param price           the price of this object
     * @param capacity        the capacity of this object
     */
    public Refrigerator(long nextApplianceId, String brandName, String modelType, double price, double capacity) {
	super(nextApplianceId, brandName, modelType, price);
	this.capacity = capacity;
    }

    /**
     * Returns the Refrigerator's special attribute "capacity".
     * 
     * @return the capacity
     */
    public double getCapacity() {
	return capacity;
    }

}
