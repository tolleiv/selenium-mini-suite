package de.tolleiv.aoe2018.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitSampleTest extends BaseTest {

    @Test(groups = {"functest", "checkintest"})
    public void testWaiting() {
        WebDriver driver = getWebDriver("WaitSample");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
        driver.findElement(By.id("timingAlert")).click();
        System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Either Pop Up is displayed or it is Timed Out");
        myAlert.accept();
        System.out.println("Alert Accepted");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
