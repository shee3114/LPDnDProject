package Distro.LPDnD.Pages.pages.login.dashboard;

import org.openqa.selenium.WebDriver;

import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToDashboard() {
		CommonFunctions commonFunctions = new CommonFunctions(driver);
		commonFunctions.navigateToModule(DistricoConstant.DASHBOARD);
	}
}
