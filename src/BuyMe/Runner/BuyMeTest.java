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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Data.BasePage.takeScreenShot;
import static Data.DataToXML.getData;
import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.getDriverInstance;


public class BuyMeTest {


    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMeTest", "Sample description");

    @BeforeClass
    public static void runBeforeTest() throws Exception {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Yehonathan.vogelsang\\Desktop\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO,"before test method");
        getDriverInstance().get(getData("URL"));
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());

    }

    @Test
    public void test01_Register() throws Exception {
        RegisterPage registerPage = new RegisterPage();
        RegisterPage.register();
        test.log(Status.PASS,"Registration test");
    }

    @Test
    public void test02_SearchGift() throws Exception {
        HomePage homePage = new HomePage();
        HomePage.searchGift();
        test.log(Status.INFO, "Search for a gift test");
    }

    @Test
    public void test03_PickBusiness() throws Exception {
        BusinessPage businessPage = new BusinessPage();
        BusinessPage.pickBusiness();
        test.log(Status.INFO, "Pick a business test");
    }

    @Test
    public void test04_SenderAndReceiverInfo() throws Exception {
        InfoGiftPage infoGiftPage = new InfoGiftPage();
        infoGiftPage.updateSenderAndReceiverInfo();
        test.log(Status.INFO, "Sender And Receiver Info test");

    }

    @AfterClass
    public static void afterClass() {
////        test.log(Status.INFO, "@After test " + "After test method");
//        driver.quit();
        // build and flush report
        extent.flush();

    }

}
