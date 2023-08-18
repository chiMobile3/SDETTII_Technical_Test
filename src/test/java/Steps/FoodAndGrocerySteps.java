package Steps;

import driver.PageDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.FoodAndGrocery;

import java.io.IOException;
import java.time.Duration;

public class FoodAndGrocerySteps {

    FoodAndGrocery foodAndGrocery = new FoodAndGrocery();

    @When("^User clicks on Food & Grocery$")
    public void clickOnExpandIcon() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        foodAndGrocery.clickOnFoodAndGrocery();
    }

    @Then("^User enters different options from \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectHomeAndGroceryOptions(String excelSheet, Integer rowNum) throws IOException, InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        foodAndGrocery.selectOptionsReadFromFile(excelSheet, rowNum);
    }

    @Then("^User validates the displayed page content with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void validateGroceryOptionsPage(String excelSheet, Integer rowNum) throws IOException, InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        Assert.assertTrue(foodAndGrocery.getOptionsPageContent(excelSheet, rowNum));
    }
}
