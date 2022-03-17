package group5.ics372.pa1.tests;

/**
 * Class to run each test class
 * @author Group 5
 *
 */
public class Test {
	public static void main(String[] args) {
		TestAddAppliance.testAll();
		TestAppliance.testAll();
		TestChargeAllRepairs.testAll();
		TestCustomer.testAll();
		TestEnrollRepairPlan.testAll();
		TestFulfillBackOrder.testAll();
//		TestListAppliances.testAll();
		TestPurchaseModels.testAll();
		TestSaveLoad.testAll();
		TestWithdrawRepairPlan.testAll();

	}
}
