package Data;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static Data.DriverSingleton.getDriverInstance;

public class BasePage {


    private static ExtentTest test;


    public static void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    protected static WebElement getWebElement(By locator) {
        try {
            return DriverSingleton.getDriverInstance().findElement(locator);
        } catch (Exception e) {
            takeScreenShot();
        }
        return null;
    }


    public static String takeScreenShot() {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getDriverInstance();
            String ImageName = String.valueOf(System.currentTimeMillis());
            String ImagePath = Constants.IMAGES_PATH + "\\" + ImageName + ".png";
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(ImagePath);
            try {
                FileUtils.copyFile(screenShotFile, destinationFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return ImagePath;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }

    }

}






