package Distro.LPDnD.Pages.pages.login;

import org.openqa.selenium.By;

public class Login_OR {

	public static By userName = By.xpath("//input[@id='LoginUser_UserName']");

	public static By password = By.xpath("//input[@id='LoginUser_Password']");

	public static By loginButton = By.xpath("//a[@id='LoginUser_LoginButton']");

	public static By logoutButton = By.xpath("//a[contains(@id,'LinkLogOut')]");

	public static By loginBox = By.xpath("//div[contains(@class,'loginbox')]");

}
