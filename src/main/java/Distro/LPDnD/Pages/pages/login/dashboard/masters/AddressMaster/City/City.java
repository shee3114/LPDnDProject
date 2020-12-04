package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.City;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.Shared_OR;
import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;

public class City {
	public WebDriver driver;
	public Actions actions;

	CommonFunctions commonFucntions;

	public City(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToCityMaster() {
		commonFucntions = new CommonFunctions(driver);
		commonFucntions.navigateToModule(DistricoConstant.CITY);
	}

	public void addCity() {

		// Select the Country from Country drop-down
		commonFucntions = new CommonFunctions(driver);
		commonFucntions.selectValueFromDropdown(Shared_OR.countryDropDown, "India");
		commonFucntions.selectValueFromDropdown(Shared_OR.stateDropDown, "Maharashtra");
		commonFucntions.enterData(City_OR.city, "Malad");

		// Click on Add button
		commonFucntions.click(Shared_OR.addBtn);
		commonFucntions.verifyNotification("City", "City added successfully.");

	}

}
