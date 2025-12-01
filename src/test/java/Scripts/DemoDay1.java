package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DemoDay1 {

    public static WebDriver driver;


    public static void selectBrowser(String browserName){
        try{
            switch (browserName.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    System.out.println("------");
            }
            driver.manage().window().maximize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        selectBrowser("Chrome");

        driver.get("https://www.google.com");

        Thread.sleep(5000);
        System.out.println("Page title: "+driver.getTitle());
        driver.quit();
    }
}
