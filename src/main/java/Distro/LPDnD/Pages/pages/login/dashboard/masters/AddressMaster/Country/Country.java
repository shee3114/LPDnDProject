package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.Country;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.Shared_OR;
import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;

public class Country {

	public WebDriver driver;

	public Country(WebDriver driver) {
		this.driver = driver;
	}

	public void NavigateToCountryMaster() {

		CommonFunctions commonFucntions = new CommonFunctions(driver);
		commonFucntions.navigateToModule(DistricoConstant.COUNTRY);

	}

	public void addCountry() {

		// Add Data to "Country Name" field
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		commonFunctions.waitTillVisbilityOfElement(Country_OR.countryName);

		commonFunctions.enterData(Country_OR.countryName, "Australia");

		// Add Data to "Short Name" field
		commonFunctions.enterData(Country_OR.countryShortName, "AUS");

		// Click on Add Button
		commonFunctions.click(Shared_OR.addBtn);

		// Verify Notification
		String actualNotification = commonFunctions.getText(Shared_OR.notification);
		if (actualNotification.equals("Country added successfully.")) {
			System.out.println("Country is added successfully");
		} else {
			System.out.println("Failed to add Country");
		}
	}

	public void deleteCountry() {

	}

}
