package Steps;

import driver.PageDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.Home;

import java.time.Duration;

public class CommonSteps {

    Home homePage = new Home();

    @Given("^User clicks accept on login prompt$")
    public void acceptLoginPrompt() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(40));
        homePage.ClickAccept();
    }

    @Given("^User is on the Dashboard$")
    public void validateDefaultNavigation() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        Assert.assertTrue(homePage.validateUserDefaultScreen());
    }

    @When("User clicks on {string}")
    public void clickOnBottomNavMenu(String navText) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homePage.selectBottomNavMenu(navText);
    }
}
