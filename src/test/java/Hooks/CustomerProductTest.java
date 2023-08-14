package Hooks;

import driver.PageDriver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageObject.*;
import utilities.ExcelDataParser;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class CustomerProductTest {

    /************
     * All the instances for class
     */
    Home homepage = new Home();
    CustomerProductAdd product_Page = new CustomerProductAdd();
    GuestCustomer customer = new GuestCustomer();
    BillingDetails billing = new BillingDetails();
    ShippingMethod shipping = new ShippingMethod();
    MoneyOrder moneyorder = new MoneyOrder();
    Payment paymentprocess = new Payment();
    MessagePopup messagepopup =new MessagePopup();
    SoftAssert softly = new SoftAssert();
    ExcelDataParser reader = new ExcelDataParser();


    /************
     * Actions performed as per Gherkins order
     */
    //home page after opening app
    @Given("^Mike on home page after opening nopCart mobile app$")
    public void openApp() throws InterruptedException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        homepage.ClickAccept();
    }

    //Scroll left to right and click electronics from categories list
    @When("^Mike click \"([^\"]*)\" from our categories list from home page$")
    public void Electronics(String category) throws InterruptedException, IOException, InvalidFormatException {
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "FirstScen");
        String electronics = testdata.get(0).get("Category");
        softly.assertEquals("electronics",category);
        if (category.equals(electronics)) {
            homepage.scrollCategory();
            homepage.clickEletronics();
        }
        softly.assertAll();
    }

    // Scroll down and click on "Nokia Lumia 1020"
    @And("^Mike click to \"([^\"]*)\" product details page$")
    public void ProductDetails(String product) throws InterruptedException, IOException, InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "FirstScen");
        String nokialumia = testdata.get(0).get("Product");
        softly.assertEquals(nokialumia,product);
        if (product.equals(nokialumia)) {
            Thread.sleep(5000);
            product_Page.scrolltoNokia();
//            product_Page.selectNokia();
        }
        softly.assertAll();
    }

    //Select size = large from product details page
    @Then("^Mike select size \"([^\"]*)\" from product details page$")
    public void SelecSize(String size) throws InterruptedException, IOException, InvalidFormatException {
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "FirstScen");
        String large = testdata.get(0).get("Size");
        softly.assertEquals(large,size);
        if (size.equals(large)) {
            Thread.sleep(7000);
            product_Page.scrollingDown();
            product_Page.DetailsPageSizeAction();
        }
        softly.assertAll();
    }

    //Quantity increased by 2
    @And("^Mike click plus button to increase Qty by \"([^\"]*)\"$")
    public void QuantityIncrease(String Quantity) throws IOException, InvalidFormatException {
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "FirstScen");
        String two = testdata.get(0).get("Quantity");
        softly.assertEquals(two,Quantity);
        if (Quantity.equals(two)) {
            product_Page.DetailsPageaddAction();
        }
        softly.assertAll();
    }

    // Added to the cart
    @Then("^Mike click add to cart button to add the product in his cart$")
    public void addTocart() throws InterruptedException {
        product_Page.AddtoCartButton();
        Thread.sleep(3000);
    }

    /********************
     * Actions Second Scenario
     */

    //Here Customer Click on top right cart
    @Given("^Mike go to shopping cart by clicking top cart icon$")
    public void topCart() {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        customer.ClickMenu();
    }

    // Customer clicks check button for further step
    @When("^Mike click checkout button from shopping cart page$")
    public void ChekoutFromShopping() {
        customer.ClickcheckOut();
    }
//Select checkout as guest
    @And("^Mike select checkout as guest from shopping cart page$")
    public void CheckoutasGuest() {
        customer.ClickGuestbutton();
    }
// Filling the bill form
    @Then("^Mike input all the details in checkout billing details page and click continue$")
    public void billingProcessHandling() throws InterruptedException, IOException, InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        //Excel data provider
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "SecondScen");
        //List of category
        String fname = testdata.get(0).get("firstname");
        String lname = testdata.get(0).get("lastname");
        String email = testdata.get(0).get("email");
        int country = Integer.parseInt(testdata.get(0).get("country"));
        int state = Integer.parseInt(testdata.get(0).get("state"));
        String comapny = testdata.get(0).get("company");
        String city = testdata.get(0).get("city");
        String addressOne = testdata.get(0).get("address1");
        String addressTwo = testdata.get(0).get("address2");
        String zipCode = testdata.get(0).get("zip");
        String phone = testdata.get(0).get("phone");
        String fax = testdata.get(0).get("fax");
        billing.billingHandler(fname, lname, email);
        billing.ScrollingintoCountry(country, state);
        Thread.sleep(2000);
        billing.BillingSecondInput(comapny, city, addressOne, addressTwo, zipCode, phone, fax);
        //submission
        billing.submitContinue();

    }
    //Select shipping method
    @And("^Mike select \"([^\"]*)\" as shipping method and click continue$")
    public void shippingmethod(String method)throws InterruptedException,IOException, InvalidFormatException {
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
//Excel data provider
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "ThirdScen");
        //List of category
        String shippingText = testdata.get(0).get("Shipping");
        softly.assertEquals(shippingText,method);
        if (method.equals(shippingText)) {
            Thread.sleep(2000);
            shipping.setScrolldown();
            shipping.setAllCate();
            shipping.submitShipping();
        }
        softly.assertAll();

    }
    // Payment method
    @And("^Mike select \"([^\"]*)\" as payment method and click continue$")
    public void MoneyOrders(String method) throws InterruptedException, IOException, InvalidFormatException{
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(20));
        //Excel data provider
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "ThirdScen");
        //List of category
        String OMText = testdata.get(0).get("Order");
        softly.assertEquals(OMText,method);
        if (method.equals(OMText)) {
            moneyorder.ScrolldownSelectRocket();
            Thread.sleep(1000);
            moneyorder.Scroll();
            moneyorder.submitMoneyrder();
        }
        softly.assertAll();
    }
    // Payment Webview page
    @And("^Mike click next button on payment information page$")
    public void paymentInfo() throws InterruptedException,IOException, InvalidFormatException{
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        //Excel data provider
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "FourthScen");
        //List of data
        String phoneno= testdata.get(0).get("mobile number");
        String transid= testdata.get(0).get("transaction id");
        Thread.sleep(8000);
        paymentprocess.switchToWebView(phoneno,transid);
    }
    // Click button to confirm
    @Then ("^Mike click confirm button to place the order$")
    public void Confirmation() throws InterruptedException{
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        paymentprocess.finalConfirm();
        Thread.sleep(10000);
    }
    // Pop up message will appear
    @And("^Verify order place successfully with popup message \"([^\"]*)\"$")
    public void SuccessfulMessage(String popupMessage)throws InterruptedException,IOException, InvalidFormatException{
        new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        //Excel data provider
        List<Map<String, String>> testdata = reader.getData("src/main/resources/ExcelData/Scenario.xlsx", "ThirdScen");
        //List of category
        String Message= testdata.get(0).get("Message");
        softly.assertEquals(Message,popupMessage);
        if (popupMessage.equals("Message")){

            messagepopup.messageShown();
        }
        softly.assertAll();

    }

}
