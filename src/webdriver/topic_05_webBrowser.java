package Auto_test;

import java.util.concurrent.TimeUnit;

import org.dataloader.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class topic_05_webBrowser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_Verify_Url() {
		driver.get("http://live.techpanda.org/");
		
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		// Click Create an account
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
	}

	public void Verify_Title() {
		driver.get("http://live.techpanda.org/");
		
		// Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		// Click Create an account
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");	
		
	}

	public void Navigate_funtion() {
		driver.get("http://live.techpanda.org/");
		
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		// Click Create an account
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
		
		// Back lại
		driver.navigate().back();
		sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		//Forward
		driver.navigate().forward();
		sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");	
	}
	
	public void get_page_source_code() {
		driver.get("http://live.techpanda.org/");
		
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\\\"footer\\\"]//a[@title= \\\"My Account\\\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		// verify page HTML có chứa  chuỗi  mong muốn 
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		// Click Create an account
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
		
		// verify page HTML có chứa  chuỗi  mong muốn 
				Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}
	
	private void sleepInSecond(long timeInsecond) {
			try {
				Thread.sleep(timeInsecond * 1000);
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


