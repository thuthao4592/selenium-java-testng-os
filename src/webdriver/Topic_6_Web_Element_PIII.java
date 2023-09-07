package webdriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_6_Web_Element_PIII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Random rand;
	
	String dataEmail, dataFirtname, dataMiddlename, dataPassword, dataConfirmPassword, dataLastname;

	By linkMyAccount = By.xpath("//div[@class='footer']//div[@class='links']//a[text()='My Account']");
	By linkcreateAccount = By.xpath("//a[@title = 'Create an Account']");
	By firtname = By.id("firstname");
	By middlename = By.id("middlename");
	By lastname = By.id("lastname");
	By emailAddress = By.id("email_address");
	By password = By.id("password");
	By confirmpassword = By.id("confirmation");
	By buttonRegister = By.xpath("//button[@title='Register']");
	By messaSuccess = By.xpath("//ul[@class='messages']//li[@class='success-msg']//span");
	
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://live.techpanda.org/");
		
		rand = new Random();
		dataEmail = "thaothang" + rand.nextInt(9999) + "@gmail.com";
		dataFirtname = "Thang";
		dataMiddlename = "ck";
		dataLastname = "Thao";
		dataPassword = "12345678";
		dataConfirmPassword = dataPassword;
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
	public void TC05_RegisterNewAccount() {
		
		driver.findElement(linkMyAccount).click();
		sleepInSecond(3);
		driver.findElement(linkcreateAccount).click();
		sleepInSecond(3);
		
		driver.findElement(firtname).sendKeys(dataFirtname);
		driver.findElement(middlename).sendKeys(dataMiddlename);
		driver.findElement(lastname).sendKeys(dataLastname);
		driver.findElement(emailAddress).sendKeys(dataEmail);
		driver.findElement(password).sendKeys(dataPassword);
		driver.findElement(confirmpassword).sendKeys(dataConfirmPassword);
		
		driver.findElement(buttonRegister).click();
		
		Assert.assertEquals(driver.findElement(messaSuccess).getText(), "Thank you for registering with Main Website Store.");
		
		String text = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(text);	
		
		Assert.assertTrue(text.contains(dataFirtname));
		Assert.assertTrue(text.contains(dataLastname));
		
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//div[@class='skip-content skip-active']//li[@class=' last']//a[text()='Log Out']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//img[contains(@src,'logo.png')]")).isDisplayed());
	}
	
	@Test
	public void TC06_Login_Valid_Info() {
		driver.findElement(linkMyAccount).click();
		sleepInSecond(3);

		driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys(dataEmail);
		driver.findElement(By.id("pass")).sendKeys(dataPassword);
		
		Assert.assertEquals(driver.findElement(messaSuccess).getText(), "Thank you for registering with Main Website Store.");
		
		String text = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		System.out.println(text);	
		
		Assert.assertTrue(text.contains(dataFirtname));
		Assert.assertTrue(text.contains(dataLastname));
		
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//div[@class='skip-content skip-active']//li[@class=' last']//a[text()='Log Out']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']//img[contains(@src,'logo.png')]")).isDisplayed());
	}
}
