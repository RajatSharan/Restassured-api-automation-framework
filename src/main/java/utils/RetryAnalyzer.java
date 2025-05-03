package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount =0;
    public static final int maxRetriesCount = 2;


    @Override
    public boolean retry(ITestResult result){
        if(retryCount < maxRetriesCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
