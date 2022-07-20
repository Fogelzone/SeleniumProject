package Pages;

import Data.BasePage;
import Data.DriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Data.DriverSingleton.driver;
import static Data.DriverSingleton.wait;

public class BusinessPage extends BasePage {

    public static void pickBusiness() throws Exception {
        assertUrl();
        selectBusiness();
        choosePrice();
    }

    public static void assertUrl(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://buyme.co.il/search?budget=1&category=359&region=13";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    private static void selectBusiness() throws Exception {
        DriverSingleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/supplier/348972?budget=1&category=359&query=&region=13']")));
        clickElement(By.cssSelector("a[href='https://buyme.co.il/supplier/348972?budget=1&category=359&query=&region=13']"));

    }

    private static void choosePrice() throws Exception {
        DriverSingleton.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/package/348972/11617735']")));
        clickElement(By.cssSelector("a[href='https://buyme.co.il/package/348972/11617735']"));
    }

}
