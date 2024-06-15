package homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewHomePage extends NewBasePage {

    private By userAvatar = By.cssSelector("selector-for-user-avatar");

    public NewHomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatar);
    }
}

/*
package homework22;
// All pages require
// Class constructor
// Locators
// Methods to pass the locators
// Final method to include all methods

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewHomePage extends NewBasePage {
    //1- CONSTRUCTOR
    public NewHomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
    // 2- LOCATORS
    By userAvatarIcon = By.cssSelector("img.avatar");

    //3-METHODS
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
    // You can add more methods to reflect what is happening in the home page

}

 */
