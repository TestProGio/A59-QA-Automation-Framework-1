package homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewPlaylistPage extends NewBasePage {

    // Locators
    private By addPlayListIcon = By.xpath("//*[@id='playlists']/h1/i");
    private By newPlaylistMenu = By.xpath("//*[@id='playlists']/nav/ul/li[1]");
    private By playlistNameField = By.xpath("//*[@id='playlists']/form/input");
    private By activePlaylist = By.xpath("//*[@id='playlists']/ul/li/a[@class='active']");
    private By renamePlaylistInput = By.cssSelector("[data-testid='inline-playlist-name-input']");
    private By successPopup = By.xpath("//*/div[2]/div[@class='success show']");

    // Constructor
    public NewPlaylistPage(WebDriver driver) {
        super(driver);
    }

    // Method to create a new playlist
    public void createPlaylist(String playlistName) {
        // Click on the add playlist icon
        clickElement(addPlayListIcon);
        // Click on the new playlist menu
        clickElement(newPlaylistMenu);
        // Enter the playlist name
        enterText(playlistNameField, playlistName);
        // Press Enter to confirm
        findElement(playlistNameField).sendKeys(Keys.RETURN);
    }

    // Method to rename a playlist
    public void renamePlaylist(String newPlaylistName) {
        // Find the active playlist
        WebElement playlist = findElement(activePlaylist);
        // Double click to enable renaming
        actions.moveToElement(playlist).doubleClick().perform();
        // Find the input field for renaming
        WebElement inputField = findElement(renamePlaylistInput);
        // Clear the existing name and enter the new name
        inputField.clear();
        inputField.sendKeys(newPlaylistName);
        // Press Enter to confirm
        inputField.sendKeys(Keys.RETURN);
    }

    // Method to check if the success popup is displayed
    public boolean isSuccessPopupDisplayed() {
        return findElement(successPopup).isDisplayed();
    }
}