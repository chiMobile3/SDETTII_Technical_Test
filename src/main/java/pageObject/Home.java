package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class Home extends Common {
    public Home() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */
    @FindBy(id = "btnAccept")
    WebElement btnAccept;
    @FindBy(id = "tvProductName")
    List<WebElement> CategoryGroups;
    @FindBy(id = "navigation_bar_item_icon_view")
    List<WebElement> bottomNavMenu;
    @FindBy(id = "navigation_bar_item_small_label_view")
    List<WebElement> bottomNavText;

    // Click on Accept button to continue.
    public void ClickAccept() {
        btnAccept.click();
    }

    // Perform scroll by category value
    public void scrollByCategory(String category) {
        androidHorizontalScrollByText("com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories", category);
    }

    // Select category from dashboard.
    public void clickCategory(String category) {
        clickOnItemFromList(category, CategoryGroups);
    }

    // Retrieve 'Home' navigation element.
    public boolean validateUserDefaultScreen() {
        return (bottomNavMenu.get(1).isDisplayed());
    }

    // Click on bottom navigation menu item.
    public void selectBottomNavMenu(String bottomMenu) {
        clickOnItemFromList(bottomMenu, bottomNavText);
    }
}
