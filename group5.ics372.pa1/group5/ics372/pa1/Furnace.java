package group5.ics372.pa1;

public class Furnace extends Appliance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int btu;

	public Furnace(long id, String brandName, String modelType, double price, int btu) {
		super(id, brandName, modelType, price);
		this.btu = btu;
		this.backOrder = false;
	}

	public int getBtu() {
		return btu;
	}

}
