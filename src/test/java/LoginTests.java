import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
        // This is a change
        // This is another change #2
    }
    // new method
    public void loginValidEmailPassword() {
        //navigateToPage();

        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
//Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable());
//WebElement avatarIcon = driver.findElement(By.ByCssSelector("image[class='avatar']"));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("image[class='avatar']"));
wait.until(ExpectedConditions.invisibilityOfElementLocated()Assert.assertEquals(driver.getCurrentUrl(), url);
Assert.assertTrue(avatarIcon.isDisplayed());

//
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
        // This is a change
        // This is another change #2
    }
}
