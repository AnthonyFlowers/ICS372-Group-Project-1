package group5.ics372.pa1.appliances;

public class DishWasher extends Appliance {
	private static final long serialVersionUID = 2022_03_17L;

	public DishWasher(long id, String brandName, String modelType, double price) {
		super(id, brandName, modelType, price);
		this.hasRepairPlan = false;
	}

}
