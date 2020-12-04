package Scenarios.Suite.BaseSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Distro.LPDnD.Pages.pages.login.Login;

public class LPDndBaseSuite {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	public void launchBrowserAndNavigateToDistro() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation doc\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://lateralpraxis.in:82/LPDnD-DistriCo/Default.aspx");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Login login = new Login(driver);
		login.login();
	}

	@AfterSuite
	public void tearDown() {
		Login login = new Login(driver);
		login.louOut();
		driver.quit();
	}

}
