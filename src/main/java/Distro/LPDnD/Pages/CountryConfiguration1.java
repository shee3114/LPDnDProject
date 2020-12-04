package Distro.LPDnD.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountryConfiguration1 {
	WebDriver driver;
	Actions actions;
	Alert alert;

	@BeforeSuite
	public void launchBrowserAndNavigateToLPDnD() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation doc\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://lateralpraxis.in:82/LPDnD-DistriCo/Default.aspx");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void login() {
		// Enter Login credentials
		WebElement userName = driver.findElement(By.xpath("//input[@id='LoginUser_UserName']"));
		userName.sendKeys("lpdndadmin");

		WebElement password = driver.findElement(By.xpath("//input[@id='LoginUser_Password']"));
		password.sendKeys("pass@123");

		// Click on Login button
		WebElement loginButton = driver.findElement(By.xpath("//a[@id='LoginUser_LoginButton']"));
		loginButton.click();

	}

	@Test(priority = 1)
	public void NavigateToCountryMaster() {

		WebElement mastersMenu = driver.findElement(By.xpath("//a[contains(text(),'Masters')]"));

		WebElement addressMenu = driver.findElement(By.xpath("//a[contains(text(),'Address')]"));

		WebElement countryMenu = driver.findElement(By.xpath("//a[contains(text(),'Country')]"));

		actions = new Actions(driver);

		actions.moveToElement(mastersMenu);
		actions.moveToElement(addressMenu);
		actions.click(countryMenu);
		actions.build().perform();
	}

	@Test(priority = 2)
	public void addCountry() {

		// Add Data to "Country Name" field
		WebElement countryName = driver.findElement(By.xpath("//input[contains(@id,'TextBoxCountry')]"));
		countryName.sendKeys("Australia");

		// Add Data to "Short Name" field
		WebElement countryShortName = driver.findElement(By.xpath("//input[contains(@id,'TextBoxShortName')]"));
		countryShortName.sendKeys("AUS");

		// Click on Add Button
		WebElement addBtn = driver.findElement(By.xpath("//span[text()='Add']"));
		addBtn.click();

		// Verify Notification
		WebElement Notification = driver.findElement(By.xpath("//span[contains(@id,'LabelExceptionMessage')]"));
		String actualNotification = Notification.getText();
		if (actualNotification.equals("Country added successfully.")) {
			System.out.println("Country is added successfully");
		} else {
			System.out.println("Failed to add Country");
		}
	}

	@Test(priority = 3)
	public void deleteCountry() {
		WebElement deleteBtn = driver.findElement(By.xpath("(//a[contains(@id,'Delete')])[1]"));
		deleteBtn.click();

		alert = driver.switchTo().alert();
		alert.accept();
		WebElement Notification = driver.findElement(By.xpath("//span[contains(@id,'LabelExceptionMessage')]"));
		String actualNotification = Notification.getText();
		if (actualNotification.equals("Country removed successfully.")) {
			System.out.println("Country is removed successfully");
		} else {
			System.out.println("Failed to remove Country");
		}

	}

	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}

}
