/*package homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// All pages require
// Class constructor
// Locators
// Methods to pass the locators
// Final method to include all methods


public class NewLoginPage extends NewBasePage{
    // Step 1- create a CONSTRUCTOR so page becomes an object
    //Every page needs a driver
    // super =
    public NewLoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    // Step 2 - include LOCATORS
    By emailField = By.cssSelector ("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    //Step 3 - page METHODS and pass locators
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword (String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitBtn).click();
    }
    public void login() {
        provideEmail("giovanna.silva@testpro.io");
        providePassword("PenGGlOa");
        clickSubmit();
    }
}

 */
package homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLoginPage extends NewBasePage {

    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector("button[type='submit']");

    public NewLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        clickElement(loginButton);
    }
}
