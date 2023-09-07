package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22 {
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
	public void TC_01_VerifyUrl() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
	}
	
	@Test
	public void TC_02_VerifyTitle() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
	
	@Test
	public void TC_03_NavigateFunction() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		driver.navigate().forward();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
	
	@Test
	public void TC_04_GetPageSourceCode() {
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
