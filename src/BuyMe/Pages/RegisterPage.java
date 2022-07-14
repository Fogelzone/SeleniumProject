package Pages;
import Data.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Data.DriverSingleton.driver;

public class RegisterPage extends BasePage {

    public static void register() {
        clickRegisterBtn();
        enterCredentials();
        agreeToTerms();
        assertFields();
//        approveRegisterBtn();
    }

    private static void clickRegisterBtn() {
        clickElement(By.className("notSigned"));
        clickElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div[1]/span"));
    }
    private static void enterCredentials(){
        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), "John");
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "Auto@project.com");
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Aa123456");
        sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), "Aa123456");
    }

    private static void agreeToTerms(){
        clickElement(By.cssSelector("span[class='bm-body-2 label']"));
    }

    private static void assertFields() {
        String expectedUserName = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).getAttribute("value");
        String actualUserName = "John";
        String expectedEmail = driver.findElement(By.cssSelector("input[placeholder='מייל']")).getAttribute("value");
        String actualEmail = "Auto@project.com";
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedEmail, actualEmail);

    }

//     private static void approveRegisterBtn() {
//         clickElement(By.cssSelector("button[type='submit']"));
//     }

}


