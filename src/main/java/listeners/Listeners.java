package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IAnnotationTransformer {
    private static Logger log = LogManager.getLogger(Listeners.class);

    public void onFinish(ITestContext arg0) {

    }

    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        //
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("test case " + result.getName() + " got failed");
    }

    public void onTestSkipped(ITestResult result) {
        log.info("test case " + result.getName() + " got skipped");
    }


    public void onTestStart(ITestResult result) {
        log.info("starting test case " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        log.info("completed test case " + result.getName());
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
    }
}
