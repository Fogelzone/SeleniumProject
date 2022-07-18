package Pages;
import Data.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.wait;

public class RegisterPage extends BasePage {

    public static void register(){
        clickRegisterBtn();
        enterCredentials();
        agreeToTerms();
        assertFields();
        approveRegisterBtn();
    }

    private static void clickRegisterBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notSigned")));
        clickElement(By.className("notSigned"));
        clickElement(By.cssSelector("span[class='text-link theme']"));

    }
    private static void enterCredentials(){
        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), "John23");
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "Auto23@project.com");
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Aa123456");
        sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), "Aa123456");
    }

    private static void agreeToTerms() {
        clickElement(By.cssSelector("span[class='bm-body-2 label']"));
    }

    private static void assertFields() {
        String expectedUserName = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).getAttribute("value");
        String actualUserName = "John23";
        String expectedEmail = driver.findElement(By.cssSelector("input[placeholder='מייל']")).getAttribute("value");
        String actualEmail = "Auto23@project.com";
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedEmail, actualEmail);

    }

     private static void approveRegisterBtn(){
         clickElement(By.cssSelector("button[type='submit']"));
     }

}


