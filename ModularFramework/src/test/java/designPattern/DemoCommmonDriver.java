package designPattern;

import org.testng.annotations.Test;

import commonLibs.implementations.CommonDriver;

public class DemoCommmonDriver {

	@Test
	public void verifyCommonDriver() throws Exception {
		CommonDriver cmnDriver = new CommonDriver("chrome");

		cmnDriver.navigateToFirstUrl("https://qatechhub.com");
		String title = cmnDriver.getTitle();
		System.out.println("Title- " + title);
		cmnDriver.closeAllBrowsers();

	}
}
