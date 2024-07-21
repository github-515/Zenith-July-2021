import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Bug_Devops_APRIL2024 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.azure.com/msrlimited/Smartler/_backlogs/backlog/Smartler%20Team/Epics");
		// Dynamic values

		String value = "TV_VOL_MUTE is called twice when try to turn on / turn off TV";
		// Calender
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0); // Adds 2 days to the current date. After this line, cal represents the date 2
									// days from the current date.
		cal.add(Calendar.MONTH, 0);
		cal.add(Calendar.YEAR, 0);

//	     HIT EPIC
		try {
			WebElement epic = driver.findElement(By.xpath("(//div[@aria-label='Expand child rows'])[19]"));
			epic.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
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

		// HIT EPIC
		WebElement epic = driver.findElement(By.xpath("(//div[@aria-label='Expand child rows'])[19]")); // Need to
																										// change the
																										// xpath
		epic.click();
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
		Thread.sleep(2000);

//		        HIT Feature
		driver.findElement(By.xpath("(//div[@aria-label='Expand child rows'])[15]")).click(); // Need to change the
																								// xpath

//		Thread.sleep(2000);
//		js.executeScript("document.querySelector('.grid-canvas.ui-draggable').scrollBy(0,800)");
//		Thread.sleep(1000);
////	             driver.findElement(By.xpath("//div[@aria-label='Expand child rows'])[8]")).click();
//
////	             HIT User story
//		driver.findElement(By.xpath("//div[@id='row_vss_2_9773']//div[@aria-label='Expand child rows']")).click(); // Need
//																													// to
//																													// change
//																													// the
//																													// xpath
//
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@id='row_vss_2_9773']//i[@aria-label='Add child']")).click();
//		Thread.sleep(1000);
////	             System.exit(0);
//
////		Create BUG
////	             WebElement task = driver.findElement(By.linkText("Task"));
//		WebElement task = driver.findElement(By.xpath("//span[normalize-space()='Bug']"));
//		task.click();
		Thread.sleep(12000);
	
			driver.findElement(By.xpath("//input[@placeholder='Enter title']")).sendKeys(value);
			// Activity
			Thread.sleep(2000);
//			driver.findElement(By.id("witc_12_txt")).sendKeys("Testing");
	
		
		driver.findElement(By.xpath("//span[text()='Unassigned']")).click();
		Thread.sleep(2000);
		WebElement task1 = driver.findElement(By.xpath("//span[text()='payel_paul']")); // Need to change name from here
		WebElement task2 = driver.findElement(By.xpath("//span[text()='ankita_seth']"));
		WebElement task3 = driver.findElement(By.xpath("//span[text()='Somenath Das']"));
		WebElement task4 = driver.findElement(By.xpath("//span[text()='Kishan Das']"));
        task2.click();       // here we need to change the name
		try {
			driver.findElement(By.cssSelector("div[aria-label=\"Description\"]")).sendKeys(value);

			Thread.sleep(2000);

			// Calender
			Date d = cal.getTime(); // Converts the Calendar object cal to a Date object d.
			System.out.println("Date d : " + d);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dateString = sdf.format(d);
			System.out.println(dateString);
			driver.findElement(By.id("witc_13_txt")).sendKeys(dateString);
			Thread.sleep(3000);
			driver.findElement(By.id("witc_14_txt")).sendKeys("8");
//	             Thread.sleep(1000);
			driver.findElement(By.id("witc_16_txt")).sendKeys("8");
			Thread.sleep(2000);
//				 WebElement save_and_close=driver.findElement(By.id("mi_767_save-and-close-work-item"));
//				 save_and_close.click();
//	             System.exit(0);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("An org.openqa.selenium.NoSuchElementException: " + e.getMessage());
		}
		// To print BUG ID
		
		
		driver.findElement(By.xpath("//span[text()='Save & Close']")).click();

		Thread.sleep(2000);

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

//		Thread.sleep(3000);
//		driver.findElement(By.id("witc_59_txt")).click();
//		Thread.sleep(2000);
//
//		WebElement element1 = driver.findElement(By.id("witc_59_txt"));
//		actions.doubleClick(element1).perform();
//		Thread.sleep(2000);
//		element1.sendKeys("Closed");
//
//		Thread.sleep(2000);
//		element1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Save & Close']")).click();
		Thread.sleep(3000);
		driver.close();
	}

}