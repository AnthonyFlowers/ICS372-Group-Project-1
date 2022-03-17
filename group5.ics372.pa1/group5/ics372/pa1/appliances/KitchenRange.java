package group5.ics372.pa1.appliances;

/**
 * This class extends Appliance. This class is a basic Appliance with no
 * special/additional attributes.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 */
public class KitchenRange extends Appliance {
	private static final long serialVersionUID = 2022_03_17L;

    /**
     * Constructor for KitchenRange.
     * 
     * @param id        the id of this Appliance
     * @param brandName the brand name of this Appliance
     * @param modelType the model type of this Appliance
     * @param price     the price of this Appliance
     */
    public KitchenRange(long id, String brandName, String modelType, double price) {
	    super(id, brandName, modelType, price);
    }

}
