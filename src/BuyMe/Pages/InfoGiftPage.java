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
        pickAnEvent();
        enterBlessing();
        uploadPicture();
        clickContinue();
        pressNowBtn();
        pickEmail();
        enterEmailAddress();
        enterSenderName();
        continueToPayment();
    }

    private static void assertGiftUrl(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://buyme.co.il/package/348972/11617735";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    private static void pressSomeoneElse() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[gtm='למישהו אחר'")));
        clickElement(By.cssSelector("div[gtm='למישהו אחר'"));
    }

    private static void enterReceiverName()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")));
        sendKeysToElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"), "דניאל");
        String actualReceiverName = driver.findElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")).getAttribute("value");
        String expectedReceiverName = "דניאל";
        Assert.assertEquals(expectedReceiverName,actualReceiverName);
    }

    private static void pickAnEvent() {
        clickElement(By.cssSelector("span[alt='לאיזה אירוע?']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='11']")));
        clickElement(By.cssSelector("li[value='11']"));
    }

    private static void enterBlessing() {
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
        String actualSenderName = driver.findElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).getAttribute("value");
        String expectedSenderName = "אין מתנות חינם";
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
}
