package group5.ics372.pa1;

public class ClothWashers extends Appliance {
	private double repairCost;

	public ClothWashers(long id, String brandName, String modelType, double repairCost) {
		super(id, brandName, modelType);
		this.repairCost = repairCost;
		this.hasRepairPlan = true;
	}

	public double getRepairCost() {
		return this.repairCost;
	}
}
