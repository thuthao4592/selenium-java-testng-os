package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_PIII {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Empty_Email_And_Password(){
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		
		driver.findElement(By.id("send2")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(),"This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(),"This is a required field.");

		
		
		
	}
	
	@Test
	public void TC_02_Invalid_Email(){
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
			
		driver.findElement(By.id("email")).sendKeys("1215621772@2535.14112");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
			
		}
		
	
	@Test
		public void TC_03_Password_Less_Than_6_Chars(){
			driver.get("http://live.techpanda.org/");
			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
			sleepInSecond(2);
				
			driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("123");
			driver.findElement(By.id("send2")).click();
			sleepInSecond(2);
			
			Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
				
			}
			
		
	@Test
	public void TC_04_Incorrect_Email_And_Password(){
			driver.get("http://live.techpanda.org/");
			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
			sleepInSecond(2);
						
			driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("123123123");
			driver.findElement(By.id("send2")).click();
			sleepInSecond(2);
					
			Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");
						
		}	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
