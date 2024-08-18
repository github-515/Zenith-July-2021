package zenith;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class broken_link_for_loop {

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
        
        
       List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
       
       SoftAssert a = new  SoftAssert();
       
       for (WebElement link:links) {
    	   
//         System.out.println(driver.findElement(By.cssSelector("a[href='https://www.soapui.org/']")).getAttribute("href"));
           String url =link.getAttribute("href");
   		// There are pre-defined method openconnection() which is come under url class in java
           // obj.method // new URL().openConnection();
           // url send as a argument in openConnection(url)
           // Let use parrent class http
           // openConnection() method return type is HttpURLConnection .
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();// with this method we can open connection send url to the internet network & get response
        // when u hit url in browser making different kind of http method called, one of the methods are head
   //   The HEAD method is similar to the GET method, but with one crucial difference: while a GET request retrieves the full content (like a webpage or file), a HEAD request only retrieves the headers, not the body of the content. 
//        when use: Testing Links: Tools that check the availability of links often use HEAD requests to confirm that a link is valid without downloading the content.
        conn.setRequestMethod("HEAD");
        conn.connect();
        // if you hit a url in browser, u will get a response// conn obj we can send as well as get response
        int respCode = conn.getResponseCode();
   	System.out.println(respCode);
   	// if er bodole Assert use korchi
   	
   	a.assertTrue(respCode<400, "The link with text "+"\u001B[4m" + link.getText() + "\u001B[0m"+" is broken with code "+respCode);
   	       
//    	   if (respCode>400) {
//    		   System.out.println("The link with text "+"\u001B[4m" + link.getText() + "\u001B[0m"+" is broken with code "+respCode);
//    		   Assert.assertTrue(false);
//    	   }
       }
       
       a.assertAll();  // once test execution completed then this line will fail the script// this way we can stop our execution if all links are not clicked
        
        
        
        

	}

}
