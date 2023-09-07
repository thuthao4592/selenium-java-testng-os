package webdriver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Popup_Part_2_Fixed_Popup_Not_In_Dom {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String email;
	Random random;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
//		implicitlyWait: Nó ảnh hưởng tới việc tìm element
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		random = new Random();
		email = "automation" + random.nextInt() + "@gmail.com";

	}
	

	public void TC_01_Fixed_Random_TiKi() {
		driver.get("https://tiki.vn/");
		
		By popup = By.cssSelector("div.ReactModal__Overlay");
		
		Assert.assertEquals(driver.findElements(popup).size(), 0);
		
		driver.findElement(By.xpath("//div//span[text() = 'Tài khoản']")).click();
		sleepInSecond(3);
		
		//Verify
		Assert.assertEquals(driver.findElements(popup).size(), 1);
		Assert.assertTrue(driver.findElement(popup).isDisplayed());
		
		driver.findElement(By.xpath("//div[@class = 'input ']//input[@name = 'tel']")).sendKeys("0961847759");
		driver.findElement(By.xpath("//p[text()= 'Đăng nhập bằng email']")).click();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//button[text()= 'Đăng nhập']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class = 'error-mess' and text() = 'Email không được để trống']")).getText(), "Email không được để trống");
		
		driver.findElement(By.xpath("//button[@class= 'btn-close']//img[@class = 'close-img']")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElements(popup).size(), 0);
	}

	@Test
	public void TC_02_Fixed_Random_FaceBook() {
		driver.get("https://www.facebook.com/");
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[text() = 'Tạo tài khoản mới']")).click();
		//Verify
		Assert.assertEquals(driver.findElements(By.xpath("//div[text() ='Đăng ký']/parent::div/parent::div")).size(), 1);
	}
	
	public void sleepInSecond(long miliSecond) {
		try {
			Thread.sleep(miliSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}



}
