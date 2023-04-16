package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
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
	@Test
	public void TC_01_(){
		
			driver.get("https://automationfc.github.io/basic-form/");
			
			System.out.println("Xin chao cac ban lop Automation Test");
			System.out.println("Xin chao cac ban"+"lop Automation Test");
			
			System.out.println(driver.findElement(By.xpath("//h5[@id='nested']")).getText());	
	}
	
	@Test
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
		//Verify
		//Assert.assertTrue-> Kiem tra 1 dieu kien dung
		//Assert.assertFalse-> Kiem tra 1 dieu kien sai
		//Assert.assertEquals-> Kiem tra thuc te voi mong muon
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

	
	}
	
	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("Johnwi@agmail@a");
		driver.findElement(By.id("txtCEmail")).sendKeys("Johnwi@agmail@a");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0964152891");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
	}
	
	@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("Johnwi3292@wick.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Johnwi3292@wick.net");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0964152891");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0964152891");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1235678");
		driver.findElement(By.id("txtCPassword")).sendKeys("123653");
		driver.findElement(By.id("txtPhone")).sendKeys("0964152891");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action1
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("dotiendat@abd.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1235678");
		driver.findElement(By.id("txtCPassword")).sendKeys("1235678");
		driver.findElement(By.id("txtPhone")).sendKeys("0964321");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
	
		//action2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("096432153213");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
	
		//action2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("9643215321");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
			
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
	
	

