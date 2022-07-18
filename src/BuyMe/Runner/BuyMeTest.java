package Runner;


import Pages.BusinessPage;
import Pages.HomePage;
import Pages.InfoGiftPage;
import Pages.RegisterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Data.DriverSingleton.getDriverInstance;


public class BuyMeTest {


//    private static ExtentReports extent= new ExtentReports();
//    private static ExtentTest test = extent.createTest("BuyMeTest", "Sample description");

    @BeforeClass
    public static void runBeforeTest() {
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
//        extent.attachReporter(htmlReporter);
//        test.log(Status.INFO,"before test method");
          getDriverInstance().get("https://buyme.co.il/");


    }

    @Test
    public void test01_Register() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage();
        RegisterPage.register();
//        test.log(com.aventstack.extentreports.Status.INFO,"Registration test");
    }

    @Test
    public void test02_SearchGift() throws InterruptedException {
        HomePage homePage = new HomePage();
        HomePage.searchGift();
//        test.log(com.aventstack.extentreports.Status.INFO, "Search a gift test");
    }

    @Test
    public void test03_PickBusiness(){
        BusinessPage businessPage = new BusinessPage();
        BusinessPage.pickBusiness();
//        test.log(com.aventstack.extentreports.Status.INFO, "Pick a business test");
    }

    @Test
    public void test04_SenderAndReceiverInfo() {
        InfoGiftPage infoGiftPage = new InfoGiftPage();
        infoGiftPage.updateSenderAndReceiverInfo();
//        test.log(com.aventstack.extentreports.Status.INFO, "Sender And Receiver Info test");

    }

//    @AfterClass
//    public static void afterClass() {
////        test.log(com.aventstack.extentreports.Status.INFO, "@After test " + "After test method");
//        driver.quit();
//        // build and flush report
////        extent.flush();

    }

//}
