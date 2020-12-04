package Scenarios.Suite.AppSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.login.dashboard.Dashboard;
import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.Country.Country;
import Scenarios.Suite.BaseSuite.LPDndBaseSuite;

public class CountrySuite extends LPDndBaseSuite {
	public Country country;

	@BeforeMethod
	public void navigateToCountryMaster() {

		country = new Country(driver);
		country.NavigateToCountryMaster();
	}

	@Test(priority = 1)
	public void addCountry() {
		Country country = new Country(driver);
		country.addCountry();
	}

	@AfterMethod
	public void navigateToDashBoard() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.navigateToDashboard();
	}

}
