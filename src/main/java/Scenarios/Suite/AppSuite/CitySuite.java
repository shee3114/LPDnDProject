package Scenarios.Suite.AppSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Distro.LPDnD.Pages.pages.login.dashboard.Dashboard;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.City.City;
import Scenarios.Suite.BaseSuite.LPDndBaseSuite;

public class CitySuite extends LPDndBaseSuite {
	public City city;
	public Dashboard dashboard;

	@BeforeMethod
	public void navigateToCityMaster() {

		city = new City(driver);
		city.navigateToCityMaster();
	}

	@Test(priority = 1)
	public void addCity() {
		city = new City(driver);
		city.addCity();
	}

	@AfterMethod
	public void navigateToDashBoard() {
		dashboard = new Dashboard(driver);
		dashboard.navigateToDashboard();
	}

}
