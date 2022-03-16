package group5.ics372.pa1;

/**
 * This class extends Appliance. This class has an additional attribute called
 * "btu" that represents the heating of the Appliance. No other Appliances has
 * this same attribute.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 */
public class Furnace extends Appliance {

    private static final long serialVersionUID = 1L;
    private int btu;

    /**
     * Constructor for the Class.
     * 
     * @param id        the id of the object created
     * @param brandName the brand name of the object created
     * @param modelType the model type of the object created
     * @param price     the price of the object created
     * @param btu       the heating output of the object created
     */
    public Furnace(long id, String brandName, String modelType, double price, int btu) {
	super(id, brandName, modelType, price);
	this.btu = btu;
	this.backOrder = false;
    }

    /**
     * Returns the btu "Heating" of the furnace.
     * 
     * @return btu
     */
    public int getBtu() {
	return btu;
    }

}
