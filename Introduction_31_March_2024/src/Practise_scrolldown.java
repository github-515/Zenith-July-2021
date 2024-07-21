
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practise_scrolldown {

	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("Webdriver.chrome.driver", "/home/msr/eclipse-workspace/chromedriver");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor  js   =  (JavascriptExecutor)driver; // js use indentifies obj which has hidden obj
//          (class)        (obj) =  (now you casting your driver to Javascript executor, now driver will be aware that it can go ahead & execute js)  
		js.executeScript("window.scrollBy(0,500)");   // Browser > Go to console & execute js > window.scrollBy(0,500)
		Thread.sleep(3000);   // for inside the table scrolling of webpage > document.querySelector(".tableFixHead").scrollTop=5000
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000\n"); // inside use single ''
        
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for (int i=0; i<values.size(); i++)
		{
//			System.out.println(Integer.parseInt(values.get(i).getText()));   // getText() return you 28 as string format but we need to change as a integer format
//			System.out.println(values.size());  // values.size() hole 9 ta jehutu 9 ta column ache.
			Integer.parseInt(values.get(i).getText());
		    sum = sum + Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);                                              
		driver.findElement(By.cssSelector(".totalAmount")).getText();                                                                   // check in console > $(".totalAmount") 
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
		
	}

}