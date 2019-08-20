package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.ElementControl;

public class HomePage {

@CacheLookup
@FindBy(linkText="New Customer")
     private WebElement customerButton;

@FindBy(linkText="Edit Customer")
    private WebElement editCustomer;
    
@FindBy(linkText="Delete Customer")
    private WebElement deleteCustomer;

@FindBy(linkText=" New Account")
    private WebElement newAccount;

@FindBy(linkText=" Edit Account")
    private WebElement editAccount;

@FindBy(linkText=" Delete Account")
    private WebElement deleteAccount;

@FindBy(linkText=" Deposit")
    private WebElement deposit;

@FindBy(linkText=" Withdrawal")
    private WebElement withdrawal;


    private ElementControl elementControl;
    
    
    public HomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    
    
elementControl = new ElementControl();
    
    }
    
    public void navigateCustomerpage() throws Exception{
    
    elementControl.clickElement(customerButton);
    elementControl.clickElement(editCustomer);
    elementControl.clickElement(deleteCustomer);
    elementControl.clickElement(newAccount);
    elementControl.clickElement(editAccount);
    elementControl.clickElement(deleteAccount);
    elementControl.clickElement(deposit);
    elementControl.clickElement(withdrawal);
    
    
    
    
    
    }
}