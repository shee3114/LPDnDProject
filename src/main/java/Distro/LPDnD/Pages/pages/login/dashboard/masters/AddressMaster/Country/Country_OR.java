package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.Country;

import org.openqa.selenium.By;

public class Country_OR {

	public static By countryMenu = By.xpath("//a[contains(text(),'Country')]");

	public static By countryName = By.xpath("//input[contains(@id,'TextBoxCountry')]");

	public static By countryShortName = By.xpath("//input[contains(@id,'TextBoxShortName')]");

	public static By countryShortNameColumnData = By.xpath("//table[contains(@id,'GridViewCountry')]//tr/td[2]");

}
