package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class MoneyOrder extends Common {
    public MoneyOrder(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }

    /**************
     * Locators
     */
    @FindBy(className = "android.widget.ScrollView")
    WebElement scrolldown;
    String method = "Rocket";

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement submitbutton;

    /****************
     * Actions

     */

//select nagad


//Scrolls down
    public void ScrolldownSelectRocket()  {
        androidScrollToAnElementByText(method);

    }

    public void Scroll() {
        verticalScroll(scrolldown,100);
    }

    //Submits the payment way
    public void submitMoneyrder(){
        submitbutton.click();
    }

}
