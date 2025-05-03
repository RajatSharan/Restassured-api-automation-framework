package core;

import com.relevantcodes.extentreports.LogStatus;
import helper.BaseTestHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utils.ExtentReport;

public class BaseTest {


    @BeforeClass(alwaysRun = true)
    public void config()  {

        String timestamp = BaseTestHelper.Timestamp();
        String subFolderPath = System.getProperty("user.dir")+"/reports/"+ timestamp;
        String reportFilePath = subFolderPath + "API_Execution_Automation.html";
        ExtentReport.intializeExtentReport(reportFilePath);

        }

@AfterMethod(alwaysRun = true)



public void getResult(ITestResult result) {

    if (result.getStatus() == ITestResult.SUCCESS) {

        ExtentReport.extentLog.log(LogStatus.PASS, "Test Case :" + result.getName() + " is passed");
    } else if (result.getStatus() == ITestResult.FAILURE) {

        ExtentReport.extentLog.log(LogStatus.FAIL, "Test Case :" + result.getName() + " is failed");
        ExtentReport.extentLog.log(LogStatus.FAIL, "Test Case is failed due to :" + result.getThrowable());

    } else if (result.getStatus() == ITestResult.SKIP) {

        ExtentReport.extentLog.log(LogStatus.SKIP, "Test Case is Skiped :" + result.getName());
    }

    ExtentReport.extentReport.endTest(ExtentReport.extentLog);

}



@AfterSuite(alwaysRun = true)

public void endReport() {

    System.out.println("Flushing report");
    ExtentReport.extentReport.flush();

    ExtentReport.extentReport.close();



    //Logging.setinstanceNull();

}

}
