import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_task_devops_26_May_2024 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.azure.com/msrlimited/Smartler/_backlogs/backlog/Smartler%20Team/Epics");
		// Dynamic user story
		String searchKeyword = "Zenith Related Testing";
//		String searchKeyword = "Zenith Patch Testing";
		// Dynamic values
		String value = "";
		
		
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
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
		Thread.sleep(2000);
		
		

		List<WebElement> UserStory=driver.findElements(By.cssSelector(".grid-row.grid-row-normal"));

		for (int i=0; i<UserStory.size(); i++ )
		{
			System.out.println(UserStory.get(i).getText());
			String name=UserStory.get(i).getText();	
//			String searchKeyword = "Zenith Related Testing";
			
			if (name.contains(searchKeyword)) 
			{
			
				System.out.println("found 'Zenith Related Testing' ");
				driver.findElements(By.xpath("//a[@class='work-item-title-link']")).get(i).click();
				Thread.sleep(2000);
				driver.navigate().back();
//				System.exit(0); 
//			driver.findElements(By.xpath("//div[@aria-label='Expand child rows']")).get(i).click();

			
			break;
			}
			
		}
		
//		System.exit(0); 
//	       Create Task
		Thread.sleep(4000);
//		 driver.findElement(By.xpath("//div[@id='row_vss_2_10212']//i[@aria-label='Add child']")).click();
		 driver.findElement(By.xpath("//div[contains(@class, 'grid-row') and contains(@class, 'grid-row-normal') and contains(@class, 'grid-row-current') and contains(@class, 'grid-row-selected')]//i[@aria-label='Add child']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement bugElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Bug']")));
        WebElement bugElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Task']")));
        System.out.println("Element found: " + bugElement.getText());
//		WebElement task = driver.findElement(By.xpath("//span[normalize-space()='Bug']"));
        Thread.sleep(1000);
        WebElement task = driver.findElement(By.xpath("//span[normalize-space()='Task']"));
		task.click();

		
		/////////////////////////////////////////////////////////////////////
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter title']")).sendKeys(value);
		// Activity
		Thread.sleep(2000);
//		driver.findElement(By.id("witc_80")).sendKeys("Testing");
//		driver.findElement(By.cssSelector("#witc_124_txt")).sendKeys("Testing");
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("Testing");
		System.out.println(" print Testing ");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Unassigned']")).click();
		Thread.sleep(2000);
		WebElement task1 = driver.findElement(By.xpath("//span[text()='Debashis Das']"));
		task1.click();
		driver.findElement(By.cssSelector("div[aria-label=\"Description\"]")).sendKeys(value);

		Thread.sleep(2000);

		// Calender
		Date d = cal.getTime(); // Converts the Calendar object cal to a Date object d.
		System.out.println("Date d : " + d);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = sdf.format(d);
		System.out.println(dateString);
//		driver.findElement(By.id("witc_13_txt")).sendKeys(dateString);
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(dateString);
		Thread.sleep(3000);
//		driver.findElement(By.id("witc_14_txt")).sendKeys("8");
		driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("4");
//	             Thread.sleep(1000);
//		driver.findElement(By.id("witc_16_txt")).sendKeys("8");
		driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("4");
		Thread.sleep(2000);
//				 WebElement save_and_close=driver.findElement(By.id("mi_767_save-and-close-work-item"));
//				 save_and_close.click();
//	             System.exit(0);
		driver.findElement(By.xpath("//span[text()='Save & Close']")).click();

		Thread.sleep(2000);

		WebElement element = driver
				.findElement(By.cssSelector(".grid-row.grid-row-normal.grid-row-selected.grid-row-current"));
		// Create Actions object
		Actions actions = new Actions(driver);

		// Double click on the element
		actions.doubleClick(element).perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).click();
		Thread.sleep(2000);

		WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		actions.doubleClick(element1).perform();
		Thread.sleep(2000);
		element1.sendKeys("Closed");

		Thread.sleep(2000);
		element1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
//				     driver.findElement(By.id("mi_1114_save-and-close-work-item")).click();
		driver.findElement(By.xpath("//span[text()='Save & Close']")).click();
		Thread.sleep(2000);

		
		
		
		
		
		
		
		
		
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		System.exit(0); 
			
		driver.close();

	}

}