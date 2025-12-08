package Utilities;

import org.openqa.selenium.*;
import Utilities.DriverFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils extends DriverFactory{

    public static void launchWebsite(String url){
        getDriver().get(url);

        System.out.println("https://demo.yo-kart.com/admin/admin-guest/login-form");
    }

    public static void click(By locator, String log){
        try {
            waitForElementFluent(locator,100);
            System.out.println("Clicking on: "+log);
            ExtentTestManager.getTest().info("Clicking on element: "+log);
            getDriver().findElement(locator).click();
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: "+locator+" ,"+e.getMessage());
        }
    }

    public static void inputText(By locator, String data){
        try{
            waitForElementFluent(locator,100);
            System.out.println("Entering text: "+data);
            ExtentTestManager.getTest().info("Entering text: "+data);
            getDriver().findElement(locator).sendKeys(data);
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: "+locator+" ,"+e.getMessage());
        }
    }

    public static String getText(By locator){
        String text="";
        try {
            waitForElementFluent(locator,100);
            text = getDriver().findElement(locator).getText();
            ExtentTestManager.getTest().info("Text fetched: "+text);
            System.out.println("Text fetched: "+text);
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: "+locator+" ,"+e.getMessage());
        }
        return text;
    }

    public static boolean waitForElementVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(timeoutInSeconds)
            );
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: "+locator+" ,"+e.getMessage());
            return false;
        }
    }

    public static boolean waitForElementFluent(By locator, int timeoutSeconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return wait.until(drv -> drv.findElement(locator).isDisplayed());
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: "+locator+" ,"+e.getMessage());
            return false;
        }
    }
    public static void mouseHover(By locator) {
        try {
            waitForElementFluent(locator,10);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(locator)).build().perform();
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("Failed due to locator: " + locator + " ," + e.getMessage());

        }
    }
}
