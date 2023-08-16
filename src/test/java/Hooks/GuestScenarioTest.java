package Hooks;

import driver.PageDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObject.ContactUS;
import pageObject.Home;
import pageObject.HomeAndGrocery;
import pageObject.Outdoor;
import utilities.ExcelDataParser;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class GuestScenarioTest {
    Home homepage = new Home();
    Outdoor outdoorPage = new Outdoor();
    HomeAndGrocery homeandgrocery = new HomeAndGrocery();
    ContactUS contactus = new ContactUS();
    SoftAssert softly = new SoftAssert();
    ExcelDataParser reader = new ExcelDataParser();

    /***********************************************
     * Scenario 1: Background common steps
     * *********************************************
     */

    @Given("^User clicks accept on login prompt$")
    public void user_clicks_accept_on_login_prompt() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(40));
        homepage.ClickAccept();
    }

    @Given("^User is on the Dashboard$")
    public void user_is_on_the_dashboard() {
        WebElement homeDefault = homepage.getHomeMenu();
        softly.assertTrue(homeDefault.isSelected());
    }

    /***********************************************
     * Scenario 1: User sorts the items
     * *********************************************
     */

    @When("^User chooses outdoor category$")
    public void user_chooses_category() throws InterruptedException {
        homepage.scrollCategory();
        homepage.clickOutdoor();
    }

    @When("^User sorts by lower price$")
    public void user_sorts_by_lower_price() {
        outdoorPage.clickSortView();
        outdoorPage.sortByLowerPrice();
    }

    @Then("^User validate the is sorted correctly$")
    public void user_validate_the_is_sorted_correctly() {
        List<String> listToSort = outdoorPage.getListBeforeSort();
        List<String> sortedList = outdoorPage.getSortedList(listToSort);
        softly.assertTrue(listToSort.equals(sortedList));
    }

    /***********************************************
     * Scenario 2 : User validates category options
     * *********************************************
     */

    //Scenario 2 : User validates category options
    @When("^User picks Category$")
    public void user_picks_category() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homepage.selectCategoryBottomMenu();

    }

    @When("^User clicks on Home and Grocery$")
    public void user_clicks_on_home_and_grocery() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homeandgrocery.clickOnHomeAndGrocery();
    }

    @Then("User enter en difference {string}")
    public void user_enter_en_difference(String string) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        System.out.println(string);
        homeandgrocery.clickOnAnElementFromList(string);
    }

    @Then("User is on {string} page")
    public void user_is_on_page(String string) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        String pageContent = homeandgrocery.getOptionsPageContent();
        softly.assertTrue(string.equalsIgnoreCase(pageContent));
    }

    /*************************************
     * Scenario 3 : User submits the form
     * ***********************************
     */


    @When("User clicks on {string}")
    public void user_clicks_on(String string) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        contactus.clickOnBottomMenuItem(string);
    }

    @When("User chooses {string}")
    public void user_chooses(String string) {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        contactus.ClickOnNavMoreList(string);
    }

    @Then("^User fills out the data$")
    public void user_fills_out_the_data() throws IOException, InvalidFormatException {
        List<Map<String, String>> testData = reader.getData("src/main/resources/ExcelData/guestScenario.xlsx", "contactus");
        String name = testData.get(0).get("Contact Name");
        String email = testData.get(0).get("Contact Email");
        String enquiry = testData.get(0).get("Contact Enquiry");
        contactus.enterContactDetails(name, email, enquiry);

    }

    @Then("^User submit the form$")
    public void user_submit_the_form() {
        contactus.clickOnSubmitButton();
    }
}
