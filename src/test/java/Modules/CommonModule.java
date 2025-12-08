package Modules;

import Pages.CommonPageObjects;
import Pages.LoginPageObjects;
import Utilities.DriverUtils;
import org.openqa.selenium.By;

public class CommonModule extends DriverUtils {

    public static void commonClick(String text) {
        boolean flag = false;
        try {
            click(CommonPageObjects.commonButton(text), "Login");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void navigateToCategories() {
        mouseHover(CommonPageObjects.sidebar);
        click(CommonPageObjects.productManagement, "Product Management");
        click(CommonPageObjects.productCatalog, "Product Catalog");
    }

    public static void searchProduct(String productName) {
        inputText(CommonPageObjects.searchproduct, productName);
        click(CommonPageObjects.searchbutton, "iphone");
    }

    public static boolean verifyproduct(String productName) {
        return waitForElementFluent(CommonPageObjects.verifyproduct(productName), 30);
    }
//    public static void selectProductCheckbox(String productName) {
//        click(CommonPageObjects.checkboxForProduct(productName), productName);
//    }
public static void selectProductCheckbox(String value) {
    try {
        // Call dynamic locator from PageObjects
        click(CommonPageObjects.commonButton(value), value);
    } catch (Exception e) {
        throw new RuntimeException("Failed to select checkbox for value: " + value);
    }
}

    public static void logout() {
    try {
        click(CommonPageObjects.profileDropdown, "Profile Dropdown");
        Thread.sleep(1500); // optional wait
        click(CommonPageObjects.logoutButton, "Logout Button");
    } catch (Exception e) {
        throw new RuntimeException("Logout failed: " + e.getMessage());
    }
}



//    public static void Checkbox(String product) {
//        click(CommonPageObjects.CheckBox, product);
//    }
}
