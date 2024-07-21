package zenith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampaignBanner {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://111.93.227.212/zmp/login.do");
//		driver.get("http://172.30.3.13/zmp/login.do");
//		driver.get("http://192.168.82.1/zmp/login.do");
		
		
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
		Thread.sleep(5000);

		 // Locate the file input element (e.g., by ID or any other locator)
        WebElement fileInput = driver.findElement(By.xpath("//div[@class='k-grid-content']//tbody[@role='rowgroup']//img[@id='bannerMenuImageIcon']"));
		Thread.sleep(5000);

        // Specify the path to the file you want to upload
        String filePath = "/home/msr/eclipse-workspace/Introduction_31_March_2024/src/zenith/campaign_banner_image/menu-icon.png";
		Thread.sleep(5000);

        // Send the file path to the file input element
        fileInput.sendKeys(filePath);
		Thread.sleep(5000);

        // Optionally, you might need to submit the form or click an upload button
        WebElement uploadButton = driver.findElement(By.id("bannerMenuImageIcon"));
        uploadButton.click();
		
		
		
		
		
		
		
		
		
		

	}

}
