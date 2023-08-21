package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Outdoor extends Common {

    public Outdoor() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }


    //----All the locators
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvSortBy")
    WebElement btnASortBy;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/otherAttrText")
    List<WebElement> SortOptions;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvProductPrice")
    List<WebElement> lowToHighPriceGroups;

    //---- Click on SoryBy button
    public void ClickSortBy() {
        btnASortBy.click();
    }

    //-------------- Select SortOption
    public void ClickSortOption(String value) {
        for(WebElement SortOption : SortOptions) {
            System.out.println("CategoryGroups- "+SortOption.getText());
            if(SortOption.getText().equals(value)) {
                SortOption.click();
                break;
            }
        }
    }

    // ---------- Validate lowToHighPrice sort
    public boolean priceSortedLowToHigh() {
        List sortedPriceInApp= new ArrayList();
        for(WebElement lowToHighPriceGroup : lowToHighPriceGroups) {
            sortedPriceInApp.add(lowToHighPriceGroup.getText());
        }
        System.out.println("Sorted price list- "+sortedPriceInApp);
        List<String> sortPrice =new ArrayList<String>(sortedPriceInApp);
        Collections.sort(sortPrice);                           // Again Sort thr price
        System.out.println("sortPrice- "+sortPrice);
        boolean isSorted = sortPrice.equals(sortedPriceInApp);  //compare the sorted price with sorted price in the App
        return isSorted;
    }



}

