package webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_010_Button_Radio_Checout {
	WebDriver driver;
	WebDriverWait expliciWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String a;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
//		Chờ đến 30s thì timeout
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		
		WebElement buttonLogin = driver.findElement(By.xpath("//div[@class='popup-login-content']//button[@title='Đăng nhập']"));
		
		//Verify button Login disable
		Assert.assertFalse(buttonLogin.isEnabled());
		
		String loginButtonBackground = buttonLogin.getCssValue("background-image");
		System.out.println(loginButtonBackground);
		Assert.assertTrue(loginButtonBackground.contains("rgb(224, 224, 224)"));
		
		driver.findElement(By.id("login_username")).sendKeys("0976355522");
		driver.findElement(By.id("login_password")).sendKeys("123456789");
		
		//Verify button Login enable
		Assert.assertTrue(buttonLogin.isEnabled());
		
		//lấy color của button Login
		Color colorButtonLogin = Color.fromString(buttonLogin.getCssValue("background-color"));
		System.out.println(colorButtonLogin);
		
		//Verify màu button
		Assert.assertEquals(colorButtonLogin.asHex().toUpperCase(),"#C92127");
	}

	@Test
	public void TC_02_ReactJS() {	
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
		
		By checkboxDual = By.xpath("//label[text()='Luggage compartment cover']/preceding-sibling::input");
		
		
		driver.findElement(checkboxDual).click();
		//Verify checkbox đã được chọn
		Assert.assertTrue(driver.findElement(checkboxDual).isSelected());
		
		driver.findElement(checkboxDual).click();
		//Verify checkbox đã bỏ chọn
		Assert.assertFalse(driver.findElement(checkboxDual).isSelected());
		
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		sleepInSecond(3);
		WebElement radio20Petro =  driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
			
//		if (!radio20Petro.isSelected()) {
			radio20Petro.click();
//		} 	
		Assert.assertTrue(radio20Petro.isSelected());
	}
	
//	@Test
	public void TC_03_VueJS() {
	}

//	@Test
	public void TC_04_Editable() {
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
