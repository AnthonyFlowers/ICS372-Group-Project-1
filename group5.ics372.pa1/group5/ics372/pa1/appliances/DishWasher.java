package group5.ics372.pa1.appliances;

public class DishWasher extends Appliance {

	public DishWasher(long id, String brandName, String modelType, double price) {
		super(id, brandName, modelType, price);
		this.hasRepairPlan = false;
	}

}
