package Pages;

import Data.BasePage;
import Data.DriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Data.DriverSingleton.driver;

public class BusinessPage extends BasePage {

    public static void pickBusiness(){
        assertUrl();
        selectBusiness();
        enterPrice();
    }

    public static void assertUrl(){
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://buyme.co.il/search?budget=1&category=359&region=13";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    private static void selectBusiness(){
        DriverSingleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/supplier/348972?budget=1&category=359&query=&region=13']"))).click();
    }

    private static void enterPrice(){
        DriverSingleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/package/348972/7869920']"))).click();
    }

}