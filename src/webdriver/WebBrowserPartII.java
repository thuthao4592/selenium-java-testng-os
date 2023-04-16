package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebBrowserPartII {
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
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
}
	@Test
	public void TC_01_Url(){
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title=\"My Account\"]")).click();
		SleepInSecond(5);
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		SleepInSecond(5);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

	}
	@Test
	public void TC_02Title() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title=\"My Account\"]")).click();
		SleepInSecond(5);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		SleepInSecond(5);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
		
	}
	@Test
	public void TC_01_Navigate() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title=\"My Account\"]")).click();
		SleepInSecond(5);	
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		SleepInSecond(5);
		driver.navigate().back();
		SleepInSecond(5);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		driver.navigate().back();
		SleepInSecond(5);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
	@Test
	public void TC_01_PageSourceHTML() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInSecond(5);
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		SleepInSecond(5);
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void SleepInSecond(long timeinSecond)
	{
	try {
		Thread.sleep(timeinSecond* 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
