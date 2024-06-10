import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver = null;// 1- declared
    ChromeOptions options = ChromeOptions();
    WebDriverWait wait; // 2- initialized

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
   @BeforeMethod
   @Parameter({"BaseURL"})
   //Precondition
   //Added ChromeOptions argument below
   options.addArguments("--remote-allow-origins=*");
   driver= new ChromeDriver(options);
   driver.manage().timeouts.implicitWait(Duration.ofSeconds(10));
   driver.manage().window().maximize();
   // 3- new line using max 10 seconds wait.
        // loading web driver with driver and max time of 10 sec.
   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   navigateToPage(baseURL);

    }
    @AfterMethod
    public void closeBrowser() { driver.quit()}

    protected void submit() throws InterruptedException {
        // Using WAIT WITH CONDITIONS
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByCssSelector("button[type='submit']")));
        submit.click();
        //Thread.sleep(1000);

    }
}