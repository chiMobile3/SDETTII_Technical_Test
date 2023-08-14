package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GuestCustomer {
    public GuestCustomer() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /********************
     * Locators
     */
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/ivAddToFav")
    List<WebElement> addlumiaButton;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/menu_cart")
    WebElement menuCartbtn;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")
    WebElement btnCheckout;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")
    WebElement guestbtnCheckout;


    /********************
     * Actions
     */
    //
//    public void lumiaButton() {
//        addlumiaButton.get(0).click();
//    }

    //Click shopt cart icon
    public void ClickMenu() {
        menuCartbtn.click();
    }
//clicks chekout
    public void ClickcheckOut() {
        btnCheckout.click();
    }
// introduced as a guest
    public void ClickGuestbutton() {
        guestbtnCheckout.click();
    }

}
