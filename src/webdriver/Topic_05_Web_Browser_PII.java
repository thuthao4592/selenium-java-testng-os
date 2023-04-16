package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_PII {
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
	public void TC_01_URL(){
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	
	}
	
	@Test
	public void TC_02_Title(){
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getTitle(), "Customer Login");
	
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(3);
		
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	
	}
	
	@Test
	public void TC_03_Navigate(){
		driver.get("http://live.techpanda.org/");
		
		//Click vào My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		
		//Click vào Create an Account
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//Back lại
		driver.navigate().back();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Foward
		driver.navigate().forward();
		sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
		
	}
	
	@Test
	public void TC_04_Page_Source_HTML(){
		driver.get("http://live.techpanda.org/");
		
		//Click vào My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		
		//Verify page HTML có chứa 1 chuỗi mong muốn
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		//Click vào Create an Account
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//Verify page HTML có chứa 1 chuỗi mong muốn
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
				
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
