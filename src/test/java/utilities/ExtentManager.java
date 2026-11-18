package utilities;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentReports getReport(){
        if(extent==null){
            ExtentSparkReporter spark = new ExtentSparkReporter("target/reports/ExtentReport.html");
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Selenium Framework");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS","Windows");
            extent.setSystemInfo("Tester","Goutami");
            extent.setSystemInfo("Browser","Chrome");
        }
        return extent;
    }
}
