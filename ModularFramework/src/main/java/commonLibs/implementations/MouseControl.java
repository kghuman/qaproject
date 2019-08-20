package commonLibs.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IMouseAction;

public class MouseControl implements IMouseAction {

	private WebDriver driver;

	public MouseControl(WebDriver driver) {
		this.driver = driver;
	}

	private Actions getActions() {
		Actions action = new Actions(driver);
		return action;
	}

	@Override
	public void dragAndDrop(WebElement source, WebElement target) throws Exception {
		getActions().dragAndDrop(source, target).build().perform();

	}

	@Override
	public void moveToElement(WebElement element) throws Exception {

		getActions().moveToElement(element).build().perform();

	}

	@Override
	public void rightClick(WebElement element) throws Exception {
		getActions().contextClick(element).build().perform();

	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		getActions().doubleClick(element).build().perform();

	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		getActions().moveToElement(element).click().build().perform();

	}
}