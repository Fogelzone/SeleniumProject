package Runner;


import Pages.BusinessPage;
import Pages.HomePage;
import Pages.InfoGiftPage;
import Pages.RegisterPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Data.BasePage.takeScreenShot;
import static Data.DataToXML.getData;
import static Data.DriverSingleton.getDriverInstance;


public class BuyMeTest {

    private static WebDriver webDriver = getDriverInstance();
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMeTest", "Buy a gift from BuyMe Website");

    @BeforeClass
    public static void runBeforeTest() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Yehonathan.vogelsang\\Desktop\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO,"before test method");
        webDriver.get(getData("URL"));
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
    }

    @Test
    public void test01_Register() throws Exception {
        RegisterPage registerPage = new RegisterPage();
        String testName = "Registration";
        test.log(Status.INFO, testName + " test");
        try {
            registerPage.register();
            test.pass(testName + " pass");
        } catch(Exception e){
            test.info(testName + " fail", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
            test.fail(e.toString());
            throw new Exception("Test failed");
        }
    }

    @Test(dependsOnMethods = {"test01_Register"})
    public void test02_SearchGift() {
        HomePage homePage = new HomePage();
        String testName = "Search for a gift";
        test.log(Status.INFO, testName + " test");
        try {
            homePage.searchGift();
            test.pass(testName + " pass");
        } catch(Exception e){
            test.info(testName + " fail", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
            test.fail(e.toString());
        }
    }

    @Test(dependsOnMethods = {"test02_SearchGift"})
    public void test03_PickBusiness() {
        BusinessPage businessPage = new BusinessPage();
        String testName = "Pick a business";
        test.log(Status.INFO, testName + " test");
        try {
            businessPage.pickBusiness();
            test.pass(testName + " pass");
        } catch(Exception e){
            test.info(testName + " fail", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
            test.fail(e.toString());
        }
    }

    @Test(dependsOnMethods = {"test03_PickBusiness"})
    public void test04_SenderAndReceiverInfo() throws Exception {
        InfoGiftPage infoGiftPage = new InfoGiftPage();
        String testName = "Sender And Receiver Info";
        test.log(Status.INFO, testName + " test");
        try {
            infoGiftPage.updateSenderAndReceiverInfo();
            test.pass(testName + " pass");
        } catch(Exception e){
            test.info(testName + " fail", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
            test.fail(e.toString());
        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        webDriver.quit();
        // build and flush report
        extent.flush();
    }

}
