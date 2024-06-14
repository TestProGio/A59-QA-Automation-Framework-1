import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllSongsTest extends BaseTest {
    private WebDriverWait wait;
    private Actions actions;

    @Test
    public void playSongWithRightClick() throws InterruptedException {
        // Initialize actions and WebDriverWait
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Login
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");

        // Navigate to All Songs
        navToChooseAllSongs();
        Thread.sleep(2000);

        // Right-click on 1st Song
        contextClickFirstSong();
        Thread.sleep(2000);

        // Choose Play from Context Menu
        choosePlayOption();
        Thread.sleep(2000);

        // Verify if song is being played
        Assert.assertTrue(isSongPlaying());


    }

    private void choosePlayOption() {
        // Click on the playback option
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    private void contextClickFirstSong() {
        // Locate the first song element and perform a context click
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    private void navToChooseAllSongs() {
        // Locate the element and ensure it's clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a"))).click();
    }

    public boolean isSongPlaying() {
        // Check if the sound bar visualizer is displayed
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    @AfterMethod
       public void stopTestExecution() {
           // Close the browser
           if (driver != null) {
               driver.quit();
           }
           // Stop the test execution programmatically
           System.exit(0);

       }
}
