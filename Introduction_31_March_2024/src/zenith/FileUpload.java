package zenith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FileUpload {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver;
        driver = new FirefoxDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the web page with the file upload
    		driver.get("http://111.93.227.212/zmp/login.do");
    		
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin123");
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//input[@name='button']")).click();
    		Thread.sleep(3000);
    		
    		driver.findElement(By.linkText("Service Setup")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.linkText("Campaign Banner")).click();
    		Thread.sleep(2000);
    		
    		driver.findElement(By.cssSelector(".k-button.k-button-icontext.k-grid-add")).click();
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("name")).sendKeys("Test-Campaing, 1@#$%");
    		Thread.sleep(2000);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
            // Explicit wait for the page to load and elements to be available
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the actual file input element (assumed it has id 'file-upload')
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bannerMenuImageIcon")));

            // Make the hidden file input element visible using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);

            // Enter the file path onto the file-selection input field
            fileInput.sendKeys("/home/msr/eclipse-workspace/Introduction_31_March_2024/src/zenith/campaign_banner_image/menu-icon.png");

            // Wait for the upload button to be clickable
//            WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("upload-button")));
//            uploadButton.click();

            // Optional: Verify the file upload success
            // WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
            // Assert.assertEquals("File Uploaded Successfully!", successMessage.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
