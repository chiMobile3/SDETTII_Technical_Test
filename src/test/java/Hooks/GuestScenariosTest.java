package Hooks;

import driver.PageDriver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import utilities.ExcelDataParser;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.io.IOException;


public class GuestScenariosTest {

    Home homePage = new Home();
    Outdoor outdoorPage = new Outdoor();
    More morePage = new More();
    ContactUs contactUsPage = new ContactUs();
    FoodAndGrocery foodAndGroceryPage = new FoodAndGrocery();
    MeatAndFish meatAndFishPage = new MeatAndFish();


    @Given("User clicks accept on login prompt")
    public void user_clicks_accept_on_login_prompt() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homePage.ClickAccept();
    }

    @Given("User is on the Dashboard")
    public void user_is_on_the_dashboard() {
        Assert.assertTrue(homePage.hamburgerMenuButton.isDisplayed());
    }

    @When("User chooses {string} category")
    public void user_chooses_category(String string) {
        homePage.ClickBottomBarMenuItem("Category");
        //homePage.ClickNevBtnCategory();
        homePage.ClickCategoryGroup("Outdoor");
    }

    @When("User sorts by lower price")
    public void user_sorts_by_lower_price() {
        outdoorPage.ClickSortBy();
        outdoorPage.ClickSortOption("Price: Low to High");

    }

    @Then("User validate the price is sorted correctly")
    public void user_validate_the_price_is_sorted_correctly() {
        Assert.assertTrue(outdoorPage.priceSortedLowToHigh());
    }

    //------------------- 2nd Scenario

    @When("User picks Category")
    public void user_picks_category() {
        homePage.ClickBottomBarMenuItem("Category");

    }

    @When("User clicks on Food and Grocery")
    public void user_clicks_on_food_and_grocery() {
        homePage.ClickCategoryGroup("Food & Grocery");
    }

    //-------------------------

    @When("User enter en difference {string}")
    public void user_enter_en_difference(String string) {
        foodAndGroceryPage.ClickFoodAndGroceryDropdownBtn();
        foodAndGroceryPage.ClickFoodAndGrocerySubGroup("Meat & Fish");
    }

    @Then("User is on {string} page")
    public void user_is_on_page(String string) {
        Assert.assertEquals("MEAT & FISH",meatAndFishPage.getCategoryBannerTxt());
    }

    //------------------- 3rd Scenario

    @When("User clicks on more")
    public void user_clicks_on_more() {
        homePage.ClickBottomBarMenuItem("More");
    }

    @When("User chooses contact us")
    public void user_chooses_contact_us() {
        morePage.ClickMoreMenuItem("Contact us");
    }


    @Then("User fills out the data")
    public void user_fills_out_the_data() {
        contactUsPage.FillContactUsForm("testname","test@test.com","test enquiry");
    }

    @Then("User submit the form")
    public void user_submit_the_form() {
        contactUsPage.ClickSubmit();
    }
}
