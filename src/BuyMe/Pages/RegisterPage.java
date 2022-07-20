package Pages;
import Data.BasePage;
import Data.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        loggedIn();
    }

    private static void clickRegisterBtn() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notSigned")));
        clickElement(By.className("notSigned"));
        clickElement(By.cssSelector("span[class='text-link theme']"));

    }
    private static void enterCredentials() throws Exception {
        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), "John" + Constants.USER_NUMBER);
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "Auto" + Constants.USER_NUMBER + "@project.com");
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Aa123456");
        sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), "Aa123456");
    }

    private static void agreeToTerms() throws Exception {
        clickElement(By.cssSelector(".login-options .icon, .grid .icon, .register-text .icon"));
    }

    private static void assertFields() {
        String actualUserName = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']")).getAttribute("value");
        String expectedUserName = "John" + Constants.USER_NUMBER;
        String actualEmail = driver.findElement(By.cssSelector("input[placeholder='מייל']")).getAttribute("value");
        String expectedEmail = "Auto" + Constants.USER_NUMBER + "@project.com";
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedEmail, actualEmail);
    }

     private static void approveRegisterBtn() throws Exception {
         clickElement(By.cssSelector("button[type='submit']"));
     }

    private static void loggedIn() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("notSigned")));
        WebElement element = getWebElement(By.cssSelector(".ember-view.dropdown.solid , arrow.ember-view.bm-icon"));
        Assert.assertNotEquals(element, null);
    }

}