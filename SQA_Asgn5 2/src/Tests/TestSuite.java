package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestSuite {

    private static ExtentReports report;
    private static Logger logger = LogManager.getLogger(TestSuite.class);

    @BeforeSuite
    public void prep() {
        System.out.println("== Executing Test Suite... ==");
    }

    @AfterSuite
    public void exit() {
        System.out.println("== Finishing Test Suite ==");
    }

    @BeforeClass
    public void startTest() {
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    	
        System.out.println("Implementing before class annotation...");
    }

    @AfterClass
    public void testFlush() {
    	report.flush();
    	 
        System.out.println("Finalizing report...");
    }

    @BeforeGroups("database")
    public void beforeG() {
        System.out.println("Implementing before groups...");
    }

    @BeforeTest
    public void beforeT() {
        System.out.println("Implementing before test...");
    }

    @BeforeMethod
    public void beforeM() {
        System.out.println("Implementing before method...");
    }

    @Test(groups = "database")
    public void test1() {
        ExtentTest test = report.createTest("Test 1");

        System.out.println("Testing first function...");
        Reporter.log("Test 1 executed");
        test.log(Status.PASS, "Test 1 Passed successfully");
    }

    @Test
    public void test2() {
        ExtentTest test = report.createTest("Test 2");

        System.out.println("Testing second function...");
        Reporter.log("Test 2 executed");
        test.log(Status.PASS, "Test 2 Fully Passed");
    }

    @Test
    public void test3() {
        ExtentTest test = report.createTest("Test 3");

        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");

        System.out.println("Testing third function...");
        Reporter.log("Test 3 executed");
        test.log(Status.FAIL, "Test 3 Dramatically Failed :(");
    }

    @Test
    public void test4() {
        ExtentTest test = report.createTest("Test 4");

        System.out.println("Testing fourth function...");
        Reporter.log("Test 4 executed");
        test.log(Status.FAIL, "Test 4 Dramatically Failed :(");
    }

    @AfterMethod
    public void afterM() {
        System.out.println("Implementing after method...");
    }

    @AfterTest
    public void afterT() {
        System.out.println("Implementing after test...");
    }
}
