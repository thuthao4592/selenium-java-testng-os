package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebElement_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	By emailTextbox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18"); 
	By educationTextArea = By.cssSelector("#edu"); 
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By passwordTextbox = By.cssSelector("#disable_password");
	By biographyTextArea = By.cssSelector("#bio");
	By developmentCheckbox = By.cssSelector("#development");
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	//@Test
	public void TC_01_() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Textbox / TextArea nếu hiển thị thì nhập text vào và in ra console
		if (driver.findElement(emailTextbox).isDisplayed()) {	
			driver.findElement(emailTextbox).sendKeys("selenium@gmail.com");
			System.out.println("Email Textbox is displayed");
		}	else {
			System.out.println("Email Textbox is not displayed");
		}
		
		//TextArea
		if (driver.findElement(educationTextArea).isDisplayed()) {	
			driver.findElement(educationTextArea).sendKeys("selenium");
			System.out.println("Education TextArea is displayed");
		}	else {
			System.out.println("Education TextArea is not displayed");
		}
		
		//Radio button
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {	
		driver.findElement(ageUnder18Radio).click();
		System.out.println("Age Under18 is displayed");
		}	else {
		System.out.println("Age Under18 is not displayed");
		}
			
		//Text
		if (driver.findElement(nameUser5Text).isDisplayed()) {	
		System.out.println("Name User5 is displayed");
		}	else {
		System.out.println("Name User5 is not displayed");
		}
	}	
	
	//@Test
	public void TC_02_() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Textbox / TextArea nếu hiển thị thì nhập text vào và in ra console
		if (driver.findElement(passwordTextbox).isEnabled()) {	
			System.out.println("Password textbox is enabled");
		}	else {
			System.out.println("Password Textbox is disabled");
		}
		
				
		if (driver.findElement(biographyTextArea).isEnabled()) {	
			System.out.println("Biography TextArea is enabled");
		}	else {
			System.out.println("Biography TextArea  is disabled");
		}
		
		
		if (driver.findElement(emailTextbox).isEnabled()) {	
		System.out.println("Email Textbox is enabled");
		}	else {
		System.out.println("Email Textbox is displayed");
		}				
	}

	//@Test
	public void TC_03_() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Verify checkbox/ radio button are deselected
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(developmentCheckbox).isSelected());
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(developmentCheckbox).click();
		sleepInSecond(3);
		
		// Verify checkbox/ radio button are selected
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(developmentCheckbox).isSelected());
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}	
	}
	
	//@Test
	public void TC_04_MailChimp(){
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		By passwordTextbox = By.id("new_password");
		By signupButton = By.id("create-account-enabled");
		driver.findElement(passwordTextbox).sendKeys("abc");		
		sleepInSecond(3);
		
		//Verify lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Verify uppercase
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("ABC");		
		sleepInSecond(3);	
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Verify 
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123");	
		sleepInSecond(3);	
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Verify 
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("@#$");		
		sleepInSecond(3);	
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		//Verify uppercase
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123456789");		
		sleepInSecond(3);	
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		//Verify uppercase
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123Abc@#5");		
		sleepInSecond(3);	
		
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
	}
	
	@Test
	public void TC_05_Empty_Email_and_Password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");		
	}
	
	@Test
	public void TC_06_Invalid_Email() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.cssSelector("ul.form-list input[type='email']")).sendKeys("123434234@12312.123123");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}	
	
	@Test
	public void TC_07_Incorrect_Email_and_Password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.cssSelector("ul.form-list input[type='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}	
	
	@Test
	public void TC_07_Incorrect_Email_or_Password() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.cssSelector("ul.form-list input[type='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123123123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}
		
	
