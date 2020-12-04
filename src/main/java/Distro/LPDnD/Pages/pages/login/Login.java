package Distro.LPDnD.Pages.pages.login;

import org.openqa.selenium.WebDriver;

import Distro.LPDnD.Pages.pages.CommonFunctions;

public class Login {
	public WebDriver driver;
	public CommonFunctions commonFunctions;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {

		commonFunctions = new CommonFunctions(driver);

		// Enter Login credential
		commonFunctions.enterData(Login_OR.userName, "lpdndadmin");

		commonFunctions.enterData(Login_OR.password, "pass@123");

		// Click on Login button
		commonFunctions.click(Login_OR.loginButton);
	}

	public void louOut() {
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.click(Login_OR.logoutButton);

		// Check if the login Box is showing or not
		boolean flag = commonFunctions.isElmentDisplayed(Login_OR.loginBox);
		if (flag) {
			System.out.println("The User is successfully logout");
		} else {
			System.out.println("Fail to logout");
		}

	}

}
