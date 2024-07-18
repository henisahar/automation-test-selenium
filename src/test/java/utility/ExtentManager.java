package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark_" + timeStamp + ".html");


            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("ExtentReports - Cucumber Integration");
            spark.config().setTheme(Theme.STANDARD);

            extent.attachReporter(spark);
        }
        return extent;
    }
}
