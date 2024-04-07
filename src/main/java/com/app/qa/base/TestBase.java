package com.app.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Actions action;
	
	
	public TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream("./src/main/resources/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			action=new Actions(driver);
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));	
	}

}
