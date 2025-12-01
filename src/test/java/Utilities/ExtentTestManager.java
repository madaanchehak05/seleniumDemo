package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void startTest(String testName, String description) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest extentTest = extent.createTest(testName, description);
        test.set(extentTest);
    }
}
