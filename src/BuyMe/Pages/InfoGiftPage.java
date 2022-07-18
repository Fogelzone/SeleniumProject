package Pages;

import Data.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.wait;

public class InfoGiftPage extends BasePage {

    public static void updateSenderAndReceiverInfo() {
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
    }

    private static void assertGiftUrl(){
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://buyme.co.il/package/348972/11617735";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    private static void pressSomeoneElse(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[gtm='למישהו אחר'")));
        clickElement(By.cssSelector("div[gtm='למישהו אחר'"));
    }

    private static void enterReceiverName()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("friendName")));
        sendKeysToElement(By.id("friendName"), "דניאל");
    }

    private static void assertReceiverName(){
        String expectedReceiverName = driver.findElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']")).getAttribute("value");
        String actualReceiverName = "דניאל";
        Assert.assertEquals(expectedReceiverName,actualReceiverName);

    }
    private static void pickAnEvent(){
        clickElement(By.cssSelector("span[alt='לאיזה אירוע?']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='11']")));
        clickElement(By.cssSelector("li[value='11']"));
    }
    private static void enterBlessing(){
        getWebElement(By.className("parsley-success")).clear();
        sendKeysToElement(By.className("parsley-success"), "God bless you and good night");
    }

    private static void uploadPicture(){
        driver.findElement(By.cssSelector("input[accept='image/png,image/jpeg,video/quicktime,video/mp4,.mov,.qt']")).sendKeys("C:\\Users\\Yehonathan.vogelsang\\Desktop\\קורס אוטומציה\\שיעור שמיני\\stellar.jpg");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='remove-media']")));
    }

    private static void clickContinue(){
        getWebElement(By.cssSelector("button[type='submit']")).submit();
    }

    private static void pressNowBtn(){
        clickElement(By.cssSelector("div[gtm='עכשיו'"));
    }

    private static void pickEmail(){
        clickElement(By.cssSelector("svg[gtm='method-email'"));
    }
    private static void enterEmailAddress(){
        sendKeysToElement(By.id("email"), "aaa@aaa.com");

    }

    private static void enterSenderName(){
        getWebElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).clear();
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"), "אין מתנות חינם");
    }

    private static void assertSenderName(){
        String expectedSenderName = driver.findElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).getAttribute("value");
        String actualSenderName = "אין מתנות חינם";
        Assert.assertEquals(expectedSenderName,actualSenderName);
    }

    private static void continueToPayment(){
        getWebElement(By.cssSelector("button[type='submit']")).submit();
    }

}
