package group5.ics372.pa1;

public class Furnaces extends Appliance {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Furnaces(long id, String brandName, String modelType) {
		super(id, brandName, modelType);
		this.backOrder = false;
	}

}
