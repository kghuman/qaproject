package com.guru99Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.ElementControl;


public class LoginPage {
 
@CacheLookup
@FindBy(name="uid")
     private WebElement userName;

@FindBy(name="password")
private WebElement userPassword;

@FindBy(name = "btnLogin")
private WebElement loginButton;

@FindBy(name = "btnReset")
private WebElement resetButton;


    private ElementControl elementControl;
    
    
    public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  
elementControl = new ElementControl();
    
    
    
    }
    
    public void login(String sUsername, String sPassword) throws Exception{
    elementControl.setText(userName, sUsername);
    elementControl.setText(userPassword, sPassword);
    
    elementControl.clickElement(loginButton);
    
    
    
    }
}