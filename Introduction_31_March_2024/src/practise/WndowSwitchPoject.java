package practise;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WndowSwitchPoject {

	public static void main(String[] args) {
	
//		System.setProperty("Webdriver.chrome.driver", "/home/msr/eclipse-workspace/chromedriver");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("div[class='example'] a")).click();
		
		

		Set<String>windows=driver.getWindowHandles(); // getWindowHandles method grab korche id// here windows store parent id & child id for two windows.
		Iterator<String> it = windows.iterator(); // Now this variable goes & extract or get the value present of parent id & child id
		String parentId = it.next();  // if we use it.next then control will goes to parent id which is index 0
		String childId = it.next(); // index 1 // we get child id
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

	}

}