package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.List;

public class Home extends Common {
    public Home() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    WebElement btnAccept;
    @FindBy(className = "android.widget.ImageButton")
    List<WebElement> menuButton;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvProductName")
    List<WebElement> CategoryGroups;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories")
    WebElement pdName;
    @FindBy(className = "androidx.recyclerview.widget.RecyclerView")
    WebElement homeCategoriesContainer;

    //pop up window accept
    public void ClickAccept() {
        btnAccept.click();
    }

    //scroll category
    public void scrollCategory() throws InterruptedException {
        androidHorizontalScrollByText("com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories","Electronics");
    }
    //Select electronics

    public void clickEletronics() {
        CategoryGroups.get(1).click();

    }

}
