package Pages;

import Data.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Data.DriverSingleton.wait;

public class HomePage extends BasePage {

    public static void searchGift() throws Exception {
        pickPricePoint();
        pickRegion();
        pickCategory();
        pressFindGiftBtn();
    }

    public static void pickPricePoint() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("notSigned")));
        clickElement(By.cssSelector("span[alt='סכום']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='1']")));
        clickElement(By.cssSelector("li[value='1']"));
    }

    public static void pickRegion() throws Exception {
        clickElement(By.cssSelector("span[alt='אזור']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='13']")));
        clickElement(By.cssSelector("li[value='13']"));
    }

    public static void pickCategory() throws Exception {
        clickElement(By.cssSelector("span[alt='קטגוריה']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='359']")));
        clickElement(By.cssSelector("li[value='359']"));
    }

    public static void pressFindGiftBtn() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://buyme.co.il/search?budget=1&category=359&region=13']")));
        clickElement(By.cssSelector("a[href='https://buyme.co.il/search?budget=1&category=359&region=13']"));
    }


}
