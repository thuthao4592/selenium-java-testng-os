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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_WebBrower {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

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

	@Test
	public void TC_01_Url() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(3);
		assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		SleepInsecon(3);
		assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

	}

	@Test
	public void TC_02_Title() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(3);
		assertEquals(driver.getTitle(), "Customer Login");
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		SleepInsecon(3);
		assertEquals(driver.getTitle(), "Create New Customer Account");

	}

	@Test
	public void TC_03_navigate() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(2);
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		SleepInsecon(2);
		
		driver.navigate().back();
		SleepInsecon(2);
		assertEquals(driver.getTitle(), "Customer Login");
		
		driver.navigate().forward();
		SleepInsecon(2);
		assertEquals(driver.getTitle(), "Create New Customer Account");

	}
	@Test
	public void TC_04_page_source_HTML() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInsecon(2);
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		SleepInsecon(2);
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
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
