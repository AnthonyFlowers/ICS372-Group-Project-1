package group5.ics372.pa1;

public class ClothWashers extends Appliance {
	private double repairCost;

	public ClothWashers(long id, String brandName, String modelType) {
		super(id, brandName, modelType);
		this.hasRepairPlan = true;
	}

}
