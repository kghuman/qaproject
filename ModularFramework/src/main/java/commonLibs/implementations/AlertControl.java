package commonLibs.implementations;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IAlerts; //github change 

public class AlertControl implements IAlerts {
	private WebDriver driver;

	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}
	@Override
	public void acceptAlert() throws Exception {
	driver.switchTo().alert().accept();
		
	}

	@Override
	public void rejectAlert() throws Exception {
		driver.switchTo().alert().dismiss();
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		return driver.switchTo().alert().getText();
		
	}

	@Override
	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		driver.switchTo().alert();
		return false;
	}

}
