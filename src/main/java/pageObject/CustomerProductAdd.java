package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import java.util.List;

public class CustomerProductAdd extends Common {
    public CustomerProductAdd() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators of Customer Product addition
     */
    /********** Locators Inside Electronics ***********/
    @FindBy(className = "androidx.recyclerview.widget.RecyclerView")
    WebElement EcronicsPageScroll;
    String id = "com.nopstation.nopcommerce.nopstationcart:id/rvProductList";

    @FindBy(className = "android.widget.ImageButton")
    List<WebElement> Selectnokia;
    String text = "Nokia Lumia 1020";
    /*************
     * Locators Inside Product Nokia Lumia 1020
     * ***********/

    @FindBy(className = "android.view.ViewGroup")
    List<WebElement> sizeButton;
    @FindBy(className = "android.widget.RadioButton")
    List<WebElement> largeButton;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvDone")
    List<WebElement> doneButton;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnPlus")
    WebElement btnPlus;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")
    WebElement btnAddtoCart;


    /*****************
     * All the Actions
     */

    // This method will scroll down to the Nokia
    public void scrolltoNokia() {
        androidVerticalScrollToTextById(id,text);
    }
    //This method perform scroll down operation in a page
    public void scrollingDown() {
        MakeScrollDown();
    }

    // Here as per requirements  large will be selected
    public void DetailsPageSizeAction() {
        sizeButton.get(5).click();
        largeButton.get(1).click();
        doneButton.get(0).click();
    }

    //Quantity increased by 2
    public void DetailsPageaddAction() {
        btnPlus.click();
    }
   // This is method adds item to the cart
    public void AddtoCartButton() {
        btnAddtoCart.click();
    }
}
















//        verticalScroll(EcronicsPageScroll,400);
//        verticalScroll(EcronicsPageScroll,400);
// This method will navigate to nokia page
//    public void selectNokia() {
//        Selectnokia.get(1).click();
////       System.out.println(Selectnokia.size());
//
//    }