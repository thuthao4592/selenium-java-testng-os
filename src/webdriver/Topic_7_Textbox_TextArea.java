package webdriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_7_Textbox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By username = By.xpath("//div[@class='orangehrm-login-form']//input[@name='username']");
	By password = By.xpath("//div[@class='orangehrm-login-form']//input[@name='password']");
	By submit = By.xpath("//div[@class='orangehrm-login-form']//button[@type='submit']");
	
	String firtName, middleName, lastName, employeeId, newuserName, newpassWord, confirmPassword, number, comment;
	
	Random rand;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		rand = new Random();
		
		firtName = "Thang";
		middleName = "ck";
		lastName = "Thao" + rand.nextInt(9999);
		
		newuserName = lastName;
		newpassWord = "12345678tT@";
		confirmPassword = newpassWord;
		
		number = "40517-402-96-7202";
		comment = "This is generated date of real people This is generated date of real people";
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
	public void TC_01_() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sleepInSecond(5);
		
		driver.findElement(username).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(submit).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//span[text()='PIM']")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//div[@class='oxd-topbar-body']//a[text()='Add Employee']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='firstName']")).sendKeys("Thang");
		driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='middleName']")).sendKeys(middleName);
		driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='lastName']")).sendKeys(lastName);
		employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input")).getAttribute("value");
		
		driver.findElement(By.xpath("//p[text()='Create Login Details']/parent::div//span")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input")).sendKeys(newuserName);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div//input")).sendKeys(newpassWord);
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div//input")).sendKeys(confirmPassword);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInSecond(8);
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='firstName']")).getAttribute("value"),"Thang");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='middleName']")).getAttribute("value"),middleName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='lastName']")).getAttribute("value"),lastName);
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input")).getAttribute("value"),employeeId);
		
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div//input")).sendKeys(number);
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea")).sendKeys(comment);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[text()='Passport']/parent::div/following-sibling::div//i[@class='oxd-icon bi-pencil-fill']")).click();
		sleepInSecond(5);
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div//input")).getAttribute("value"), number);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div//textarea")).getAttribute("value"),comment);
		
		driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']/following-sibling::p")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.findElement(username).sendKeys(newuserName);
		driver.findElement(password).sendKeys(newpassWord);
		driver.findElement(submit).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//div[@class='oxd-sidepanel-body']//span[text()='My Info']")).click();
		sleepInSecond(5);
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='firstName']")).getAttribute("value"),"Thang");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Full Name']/parent::div/following-sibling::div//input[@name='lastName']")).getAttribute("value"),lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div//input")).getAttribute("value"),employeeId);
	
		System.out.println("employeeId = " + employeeId);
	}
}
