package config;

import java.util.Properties;

import zenith.FirstSeleniumTest;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

import java.io.InputStream;

public class PropertiesFile {
	static Properties prop = new Properties();        // 1. create a obj class of properties file
	
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
		
	}
	
	
	
	// How to get data from Properties File
	public static void readPropertiesFile() {
		
		try {
												  // 2. create a obj class of input stream.
			InputStream input = new FileInputStream("/home/msr/git/Introduction_31_March_2024/Introduction_31_March_2024/src/config/config.properties");
												  // 3. Load properties file
			// this statement will make our configuration or the properties file avilable to our java program
			prop.load(input);
												// 4. Get values from properties file. 
			System.out.println(prop.getProperty("browser"));
			FirstSeleniumTest.browser = prop.getProperty("browser");
			System.out.println(FirstSeleniumTest.browser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// How to set data to Properties File
	
	public static void writePropertiesFile() {
		
		// 1. create a obj class of properties file // already assigned
		// 2. create a obj class of output stream.
		
		try {
		
			OutputStream output = new FileOutputStream("/home/msr/git/Introduction_31_March_2024/Introduction_31_March_2024/src/config/config.properties");
		// 3. Set values
//			prop.setProperty("browser", "Chrome");
			
			// Add a new parameter
			prop.setProperty("Result", "pass");
			
		// 4. store vaules in properties file.
			prop.store(output, null); // you can also comment as "comments" instead of null.
			
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
	}
	
	
}
