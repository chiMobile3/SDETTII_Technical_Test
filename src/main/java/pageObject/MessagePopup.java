package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MessagePopup {
    public MessagePopup(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }

    /*********
     * Locators
     */
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/back_arrow")
    WebElement returnto;

    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_text_title")
    WebElement titletext;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_text_message")
    WebElement successtext;
    @FindBy(id= "com.nopstation.nopcommerce.nopstationcart:id/md_button_positive")
    WebElement Furthercontinue;

    /**********
     * Actions
     */

    public void messageShown() throws InterruptedException{
        Thread.sleep(2000);
        Furthercontinue.click();
    }

}
