package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;
import java.util.Set;

public class Payment extends Common {

public Payment(){
    PageFactory.initElements(PageDriver.getCurrentDriver(),this);
}

    /*****************
     * Locators
     */
    @FindBy(className= "android.widget.Button")
    WebElement nextbutton;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/checkoutButton")
    WebElement confirmbtn;
   @FindBy(id = "PhoneNumber")
   WebElement phoneno;
   @FindBy(id = "TransactionId")
   WebElement transactionid;
   @FindBy(className = "android.widget.EditText")
   List<WebElement> inputs;


    /********************
     * Actions
     */

    // It switches Native app to webview and clicks next button
    public void switchToWebView(String phone,String tsi) throws InterruptedException {
        Set<String> contextNames = PageDriver.getCurrentDriver().getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        PageDriver.getCurrentDriver().context("NATIVE_APP"); // set context to NATIVE_APP
        Thread.sleep(4000);
        sendText(inputs.get(0),phone);
        sendText(inputs.get(1),tsi);
        nextbutton.click();
    }


    //Order Confirm
    public void finalConfirm(){
        confirmbtn.click();
    }
    //Success message


}
