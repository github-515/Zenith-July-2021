package adding_Ecomerce_Items;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class me {
	
	 
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver();
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		
        driver.get("https://rahulshettyacademy.com/seleniumPractise/"); // //button[text()='ADD TO CART'] ata diye find korlam 30 ta elemt dekharche
        
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));  // findElements hobe 30 ta ache tai                                                        //h4.product-name 30 ta show korche
        
        for(int i=0;i<products.size();i++)
        {
        	String[] name=products.get(i).getText().split("-"); // product er i index theke text tule name a rakche
        	//Brocolli,    1 kg

        	String formattedName=name[0].trim(); // name [0] = "Cauliflower " Cauliflower er porer space take trim korchi// name [1] =  1 Kg 
        	// check whether name you extracted is present in array or not
        	// convert array into array list // search google convert array to array list
        	List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        	if(itemsNeededList.contains(formattedName))
        	{
        		// click on add to cart
        		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); 
        		// text locator "ADD TO CART" change hoye ADDED hoye jache tai o next item k ADD to cart hisabe khuje pachhe & next item k 0 index theke start korche
        	}
        }
            
	}

}