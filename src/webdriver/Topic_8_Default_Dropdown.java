package webdriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_8_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	Random rand;
	String mail;
	String firtnawe, lastname, mail1;
	

	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		rand = new Random();
		mail = "tranthithai" + rand.nextInt(9999) + "@gmail.com";
		driver.get("https://demo.nopcommerce.com/register");
		
		firtnawe = "Quang";
		lastname = "Trung";
		mail1 = "huonghoa@gmail.com";

	}

	@Test
	public void TC_01_Url() {
		sleepInSecond(4);
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.xpath("//div[@id='gender']//span[@class='male']")).click();
		new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("1");
		new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("May");
		new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1980");
		driver.findElement(By.id("FirstName")).sendKeys("Tran Thi");
		driver.findElement(By.id("LastName")).sendKeys("Trao");
		driver.findElement(By.id("Email")).sendKeys(mail);
		driver.findElement(By.id("Password")).sendKeys("123456789");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456789");
		driver.findElement(By.id("register-button")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page registration-result-page']//div[@class='page-body']//div[@class='result']")).getText(),"Your registration completed");
		
		//Login
		driver.findElement(By.xpath("//a[text()='My account']")).click();
		driver.findElement(By.id("Email")).sendKeys(mail);
		driver.findElement(By.id("Password")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Verify
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),"1");
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),"May");
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),"1980");
		

	}

	@Test
	public void TC_02_Add_Address() {
		sleepInSecond(4);
		driver.findElement(By.cssSelector("li.customer-addresses>a")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		
		driver.findElement(By.id("Address_FirstName")).sendKeys(firtnawe);
		driver.findElement(By.id("Address_LastName")).sendKeys(lastname);
		driver.findElement(By.id("Address_Email")).sendKeys(mail1);
		new Select(driver.findElement(By.id("Address_CountryId"))).selectByVisibleText("Viet Nam");
		driver.findElement(By.id("Address_City")).sendKeys("Hải Hà");
		driver.findElement(By.id("Address_Address1")).sendKeys("1 Lê Văn Lương");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("1234");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("0961845568");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
//		Verify
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='info']//li[@class='name']")).getText(), firtnawe + lastname);
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='info']//li[@class='email']")).getText().contains(mail1));
	}

	@Test
	public void TC_03_Form() {
		
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}



}
