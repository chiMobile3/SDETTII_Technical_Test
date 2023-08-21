package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MeatAndFish extends Common {
    public MeatAndFish() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    //----All the locators
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvCategoryBannerProdName")
    public WebElement categoryBanner;

    public String getCategoryBannerTxt(){
        return categoryBanner.getText();
    }

}

