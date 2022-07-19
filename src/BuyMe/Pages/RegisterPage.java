package Pages;
import Data.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.wait;

public class RegisterPage extends BasePage {

    public static void register() throws Exception {
        clickRegisterBtn();
        enterCredentials();
        agreeToTerms();
        assertFields();
        approveRegisterBtn();
    }

    private static void clickRegisterBtn() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notSigned")));
        clickElement(By.className("notSigned"));
        clickElement(By.cssSelector("span[class='text-link theme']"));

    }
    private static void enterCredentials() throws Exception {
        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), "John35");
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "Auto35@project.com");
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Aa123456");
        sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), "Aa123456");
    }

    private static void agreeToTerms() throws Exception {
        clickElement(By.cssSelector("span[class='bm-body-2 label']"));
    }

    private static void assertFields() {
        String expectedUserName = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).getAttribute("value");
        String actualUserName = "John35";
        String expectedEmail = driver.findElement(By.cssSelector("input[placeholder='מייל']")).getAttribute("value");
        String actualEmail = "Auto35@project.com";
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedEmail, actualEmail);

    }

     private static void approveRegisterBtn() throws Exception {
         clickElement(By.cssSelector("button[type='submit']"));
     }

}


