package Steps;

import driver.PageDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.ContactUS;

import java.io.IOException;
import java.time.Duration;

public class ContactUsSteps {

    ContactUS contactUS = new ContactUS();

    @When("^User chooses \"([^\"]*)\"$")
    public void selectContactUsOption(String navMenuItem) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        contactUS.ClickOnNavMoreList(navMenuItem);
    }

    @Then("^User fills out the data$")
    public void fillFormDetails() throws IOException, InvalidFormatException {
        contactUS.enterFormDetails();
    }

    @Then("^User submit the form$")
    public void submitForm() {
        contactUS.clickOnSubmitButton();
    }
}
