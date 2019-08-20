package demo;

import org.testng.annotations.Test;

import utils.TestDataReader;

public class DemoDataProvider {

	
	@Test(dataProvider = "getData", dataProviderClass = TestDataReader.class)
	public void printTestData(String emailId, String password) {
		System.out.println("Email Id- " + emailId);
		System.out.println("Password - " + password);
	}
}
