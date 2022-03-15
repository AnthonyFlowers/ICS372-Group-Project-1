package group5.ics372.pa1;

public class ClothWasher extends Appliance {
	private double repairCost;

	public ClothWasher(long id, String brandName, String modelType, double price, double repairCost) {
		super(id, brandName, modelType, price);
		this.repairCost = repairCost;
		this.hasRepairPlan = true;
	}

	@Override
	public double getRepairCost() {
		return this.repairCost;
	}
}
