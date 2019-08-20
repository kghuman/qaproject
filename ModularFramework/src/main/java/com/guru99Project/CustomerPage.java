package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.DropdownControl;
import commonLibs.implementations.ElementControl;

public class CustomerPage {

	@CacheLookup
	@FindBy(name = "name")
	private WebElement Name;

	@FindBy(xpath = "//input [@value='m']")
	private WebElement gender;

	@FindBy(name = "dob")
	private WebElement dob;

	@FindBy(name = "addr")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "pinno")
	private WebElement pinNumber;

	@FindBy(name = "telephoneno")
	private WebElement telephoneNumber;

	@FindBy(name = "emailid")
	private WebElement emailId;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitButton;

	private DropdownControl dropdownControl;

	private ElementControl elementControl;

	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

		dropdownControl = new DropdownControl();
		elementControl = new ElementControl();

	}

	public void addCustomer() throws Exception {
		elementControl.setText(Name, "abc");

		elementControl.setText(gender, "m");

		dropdownControl.selectViaValue(dob, "01/01/1994");

		elementControl.setText(address, "12 street");

		elementControl.setText(city, "union city");

		elementControl.setText(state, "CA");

		elementControl.setText(pinNumber, "123456");

		elementControl.setText(telephoneNumber, "123456789");

		elementControl.setText(emailId, "avc@gmail.com");

		elementControl.setText(password, "agama123");

		elementControl.clickElement(submitButton);

	}
}