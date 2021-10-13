package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG {

    static public ExtentReports extent;
    public static ExtentReports getReportObject() {
        System.out.println(System.getProperty("user.dir"));
        String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String path = System.getProperty("user.dir")+"/reports/"+ fileName+".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Selenium Easy Automation");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Zoe");
        return extent;
    }

}
