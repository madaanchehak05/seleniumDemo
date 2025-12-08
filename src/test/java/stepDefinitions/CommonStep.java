package stepDefinitions;

import Modules.CommonModule;
import Utilities.ExcelUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonStep {
    @And("Navigate to Product Catalog")
    public void navigateToCategories() {
        CommonModule.navigateToCategories();

    }

    @And("Search {string}")
    public void search(String productName) {
        // Write code here that turns the phrase above into concrete actions
        String product = ExcelUtils.getData("Product",productName,"productName");
        CommonModule.searchProduct(product);


    }

    @And("verify {string} is present")
    public void verifyIsPresent(String productName) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(CommonModule.verifyproduct(productName));
    }
    @Then("user should be logout")
    public void userShouldBeLogout() {
        CommonModule.logout();
    }


    }










