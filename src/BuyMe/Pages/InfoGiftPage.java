package Pages;

import Data.BasePage;
import Data.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InfoGiftPage extends BasePage {

    public static void updateSenderAndReceiverInfo(){
        enterReceiverName();
        pickAnEvent();
        enterBlessing();

    }

    private static void enterReceiverName(){
        sendKeysToElement(By.id("friendName"), "John");
    }
    private static void pickAnEvent(){
        clickElement(By.cssSelector("span[alt='לאיזה אירוע?']"));
        DriverSingleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='11']"))).click();
    }
    private static void enterBlessing(){
        getWebElement(By.className("parsley-success")).clear();
        sendKeysToElement(By.className("parsley-success"), "God bless you and good night");
    }

}
