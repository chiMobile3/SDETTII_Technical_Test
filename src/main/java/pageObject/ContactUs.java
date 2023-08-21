package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;


public class ContactUs extends Common {
    public ContactUs() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    //----All the locators
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etName")
    WebElement inptBoxName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEmail")
    WebElement inptBoxEmail;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEnquiry")
    WebElement inptBoxEnquiry;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnSubmit")
    WebElement btnSubmit;


    //----------- Fill ContactUsForm
    public void FillContactUsForm(String name, String email, String enquiry) {
        inptBoxName.sendKeys(name);
        inptBoxEmail.sendKeys(email);
        inptBoxEnquiry.sendKeys(enquiry);
    }


    //----------- Submit Form
    public void ClickSubmit() {
        btnSubmit.click();
    }
}

