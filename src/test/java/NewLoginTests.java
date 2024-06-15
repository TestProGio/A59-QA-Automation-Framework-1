/*import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class NewLoginTests extends NewBaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        // create login page objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(); // Method that does all the login from login page
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //@Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // https://qa.koel.app/
    }

    // @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");
        submit();
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    //@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}

 */
import org.testng.Assert;
import org.testng.annotations.Test;
import homework22.NewLoginPage;
import homework22.NewHomePage;

public class NewLoginTests extends NewBaseTest {

    @Test
    public void loginValidEmailPassword() {
        NewLoginPage loginPage = new NewLoginPage(driver);
        NewHomePage homePage = new NewHomePage(driver);
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        NewLoginPage loginPage = new NewLoginPage(driver);
        loginPage.login("invalid@testpro.io", "te$t$tudent");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test
    public void loginValidEmailEmptyPassword() {
        NewLoginPage loginPage = new NewLoginPage(driver);
        loginPage.login("invalid@testpro.io", "");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {
        NewLoginPage loginPage = new NewLoginPage(driver);
        loginPage.login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}