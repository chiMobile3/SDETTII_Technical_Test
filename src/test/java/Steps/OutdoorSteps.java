package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.Home;
import pageObject.Outdoor;

public class OutdoorSteps {

    Home homePage = new Home();
    Outdoor outdoorPage = new Outdoor();

    @When("^User chooses \"([^\"]*)\" category$")
    public void dashboardCategorySelection(String category) {
        homePage.scrollByCategory(category);
        homePage.clickCategory(category);
    }

    @When("^User sorts by \"([^\"]*)\"$")
    public void sortByLowerPrice(String sortValue) {
        outdoorPage.selectSortByValue(sortValue);
    }

    @Then("^User validate the value is sorted correctly$")
    public void validateSortedPrice() {
        Assert.assertTrue(outdoorPage.validateSorting());
    }
}
