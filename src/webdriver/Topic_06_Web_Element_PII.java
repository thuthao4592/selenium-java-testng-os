package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element_PII {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	By emailTextbox=By.id("email");
	By ageUnder18Radio=By.cssSelector("#under_18");
	By educationTextArea=By.cssSelector("#edu");
	By nameUser5Text=By.xpath("//h5[text()='Name: User5']");
	By passwordTextbox=By.cssSelector("#disable_password");
	By biographyTextarea=By.cssSelector("#bio");
	By deverlopmentCheckbox=By.cssSelector("#development");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_Displayed(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		//Textbox or Textarea nếu có hiển thị thì nhập text vào và in ra console
		if(driver.findElement(emailTextbox).isDisplayed())
		{
			driver.findElement(emailTextbox).sendKeys("Selenium Webdriver");
			System.out.println("Email Textbox is displayed");
		}else {
			System.out.println("Email Textbox is not displayed");
		}
		
		//Textarea
		if(driver.findElement(educationTextArea).isDisplayed())
		{
			driver.findElement(educationTextArea).sendKeys("Selenium Grid");
			System.out.println("Education Textarea is displayed");
		}else {
			System.out.println("Education Textarea  is not displayed");
		}
		
		//Radio
		if(driver.findElement(ageUnder18Radio).isDisplayed())
		{
			driver.findElement(ageUnder18Radio).click();
			System.out.println("Age Under 18 is displayed");
		}else {
			System.out.println("Age Under 18  is not displayed");
		}
		
		//Radio
		if(driver.findElement(nameUser5Text).isDisplayed())
		{
			
			System.out.println("Name User 5 is displayed");
		}else {
			System.out.println("Name User 5  is not displayed");
		}
		
	}
	//@Test
	public void TC_02_Enabled(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		if(driver.findElement(passwordTextbox).isEnabled())
		{
			
			System.out.println("Password is enabled");
		}else {
			System.out.println("Password is disabled");
		}
		
		if(driver.findElement(biographyTextarea).isEnabled())
		{
			
			System.out.println("Biography Textarea is enabled");
		}else {
			System.out.println("Biography Textarea is disabled");
		}
		
		if(driver.findElement(emailTextbox).isEnabled())
		{
			
			System.out.println("Email textbox is enabled");
		}else {
			System.out.println("Email textbox is disabled");
		}
	}
	
	//@Test
	public void TC_03_Selected(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Verify checkbox/ radio button are deselected
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(deverlopmentCheckbox).isSelected());
		
		//Click to checkbox/ radio
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(deverlopmentCheckbox).click();
		sleepInSecond(3);
		
		//Verify checkbox/ radio button are selected
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(deverlopmentCheckbox).isSelected());
		
		//Click bỏ chọn và verify lại
		driver.findElement(deverlopmentCheckbox).click();
		Assert.assertFalse(driver.findElement(deverlopmentCheckbox).isSelected());
		
	}
	@Test
	public void TC_04_Selected(){
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.id("email")).sendKeys("johnwick2023@gmail.com");
		
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
		
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("ABC");
		sleepInSecond(3);
		
		
		//Verify uppercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123");
		sleepInSecond(3);
		
		
		//Verify number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("*");
		sleepInSecond(3);
		
		
		//Verify special character
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("12345678");
		sleepInSecond(3);
		
		
		//Verify >= 8 char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		

	
		
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys("123abcABC@");
		sleepInSecond(3);
		
		
		//Verify full data
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());

	
	}
	
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
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
