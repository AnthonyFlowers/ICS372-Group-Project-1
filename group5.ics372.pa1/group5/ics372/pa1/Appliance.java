package group5.ics372.pa1;

/**
 * 
 * Should we make this abstract or an interface? Furnace, Refrigerator,
 * ClothAppliance, KitchenRange and Dishwasher will extend/implement this class
 */
public abstract class Appliance {
	private static long nextId = 1;
	// Protected or public?
	// Probably protected - Vontha
	protected long id;
	protected String brandName;
	protected String modelType;
	protected double price;
	protected int stock = 0; //reffered to as inventory in "instructions"
	protected double repairPlan = 0; // added, "zero" means no repair plans

	/**
	 * Generic Constructor
	 */
	public Appliance(String brandName, String modelType) {
		addId();
		this.brandName = brandName;
		this.modelType = modelType;
		//this.stock = stock;           //initialize to methods below, not in constructor
		//this.repairPlan = repairPlan; //initialize to methods below, not in constructor

	}
	
	private void addId() {
		this.id = nextId++;
	}
	//aka addRepairPlan()
	public void addRepairCharges(double newRepairCharges) {
		this.repairPlan = newRepairCharges;
	}
	 //Adds to stock, aka "inventory"
	public void addStock(int addAmount) {
		this.stock += addAmount;
	}
	public void setPrine(double price) {
		this.price = price;
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
	 * @param addAmount
	 */
	public boolean removeStock(int removeAmount) {
		// #1
		if (removeAmount - stock >= 0) {
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
		return false;
	}

	/**
	 * Left blank for now. Need to review project guidelines on what the toString
	 * should do again
	 */
	@Override
	public String toString() {
		return null;
	}
}
