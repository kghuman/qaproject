package in.amazon.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;
import in.amazon.pages.Homepage;
import in.amazon.utils.ConfigFileReader;

public class BaseTest {

CommonDriver cmnDriver;
Homepage homepage;
ScreenshotControl screenshotControl;

ExtentHtmlReporter htmlReporter;
ExtentReports extentReport;
ExtentTest extentTest;

String executionStartTime;
String currentWorkingDirectory;
String reportFilename;

Properties configProperty;
String configFileName;


String browserType;
String baseUrl;

WebDriver driver;

@BeforeSuite
public void beforeSuite() throws Exception {

initializeExcutionStartTime();
initializeCurrentWorkingDirectory();
initializeconfigProperty();
initializeExtentReport();


}

private void initializeconfigProperty() throws Exception {
configFileName = String.format("%s/config.config.properties", currentWorkingDirectory);
configProperty = ConfigFileReader.readConfigProperties(configFileName);
}
@BeforeClass
public void setup() throws Exception {

extentTest = extentReport.createTest("TC - Setting up the tests");

invokeBrowser(baseUrl);
initializeScreenshotVaraiable();
}


@AfterClass
public void cleanup() throws Exception {
extentTest = extentReport.createTest("TC - Clearing up the tests");
extentTest.log(Status.INFO, "Closing the browser: ");

cmnDriver.closeAllBrowsers();
}

@AfterMethod
public void afterATestcase(ITestResult result) throws Exception {

String testcaseName = result.getName();
String filename = String.format("%s/screenshots/%s_%s.jpeg",currentWorkingDirectory, testcaseName, executionStartTime);

if (result.getStatus() == ITestResult.FAILURE) {
screenshotControl.captureAndSaveScreenshot(filename);

extentTest.log(Status.FAIL, "Failed testcase: " + testcaseName);
extentTest.addScreenCaptureFromPath(filename);
} else if (result.getStatus() == ITestResult.SKIP)

{
extentTest.log(Status.SKIP, "Skipprd testcase: " + testcaseName);

}
}

@AfterSuite
public void postCleanup() {
extentReport.flush();
}
private void initializeExtentReport() {
extentReport = new ExtentReports();
extentReport.attachReporter(htmlReporter);

}

private void initializeCurrentWorkingDirectory() {

currentWorkingDirectory = System.getProperty("user.dir");

reportFilename = String.format("%s/reports/AmazonTestReports_%s.html", currentWorkingDirectory,
executionStartTime);

htmlReporter = new ExtentHtmlReporter(reportFilename);

}

private void initializeExcutionStartTime() {
Date date = new Date();
        executionStartTime = String.valueOf(date.getTime());

}

  private void initializeScreenshotVaraiable() {

screenshotControl = new ScreenshotControl(driver);
}


private void invokeBrowser(String baseUrl) throws Exception {
browserType = "browserType";

extentTest.log(Status.INFO, "Initializing Browser: " + browserType);

cmnDriver = new CommonDriver("chrome");

int pageloadtimeout = Integer.parseInt(configProperty.getProperty("pageloadtimeout"));
extentTest.log(Status.INFO, "Pageload Timeout: " + pageloadtimeout);
cmnDriver.setPageloadTimeout(pageloadtimeout);

int implicitWait = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
extentTest.log(Status.INFO, "Pageload Timeout: " + implicitWait);
cmnDriver.setElementDetectionTimeout(implicitWait);

baseUrl = configProperty.getProperty("baseUrl");
extentTest.log(Status.INFO,"URL : " + baseUrl);
cmnDriver.navigateToFirstUrl(baseUrl);

driver = cmnDriver.getDriver();

}



}