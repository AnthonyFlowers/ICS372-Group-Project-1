package group5.ics372.pa1.appliances;

/**
 * This class represents a ClothDryer appliance. Cloth dryers have a
 * monthlyPayment for service plans
 * 
 * @author Group 5
 *
 */
public class ClothDryer extends Appliance {

	private static final long serialVersionUID = 2022_03_14L;
	private final double monthlyPayment;

	/**
	 * Initialize a new ClothDryer
	 * 
	 * @param id             - the id of this Appliance
	 * @param brandName      - the brand name of this appliance
	 * @param modelType      - the model type of this appliance
	 * @param price          - the price of this appliance
	 * @param monthlyPayment - the monthly repair plan price of this ClothDryer
	 */
	public ClothDryer(long id, String brandName, String modelType, double price, double monthlyPayment) {
		super(id, brandName, modelType, price);
		this.monthlyPayment = 2 * monthlyPayment;
		this.hasRepairPlan = true;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	@Override
	public double getRepairCost() {
		return this.monthlyPayment;
	}

}
