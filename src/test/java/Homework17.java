import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test(priority = 1)
    // HAPPY PATH - LOGIN TEST
    public void loginTest() {

        // STEP 0-PRE-CONDITIONS
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-features=ChromeHelp");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize(); // to have window open at max

        // STEP 1 - NAVIGATE TO KOEL WEBSITE
        String url = "https://qa.koel.app/";
        driver.get(url); // Opens a specified URL

        // Wait for the page to load completely
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        // STEP 2 - GO TO EMAIL INPUT FIELD AND GET XPATH OR CSS LOCATOR
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys("giovanna.silva@testpro.io");

        // STEP 3 - PASSWORD FIELD
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear(); // clear pw field
        passwordField.sendKeys("ShakaMaya1302!");

        // STEP 4 - CLICK ON LOGIN BUTTON
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginBtn.click();

        // Make sure you are logged in by checking the URL and using the avatar
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

        // Locate Search Box
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
        searchBox.clear(); // clear search box
        searchBox.sendKeys("M33 Project - The Orchestra Improvisation");

        // Ensure the search results are loaded and view all button is visible
        WebElement viewAllBtn = null;
        int attempts = 0;
        while (attempts < 3) {
            try {
                viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewAllBtn); // Scroll to the button
                viewAllBtn.click();
                break;
            } catch (org.openqa.selenium.TimeoutException e) {
                attempts++;
                System.out.println("Attempt " + attempts + ": Element not clickable, retrying...");
            }
        }
        if (viewAllBtn == null) {
            throw new RuntimeException("Failed to locate and click View All button after 3 attempts");
        }

        // Locate All Songs
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
        allSongs.click();

        // Quit the driver
        driver.quit();
    }
}