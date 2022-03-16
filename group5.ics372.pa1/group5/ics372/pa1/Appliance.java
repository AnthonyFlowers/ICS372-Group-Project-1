package group5.ics372.pa1;

import java.io.Serializable;

/**
 * This class implements Serializable. This class is meant to serve as a super
 * class for: ClothDyer, ClothWaser, DishWasher, KitchenRange, Refrigerator, and
 * Furnace.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
 *
 */
public abstract class Appliance implements Serializable {

    private static final long serialVersionUID = 2022_03_12L;

    protected long applianceID;
    protected String brandName;
    protected String modelType;
    protected double price;
    protected int stock = 0;
    protected boolean hasRepairPlan;
    protected double repairCost;
    protected boolean backOrder;

    /**
     * Initialize a new appliance with a generated id
     * 
     * @param String brandName - the brand name of this appliance
     * @param String modelType - the model of this appliance
     */
    public Appliance(long id, String brandName, String modelType, double price) {
	this.applianceID = id;
	this.brandName = brandName;
	this.modelType = modelType;
	this.price = price;
	this.backOrder = true;
	this.hasRepairPlan = false;
    }

    /**
     * Sets the repair cost for the appliance.
     * 
     * @param newCost the value repairCost will be set to
     */
    public void setRepairCost(double newCost) {
	this.repairCost = newCost;
    }

    /**
     * Given an amount adds that amount to the stock/inventory of the current
     * Appliance.
     * 
     * @param addAmount and integer value to add to the Appliance's stock
     */
    public void addStock(int addAmount) {
	this.stock += addAmount;
    }

    /**
     * Sets the price of the Appliance.
     * 
     * @param price value of the new price
     */
    public void setPrice(double price) {
	this.price = price;
    }

    /**
     * Gets the current Appliance's Id/
     * 
     * @return applianceID
     */
    public long getApplianceID() {
	return applianceID;
    }

    /**
     * Gets the current Appliance's price.
     * 
     * @return price
     */
    public double getPrice() {
	return price;
    }

    /**
     * Gets the model type of the current Appliance.
     * 
     * @return modeltype
     */
    public String getType() {
	return this.modelType;
    }

    /**
     * Gets the brand of the current Appliance.
     * 
     * @return brandName
     */
    public String getBrand() {
	return this.brandName;
    }

    /**
     * Gets the stock amount of the current Appliance.
     * 
     * @return stock
     */
    public int getStock() {
	return stock;
    }

    /**
     * Check if this appliance has a repair plan
     * 
     * @return boolean - true if this appliance has a repair plan false otherwise
     */
    public boolean getRepairPlanBoolean() {
	return hasRepairPlan;
    }

    /**
     * Gets the repair cost of the current Appliance.
     * 
     * @return repairCost
     */
    public double getRepairCost() {
	return repairCost;
    }

    /**
     * Code checks to make sure removeAmount doesn't make stock go negative if true
     * then subtract removeAmount from Stock. Then return true. Else no operation
     * performed, return false.
     * 
     * @param removeAmount the amount of stock to be removed from the current
     *                     Appliance
     */
    public boolean removeStock(int removeAmount) {
	if (stock - removeAmount >= 0) {
	    this.stock -= removeAmount;
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Returns whether or not the current Appliance can be backOrdered.
     * 
     * @return whether or not the current Appliance can be backOrdered
     */
    public boolean canBackOrder() {
	return this.backOrder;
    }

    @Override
    public String toString() {
	return String.format(
		"ID: %s\t| BrandName: %s\t| ModelType: %s\t| Price: %.2f\t| Stock: %d\t| RepairCost: %.2f\t",
		this.applianceID, this.brandName, this.modelType, this.price, this.getStock(), this.getRepairCost());

    }
}
