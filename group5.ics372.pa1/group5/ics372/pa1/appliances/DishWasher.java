package group5.ics372.pa1.appliances;

/**
 * This class extends Appliance. This class represents a basic Appliance with no
 * special attributes.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public class DishWasher extends Appliance {
    private static final long serialVersionUID = 2022_03_17L;
    /**
     * Constructor for Dishwasher. This Appliance has no repair plan.
     * 
     * @param id        the id of the object created
     * @param brandName the brand name of the object created
     * @param modelType the model type of the object created
     * @param price     the price of the object created
     */
    public DishWasher(long id, String brandName, String modelType, double price) {
	super(id, brandName, modelType, price);
	this.hasRepairPlan = false;
    }

}
