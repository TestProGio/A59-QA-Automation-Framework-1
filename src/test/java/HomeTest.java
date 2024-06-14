import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

// IS THE BUTTON VISIBLE

public class HomeTest extends BaseTest {
    private WebDriverWait wait;
    private Actions actions;

    //class actions
    @Test

   /* public void HoverOverPlayButtonAndPlaySong() throws InterruptedException {
        // Initialize actions and WebDriverWait
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Login
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");
        Thread.sleep(2000);
        Assert.assertTrue(hoverPlay().isDisplayed());

    }*/
    public void CountSongsInPlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Login
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");
        Thread.sleep(2000);
        //Choose a Playlist by Name
        choosePlayListByName("TestPro Playlist");
        Thread.sleep(2000);
        //DisplayAllSongs
        displayAllSongs();
        Thread.sleep(2000);
        //SongsCount
        songsCount();
        Thread.sleep(2000);
        //Playlist details
        getPlaylistDetails();
        Thread.sleep(2000);
        // Assert: Check number of songs are match number shown in info section
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(songsCount())));

    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int songsCount() {
        //returns int
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs() {
        //list of web elements -plural
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+ songsCount());
    for (WebElement e: songList) {
        System.out.println(e.getText());
        }

    }

    public void choosePlayListByName(String playlistName) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }
    //helper method returns web element
    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid=play-btn]"));
        actions.moveToElement(playBtn).perform();
        // Wait for the element to become visible after the hover action
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    }




