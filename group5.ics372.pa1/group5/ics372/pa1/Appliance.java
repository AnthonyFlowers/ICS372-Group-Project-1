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
	protected int stock;

	/**
	 * Generic Constructor
	 * 
	 * @param id
	 * @param brandName
	 * @param modelType
	 * @param price
	 * @param stock
	 */
	public Appliance(String brandName, String modelType, double price, int stock) {
		addId();
		this.brandName = brandName;
		this.modelType = modelType;
		this.price = price;
		this.stock = stock;
	}

	private void addId() {
		this.id = nextId++;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	/**
	 * addStock() *Note*for future improvements, only allow positive
	 * addAmounts*Note*
	 * 
	 * @param addAmount
	 */
	public void addStock(int addAmount) {
		this.stock += addAmount;
	}

	/**
	 * addStock() *Note*for future improvements, only allow positive
	 * addAmounts*Note*
	 * 
	 * #1: Code checks to make sure removeAmount doesn't make stock go negative if
	 * true then subtract removeAmount from Stock. Then return true #2: Else no
	 * operation performed, return false
	 * 
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
	 * !!NEEDS TO ME CODED!! Left blank, perferably whoever did this seqence diagram
	 * code this.
	 * 
	 * @return
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
