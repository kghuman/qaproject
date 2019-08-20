package in.amazon.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import in.amazon.pages.Homepage;

public class HomepageTests extends BaseTest {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {

		extentTest = extentReport.createTest("TC -Verify Title of the page ");

		String actualTitle = cmnDriver.getTitle();

		extentTest.log(Status.INFO, "Actual Title: " + actualTitle);

		String expectedTitle = "Amazon Home Page";

		extentTest.log(Status.INFO, "Expected Title: " + expectedTitle);

		AssertJUnit.assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 1000)
	public void verifyProductsearch() throws Exception {

		extentTest = extentReport.createTest("TC -Verify Product Search ");

		homepage = new Homepage(driver);

		String product = "Apple Watch";
		String category = "Electronics";

		extentTest.log(Status.INFO, "Product: " + product);
		extentTest.log(Status.INFO, "Category: " + category);

		homepage.searchProduct(product, category);

	}
}
