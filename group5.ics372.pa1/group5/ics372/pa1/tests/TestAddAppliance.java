package group5.ics372.pa1.tests;

import group5.ics372.pa1.Company;

public class TestAddAppliance {

	public static void main(String[] args) {
		testAddAppliance();
	}

	private static void testAddAppliance() {
		Company company = new Company();
		String applianceName = "Washer";
		company.addAppliance(null, null, null);
	}

}
