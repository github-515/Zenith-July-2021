package zenith;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class broken_link {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver;
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		  //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"] // ata te jhar khachhe

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        System.out.println(driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href"));
        String url =driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href");
		// There are pre-defined method openconnection() which is come under url class in java
        // obj.method // new URL().openConnection();
        // url send as a argument in openConnection(url)
        // Let use parrent class http
        // openConnection() method return type is HttpURLConnection .
     HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();// with this method we can open connection send url to the internet network & get response
     // when u hit url in browser making different kind of http method called, one of the methods are head
//   The HEAD method is similar to the GET method, but with one crucial difference: while a GET request retrieves the full content (like a webpage or file), a HEAD request only retrieves the headers, not the body of the content. 
//     when use: Testing Links: Tools that check the availability of links often use HEAD requests to confirm that a link is valid without downloading the content.
     conn.setRequestMethod("HEAD");
     conn.connect();
     // if you hit a url in browser, u will get a response// conn obj we can send as well as get response
     int respCode = conn.getResponseCode();
	System.out.println(respCode);
	}

}
