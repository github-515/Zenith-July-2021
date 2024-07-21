package zenith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class guestMessage1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://111.93.227.212/zmp/login.do");
//		driver.get("http://172.30.3.13/zmp/login.do");
		driver.get("http://192.168.82.1/zmp/login.do");

		// Dynamic Room No
		int room_no=1501;
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='button']")).click();
		Thread.sleep(3000);
		
		
	
		
		
		
		
		driver.findElement(By.linkText("Guest Management")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Guest Message")).click();
		Thread.sleep(2000);
//		driver.findElement(By.partialLinkText("Add new Message")).click();
		 WebElement addNewMessageLink = driver.findElement(By.cssSelector("a.k-button.k-button-icontext.k-grid-add[href='create-guest-message.do']"));
         addNewMessageLink.click();

		Thread.sleep(2000);
//		driver.findElement(By.id("destination")).sendKeys(room_no);
		WebElement destinationInput = driver.findElement(By.id("destination"));
        destinationInput.sendKeys(String.valueOf(room_no));
        Thread.sleep(1000);
        driver.findElement(By.id("msgSubject_en")).sendKeys("Test@!!&*^123");
        Thread.sleep(1000);
        driver.findElement(By.id("msgText_en")).sendKeys("@#&^%!!! > We are delighted to welcome you in MSR."
        		+ "We are delighted to welcome you in MSRWe are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR"
        		+ "We are delighted to welcome you in MSR@#&^%!!! > We are delighted to welcome you in MSR.We are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSR@#&^%!!! > We are delighted to welcome you in MSR.We are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSR@#&^%!!! > We are delighted to welcome you in MSR.We are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSRWe are delighted to welcome you in MSR");
        
        
        driver.findElement(By.xpath("//input[@value='Create Message']")).click();
        


		
		
		
		
		
		System.exit(0); 
		
		

	}

}
