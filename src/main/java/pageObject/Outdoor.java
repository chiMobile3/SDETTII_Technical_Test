package pageObject;

import driver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Outdoor {
    public Outdoor() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    /***************
     * All the locators
     */
    @FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Placeholder\"])[2]")
    WebElement sortView;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/otherAttrText")
    List<WebElement> sortByItems;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvProductPrice")
    List<WebElement> productPrices;

    //Click Sort View Image
    public void clickSortView() {
        sortView.click();
    }

    //Select Low Price
    public void sortByLowerPrice() {
        sortByItems.get(2).click();
    }

    // Extract List of product prices using Java Stream
    public List<String> getListBeforeSort() {
        return productPrices.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
    }

    // TODO: Move this common utility.
    // Return sorted list of items.
    public List<String> getSortedList(List<String> listToSort) {
        Collections.sort(listToSort);
        return listToSort;
    }
}
