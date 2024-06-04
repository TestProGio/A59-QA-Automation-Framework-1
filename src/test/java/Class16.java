import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Class16 extends BaseTest {

    @Test

    //HAPPY PATH - LOGIN TEST
    public void loginTest() {

        //STEP 0-PRE-CONDITIONS
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // to have window open at max

//STEP 1 - NAVIGATE TO KOEL WEBSITE
        String url = "https://qa.koel.app/";
        driver.get(url);// Opens a specified URL
        //java function to have it wait 2 sec
        waitSeconds(2000); // Used here

        // STEP 2 - GO TO EMAIL INPUT FIELD AND GET XPATH OR CSS LOCATOR
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        // assure email field is not auto populated
        emailField.clear();
        emailField.sendKeys("giovanna.silva@testpro.io");
        waitSeconds(2000); // Used here

        //STEP 3 PASSWORD FIELD
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();// clear pw field
        passwordField.sendKeys("ShakaMaya1302!");
        waitSeconds(2000); // Used here

        //STEP 4 CLICK ON LOGIN BUTTON
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        waitSeconds(2000); // Used here

        // Make sure you are logged in by checking the URL and using the avatar
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        // Assertions - expected vs actual experience with boolean
        Assert.assertTrue(avatarIcon.isDisplayed());

        //quit
        driver.quit();
    }
    // Helper method to introduce a delay in milliseconds
    private void waitSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

