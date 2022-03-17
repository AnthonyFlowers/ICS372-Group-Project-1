package group5.ics372.pa1.appliances;

public class Furnace extends Appliance {
	private static final long serialVersionUID = 2022_03_17L;
	
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
