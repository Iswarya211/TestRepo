import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class LoginTest {

    public static void main(String[] args) {

        // Setup Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open login page
            driver.get("https://example.com/login");

            // Locate username field
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("testuser");

            // Locate password field
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("password123");

            // Locate login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Optional: Validate successful login
            String currentUrl = driver.getCurrentUrl();
            System.out.println("After login URL: " + currentUrl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
