package de.tolleiv.aoe2018.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTest extends BaseTest {
    @Test(groups = {"functest", "checkintest"})
    public void testGoogle() {
        WebDriver driver = getWebDriver("JavaSample");
        driver.get("http://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("TestingBot");
        element.submit();

        //Assert.assertTrue(driver.getTitle().contains("Title of Page"));
        driver.quit();
    }

    @Test(groups = {"functest", "checkintest"})
    public void testSueddeutsche() {
        WebDriver driver = getWebDriver("JavaSample");
        driver.get("https://sueddeutsche.de");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//*[@data-linktrack='onclick_platformtype_homepage_topthema_1']"));
        element.click();
        Assert.assertEquals(driver.getTitle(), "(1)Landtagswahl in Hessen: Viele Koalitionen möglich - Politik - Süddeutsche.de");
        driver.quit();
    }

    @Test(groups = {"functest", "checkintest"})
    public void testGb() {
        WebDriver driver = getWebDriver("JavaSample");
        driver.get("https://www.golden-buffalo.de/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getTitle(), "Golden Buffalo Handelsgesellschaft mit beschränkter Haftung - Spezialitäten vom Wasserbüffel - Startseite");
        driver.quit();
    }

    @Test(groups = {"functest", "checkintest"})
    public void testBrowserCommands() {
        WebDriver driver = getWebDriver("JavaSample");
        String url = "http://www.store.demoqa.com";
        driver.get(url);

        // Storing Title name in the String variable
        String title = driver.getTitle();

        // Storing Title length in the Int variable
        int titleLength = driver.getTitle().length();

        // Printing Title & Title length in the Console window
        System.out.println("Title of the page is : " + title);
        System.out.println("Length of the title is : " + titleLength);

        // Storing URL in String variable
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(url)) {
            System.out.println("Verification Successful - The correct Url is opened.");
        } else {
            System.out.println("Verification Failed - An incorrect Url is opened.");
            //In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }

        // Storing Page Source in String variable
        String pageSource = driver.getPageSource();

        // Storing Page Source length in Int variable
        int pageSourceLength = pageSource.length();

        // Printing length of the Page Source on console
        System.out.println("Total length of the Pgae Source is : " + pageSourceLength);

        //Closing browser
        driver.quit();
    }

    @Test(groups = {"functest", "checkintest"})
    public void testBrowserCommands2() {
        WebDriver driver = getWebDriver("JavaSample");
        driver.get("http://demoqa.com/frames-and-windows/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(".//*[@rel='bookmark']")).click();
        driver.quit();
    }

    @Test(groups = {"functest", "checkintest"})
    public void testSelectOption() {
        WebDriver driver = getWebDriver("JavaSample");
        // Put an Implicit wait,
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch the URL
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");

        // Step 3: Select 'Continents' Drop down ( Use Id to identify the element )
        // Find Select element of "Single selection" using ID locator.
        Select oSelect = new Select(driver.findElement(By.id("continents")));

        // Step 4:) Select option 'Europe' (Use selectByIndex)
        oSelect.selectByVisibleText("Europe");

        // Using sleep command so that changes can be noticed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 5: Select option 'Africa' now (Use selectByVisibleText)
        oSelect.selectByIndex(2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 6: Print all the options for the selected drop down and select one option of your choice
        // Get the size of the Select element
        List<WebElement> oSize = oSelect.getOptions();
        int iListSize = oSize.size();

        // Setting up the loop to print all the options
        for(int i =0; i < iListSize ; i++){
            // Storing the value of the option
            String sValue = oSelect.getOptions().get(i).getText();
            // Printing the stored value
            System.out.println(sValue);
            // Putting a check on each option that if any of the option is equal to 'Africa" then select it
            if(sValue.equals("Africa")){
                oSelect.selectByIndex(i);
                break;
            }
        }
        // Kill the browser
        driver.quit();
    }
}
