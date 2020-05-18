package monsterworks.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerUtils extends TestListenerAdapter {

    private static Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    @Override
    public void onTestSuccess(ITestResult tr) {
        info(tr.getName() + " was successful");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        error(tr.getName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        info(tr.getName() + " skipped");
    }

    @Override
    public void onTestStart(ITestResult tr) {
        info(tr.getName() + " started");
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void error(String message){
        logger.error(message);
    }
}
