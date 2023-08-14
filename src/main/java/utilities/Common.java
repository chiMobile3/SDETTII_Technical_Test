package utilities;

import driver.PageDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.Arrays;

public class Common {
    /*******************************************
     * *****************************************
     * PassValue in the input field using sendTextMethod
     * @param element
     * @param value
     */
    // send text method sends values in a web element like inputs
    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    /************************************
     * **********************************
     * Method----1 stands for top bottom scrolling
     * @param element
     * @param duration
     */
    //This method scrolls from top to bottom
    public void verticalScroll(WebElement element,int duration) {
        //Creating Vertical Scroll Event
        //Scrollable Element

        int centerX = element.getRect().x + (element.getSize().width / 2);

        double startY = element.getRect().y + (element.getSize().height * 0.7);//9

        double endY = element.getRect().y + (element.getSize().height * 0.2);//1
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration),//550
                PointerInput.Origin.viewport(), centerX, (int) endY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        PageDriver.getCurrentDriver().perform(Arrays.asList(swipe));

    }
    /**********************
     * Method---------2 TouchAction Scrolling top bottom
     */
    public void MakeScrollDown() {
        TouchAction action = new TouchAction(PageDriver.getCurrentDriver());
        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                .moveTo(PointOption.point(115, 350)).release().perform();
    }

    /*********************************
     * *******************************
     * Method---------3 Search by "text" scrolling top bottom
     */

    //--------------------------
    public void androidScrollToAnElementByText(String text) {
        try {
            (PageDriver.getCurrentDriver()).findElement(
                    MobileBy.AndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))")).click();
        } catch (Exception e) {
            throw new NoSuchElementException("No element" + e);
        }
    }
    /***************************************
     * *************************************
     * This method-----4 stands for scrolling top bottom
     * @param id
     * @param text
     * Store webelement(must be scrollable and text as a string----call the method passing arguements those are stored in the variable
     */
    public void androidVerticalScrollToTextById(String id,String text) {
        try {
            (PageDriver.getCurrentDriver()).findElement(
                    MobileBy.AndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)." + "resourceId(\""+ id +"\"))" + ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))")).click();
        } catch (Exception e) {
            throw new NoSuchElementException("No element" + e);
        }
    }
    /***************************************
     * *************************************
     * This method-----1 stands for left right scrolling
     * @param element
     * @param duration
     */
    //This method scrolls from left to right
    public void horizontalScroll(WebElement element,int duration) {
        int centerY = element.getRect().y + (element.getSize().height/2 );

        double startX = element.getRect().x + (element.getSize().width * .8);

        double endX = element.getRect().x + (element.getSize().width * .2);
        //Type of Pointer Input
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        //Creating Sequence object to add actions
        Sequence swipe = new Sequence(finger, 1);
        //Move finger into starting position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), (int) startX, centerY));
        //Finger comes down into contact with screen
        swipe.addAction(finger.createPointerDown(0));
        //Finger moves to end position
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration),
                PointerInput.Origin.viewport(), (int) endX, centerY));
        //Get up Finger from Srceen
        swipe.addAction(finger.createPointerUp(0));

        //Perform the actions
        PageDriver.getCurrentDriver().perform(Arrays.asList(swipe));

        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /***************************************
     * *************************************
     * This method-----2 stands for left right scrolling includes "id/class" and target "text"
     * @param id
     * @param text
     * Store webelement(must be scrollable and text as a string----call the method passing arguements those are stored in the variable
     */
    public void androidHorizontalScrollByText(String id,String text) {
        try {
            (PageDriver.getCurrentDriver()).findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
                    + "resourceId(\""+id+"\"))" + ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\""+text+"\"))")); }
        catch (Exception e) {
            throw new NoSuchElementException("No element" + e);
        }
    }


    }

