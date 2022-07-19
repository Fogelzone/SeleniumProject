package Pages;

import Data.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.wait;

public class InfoGiftPage extends BasePage {

    public static void updateSenderAndReceiverInfo() throws Exception {

        assertGiftUrl();
        pressSomeoneElse();
        enterReceiverName();
        assertReceiverName();
        pickAnEvent();
        enterBlessing();
        uploadPicture();
        clickContinue();
        pressNowBtn();
        pickEmail();
        enterEmailAddress();
        enterSenderName();
        assertSenderName();
        continueToPayment();
        visibleSubmitBtn();
    }

    private static void assertGiftUrl(){
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://buyme.co.il/package/348972/11617735";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    private static void pressSomeoneElse() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[gtm='למישהו אחר'")));
        clickElement(By.cssSelector("div[gtm='למישהו אחר'"));
    }

    private static void enterReceiverName() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("friendName")));
        sendKeysToElement(By.id("friendName"), "דניאל");
    }

    private static void assertReceiverName(){
        String expectedReceiverName = driver.findElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")).getAttribute("value");
        String actualReceiverName = "דניאל";
        Assert.assertEquals(expectedReceiverName,actualReceiverName);

    }
    private static void pickAnEvent() throws Exception {
        clickElement(By.cssSelector("span[alt='לאיזה אירוע?']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='11']")));
        clickElement(By.cssSelector("li[value='11']"));
    }
    private static void enterBlessing() throws Exception {
        getWebElement(By.className("parsley-success")).clear();
        sendKeysToElement(By.className("parsley-success"), "God bless you and good night");
    }

    private static void uploadPicture(){
        driver.findElement(By.cssSelector("input[accept='image/png,image/jpeg,video/quicktime,video/mp4,.mov,.qt']")).sendKeys("C:\\Users\\Yehonathan.vogelsang\\Desktop\\קורס אוטומציה\\שיעור שמיני\\stellar.jpg");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='remove-media']")));
    }

    private static void clickContinue() throws Exception {
        getWebElement(By.cssSelector("button[type='submit']")).submit();
    }

    private static void pressNowBtn() throws Exception {
        clickElement(By.cssSelector("div[gtm='עכשיו'"));
    }

    private static void pickEmail() throws Exception {
        clickElement(By.cssSelector("svg[gtm='method-email'"));
    }
    private static void enterEmailAddress() throws Exception {
        sendKeysToElement(By.id("email"), "aaa@aaa.com");
    }

    private static void enterSenderName() throws Exception {
        getWebElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).clear();
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"), "אין מתנות חינם");
    }

    private static void assertSenderName(){
        String expectedSenderName = driver.findElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).getAttribute("value");
        String actualSenderName = "אין מתנות חינם";
        Assert.assertEquals(expectedSenderName,actualSenderName);
    }

    private static void continueToPayment() throws Exception {
        WebElement result = getWebElement(By.cssSelector("button[type='submit']"));
        if (result != null){
            result.submit();
        } else {
            throw new Exception("Failed to locate submit button");
        }
    }

    private static void visibleSubmitBtn() throws Exception {
        Boolean result = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        if (result != null) {
            return;
        } else {
            throw new Exception("Submit button is still visible");
        }
    }

}
