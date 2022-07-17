package Pages;
import Data.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static Data.DriverSingleton.wait;

public class HomePage extends BasePage {

    public static void searchGift() throws InterruptedException{
        pickPricePoint();
        pickRegion();
        pickCategory();
        pressFindGiftBtn();
    }

    public static void pickPricePoint() throws InterruptedException{
        clickElement(By.className("notSigned"));
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "Auto@project.com");
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Aa123456");
        clickElement(By.cssSelector("button[type='submit']"));
        Thread.sleep(5000);
        clickElement(By.cssSelector("span[alt='סכום']"));
        clickElement(By.cssSelector("li[value='1']"));
    }

    public static void pickRegion(){
        clickElement(By.cssSelector("span[alt='אזור']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='13']"))).click();
    }

    public static void pickCategory(){
        clickElement(By.cssSelector("span[alt='קטגוריה']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='359']"))).click();
    }

    public static void pressFindGiftBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/search?budget=1&category=359&region=13']"))).click();
    }


}
