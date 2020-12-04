package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State;

import org.openqa.selenium.WebDriver;
import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.Shared_OR;
import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;

public class State {

	public WebDriver driver;

	public State(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToStateMaster() {

		CommonFunctions commonFucntions = new CommonFunctions(driver);
		commonFucntions.navigateToModule(DistricoConstant.STATE);

	}

	public void addState() {

		CommonFunctions commonFunctions = new CommonFunctions(driver);

		// Wait till country page is getting opened.
		commonFunctions.waitTillVisbilityOfElement(Shared_OR.countryDropDown);

		// Select the country from country drop-down.
		commonFunctions.selectValueFromDropdown(Shared_OR.countryDropDown, "India");

		// Enter the data to "State Name" field.
		commonFunctions.enterData(State_OR.stateName, "Karnataka");

		// Enter the data to "Short Name" field
		commonFunctions.enterData(State_OR.stateShortName, "KA");

		// Enter the data to "GST Code" field.
		commonFunctions.enterData(State_OR.gstCode, "12");

		// Click on "Add" button
		commonFunctions.click(Shared_OR.addBtn);

		// Verify Notification
		commonFunctions.verifyNotification("State", "State added successfully.");
	}
}
