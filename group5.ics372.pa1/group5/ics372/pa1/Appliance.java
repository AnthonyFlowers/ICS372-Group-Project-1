package group5.ics372.pa1;

import java.io.Serializable;

/**
<<<<<<< Updated upstream
 * This class represents an appliance. An Appliance is the base item that is
 * stored in the companies catalog
 * 
 * @author Group 5
=======
 * This class implements Serializable. This class is meant to serve as a super
 * class for: ClothDyer, ClothWaser, DishWasher, KitchenRange, Refrigerator, and
 * Furnace.
 * 
 * @author ICS 372-50(WED) Group 5-Chatchai Xiong, Vontha Chan, Anthony Flowers
>>>>>>> Stashed changes
 *
 */
public abstract class Appliance implements Serializable {

<<<<<<< Updated upstream
	private static final long serialVersionUID = 2022_03_12L;

	// Protected or public?
	protected long applianceID;
	protected String brandName;
	protected String modelType;
	protected double price;
	protected int stock = 0; // reffered to as inventory in "instructions"
	protected boolean hasRepairPlan;
	protected double repairCost; // added, "zero" means no repair plans
	protected boolean backOrder;

	/**
	 * Initialize a new Appliance
	 * 
	 * @param id        - the id of the new Appliance
	 * @param brandName - the brand name of the new Appliance
	 * @param modelType - the model type of the new Appliance
	 * @param price     - the price of the new Appliance
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
	 * Set the repair cost of this Appliance
	 * 
	 * @param newCost - the price to set this Appliances cost to
	 */
	public void setRepairCost(double newCost) {
		this.repairCost = newCost;
	}

	/**
	 * Add stock to this Appliance
	 * 
	 * @param addAmount - The amount of stock to add to this Appliance
	 */
	public void addStock(int addAmount) {
		this.stock += addAmount;
	}

	/**
	 * Set the price of this Appliance
	 * 
	 * @param price - the price to set this Appliance to
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the ID of this Appliance
	 * 
	 * @return long - the ID of this Appliance
	 */
	public long getApplianceID() {
		return applianceID;
	}

	/**
	 * Get the price of this Appliance
	 * 
	 * @return double - the cost of this Appliance
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Get the model type of this Appliance
	 * 
	 * @return String - the model type of this Appliance
	 */
	public String getType() {
		return this.modelType;
	}

	/**
	 * Get the brand name of this Appliance
	 * 
	 * @return String - the brand name of this Appliance
	 */
	public String getBrand() {
		return this.brandName;
	}

	/**
	 * Get the amount of stock remaining for this Appliance
	 * 
	 * @return int - the quantity remaining
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

	// Returns the cost of the repairPlan if it has one else the cost is zero
	public double getRepairCost() {
		return repairCost;
	}

	// Don't need this obj in appliance
	// public RepairPlan getRepairPlan() {
	// return this.repairPlan;
	// }

	/**
	 * #1: Code checks to make sure removeAmount doesn't make stock go negative if
	 * true then subtract removeAmount from Stock. Then return true #2: Else no
	 * operation performed, return false
	 * 
	 * @param removeAmount
	 */
	public boolean removeStock(int removeAmount) {
		// #1
		if (stock - removeAmount >= 0) {
			this.stock -= removeAmount;
			return true;
		}
		// #2
		else {
			return false;
		}
	}

	/**
	 * TODO
	 */
	public boolean canBackOrder() {
		return this.backOrder;
	}

	@Override
	public String toString() {
		return String.format(
				"ID: %s\t| BrandName: %s\t| ModelType: %s\t| Price: %.2f\t| Stock: %d\t| RepairCost: %.2f\t",
				this.applianceID, this.brandName, this.modelType, this.price, this.getStock(), this.getRepairCost());

=======
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
	// #1
	if (stock - removeAmount >= 0) {
	    this.stock -= removeAmount;
	    return true;
	}
	// #2
	else {
	    return false;
>>>>>>> Stashed changes
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
