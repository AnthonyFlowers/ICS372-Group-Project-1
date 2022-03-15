package group5.ics372.pa1;

/**
 * This class represents a ClothDryer appliance. Cloth dryers have a
 * monthlyPayment for service plans
 * 
 * @author Group 5
 *
 */
public class ClothDryers extends Appliance {

	private static final long serialVersionUID = 2022_03_14L;
	private final Double monthlyPayment;

	/**
	 * Initialize a new ClothDryer appliance
	 * 
	 * @param String brandName
	 * @param String modelType
	 * @param Double monthlyPayment - the monthly payment for the service plan of
	 *               this dryer
	 * @see group5.ics372.pa1.Appliance#Appliance(String, String)
	 */
	public ClothDryers(long id, String brandName, String modelType, Double monthlyPayment) {
		super(id, brandName, modelType);
		this.monthlyPayment = monthlyPayment;
		this.hasRepairPlan = true;
	}

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

}
