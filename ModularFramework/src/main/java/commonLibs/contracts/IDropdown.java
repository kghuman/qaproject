package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IDropdown {

	void selectViaVisibleText(WebElement element, String visibleText) throws Exception;

	void selectViaValue(WebElement element, String value) throws Exception;

	void selectViaIndex(WebElement element, int index) throws Exception;

}
