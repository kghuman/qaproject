package com.guru99Project.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.guru99Project.LoginPage;

public class Guru99Test extends BaseTest {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {
		extentTest = extentReport.createTest("TC -Verify Title of the page ");

		String actualTitle = cmnDriver.getTitle();

		extentTest.log(Status.INFO, "Actual Title: " + actualTitle);

		String expectedTitle = "Demo Guru99";

		extentTest.log(Status.INFO, "Expected Title: " + expectedTitle);

		AssertJUnit.assertEquals(actualTitle, expectedTitle);

	}

	@Parameters({ "user", "pass" })
	@Test(priority = 10000)
	public void verifyLoginWithCorrectCredentials(String username, String password) throws Exception {
		extentTest = extentReport.createTest("TC -Verify User login ");

		loginPage.login(username, password);

//To do  :: write the logic of getting username from the homepage

		String managerIdText = driver.findElement(By.xpath("//td[contains(text(), 'Manger Id :')]\r\n" + "")).getText();
		String actualMangerId = managerIdText.split(":")[1].trim();

		loginPage = new LoginPage(driver);

	}

}
