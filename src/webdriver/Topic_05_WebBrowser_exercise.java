package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrowser_exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

		
	@BeforeClass
	public void beforeClass() {

			if (osName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
	}

	
	@Test
	public void TC_01_() {
		driver.get("http://live.techpanda.org/");
		// Click My Account
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(5);		
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		// Click Create an Account
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInSecond(5);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Title() {
		driver.get("http://live.techpanda.org/");
		// Click My Account
		// title---> console
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(5);		
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		// Click Create an Account
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInSecond(5);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");		
		
	}

	@Test
	public void TC_03_Navigate() {
	
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInSecond(3);
		// Back lại
		driver.navigate().back();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		// Forward 
		driver.navigate().forward();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
		
		
		
	@Test
	public void TC_04_Page_Source_HTML() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		// Verify page HTML có chứa 1 chuỗi mong muốn
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
	}
		
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
