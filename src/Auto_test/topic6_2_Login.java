package Auto_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic6_2_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test 
	public void TC_01_login_with_empty_email_password() {
		driver.get("http://live.techpanda.org/");
	//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		
		
		
		//Verify
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id = \"advice-required-entry-email\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id = \"advice-required-entry-pass\"]")).isDisplayed());
		
		
	}
	@Test
		public void TC_02_Login_with_invalid_email() {
		driver.get("http://live.techpanda.org/");
			//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys("234gtyu@ee");
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
			 
		//verify 
			
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id = \"advice-validate-email-email\"]")).isDisplayed());	
		}
	//@Test
	public void TC_02_Login_with_passord_5char() {
		driver.get("http://live.techpanda.org/");
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		 
		//verify 
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id= \"advice-validate-password-pass\"]")).isDisplayed());
	}
	//@Test
	public void login_with_incorrect_email_password() {
		driver.get("http://live.techpanda.org/");
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
	
		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class= \"error-msg\"]")).isDisplayed());
		
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