package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Distro.LPDnD.Pages.pages.CommonFunctions;
import Distro.LPDnD.Pages.pages.Shared_OR;

public class State {

	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;

	public State(WebDriver driver) {
		this.driver = driver;
	}

	State(Actions actions) {
		this.actions = actions;
	}

	public void navigateToStateMaster() {

		actions = new Actions(driver);
		CommonFunctions commonFunctions = new CommonFunctions(driver);

		commonFunctions.moveToElement(Shared_OR.mastersMenu);
		commonFunctions.moveToElement(Shared_OR.addressMenu);
		commonFunctions.actionsClick(State_OR.stateMenu);
		actions.build().perform();
	}

	public void addState() {

		CommonFunctions commonFunctions = new CommonFunctions(driver);

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(commonFunctions.getElement(Shared_OR.countryDropDown)));

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
		String actualNotification = commonFunctions.getText(Shared_OR.notification);
		if (actualNotification.equals("State added successfully.")) {
			System.out.println("State is added successfully");
		} else {
			System.out.println("Failed to add State");
		}
	}
}
