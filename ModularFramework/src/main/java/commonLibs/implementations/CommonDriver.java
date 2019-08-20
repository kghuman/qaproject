
package commonLibs.implementations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {

	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.elementDetectionTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetionTimeot) {
		this.elementDetectionTimeout = elementDetionTimeot;
	}

	public CommonDriver(String browserType) throws Exception {
		pageloadTimeout = 30;
		elementDetectionTimeout = 10;

		browserType = browserType.trim();

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/kanwalpreetghuman/Desktop/Libs/chromedriver");
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/kanwalpreetghuman/Desktop/Libs/geckodriver");
			driver = new FirefoxDriver();

		} else {
			throw new Exception("Invalid Browser type: " + browserType);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		url = url.trim();
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);

	}

	@Override
	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {

		return getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {

		return getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		driver.navigate().to(url);

	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();
	}

	@Override
	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();

		}
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if (driver != null) {
			driver.quit();
		}

	}

}
