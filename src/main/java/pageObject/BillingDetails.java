package pageObject;

import driver.PageDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class BillingDetails extends Common {
    public BillingDetails() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /**********
     * Locators for billing
     */

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etFirstName")
    WebElement inputfirstName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etLastName")
    WebElement inputlastName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEmail")
    WebElement inputemail;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")
    WebElement countrySelect;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/stateSpinner")
    WebElement stateSelect;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")
    WebElement inputcompanyName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCity")
    WebElement inputcity;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")
    WebElement inputaddress1;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2")
    WebElement inputaddress2;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etZipCode")
    WebElement inputzip;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etPhone")
    WebElement inputPhone;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etFax")
    WebElement inputFax;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement submittoContinue;
    /**************** */
    @FindBy(className = "android.widget.ListView")
    WebElement listView;
    //android.widget.TextView
    @FindBy(id = "android:id/text1")
    List<WebElement> Selectcountrybyindex;
    @FindBy(id = "android:id/text1")
    List<WebElement> Selectstatebyindex;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/rootScrollViewBillingAddress")
    WebElement scrollForm;

    /***********
     * Actions
     */
    //pass input value for fname, lname, email
    public void billingHandler(String fname, String lname, String email) {
        sendText(inputfirstName, fname);
        sendText(inputlastName, lname);
        sendText(inputemail, email);

    }
    //Select value for country and state
    public void ScrollingintoCountry(int country, int state) {
        countrySelect.click();
//        verticalScroll(listView,180);
//        verticalScroll(listView,100);
        androidScrollToAnElementByText("Bangladesh");
//        Selectcountrybyindex.get(country).click();
        stateSelect.click();
        Selectstatebyindex.get(state).click();


    }
    //Input value for rest of the inputs in the form

    public void BillingSecondInput(String company, String city, String add1, String add2, String zip, String phone, String fax) throws InterruptedException {
        sendText(inputcompanyName, company);
        Thread.sleep(3000);
        verticalScroll(scrollForm,200);
        sendText(inputcity, city);
        sendText(inputaddress1, add1);
        sendText(inputaddress2, add2);
        sendText(inputzip, zip);
        sendText(inputPhone, phone);
        sendText(inputFax, fax);
    }
//submit for further step
    public void submitContinue() {
        submittoContinue.click();
    }
}
