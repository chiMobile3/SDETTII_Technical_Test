package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class ContactUS extends Common {

    public ContactUS() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */

    @FindBy(id = "tvOptionName")
    List<WebElement> bottomNavMoreList;
    @FindBy(id = "etName")
    WebElement conName;
    @FindBy(id = "etEmail")
    WebElement conEmail;
    @FindBy(id = "etEnquiry")
    WebElement conEnquiry;
    @FindBy(id = "btnSubmit")
    WebElement btnSubmit;

    // Populate the contact details.
    public void enterFormDetails() {
        sendText(conName, generateRandomString(6));
        sendText(conEmail, randomEmailGenerator());
        sendText(conEnquiry, generateRandomString(15));
    }

    // Form Submission.
    public void clickOnSubmitButton() {
        btnSubmit.click();
    }

    // Handling the slide bar navigation drawer from 'More' menu item.
    public void ClickOnNavMoreList(String navText) {
        clickOnItemFromList(navText, bottomNavMoreList);
    }
}
