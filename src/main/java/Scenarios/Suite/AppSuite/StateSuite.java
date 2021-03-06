package Scenarios.Suite.AppSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Distro.LPDnD.Pages.pages.login.dashboard.Dashboard;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State.State;
import Scenarios.Suite.BaseSuite.LPDndBaseSuite;

public class StateSuite extends LPDndBaseSuite {
	@BeforeMethod
	public void NavigateToCountryMaster() {

		State state = new State(driver);
		state.navigateToStateMaster();
	}

	@Test(priority = 1)
	public void addState() {
		State state = new State(driver);
		state.addState();
	}

	@AfterMethod
	public void navigateToDashBoard() {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.navigateToDashboard();
	}

}
