package hooks;

import Utilities.DriverFactory;
import Utilities.ExtentManager;
import Utilities.ExtentTestManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.DriverManager;

import static Utilities.DriverFactory.getDriver;

public class hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        DriverFactory.initDriver();
        ExtentTestManager.startTest(scenario.getName(), "BDD Scenario Execution");
        ExtentTestManager.getTest().info("Scenario Started: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentTestManager.getTest().fail("Scenario Failed");

            // screenshot
            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(
                    ((TakesScreenshot) getDriver())
                            .getScreenshotAs(OutputType.BASE64),
                    "Failure Screenshot");
        } else {
            ExtentTestManager.getTest().pass("Scenario Passed");
        }

        ExtentManager.getInstance().flush();
        DriverFactory.quitDriver();
    }
}
