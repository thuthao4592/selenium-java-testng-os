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
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By emailtextbox=By.id("mail");
	By ageUnder18Radio=By.cssSelector("#under_18");
	By educationTextArea=By.cssSelector("#edu");
    By nameuser5txt=By.xpath("//h5[text()='Name: User5']");
    By Password=By.cssSelector("#disable_password");
    By BioTextarea=By.cssSelector("#bio");
    By Developmentcheckbox=By.cssSelector("#development");
	

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
	public void TC_01_displayed() {
//		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.get("http://google.com/");
		if (driver.findElement(emailtextbox).isDisplayed()) {
			driver.findElement(emailtextbox).sendKeys("Selenium Webdrive");
			System.out.println("Email textbox is displayed");
			
		} else {
            System.out.println("Email textbox is not displayed");
		}
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Selenium Grid");
			System.out.println("Education textArea is displayed");
			
		} else {
			System.out.println("Education textArea is not displayed");

		}
	
		//Radio
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.println("Age Under18 is displayed");
			
		} else {
			System.out.println("Age Under18 is not displayed");
		}
		
		//h5
		if (driver.findElement(nameuser5txt).isDisplayed()) {
			System.out.println("Name user h5 is displayed");
			
		} else {
			System.out.println("Name user h5 is not displayed");
		}
		
	}
	
	//@Test
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		if (driver.findElement(Password).isEnabled()) {
			System.out.println("Password textbox is Enable");
		} else {
			System.out.println("Password textbox is Disable");
		}
		if (driver.findElement(BioTextarea).isEnabled()) {
			System.out.println("BioTextarea is Enable");
		} else {
			System.out.println("BioTextarea is Disable");
		}
		if (driver.findElement(emailtextbox).isEnabled()) {
			System.out.println("Email is Enable");
		} else {
			System.out.println("Email is Disable");
		}
	}
	//@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(Developmentcheckbox).isSelected());
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(Developmentcheckbox).click();
		
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(Developmentcheckbox).isSelected());
		

	}
	@Test
	public void TC_04_Mailchimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("hangle@gmail.com");
		By PasswordTextbox=By.id("new_password");
		
		driver.findElement(PasswordTextbox).sendKeys("abc");
		
		SleepInsecon(3);
		
		//Verify Lowcase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("ABC");
		SleepInsecon(3);
		
		//Verify upercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("123");
		SleepInsecon(3);
		//verify number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("@#$");
		SleepInsecon(3);
		
		//verify special character
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("ABCDFGHH");
		SleepInsecon(3);
		
		//verify char>=8
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("123abcABC@#@#");
		SleepInsecon(3);
		
		//verify full data
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
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
