package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_WebElementPII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
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
		}

	@Test
	public void TC_01_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if (driver.findElement(emailTextBox).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Selenium WebDriver");
			System.out.println("Email Text box is displayed");
		} else {
			System.out.println("Email Text box is not displayed");
		}
	
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("Selenium GRID");
			System.out.println("Education TextArea is displayed");
		} else {
			System.out.println("Education TextArea is not displayed");
		}
		
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.println("Age Under18 Radio is displayed");
		} else {
			System.out.println("Age Under18 Radio is not displayed");
		}
		
		if (driver.findElement(nameUser5Text).isDisplayed()) {
			System.out.println("Name User5 Text is displayed");
		} else {
			System.out.println("Name User5 Text is not displayed");
		}
	
		}
	@Test
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");	
		if (driver.findElement(passwordTextbox).isEnabled()) {
			System.out.println("Pass word is enabled");
		} else {
			System.out.println("Pass word is disabled");
	}
		
		if (driver.findElement(biographyTextArea).isEnabled()) {
			System.out.println("Biography TextArea is enabled");
		} else {
			System.out.println("Biography TextArea is disabled");
	}
		
		if (driver.findElement(emailTextBox).isEnabled()) {
			System.out.println("Email TextBox is enabled");
		} else {
			System.out.println("Email TextBox is disabled");
	}
	}
	@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(designCheckBox).isSelected());
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(designCheckBox).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(designCheckBox).isSelected());
		}

	

	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("auto123@gmail.com");
		By passwordTextBox = By.id("new_password");
		By SignupButton = By.id("create-account-enabled");
		
		driver.findElement(passwordTextBox).sendKeys("abc");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("ABC");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("54321");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("$#@!");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("ABCXYZGHM");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		
		//Verify char>=8 
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("Abc@123456");
		driver.findElement(SignupButton).click();
		sleepInSecond(3);
		
		//Verify full data
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		}
	

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
