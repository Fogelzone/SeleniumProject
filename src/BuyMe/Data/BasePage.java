package Data;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {


    private static ExtentTest test;

    public static void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text)  {
        getWebElement(locator).sendKeys(text);
    }

    protected static WebElement getWebElement(By locator)  {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

}



