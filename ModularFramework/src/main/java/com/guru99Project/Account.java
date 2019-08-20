package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.ElementControl;
import commonLibs.implementations.DropdownControl;

public class Account {
    
@CacheLookup
@FindBy(name="cusid")
     private WebElement customerId;

@FindBy(name="selaccount")
     private WebElement selectAcount;

@FindBy(name="inideposit")
    private WebElement initialDeposit;

@FindBy(name="button2")
    private WebElement sumbitButton;


private DropdownControl dropdownControl;

    private ElementControl elementControl;
    
    
    public Account(WebDriver driver) {
    PageFactory.initElements(driver, this);
    
    dropdownControl = new DropdownControl(); 
elementControl = new ElementControl();
    
}
    public void createAccount() throws Exception{
    elementControl.setText(customerId, "1234");
    dropdownControl.selectViaVisibleText(selectAcount, "Savings");
    elementControl.setText(initialDeposit, "12345");
    elementControl.clickElement(sumbitButton);
    
    
}
}

