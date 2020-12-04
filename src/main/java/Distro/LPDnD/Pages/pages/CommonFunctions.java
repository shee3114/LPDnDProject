package Distro.LPDnD.Pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Distro.LPDnD.Pages.pages.login.dashboard.core.DistricoConstant;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.City.City_OR;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.Country.Country_OR;
import Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State.State_OR;

public class CommonFunctions {
	public WebDriver driver;
	public Actions actions;

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get the WebElement
	 * 
	 * @param locator Locator of webElement
	 * 
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			// get the webElement of locator
			element = driver.findElement(locator);

		} catch (NoSuchElementException e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
		return element;
	}

	/**
	 * click on WebElement
	 * 
	 * @param locator Locator of webElement
	 * 
	 */
	public void click(By locator) {
		// set the Element Name
		WebElement element = getElement(locator);
		try {
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to click element - '" + locator.toString() + "'"));
		}
	}

	/**
	 * Enter Data on WebElement
	 * 
	 * @param locator Locator of webElement
	 * @param data    that need to enter
	 * 
	 */

	public void enterData(By locator, String data) {
		WebElement element = getElement(locator);
		try {
			element.sendKeys(data);
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to enter data in - '" + locator.toString() + "'"));
		}
	}

	public String getText(By locator) {
		WebElement element = getElement(locator);
		String text = null;
		try {
			text = element.getText();
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to click element - '" + locator.toString() + "'"));
		}
		return text;
	}

	/**
	 * Move to Element by using actions class
	 * 
	 * @param locator Locator of webElement
	 * 
	 */
	public void moveToElement(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);

		try {
			actions.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
	}

	public void actionsClick(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);

		try {
			actions.click(element).perform();
		} catch (NoSuchElementException e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
	}

	public boolean isElmentDisplayed(By locator) {

		boolean flag = false;
		WebElement element = getElement(locator);
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {
			System.out.println(("Element not found - '" + locator.toString() + "'"));
		}
		return flag;
	}

	/*
	 * Method to select the value from drop-down
	 */
	public void selectValueFromDropdown(By dropDownLocator, String value) {

		WebElement element = getElement(dropDownLocator);

		// Initialization for the Select Class
		Select select = new Select(element);

		try {
			select.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			System.out.println(("Failed to select " + value + " from dropdown."));
		}
	}

	/*
	 * Method to Navigate the Particular page of Master Module
	 */
	public void navigateToModule(String page) {
		switch (page) {
		case DistricoConstant.COUNTRY:
			navigateToPage(Shared_OR.mastersMenu, Shared_OR.addressMenu, Country_OR.countryMenu);
			break;
		case DistricoConstant.STATE:
			navigateToPage(Shared_OR.mastersMenu, Shared_OR.addressMenu, State_OR.stateMenu);
			break;
		case DistricoConstant.CITY:
			navigateToPage(Shared_OR.mastersMenu, Shared_OR.addressMenu, City_OR.cityMenu);
			break;
		case DistricoConstant.DASHBOARD:
			click(Shared_OR.homeMenu);
			break;

		}
	}

	/*
	 * Navigate to page
	 */
	public void navigateToPage(By moduleName, By menu, By subMenu) {
		actions = new Actions(driver);

		moveToElement(moduleName);
		moveToElement(menu);
		actionsClick(subMenu);
		actions.build().perform();
	}

	/*
	 * Method to wait untill visibility of element
	 */
	public void waitTillVisbilityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			System.out.println((" " + locator.toString() + " Element is not visible."));
		}
	}

	/*
	 * Method to verify notification
	 */
	// Verify Notification
	public void verifyNotification(String Module, String expectedNotification) {
		String actualNotification = getText(Shared_OR.notification);
		if (actualNotification.equals(expectedNotification)) {
			System.out.println(Module + " is added successfully");
		} else {
			System.out.println("Failed to add " + Module);
		}
	}
}
