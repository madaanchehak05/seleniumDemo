package Modules;

import Pages.LoginPageObjects;
import Utilities.DriverUtils;

public class LoginModule extends DriverUtils {

    public static void navigateTo(String url){
        try {
            launchWebsite(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean loginIntoApplication(String username, String password){
        try {
            inputText(LoginPageObjects.username,username);
            inputText(LoginPageObjects.password,password);
            click(LoginPageObjects.loginButton,"Login button");
            return waitForElementFluent(LoginPageObjects.loggedInUserName,30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyUserIsLoggedIn(){
        try {
//            getText(LoginPageObjects.loggedInState);
            return waitForElementFluent(LoginPageObjects.loggedInState,10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
