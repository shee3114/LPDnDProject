package Distro.LPDnD.Pages.pages;

import org.openqa.selenium.By;

public class Shared_OR {

	public static By mastersMenu = By.xpath("//a[contains(text(),'Masters')]");

	public static By addressMenu = By.xpath("//a[contains(text(),'Address')]");

	public static By homeMenu = By.xpath("//a[contains(text(),'Home')]");

	public static By notification = By.xpath("//span[contains(@id,'LabelExceptionMessage')]");

	public static By deleteBtn = By.xpath("//a[contains(@id,'Delete')]");

	public static By addBtn = By.xpath("//span[text()='Add']");

	public static By countryDropDown = By.xpath("//select[contains(@id,'ListCountry')]");

	public static By stateDropDown = By.xpath("//select[contains(@id,'ListState')]");

}
