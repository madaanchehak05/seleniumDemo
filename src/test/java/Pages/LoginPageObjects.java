package Pages;

import org.openqa.selenium.By;

public class LoginPageObjects {

    public static By username = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@placeholder='Password']");
    public static By loginButton = By.xpath("//button[@type='submit']");
    public static By loggedInUserName = By.xpath("//img[@alt='profile picture']/following-sibling::p");
    public static By loggedInState = By.xpath("//img[@alt='Admin']");



}
