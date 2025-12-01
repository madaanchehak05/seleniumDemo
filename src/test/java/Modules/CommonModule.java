package Modules;

import Pages.CommonPageObjects;
import Pages.LoginPageObjects;
import Utilities.DriverUtils;

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
}
