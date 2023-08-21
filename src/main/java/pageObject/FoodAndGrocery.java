package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import java.util.List;

public class FoodAndGrocery extends Common {
    public FoodAndGrocery() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    //----All the locators
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/categoryNameTextView")
    WebElement dropdownBtnFoodAndGrocery;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/topCategoryName")
    List<WebElement> foodAndGrocerySubGroups;


    //click FoodAndGrocery dropdownBtn
    public void ClickFoodAndGroceryDropdownBtn() {
        dropdownBtnFoodAndGrocery.click();
    }

    //-------------- Select SortOption
    public void ClickFoodAndGrocerySubGroup(String value) {
        for(WebElement foodAndGrocerySubGroup : foodAndGrocerySubGroups) {
            System.out.println("FoodAndGrocerySubGroup- "+foodAndGrocerySubGroup.getText());
            if(foodAndGrocerySubGroup.getText().equals(value)) {
                foodAndGrocerySubGroup.click();
                break;
            }
        }
    }
}

