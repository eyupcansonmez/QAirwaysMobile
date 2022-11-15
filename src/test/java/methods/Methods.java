package methods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Methods extends BaseTest {

    AppiumDriver driver;
    FluentWait<AppiumDriver> wait;

    public Methods() {
        BaseTest DriverSetup = new BaseTest();
        driver = DriverSetup.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }
    public MobileElement findElement(By by) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(String key, By by) {
        findElement(by).sendKeys(key);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public String addDay(int day) {
        DateFormat dateFormat = new SimpleDateFormat("D");
        Date date = new Date(new Date().getTime() + 86400000L * day);
        return dateFormat.format(date);
    }
}