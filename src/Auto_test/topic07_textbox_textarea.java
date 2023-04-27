package Auto_test;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic07_textbox_textarea {
	WebDriver driver;
	Random rand= new Random();
	Actions action; 
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String employeeID = String.valueOf(rand.nextInt(99999)) ;
    String passportNumber = "75640-034-05-0978";
    String commnent = "A comment is something you write\nsay that expresses an opinion";
    
    		
	@BeforeClass
	public void beforeClass() {

		rand= new Random();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
	}

	@Test 
	public void TC_01_create_new_Empoloyee() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		sleepInSecond(6);
		
		 driver.findElement(By.xpath("//span[text()= 'PIM']/parent::a/parent::li")).click();
		 sleepInSecond(2);
		 
		 driver.findElement(By.xpath("//a[text() = \"Add Employee\"]")).click();
		 sleepInSecond(5);
		 
		 driver.findElement(By.name("firstName")).sendKeys("Automation");
		 driver.findElement(By.name("lastName")).sendKeys("FC");
		 
		 driver.findElement(By.xpath("//label[text() = \"Employee Id\"]/parent::div/following-sibling::div/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		 sleepInSecond(1);
		 driver.findElement(By.xpath("//label[text() = \"Employee Id\"]/parent::div/following-sibling::div/input")).sendKeys(Keys.DELETE);
		 sleepInSecond(2);
		 
		 driver.findElement(By.xpath("//label[text() = \"Employee Id\"]/parent::div/following-sibling::div/input")).sendKeys(employeeID);
		 driver.findElement(By.xpath("//p[text() = \"Create Login Details\"]/parent::div/div/label/span")).click();
		 sleepInSecond(3);
		 
		 driver.findElement(By.xpath("//label[text() = 'Username']/parent::div/following-sibling::div/input")).sendKeys("afc" + employeeID);
		 driver.findElement(By.xpath("//label[text() = 'Password']/parent::div/following-sibling::div/input")).sendKeys("Abcmn123!");
		 driver.findElement(By.xpath("//label[text() = 'Confirm Password']/parent::div/following-sibling::div/input")).sendKeys("Abcmn123!");
		 driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
		 sleepInSecond(10);
		 
		 Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Automation");
		 Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "FC");
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		 
		 driver.findElement(By.xpath("//a[text()= 'Immigration']")).click();
		 sleepInSecond(5);

		 driver.findElement(By.xpath("//h6[text() = 'Assigned Immigration Records']/following-sibling::button")).click();
		 
		 
		 driver.findElement(By.xpath("//label[text() = 'Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
		 driver.findElement(By.xpath("//label[text() = 'Comments']/parent::div/following-sibling::div/textarea")).sendKeys(commnent);
		 driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
		 sleepInSecond(7);

		 driver.findElement(By.xpath("//i[@class= 'oxd-icon bi-pencil-fill']/parent::button")).click();
		 sleepInSecond(3);
		 
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), commnent);

		 driver.findElement(By.xpath("//span[@class= 'oxd-userdropdown-tab']/parent::li")).click();
		 driver.findElement(By.xpath("//a[text()= 'Logout']")).click();
		 sleepInSecond(5);
		 
		 driver.findElement(By.name("username")).sendKeys("afc" + employeeID);
			driver.findElement(By.name("password")).sendKeys("Abcmn123!");
			driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		 sleepInSecond(6);
		 
		 driver.findElement(By.xpath("//span[text()= 'My Info']")).click();
		 sleepInSecond(5);
		 
		 Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Automation");
		 Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "FC");
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		 
		 driver.findElement(By.xpath("//a[text()= 'Immigration']")).click();
		 sleepInSecond(5);
		 driver.findElement(By.xpath("//i[@class= 'oxd-icon bi-pencil-fill']/parent::button")).click();
		 sleepInSecond(3);
		 
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passportNumber);
		 Assert.assertEquals(driver.findElement(By.xpath("//label[text() = 'Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), commnent);

		 
	}
	@Test 
	public void TC_02_verify_Employee() {
		
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
	
