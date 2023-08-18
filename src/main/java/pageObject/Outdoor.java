package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

import java.util.ArrayList;
import java.util.List;

public class Outdoor extends Common {
    public Outdoor() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */
    @FindBy(xpath = "(//*[@content-desc=\"Placeholder\"])[2]")
    WebElement sortView;
    @FindBy(id = "otherAttrText")
    List<WebElement> sortByItems;
    @FindBy(id = "tvProductPrice")
    List<WebElement> productPrices;

    //Click Sort View Image
    public void selectSortByValue(String sortValue) {
        sortView.click();
        clickOnItemFromList(sortValue, sortByItems);
    }

    //Select Low Price
    public void sortByLowerPrice() {
        sortByItems.get(2).click();
    }

    // Extract List of product prices using Java Stream
    public List<String> getListBeforeSort() {
        List<String> listBeforeSort = new ArrayList<String>();
        for (WebElement e : productPrices) {
            listBeforeSort.add(e.getText());
        }
        return listBeforeSort;
    }

    public boolean validateSorting() {
        List<String> listToSort = getListBeforeSort();
        List<String> sortedList = getSortedList(listToSort);
        return listToSort.equals(sortedList);
    }
}
