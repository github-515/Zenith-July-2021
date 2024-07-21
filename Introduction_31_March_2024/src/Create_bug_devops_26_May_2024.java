import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_bug_devops_26_May_2024 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.azure.com/msrlimited/Smartler/_backlogs/backlog/Smartler%20Team/Epics");
		
		// Dynamic user story
//		String searchKeyword = "ITC Sheraton TV Application Testing [Black Theme]";
//		String searchKeyword = "BLK TV Application Testing";
//		String searchKeyword = "Zenith Related Testing";
		String searchKeyword = "Zenith Patch Testing";
		
		// Dynamic values

		String value = "[Zenith] Report >TV App Streaming Report> App Names should be present instead of Channel name"
				+ "[Zenith] Report >DTH Channel Streaming Report >Channel name should be channel names.";
		
		// Dynamic Names
		
//		  String searchname = "Kishan Das";
//	        String searchname = "payel_paul";
//	        String searchname = "ankita_seth";
//	        String searchname = "Somenath Das";
	        String searchname = "anisha_bhardwaj";
//	        String searchname = "Prabir Paul";
//	        String searchname = "Krishna Sarkar";
//	        String searchname = "prashanta_acharjee";
//	        String searchname = "sumon_roy";
		
		
		// Calender
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0); // Adds 2 days to the current date. After this line, cal represents the date 2
									// days from the current date.
		cal.add(Calendar.MONTH, 0);
		cal.add(Calendar.YEAR, 0);
		
//	     HIT EPIC
		try {
	WebElement epic=driver.findElement(By.xpath("(//div[@aria-label='Expand child rows'])[19]"));
	epic.click();

		}catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("An org.openqa.selenium.NoSuchElementException: " + e.getMessage());
		}
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(4000);
		driver.findElement(By.id("i0116")).sendKeys("debashis_das@msrlimited.com");
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(4000);

		driver.findElement(By.id("i0118")).sendKeys("das9831801906");
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("declineButton")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		        js.executeScript("window.scrollBy(10, 500)");
		Thread.sleep(4000);
		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
//		        js.executeScript("document.querySelector('#row_vss_2_9506').scrollTop=5000\n");
		Thread.sleep(2000);
		
		
		

		//	     HIT EPIC
		 WebElement epic=driver.findElement(By.xpath("(//div[@aria-label='Expand child rows'])[19]")); // Need to change the xpath
        epic.click();
        Thread.sleep(2000);
		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
		Thread.sleep(2000);
		
//		 HIT Feature
		
//		driver.findElement(By.xpath("(//div[@id='row_vss_2_10173'])[1]")).click();
		
		List<WebElement> Features=driver.findElements(By.cssSelector(".grid-row.grid-row-normal"));

		for (int i=0; i<Features.size(); i++ )
		{
			String name=Features.get(i).getText();	
			if (name.contains("QA Activities")) 
			{
				Thread.sleep(2000);
				System.out.println("found 'QA Activities' ");
			driver.findElements(By.xpath("//div[@aria-label='Expand child rows']")).get(i).click();
			break;
			}
			
		}
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
		Thread.sleep(2000);
		
		List<WebElement> UserStory=driver.findElements(By.cssSelector(".grid-row.grid-row-normal"));

		for (int i=0; i<UserStory.size(); i++ )
		{
			String name=UserStory.get(i).getText();	
			if (name.contains(searchKeyword)) 
			{
				Thread.sleep(2000);
				System.out.println("found 'Zenith Related Testing' ");
				driver.findElements(By.xpath("//a[@class='work-item-title-link']")).get(i).click();
				Thread.sleep(2000);
				driver.navigate().back();
//			driver.findElements(By.xpath("//div[@aria-label='Expand child rows']")).get(i).click();
			
			break;
			}
			
		}
		
//	       Create BUG
		Thread.sleep(2000);
//		 driver.findElement(By.xpath("//div[@id='row_vss_2_10206']//i[@aria-label='Add child']")).click();
		 driver.findElement(By.xpath("//div[contains(@class, 'grid-row') and contains(@class, 'grid-row-normal') and contains(@class, 'grid-row-current') and contains(@class, 'grid-row-selected')]//i[@aria-label='Add child']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bugElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Bug']")));
//        WebElement bugElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Task']")));
        System.out.println("Element found: " + bugElement.getText());
		WebElement task = driver.findElement(By.xpath("//span[normalize-space()='Bug']"));
        Thread.sleep(1000);
//        WebElement task = driver.findElement(By.xpath("//span[normalize-space()='Task']"));
		task.click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter title']")).sendKeys(value);
		// Activity
		Thread.sleep(2000);
//		driver.findElement(By.id("witc_12_txt")).sendKeys("Testing");

	
	driver.findElement(By.xpath("//span[text()='Unassigned']")).click();
	Thread.sleep(2000);
	
    // Target name by search name           
        
        WebElement task4 = driver.findElement(By.xpath("//span[text()='" + searchname + "']"));
        task4.click(); 
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[@data-placeholder='Click to add Repro Steps']")).sendKeys(value);
        
	try {
		driver.findElement(By.cssSelector("div[aria-label=\"Description\"]")).sendKeys(value);

		Thread.sleep(2000);

		// Calendar
		Date d = cal.getTime(); // Converts the Calendar object calendar to a Date object d.
		System.out.println("Date d : " + d);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = sdf.format(d);
		System.out.println(dateString);
		driver.findElement(By.id("witc_13_txt")).sendKeys(dateString);
		Thread.sleep(3000);
		driver.findElement(By.id("witc_14_txt")).sendKeys("8");
//             Thread.sleep(1000);
		driver.findElement(By.id("witc_16_txt")).sendKeys("8");
		Thread.sleep(2000);
//			 WebElement save_and_close=driver.findElement(By.id("mi_767_save-and-close-work-item"));
//			 save_and_close.click();
//             System.exit(0);
	} catch (org.openqa.selenium.NoSuchElementException e) {
		System.out.println("An org.openqa.selenium.NoSuchElementException: " + e.getMessage());
	}

//	System.exit(0); 
	
	driver.findElement(By.xpath("//span[text()='Save & Close']")).click();
	// To print BUG ID
	Thread.sleep(2000);
//	driver.close()	;
	WebElement element = driver
			.findElement(By.cssSelector(".grid-row.grid-row-normal.grid-row-selected.grid-row-current"));
	// Create Actions object
	Actions actions = new Actions(driver);

	// Double click on the element
	actions.doubleClick(element).perform();

	Thread.sleep(2000);
	System.out.println("BUG ID : "+driver.findElement(By.xpath("//span[@aria-label=\"ID Field\"]")).getText());
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@aria-label='Repro Steps']")).sendKeys(value);


	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Save & Close']")).click();
	Thread.sleep(3000);
//////////////////////////////////////////////////////////////////////////////////////////

//driver.close()	;
		
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////		
//		System.exit(0); 
		
		

	}

}