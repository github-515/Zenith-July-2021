package zenith;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZenithPortalBrokenLinks {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("http://111.93.227.212/zmp/login.do");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("MSR@chola2022");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='button']")).click();
        
        Thread.sleep(3000); // wait for the page to load

        // Get all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        int totalLinks = links.size();
        int jsVoidCount = 0;
        int response200Count = 0;
        int brokenLinkCount = 0;

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            
            if (url == null || url.isEmpty()) {
                continue;
            }
            
            if (url.contains("javascript:void(0)")) {
                jsVoidCount++;
                System.out.println("Skipping invalid or JavaScript-based URL: " + url);
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("GET");
                connection.connect();
                
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    response200Count++;
                } else if (responseCode >= 201) {
                    brokenLinkCount++;
                    System.out.println("Broken link detected (Response code " + responseCode + "): " + url);
                }
                
                System.out.println("Response code for " + url + ": " + responseCode);
            } catch (Exception e) {
                System.out.println("Error connecting to URL: " + url);
            }
        }
        
        System.out.println("Total number of links: " + totalLinks);
        System.out.println("Number of 'javascript:void(0)' links: " + jsVoidCount);
        System.out.println("Number of links with a 200 response: " + response200Count);
        System.out.println("Number of broken links (response code 200+): " + brokenLinkCount);

        driver.quit();
    }
}
