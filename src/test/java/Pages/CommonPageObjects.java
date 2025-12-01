package Pages;

import org.openqa.selenium.By;

public class CommonPageObjects {

    public static By commonButton(String text){
        return By.xpath("//button[text()='"+text+"']");
    }
    public static By sidebar = By.xpath("//button[@class='sidebar-toggle sidebarOpenerBtnJs']");
    public static By productManagement = By.xpath("//span[text()='Product management']");
    public static By productCatalog = By.xpath("//a[@class='nav_link navLinkJs dropdown-toggle-custom']");
    public static By arrowDown = By.xpath("//a[@class='btn advanced-trigger ms-2 advSrchToggleJs collapsed']");
    public static By searchproduct = By.xpath("//input[@title='Search by product name and model']");
    public static By searchbutton = By.xpath("//button[@type='submit']");
    public static By verifyproduct(String productName) {
        return By.xpath("//span[contains(text(),'"+productName+"')]");
    }



}
