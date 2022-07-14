package Runner;

import Pages.HomePage;
import Pages.RegisterPage;
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

}
