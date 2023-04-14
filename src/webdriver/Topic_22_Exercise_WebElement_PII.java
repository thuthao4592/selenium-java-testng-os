package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_Exercise_WebElement_PII {
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

//	@Test
	public void TC_01_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Textbox nếu có hiển thị thì nhập text vào và in ra console
		if (driver.findElement(emailTextBox).isDisplayed()) {
			driver.findElement(emailTextBox).sendKeys("Thaib3995@gmail");
			System.out.println("Email Text box is displayed");
		} else {
			System.out.println("Email Text box is not displayed");
		}
		
		//Text Area
		if (driver.findElement(educationTextArea).isDisplayed()) {
			driver.findElement(educationTextArea).sendKeys("GRID");
			System.out.println("education TextArea is displayed");
		} else {
			System.out.println("education TextArea is not displayed");
		}
		
		//Radio button
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.println("age Under18 Radio is displayed");
		} else {
			System.out.println("age Under18 Radio is not displayed");
		}
		
		if (driver.findElement(nameUser5Text).isDisplayed()) {
			System.out.println("name User5 Text is displayed");
		} else {
			System.out.println("name User5 Text is not displayed");
		}
	
		
		}
//	@Test
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");	
		if (driver.findElement(passwordTextbox).isEnabled()) {
			System.out.println("pass word is enabled");
		} else {
			System.out.println("pass word is disabled");
	}
		
		if (driver.findElement(biographyTextArea).isEnabled()) {
			System.out.println("biography TextArea is enabled");
		} else {
			System.out.println("biography TextArea is disabled");
	}
		
		if (driver.findElement(emailTextBox).isEnabled()) {
			System.out.println("email TextBox is enabled");
		} else {
			System.out.println("email TextBox is disabled");
	}
	}
//	@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Verify checkbox/ Radio button are deselected
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(designCheckBox).isSelected());
		
		//Click to checkbox/radio
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(designCheckBox).click();
		sleepInSecond(3);
		
		//Verify checkbox/ Radio button are selected
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(designCheckBox).isSelected());
		}
	

	private void sleepInSecond(int i) {		
	}

	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("Thaib3995@gmail.com");
		By passwordTextBox = By.id("new_password");
		By SignupButton = By.xpath("//button[@id='create-account-enabled']");
		
		driver.findElement(passwordTextBox).sendKeys("bigo");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
		//Verify lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("BIGO");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
		//Verify UpperCase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("123");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
		//Verify number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("@#!");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
		//Verify Special char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("12345678");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
		//Verify 8 char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys("123Axc@!");
		driver.findElement(SignupButton).click();
		sleepInSecond(2);
		
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
}
