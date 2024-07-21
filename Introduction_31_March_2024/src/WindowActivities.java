import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com"); // .get method uses 
//		Load a new web page in the current browser window. This is done using an HTTP POST operation, 
//		and the method will block until the load is complete (with the default 'page load strategy'. 
		driver.navigate().to("https://rahulshettyacademy.com"); // navigate method will not block until the load is complete.
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();

	}

}
