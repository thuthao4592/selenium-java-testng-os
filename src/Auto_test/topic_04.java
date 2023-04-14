package Auto_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.Msedgedrive;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@SuppressWarnings("unused")
public class topic_04 {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	

	@Test 
	public void TC_01_Run_Firefox() {
		// Firefox
				//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get("https://github.com/nguyenthuhuong91?tab=repositories");
				driver.quit();
	}
	
	@Test 
	public void TC_02_Run_Chrome() {
		// Chrome
				//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedrive.exe");
				driver = new ChromeDriver();
				driver.get("https://github.com/nguyenthuhuong91?tab=repositories");
				driver.quit();
	}
	
//	@Test 
//	public void TC_03_Run_Edge() {
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\msedgedrive.exe");
//		driver = new Msedgedrive();
//		driver.get("https://github.com/nguyenthuhuong91?tab=repositories");
//		driver.quit();

}
