package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class actionDemo {

	public static void main(String[] args) {
//		System.setProperty("Webdriver.chrome.driver", "/home/msr/eclipse-workspace/chromedriver");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		Actions a = new Actions(driver); // akhane driver holo parameter jate Action class a driver er method gulo kaj kore.
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));	
//		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform(); // for hover
		// build holo ready to execute // perform holo execut // execute korar jonno ai 2 to meghod use hobe 
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform(); // Capital letter
		a.moveToElement(move).contextClick().build().perform(); // for right click
	}

}