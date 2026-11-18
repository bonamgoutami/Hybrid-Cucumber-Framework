package listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

import utilities.ExtentManager;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getName());
    }
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }
    public void onFinish(ITestContext arg0) {
        extent.flush();
    }

}
