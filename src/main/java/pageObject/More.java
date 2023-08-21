package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import java.util.List;

public class More extends Common {
    public More() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    //----All the locators
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvOptionName")
    List<WebElement> moreMenuItems;

    //-------------- Select SortOption
    public void ClickMoreMenuItem(String value) {
        for(WebElement moreMenuItem : moreMenuItems) {
            System.out.println("CategoryGroups- "+moreMenuItem.getText());
            if(moreMenuItem.getText().equals(value)) {
                moreMenuItem.click();
                break;
            }
        }
    }

}

