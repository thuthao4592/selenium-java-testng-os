package Auto_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic06_element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By emailTexbox = By.id("mail");
	By ageUnder18Radio = By.cssSelector("#under_18");
	By educateonTextArea = By.cssSelector("#edu");
	By nameUser5Text = By.xpath("//h5[text()= \"Name: User5\"]");
	By passwordText = By.xpath("//input[@id = \"disable_password\"]");
	By biographyTextArea = By.cssSelector("#bio");
	By developmentCheckBox = By.cssSelector("#development");
	

	@BeforeClass
	public void beforeClass() {
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	//@Test 
	public void TC_01_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// Textbox nếu có hiển thị thì nhập tiếp vào in ra console
		if(driver.findElement(emailTexbox).isDisplayed()) {
			driver.findElement(emailTexbox).sendKeys("Selenium.Webdrive");
			System.out.print("Email textbox is displayed");
		} else {
			System.out.print("Email textbox is not displayed");
	
		}
		
		// Textarea nếu có hiển thị thì nhập tết vào in ra console
		
		if (driver.findElement(ageUnder18Radio).isDisplayed()) {
			driver.findElement(ageUnder18Radio).click();
			System.out.print("Age under 18 is displayed");
			
		} else {
			System.out.print("Education area is not displayed");
		}
		// Radio button nếu có hiển thị thì nhập tết vào in ra console
		
				if (driver.findElement(nameUser5Text).isDisplayed()) {
					System.out.print("Name user 5 is displayed");
					
				} else {
					System.out.print("Name user 5 is not displayed");
				}
		// Radio button nếu có hiển thị thì nhập tết vào in ra console
				
				if (driver.findElement(educateonTextArea).isDisplayed()) {
					driver.findElement(educateonTextArea).sendKeys("Selenium. GRID");
					System.out.print("Education area is displayed");
					
				} else {
					System.out.print("Education area is not displayed");
				}
								
	}

	//@Test
	public void TC_02_enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		 if (driver.findElement(passwordText).isEnabled()) {
		 System.out.print("Password textbox is enable");
			
		 } else {
			System.out.print("Password textbox is not enable");
		}
		 
		 
		 if (driver.findElement(biographyTextArea).isEnabled()) {
			 System.out.print("Biography textarea  is enable");
				
			 } else {
				System.out.print("Biography textarea is not enable");
			}
	}

	//@Test
	public void TC_03_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// verify checkbox/ radio button are deselected
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected()); // nếu chưa chọn thì là fail
		Assert.assertFalse(driver.findElement(developmentCheckBox).isSelected());
		
		// Click checkbox/ radio
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(developmentCheckBox).click();
		sleepInSecond(3);
		
		// verify checkbox/ radio button are selected
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected()); // nếu đã chọn thì là true
		Assert.assertTrue(driver.findElement(developmentCheckBox).isSelected());
		
	}
	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
	   
		driver.findElement(By.id("email")).sendKeys("automaiton123@gmail.com");
		
		By PasswordTextbox = By.id("new_password");
		By singupbutton = By.id("create-account-enabled");
		
		driver.findElement(PasswordTextbox).sendKeys("abc");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		 
		// verify lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("ABC");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("123");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("@#!");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		

		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("ABCADGUWYY");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed()); 
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(PasswordTextbox).clear();
		driver.findElement(PasswordTextbox).sendKeys("ABcd@12345");
		//driver.findElement(singupbutton).click();
		sleepInSecond(3);
		
		//verify full data
		
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
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
