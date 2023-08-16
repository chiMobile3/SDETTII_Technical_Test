package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUS {

    public ContactUS() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/navigation_bar_item_small_label_view")
    List<WebElement> bottomNavText;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvOptionName")
    List<WebElement> bottomNavMoreList;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etName")
    WebElement conName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEmail")
    WebElement conEmail;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEnquiry")
    WebElement conEnquiry;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnSubmit")
    WebElement btnSubmit;

    // TODO: Move this common utility
    // To click on a specific item from list of elements.
    public void clickOnItemFromList(String text, List<WebElement> listOfItems) {
        for (WebElement element : listOfItems) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    // Populate the contact details.
    public void enterContactDetails(String name, String email, String enquiry) {
        conName.sendKeys(name);
        conEmail.sendKeys(email);
        conEnquiry.sendKeys(enquiry);
    }

    // Form Submission.
    public void clickOnSubmitButton() {
        btnSubmit.click();
    }

    // Selecting the bottom navigation bar elements.
    public void clickOnBottomMenuItem(String text) {
        clickOnItemFromList(text, bottomNavText);
    }

    // Handling the slide bar menu from 'More' menu item.
    public void ClickOnNavMoreList(String text) {
        clickOnItemFromList(text, bottomNavMoreList);
    }
}
