package commonLibs.implementations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropdownControl implements IDropdown{

private Select getSelect(WebElement element) {
Select select = new Select(element);
return select;
}

@Override
public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {

getSelect(element).selectByVisibleText(visibleText);
}

@Override
public void selectViaValue(WebElement element, String value) throws Exception {
getSelect(element).selectByValue(value);

}

@Override
public void selectViaIndex(WebElement element, int index) throws Exception {
getSelect(element).selectByIndex(index);

}

}