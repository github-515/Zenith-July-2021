package practise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class url_200 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		WebDriver driver;
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://111.93.227.212/zmp/login.do");
//		driver.get("http://172.30.3.13/zmp/login.do");
//		driver.get("http://192.168.82.1/zmp/login.do");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(7000));
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("MSR@chola2022");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='button']")).click();
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='mega-menu']")));
		
		Actions action = new Actions(driver);
		 WebElement element = driver.findElement(By.linkText("Dashboard"));
         action.moveToElement(element).build().perform();
         Thread.sleep(1000);

//       System.out.println(driver.findElement(By.tagName("a")).getAttribute("href"));
       String url =driver.findElement(By.tagName("a")).getAttribute("href");
         
//         String url =driver.findElement(By.cssSelector("a[href='main-menu.do']")).getAttribute("href");
         HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
         conn.setRequestMethod("GET");
         conn.connect();
         int respCode = conn.getResponseCode();
         System.out.println("start");
     	System.out.println(respCode);
	    
     	Thread.sleep(2000);
	
	
        String url1 =driver.findElement(By.cssSelector("a[href='show-consolidate-dashboard-data.do']")).getAttribute("href");
        HttpURLConnection conn1 = (HttpURLConnection) new URL(url1).openConnection();
        conn1.setRequestMethod("GET");
        conn1.connect();
        int respCode1 = conn1.getResponseCode();
    	System.out.println(respCode1);
    	 System.out.println("end");

//       System.out.println(driver.findElement(By.tagName("a")).getAttribute("href"));
//       a[href='javascript:void(0);']
        
}
}
