package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentReport {

    public static ExtentReports extentReport;

    public static ExtentTest extentLog;

    public static void intializeExtentReport(String reportPath) {

        if(extentReport == null) {
            extentReport = new ExtentReports(reportPath,true);
            extentReport.addSystemInfo("Host Name", System.getProperty("user.name"));
            extentReport.addSystemInfo("Environment Name", "QA");
            extentReport.addSystemInfo("OS Version", "Windows 11");
            extentReport.loadConfig(new File(System.getProperty("user.dir")+"/resources/extent-config.xml"));

        }
    }

}
