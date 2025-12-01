package stepDefinitions;

import Modules.CommonModule;
import Modules.LoginModule;
import Utilities.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    @Given("launch {string} application")
    public void launchWebsite(String testdata) {
        String url = ExcelUtils.getData("Login",testdata,"url");
        LoginModule.launchWebsite(url);
        System.out.println("debug point");
    }

    @When("Login into application using {string}")
    public void loginIntoApplicationUsing(String testdata) {
        String username = ExcelUtils.getData("Login",testdata,"username");
        String password = ExcelUtils.getData("Login",testdata,"password");
        Assert.assertTrue(LoginModule.loginIntoApplication(username,password));
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(LoginModule.verifyUserIsLoggedIn());
    }

    @When("user click on {string}")
    public void userClickOn(String commonText) {
        CommonModule.commonClick(commonText);
    }
}
