package Distro.LPDnD.Pages.pages.login.dashboard.masters.AddressMaster.State;

import org.openqa.selenium.By;

public class State_OR {

	public static By stateMenu = By.xpath("//a[contains(text(),'State')]");

	public static By stateName = By.xpath("//input[contains(@name,'BoxState')]");

	public static By stateShortName = By.xpath("//input[contains(@name,'BoxShortName')]");

	public static By gstCode = By.xpath("//input[contains(@name,'BoxGSTCode')]");

}
