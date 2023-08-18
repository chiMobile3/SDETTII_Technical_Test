package pageObject;

import driver.PageDriver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;
import utilities.ExcelDataParser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FoodAndGrocery extends Common {
    public FoodAndGrocery() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }


    ExcelDataParser reader = new ExcelDataParser();

    /***************
     * All the locators
     */

    @FindBy(id = "ivExpand")
    List<WebElement> expandIcons;
    @FindBy(id = "tvName")
    List<WebElement> hamburgerItems;
    @FindBy(id = "tvCategoryBannerProdName")
    WebElement pageName;

    // Select the expand icon from 'Home & Grocery'.
    public void clickOnFoodAndGrocery() {
        expandIcons.get(1).click();
    }

    // Retrieve options page content.
    public boolean getOptionsPageContent(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        String option =getOptionsFromExcelSheet(sheetName, rowNumber);
        return pageName.getText().equalsIgnoreCase(option);
    }

    public String getOptionsFromExcelSheet(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String, String>> testData =
                reader.getData("src/main/resources/ExcelData/guestScenario.xlsx", sheetName);
        return testData.get(rowNumber).get("Options").trim();
    }

    public void selectOptionsReadFromFile(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        String option = getOptionsFromExcelSheet(sheetName,rowNumber);
        clickOnItemFromList(option, hamburgerItems);
    }
}
