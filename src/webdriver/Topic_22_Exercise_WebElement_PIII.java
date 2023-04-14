package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_Exercise_WebElement_PIII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By emailTextBox = By.id("mail");
	By ageUnder18Radio = By.xpath("//input[@id=\"under_18\"]");
	By educationTextArea = By.cssSelector("#edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By passwordTextbox = By.xpath("//input[@id=\"password\"]");
	By biographyTextArea = By.xpath("//textarea[@id=\"bio\"]");
	By designCheckBox = By.cssSelector("#design");
	
//	Java - System.out.println("");
//	JS - Console.log("");
//	C# - Console.WriteLine("");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Empty_Email_Password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepSecond(2);
		driver.findElement(By.id("send2")).click();
		sleepSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
		
		}
private void sleepSecond(int i) {
	// TODO Auto-generated method stub
	
}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepSecond(2);
		driver.findElement(By.id("email")).sendKeys("13365@4657.245");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		sleepSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	
	}
	@Test
	public void TC_03_Password_Less_Than_6_Chars() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepSecond(2);
		driver.findElement(By.id("email")).sendKeys("thaib3995@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.id("send2")).click();
		sleepSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
		
	}

	@Test
	public void TC_04_Incorrect_Email_PassWord() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepSecond(2);
		driver.findElement(By.id("email")).sendKeys("thaib3995@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("1236435");
		driver.findElement(By.id("send2")).click();
		sleepSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
		
		
		}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
