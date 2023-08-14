package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class ShippingMethod extends Common {
    public ShippingMethod() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /****************
     * Locators
     */
    @FindBy(className = "android.widget.ScrollView")
    WebElement scrolldown;
    @FindBy(className = "android.widget.RelativeLayout")
    List<WebElement> allCate;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement submitbutton;

    /*************
     * Actions
     */
    //scrolling to en element
    public void setScrolldown()  {
        verticalScroll(scrolldown,550);
    }
    //select the shipping method
    public void setAllCate() {
        allCate.get(4).click();
    }
    //submit shipping continue

    public void submitShipping(){
        submitbutton.click();
    }
}
