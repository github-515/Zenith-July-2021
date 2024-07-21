package zenith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ticker {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://111.93.227.212/zmp/login.do");
//		driver.get("http://172.30.3.13/zmp/login.do");
//		driver.get("http://192.168.82.1/zmp/login.do");

		// Dynamic Room No
		int room_no=9996;
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='button']")).click();
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Guest Management"))).build().perform();
//		By.linkText("")


		
		
		
		
		
		System.exit(0); 
		
		

	}

}
