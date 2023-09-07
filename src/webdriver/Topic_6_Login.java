package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_6_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void TC_01_LoginEmpty() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']//a[text()='My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.id("send2")).click();
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-pass")).isDisplayed());		
	}
	
	@Test
	public void TC_02_InvalidMail() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']//a[text()='My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//ul[@class='form-list']//input[@name='login[username]']")).sendKeys("1231212@12123.4343");
		driver.findElement(By.id("pass")).sendKeys("123456");
		
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Password6() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']//a[text()='My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Incorrect() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//li[@class='first']//a[text()='My Account']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123");
		
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
	
}
