package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-popup-blocking");
        driver.set(new ChromeDriver(options));
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}
