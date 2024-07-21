package zenith;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class link {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
//		driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://111.93.227.212/zmp/login.do");
//		driver.get("http://172.30.3.13/zmp/login.do");
//		driver.get("http://192.168.82.1/zmp/login.do");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(7000));

		


		 // List of dynamic link texts
        List<String> linkTexts = List.of("Dashboard","Configuration Setup","Service Setup","Guest Management","User Management","Reports", "Support"); // Add your dynamic link texts here
//        List<String> linkTexts = List.of("Dashboard"); // Add your dynamic link texts here

		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin123");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='button']")).click();
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='mega-menu']")));

		
//		Thread.sleep(4000);
		
		
		// 1. Give me the count of the links on the page.
    	System.out.println("Total links in the Page : "+driver.findElements(By.tagName("a")).size());
    	
    	// 2. count of the link from all Management section
    	Actions action = new Actions(driver);
    	
    	  // Iterate through the list and perform mouse over action
        for (String linkText : linkTexts) {
            try {
                WebElement element = driver.findElement(By.linkText(linkText));
                action.moveToElement(element).build().perform();
                Thread.sleep(1000);
        		WebElement count_of_link = driver.findElement(By.xpath("//li[@class='dc-mega-li mega-hover']//ul[@class='submenu sub']"));
        		System.out.println("\n");
    			System.out.println(linkText+" menu contains"+" : "+count_of_link.findElements(By.tagName("a")).size()+" links");
    			System.out.println("\n");
                Thread.sleep(1000); // Pause for 1 second
                              
        		// click on each link of the column & check if the pages are opening
        		
        		for (int i=0; i< count_of_link.findElements(By.tagName("a")).size(); i++)
        		{
        			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
        			count_of_link.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        			Thread.sleep(5000L);
        			
        		}               // open all the Tabs 
        		
        		String originalWindow = driver.getWindowHandle(); // Save the original window handle
        		Set<String> abc = driver.getWindowHandles(); // Get all window handles
        		Iterator<String> it = abc.iterator();  

        		while (it.hasNext()) {
        		    String windowHandle = it.next(); // Get the next window handle
        		    driver.switchTo().window(windowHandle); // Switch to the window
        		   
        		    // Print the current URL and close the window if it's not the original window
        		    if (!windowHandle.equals(originalWindow)) {  	// 	originalWindow jodi windowHandle na hoy    	
        		    	 System.out.println(driver.getCurrentUrl()); // Print the current URL
        		        driver.close();
        		    }
        		}
        		
        		// Switch back to the original window
        		
        		driver.switchTo().window(originalWindow);
        		Thread.sleep(1000);

                
                
                
                
                
                
                
                
                
                
                
                
                
                
            } catch (Exception e) {
                System.out.println("Could not find element with link text: " + linkText);
            }
        }
    	
        
        
        
        
        
        
        
        
        
    	
//		a.moveToElement(driver.findElement(By.linkText("Support"))).build().perform();
		
//		WebElement GuestManagement = driver.findElement(By.xpath("(//div[@class='sub-container mega'])[6]"));
//		WebElement GuestManagement = driver.findElement(By.xpath("//li[@class='dc-mega-li mega-hover']//ul[@class='submenu sub']"));

//    			System.out.println(GuestManagement.findElements(By.tagName("a")).size());


		
		
		
		
//        driver.close();
//		System.exit(0); 
		
		

	}

}
