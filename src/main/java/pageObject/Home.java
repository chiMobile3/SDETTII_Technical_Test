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
    //---------------------------
    @FindBy(className = "android.widget.ImageButton")
    public WebElement hamburgerMenuButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Category\"]/android.view.ViewGroup/android.widget.TextView")
    public WebElement nevBtnCategory;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/navigation_bar_item_small_label_view")
    List<WebElement> bottomBarMenuItems;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvName")
    List<WebElement> categoryGroups;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories")
    WebElement pdName;
    @FindBy(className = "androidx.recyclerview.widget.RecyclerView")
    WebElement homeCategoriesContainer;

    //pop up window accept
    public void ClickAccept() {
        btnAccept.click();
    }

    //public void ClickNevBtnCategory() {
    //   nevBtnCategory.click();
    //}

    //-------------- Select bottom Nev Menu
    public void ClickBottomBarMenuItem(String value) {
        for(WebElement BottomBarMenuItem : bottomBarMenuItems) {
            System.out.println("BottomBarMenuItem- "+BottomBarMenuItem.getText());
            if(BottomBarMenuItem.getText().equals(value)) {
                BottomBarMenuItem.click();
                break;
            }
        }
    }

    //-------------- Select CategoryGroups
    public void ClickCategoryGroup(String value) {
        for(WebElement categoryGroup : categoryGroups) {
            System.out.println("CategoryGroups- "+categoryGroup.getText());
            if(categoryGroup.getText().equals(value)) {
                categoryGroup.click();
                break;
            }
        }
    }

    //scroll category
    public void scrollCategory() throws InterruptedException {
        androidHorizontalScrollByText("com.nopstation.nopcommerce.nopstationcart:id/rvHomeCategories","Electronics");
    }
    //Select electronics

    public void clickEletronics() {
        categoryGroups.get(1).click();

    }

}
