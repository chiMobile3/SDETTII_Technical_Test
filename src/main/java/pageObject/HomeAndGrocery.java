package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeAndGrocery {
    public HomeAndGrocery() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/ivExpand")
    List<WebElement> expandIcons;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvName")
    List<WebElement> hamburgerItems;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvCategoryBannerProdName")
    WebElement pageName;

    // TODO: This can be moved to utility.
    // Select an element from the navigation drawer.
    public void clickOnAnElementFromList(String text) {
        for (WebElement element : hamburgerItems) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    // Select the expand icon from 'Home & Grocery'.
    public void clickOnHomeAndGrocery() {
        expandIcons.get(1).click();
    }

    // Retrieve options page content.
    public String getOptionsPageContent() {
        return pageName.getText();
    }
}
