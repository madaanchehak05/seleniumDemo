package Pages;

import org.openqa.selenium.By;

public class CommonPageObjects {

    public static By commonButton(String text){
        return By.xpath("//button[text()='"+text+"']");
    }
    public static By sidebar = By.xpath("//button[@class='sidebar-toggle sidebarOpenerBtnJs']");
    public static By productManagement = By.xpath("//span[text()='Product management']");
    public static By productCatalog = By.xpath("//a[@class='nav_link navLinkJs dropdown-toggle-custom']");
    public static By arrowDown;

    //static {
        //arrowDown = By.xpath("//a[@class='btn advanced-trigger ms-2 advSrchToggleJs collapsed']");
    //}

    public static By searchproduct = By.xpath("//input[@title='Search by product name and model']");
    public static By searchbutton = By.xpath("//button[@type='submit']");
    public static By verifyproduct(String productName) {
        return By.xpath("//span[contains(text(),'"+productName+"')]");
    }
    public static By selectItem = By.xpath("//input[@class='selectItemJs' and @value='2574']");

    public static By profileDropdown = By.xpath("//a[@class='dropdown-toggle no-after']");
    public static By checkboxForValue(String value) {
        return By.xpath("//input[@class='selectItemJs' and @value='" + value + "']");
    }

    public static By logoutButton = By.xpath("//a[contains(text(),'Logout')]");



}







