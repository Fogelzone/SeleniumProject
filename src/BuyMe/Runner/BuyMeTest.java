package Runner;

import Pages.RegisterPage;
import org.testng.annotations.Test;


public class BuyMeTest {

    @Test
    public void test01_Register() {
        RegisterPage registerPage = new RegisterPage();
        RegisterPage.register();
    }

}
