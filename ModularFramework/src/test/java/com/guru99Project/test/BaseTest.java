package com.guru99Project.test;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru99Project.CustomerPage;
import com.guru99Project.HomePage;
import com.guru99Project.LoginPage;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;

public class BaseTest {

	CommonDriver cmnDriver;
	LoginPage loginPage;
	HomePage homePage;
	CustomerPage customerPage;

	ScreenshotControl screenshotControl;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest extentTest;

	String executionStartTime;
	String currentWorkingDirectory;
	String reportFilename;

	String browserType;
	String baseUrl;

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		initializeExecutionStartTime();

		initializeCurrentWorkingDirectory();

		initializeExtentReport();

	}

	@BeforeClass
	public void setup() throws Exception {

		extentTest = extentReport.createTest("TC - Setting up the tests");
		invokeBrowser();
		initializeScreenshotvariable();
	}

	private void invokeBrowser() throws Exception {
		browserType = "chrome";

		extentTest.info("Browser Used - " + browserType);

		cmnDriver = new CommonDriver("chrome");

		int pageloadtimeout = 20;

		cmnDriver.setPageloadTimeout(pageloadtimeout);

		int implicitWait = 10;
		extentTest.info("Pageload Timeout: " + implicitWait);
		cmnDriver.setElementDetectionTimeout(implicitWait);

		baseUrl = "http://demo.guru99.com/v4";
		cmnDriver.navigateToFirstUrl(baseUrl);

		driver = cmnDriver.getDriver();

	}

	@AfterClass
	public void cleanup() throws Exception {
		extentTest = extentReport.createTest("TC - Clearing up the tests");
		extentTest.info("Closing the browser: ");

		cmnDriver.closeAllBrowsers();
	}

	@AfterMethod
	public void afterATestcase(ITestResult result) throws Exception {

		String testcaseName = result.getName();
		String filename = String.format("%s/screenshots/%s_%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartTime);

		if (result.getStatus() == ITestResult.FAILURE) {
			screenshotControl.captureAndSaveScreenshot(filename);

			extentTest.fail("Failed testcase: " + testcaseName);
			extentTest.addScreenCaptureFromPath(filename);
		} else if (result.getStatus() == ITestResult.SKIP)

		{
			extentTest.skip("Skipprd testcase: " + testcaseName);

		}
	}

	@AfterSuite
	public void postCleanup() {
		extentReport.flush();
	}

	private void initializeExtentReport() {
		htmlReporter = new ExtentHtmlReporter(reportFilename);

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);

	}

	private void initializeCurrentWorkingDirectory() {
		currentWorkingDirectory = System.getProperty("user.dir");

		reportFilename = String.format("%s/reports/Guru99Report_%s.html", currentWorkingDirectory, executionStartTime);

	}

	private void initializeExecutionStartTime() {
		Date date = new Date();
		executionStartTime = String.valueOf(date.getTime());
	}

	private void initializeScreenshotvariable(){

	
		screenshotControl = new ScreenshotControl(driver);

	}
}
