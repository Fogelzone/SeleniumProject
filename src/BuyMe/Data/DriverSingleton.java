package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Data.DataToXML.getData;

public class DriverSingleton {
    public static WebDriver driver;
    public static WebDriverWait wait;


    public static WebDriver getDriverInstance() throws Exception {
        if (driver == null) {
            String type = getData("browserType");

            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
            if (type.equals("Chrome")) {
                System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            } else if (type.equals("FF")) {
                System.setProperty("webdriver.firefox.driver", "C:\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();}

                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            }
            return driver;
        }

    }



