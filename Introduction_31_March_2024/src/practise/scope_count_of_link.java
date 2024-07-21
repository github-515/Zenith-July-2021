package practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope_count_of_link {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("Webdriver.chrome.driver", "/home/msr/eclipse-workspace/chromedriver");
		WebDriver driver ;
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
	
		
		// 1. Give me the count of the links on the page.
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// 2. count of the link from footer section
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3. count of the link of 1st column of footer section
		
		WebElement colomdriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(colomdriver.findElements(By.tagName("a")).size());
		
//     // 4. count of the link of 2nd column of footer section
//        
//        WebElement colomdriver2 = driver.findElement(By.xpath("(//tbody/tr/td/ul)[2]"));
//        System.out.println(colomdriver2.findElements(By.tagName("a")).size());
		
		// click on each link of the column & check if the pages are opening
		
		for (int i=1; i< colomdriver.findElements(By.tagName("a")).size(); i++)
		{
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			colomdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}               // open all the Tabs 
		
			            Set<String> abc = driver.getWindowHandles(); //4
			                   Iterator<String> it = abc.iterator();  
			              while(it.hasNext()) // if it has any windows present // Return true if the iteration has more elements.
			            {
			            	driver.switchTo().window(it.next());  // it.next start with 0 index means this addr(https://rahulshettyacademy.com/AutomationPractice/) // next jabe index1, 2 , 3 etc
			            	// it.next jate bar bar na likte hoy sai karone while loop a kaj korchi..
			            	System.out.println(driver.getTitle());
			            }
			
		

	}

}