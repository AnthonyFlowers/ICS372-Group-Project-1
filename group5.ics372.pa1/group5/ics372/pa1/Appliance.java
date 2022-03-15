package group5.ics372.pa1;

import java.io.Serializable;

public abstract class Appliance implements Serializable {

	private static final long serialVersionUID = 2022_03_12L;

	// Protected or public?
	protected long applianceID;
	private String brandName;
	private String modelType;
	protected double price;
	protected int stock = 0; // reffered to as inventory in "instructions"
	protected double repairPlan = 0; // added, "zero" means no repair plans
	protected boolean backOrder;

	/**
	 * Initialize a new appliance with a generated id
	 * 
	 * @param String brandName - the brand name of this appliance
	 * @param String modelType - the model of this appliance
	 */
	public Appliance(long id, String brandName, String modelType) {
		this.applianceID = id;
		this.brandName = brandName;
		this.modelType = modelType;
		this.backOrder = true;
		// this.stock = stock; //initialize to methods below, not in constructor
		// this.repairPlan = repairPlan; //initialize to methods below, not in
		// constructor

	}

	// aka addRepairPlan()
	public void addRepairCharges(double newRepairCharges) {
		this.repairPlan = newRepairCharges;
	}

	// Adds to stock, aka "inventory"
	public void addStock(int addAmount) {
		this.stock += addAmount;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getApplianceID() {
		return applianceID;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return this.modelType;
	}

	public String getBrand() {
		return this.brandName;
	}

	public int getStock() {
		return stock;
	}

	/**
	 * Check if this appliance has a repair plan
	 * 
	 * @return boolean - true if this appliance has a repair plan false otherwise
	 */
	public boolean hasRepairPlan() {
		if (this.repairPlan <= 0) {
			return false;
		}

		return true;
	}

	// Returns the cost of the repairPlan if it has one else the cost is zero
	public double getRepairPlan() {
		if (this.hasRepairPlan())
			return this.repairPlan;
		else
			return 0;
	}

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
		return String.format("ID: %s\t| BrandName: %s\t| ModelType: %s\t| Price: %.2f\t| Stock: %d", this.applianceID,
				this.brandName, this.modelType, this.price, this.getStock());

	}
}
