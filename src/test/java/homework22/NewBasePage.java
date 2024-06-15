package homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public NewBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElementAndCheckClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickElement(By locator) {
        findElementAndCheckClickability(locator).click();
    }

    public void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}