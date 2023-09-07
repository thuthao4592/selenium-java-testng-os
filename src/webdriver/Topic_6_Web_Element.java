package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_6_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By emailTextbox = By.id("mail");
	By ageUnder1 = By.cssSelector("#under_18");
	By eduTextbox = By.id("edu");
	By user5 = By.xpath("//h5[text()='Name: User5']");
	
	By job1 = By.id("job1");
	By interrestDeveloper = By.cssSelector("#development");
	By slide01 = By.cssSelector("#slider-1");
	By password = By.id("disable_password");
	By ageRadio = By.cssSelector("#radio-disabled");
	By bio = By.cssSelector("#bio");
	
	By languagueJava = By.cssSelector("#java");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void TC_01_isDisable() {
		//isDisable dung để verify xem element cso hiển thị hay không
		//phạm vi: tất cả
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Automation testing");
			System.out.println("Element is displayed");
		}else {
			System.out.println("Element is not displayed");
		}
		if(driver.findElement(eduTextbox).isDisplayed()) {
			driver.findElement(eduTextbox).sendKeys("Automation testing");
			System.out.println("Element is displayed");
		}else {
			System.out.println("Element is not displayed");
		}
		if(driver.findElement(ageUnder1).isDisplayed()) {
			driver.findElement(ageUnder1).click();
			System.out.println("Element is displayed");
		}else {
			System.out.println("Element is not displayed");
		}
		if(driver.findElement(user5).isDisplayed()) {
			System.out.println("Element is displayed");
		}else {
			System.out.println("Element is not displayed");
		}
	}
	
//	@Test
	public void TC_02_isEnable() {
		//isEnable dùng để verify xem element có thao tác được hay không
		//phạm vi: tất cả
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
		if(driver.findElement(eduTextbox).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
		if(driver.findElement(ageUnder1).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
		if(driver.findElement(password).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
		if(driver.findElement(ageRadio).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
		if(driver.findElement(bio).isEnabled()) {
			System.out.println("Element is enabled");
		}else {
			System.out.println("Element is not enabled");
		}
	}
	
	//@Test
	public void TC_03_isSelected() {
		//isEnable dùng để verify xem element có được chọn hay không
		//phạm vi: radio
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//chọn languagueJava và ageUnder1
		driver.findElement(ageUnder1).click();
		driver.findElement(languagueJava).click();
		
		if(driver.findElement(ageUnder1).isSelected()) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Element is not selected");
		}
		if(driver.findElement(languagueJava).isSelected()) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Element is not selected");
		}
		
		//bỏ chọn languagueJava
		driver.findElement(languagueJava).click();
		
		if(driver.findElement(ageUnder1).isSelected()) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Element is not selected");
		}
		if(driver.findElement(languagueJava).isSelected()) {
			System.out.println("Element is selected");
		}else {
			System.out.println("Element is not selected");
		}
	}
	
	@Test
	public void TC_04_isSelected() {
		driver.get("https://login.mailchimp.com/signup/");
		sleepInSecond(3);
		//nhập password là số
		driver.findElement(By.id("email")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("new_password")).sendKeys("111111");
		driver.findElement(By.id("create-account-enabled")).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
