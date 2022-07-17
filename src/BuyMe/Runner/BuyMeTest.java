package Runner;

import Data.DriverSingleton;
import Pages.BusinessPage;
import Pages.HomePage;
import Pages.InfoGiftPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BuyMeTest {


//    @Test
//    public void test01_Register() {
//        RegisterPage registerPage = new RegisterPage();
//        RegisterPage.register();
//    }

    @Test
    public void test02_SearchGift() throws InterruptedException {
        HomePage homePage = new HomePage();
        HomePage.searchGift();
    }

    @Test
    public void test03_PickBusiness() {
        BusinessPage businessPage = new BusinessPage();
        BusinessPage.pickBusiness();
    }

    @Test
    public void test04_SenderAndReceiverInfo(){
        InfoGiftPage infoGiftPage = new InfoGiftPage();
        infoGiftPage.updateSenderAndReceiverInfo();

    }

}
