package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By emailtextbox=By.id("mail");
	By ageUnder18Radio=By.cssSelector("#under_18");
	By educationTextArea=By.cssSelector("#edu");
    By nameuser5txt=By.xpath("//h5[text()='Name: User5']");
    By Password=By.cssSelector("#disable_password");
    By BioTextarea=By.cssSelector("#bio");
    By Developmentcheckbox=By.cssSelector("#development");
	

	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
//		test
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

//		test
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_Empty_email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(3);
		
		driver.findElement(By.id("send2")).click();
		SleepInsecon(3);
		
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	
		}
	//@Test
	public void TC_02_Invalid_email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(3);
		
		driver.findElement(By.id("email")).sendKeys("123454@432434");
		driver.findElement(By.id("pass")).sendKeys("123456");
		
		driver.findElement(By.id("send2")).click();
		SleepInsecon(3);
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
			
		}
	//@Test
	public void TC_03_pass_than_less_6char() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(3);
		
		driver.findElement(By.id("email")).sendKeys("hangle@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
	
		driver.findElement(By.id("send2")).click();
		SleepInsecon(3);	
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");		
		}
	
	@Test
		public void TC_04_incorrect_email_pass() {
			driver.get("http://live.techpanda.org/");
			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
			SleepInsecon(3);
			
			driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("123123123");
		
			driver.findElement(By.id("send2")).click();
			SleepInsecon(3);	
			Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//span")).getText(), "Invalid login or password.");		
			}
	
public void SleepInsecon(long timeInsecond) {
	try {
		Thread.sleep(timeInsecond*1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
