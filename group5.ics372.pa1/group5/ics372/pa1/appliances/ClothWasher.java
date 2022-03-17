package group5.ics372.pa1.appliances;

public class ClothWasher extends Appliance {
    /**
     * This class is a extends of Appliance. This class has an additional special
     * attribute called repairCost.
     * 
     * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
     */
    private static final long serialVersionUID = 2022_03_15L;
    private double repairCost;

    /**
     * Initialize a new ClothWasher
     * 
     * @param id         - the id of this Appliance
     * @param brandName  - the brand name of this Appliance
     * @param modelType  - the model type of this Appliance
     * @param price      - the price of this Appliance
     * @param repairCost - the monthly repair plan cost of this ClothWasher
     */
    public ClothWasher(long id, String brandName, String modelType, double price, double repairCost) {
	super(id, brandName, modelType, price);
	this.repairCost = repairCost;
	this.hasRepairPlan = true;
    }

    @Override
    public double getRepairCost() {
	return this.repairCost;
    }
}
