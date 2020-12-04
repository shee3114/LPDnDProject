package Scenarios.Suite.AppSuite;

import org.testng.annotations.Test;

import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State.State;
import Scenarios.Suite.BaseSuite.LPDndBaseSuite;

public class StateSuite extends LPDndBaseSuite {
	@Test(priority = 1)
	public void NavigateToCountryMaster() {

		State state = new State(driver);
		state.navigateToStateMaster();
	}

	@Test(priority = 2)
	public void addState() {
		State state = new State(driver);
		state.addState();
	}
}
