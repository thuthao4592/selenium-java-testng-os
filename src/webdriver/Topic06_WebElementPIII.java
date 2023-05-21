package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_WebElementPIII {
	WebDriver driver;
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String EmailAddress,firstName,LastName,FullName,passWord;
	By emailTextBox = By.id("mail");
	By ageUnder18Radio = By.xpath("//input[@id=\"under_18\"]");
	By educationTextArea = By.xpath("//textarea[@id=\"edu\"]");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By passwordTextbox = By.xpath("//input[@id=\"password\"]");
	By biographyTextArea = By.xpath("//textarea[@id=\"bio\"]");
	By designCheckBox = By.xpath("//input[@id=\"design\"]");

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
		EmailAddress="Automaiton"+ rand.nextInt(9999)+"@gmail.com";
		firstName= "Automatiom";
		LastName="FC";
		FullName=firstName+" "+LastName;
		passWord="123456a";
		}
	
	@Test
	public void TC_01_Empty_Email_Password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("send2")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
		
		}


	@Test
	public void TC_02_Invalid_Email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("email")).sendKeys("12345@46788");
		driver.findElement(By.id("pass")).sendKeys("pass");
		driver.findElement(By.id("send2")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	
	}
	@Test
	public void TC_03_Password_Less_Than_6_Chars() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("email")).sendKeys("auto123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.id("send2")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
		
	}

	@Test
	public void TC_04_Incorrect_Email_Pass() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("email")).sendKeys(EmailAddress);
		driver.findElement(By.id("pass")).sendKeys("1236435");
		driver.findElement(By.id("send2")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']")).getText(), "Invalid login or password.");
		
		
		}
	@Test
	public void TC_05_Creat_New_ACC() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='Create an Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname	")).sendKeys(LastName);
		driver.findElement(By.id("email_address")).sendKeys(EmailAddress);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.id("confirmation")).sendKeys(passWord);
		driver.findElement(By.xpath("//div[@class='footer']//button[@title='Register']")).click();

		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='messages']")).getText(), "Thank you for registering with Main Website Store.");
		String ContactInformationText= driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		////h3[text()='Contact Information']/parent::div/following-sibling::div/p lay len div cha cua h3 roi follow sang em cua div cha vua tim, lay the p
        System.out.println(ContactInformationText);		
        Assert.assertTrue(ContactInformationText.contains(FullName));
        Assert.assertTrue(ContactInformationText.contains(EmailAddress));
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();

		sleepInSecond(5);
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed());

        }
	@Test
	public void TC_06_Creat_New_ACC() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(3);
		driver.findElement(By.id("email")).sendKeys(EmailAddress);
		driver.findElement(By.id("pass")).sendKeys("passWord");
		driver.findElement(By.id("send2")).click();
		sleepInSecond(3);
		String ContactInformationText= driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		////h3[text()='Contact Information']/parent::div/following-sibling::div/p lay len div cha cua h3 roi follow sang em cua div cha vua tim, lay the p
        System.out.println(ContactInformationText);		
        Assert.assertTrue(ContactInformationText.contains(FullName));
        Assert.assertTrue(ContactInformationText.contains(EmailAddress));		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepInSecond(long timeinSecond)
	{
	try {
		Thread.sleep(timeinSecond* 1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}