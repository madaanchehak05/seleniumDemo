package Scripts;

import org.openqa.selenium.By;

public class DemoDay2 extends DemoDay1{

    public static By username = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@placeholder='Password']");
    public static By loginButton = By.xpath("//button[@type='submit']");
    public static By loggedInUserName = By.xpath("//img[@alt='profile picture']/following-sibling::p");

    public static void click(By locator, String log){
        System.out.println("Clicking on: "+log);
        driver.findElement(locator).click();
    }

    public static void inputText(By locator, String data){
        System.out.println("Entering text: "+data);
        driver.findElement(locator).sendKeys(data);
    }

    public static String getText(By locator){
        String text = driver.findElement(locator).getText();
        System.out.println("Text fetched: "+text);
        return text;
    }

    public static void main(String[] args) throws InterruptedException {
        selectBrowser("Chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);
        inputText(username,"Admin");
        Thread.sleep(3000);
        inputText(password,"admin123");
        Thread.sleep(3000);
        click(loginButton,"Login");
        Thread.sleep(3000);
        String username = getText(loggedInUserName);
        System.out.println("Hi ,"+username+" Thankyou for login");
        driver.quit();
    }

}
