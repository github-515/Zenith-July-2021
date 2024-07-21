package zenith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertiesFile;

public class FirstSeleniumTest {

	public static String browser;
	static WebDriver driver;
	public static void main(String[] args) {
//		setBrowser();
		PropertiesFile.readPropertiesFile();
		setBrowserConfig();
		runTest();
		PropertiesFile.writePropertiesFile();
		
	}

	// set Browser
	// set Browser config
	//run test

	public static void setBrowser() {
		browser="Firefox";
	}

	public static void setBrowserConfig() {
		
//		String projectLocation = System.getProperty("user.dir");
		if(browser.contains("Firefox")) {
	
		driver = new FirefoxDriver();
		}
		if(browser.contains("Chrome")) {
		
		driver = new ChromeDriver();
		}
		
	}

	public static void runTest() {
		
//		driver.manage().window().maximize();
				driver.get("http://111.93.227.212/zmp/login.do");
		//		driver.get("http://172.30.3.13/zmp/login.do");
//		driver.get("https://www.google.com");
		
		driver.quit();
	

	}

}
