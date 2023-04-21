package Auto_test;

import java.util.Random;
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
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAddress, firstName, lastName, password, fullName ;

	@BeforeClass
	public void beforeClass() {

		rand= new Random();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		emailAddress = "Automation" + rand.nextInt(9999) + "@gmail.com"; 
		firstName = "Automation"; 
		lastName = "FC"; 
		password = "12345678";
		fullName = firstName + " " + lastName; 
		
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
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id= \"advice-required-entry-email\"]")).getText(),"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id= \"advice-required-entry-pass\"]")).getText(),"This is a required field.");

		
	
	}
	//@Test
	public void TC_02_Login_with_invalid_email() {
		driver.get("http://live.techpanda.org/");
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys("2345543@344555.123");
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id= \"advice-required-entry-email\"]")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
 
		//verify 
			
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id = \"advice-validate-email-email\"]")).isDisplayed());	
		}
	//@Test
	public void TC_03_Login_with_passord_5char() {
		driver.get("http://live.techpanda.org/");
		//  Click My account
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		sleepInSecond(2);
		//verify 
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id= \"advice-validate-password-pass\"]")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	//@Test
	public void TC_04_login_with_incorrect_email_password() {
		driver.get("http://live.techpanda.org/");

		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
	
		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class= \"error-msg\"]//span")).getText(), "Invalid login or password.");
	}
	
	@Test
	public void TC_05_create_an_new_account () {
		driver.get("http://live.techpanda.org/");

		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		//Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		
		driver.findElement(By.xpath("//a[@title = \"Create an Account\"]")).click();
		
		driver.findElement(By.xpath("//input[@id= \"firstname\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id= \"lastname\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id= \"email_address\"]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id= \"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id= \"confirmation\"]")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@title= \"Register\"]")).click();
		
		//Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/index/");
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class = \"success-msg\"]//span ")).getText(), "Thank you for registering with Main Website Store.");
		String contactInformationText =  driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(contactInformationText);
		
		Assert.assertTrue(contactInformationText.contains(fullName));
		Assert.assertTrue(contactInformationText.contains(emailAddress));
		
		driver.findElement(By.xpath("//div[@class = \"account-cart-wrapper\"]//span[text()= 'Account']")).click();
		driver.findElement(By.xpath("//a[@title= \"Log Out\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class = \"page-title\"]//img")).isDisplayed());
		
	}
	@Test
	public void TC_06_login_valid_info () {
		driver.findElement(By.xpath("//div[@class=\"footer\"]//a[@title= \"My Account\"]")).click();
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//input[@id = \"email\"]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id= \"pass\"]")).sendKeys("password");
		driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
		sleepInSecond(2);
		String contactInformationText =  driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
	
		
		Assert.assertTrue(contactInformationText.contains(fullName));
		Assert.assertTrue(contactInformationText.contains(emailAddress));
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
