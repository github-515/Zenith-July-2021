package adding_Ecomerce_Items;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class adding_Ecomerce_Items1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded); // akhane jehutu static method k call korchi tai r obj create kora holo na.
		driver.findElement(By.cssSelector("img[alt='Cart'")).click();
	
	
	
	}
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i<products.size(); i++) 
		{
		String[] name=products.get(i).getText().split("-");	
		String formattedName=name[0].trim();
		// convert array into array list
		List itemsNeededList = Arrays.asList(itemsNeeded);
		 int j=0;
		if (itemsNeededList.contains(formattedName)) 
		{
		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			if(j==3) {
				break;
			}
		}
		}
		
	}

}
