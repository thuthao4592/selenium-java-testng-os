package Auto_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class topic_03 {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {	
		
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
		
	}
	@Test
	public void TC_01_Empty_Data1() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
		
		
		// Verify
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}
	 @Test
	 public void TC_02_Invalid_Email1() {
		 driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		 
		 driver.findElement(By.id("txtFirstname")).sendKeys("Ha An");
		 driver.findElement(By.id("txtEmail")).sendKeys("123@456@678");
		 driver.findElement(By.id("txtCEmail")).sendKeys("123@456@678");
		 driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		 driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		 driver.findElement(By.id("txtPhone")).sendKeys("0956784567");
		 
		 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
		 
		 //verify
		 Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
			Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	 }
	 
	 @Test
	public void TC_03_Incorrect_Email1() {
		// TODO Auto-generated method stub
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		 
		 driver.findElement(By.id("txtFirstname")).sendKeys("Ha An");
		 driver.findElement(By.id("txtEmail")).sendKeys("haan@gmail.com");
		 driver.findElement(By.id("txtCEmail")).sendKeys("han@gmail.com");
		 driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		 driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		 driver.findElement(By.id("txtPhone")).sendKeys("0956784567");
		 
		 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
		 
		 //verify
		 Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
			
	}
	 
	 @Test
		public void TC_04_Invalid_Password() {
			// TODO Auto-generated method stub
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			 
			 driver.findElement(By.id("txtFirstname")).sendKeys("Ha An");
			 driver.findElement(By.id("txtEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtCEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtPassword")).sendKeys("123");
			 driver.findElement(By.id("txtCPassword")).sendKeys("123");
			 driver.findElement(By.id("txtPhone")).sendKeys("0956784567");
			 
			 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
			 
			 //verify
			 Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
			 Assert.assertEquals( driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
				
		}
	 
	 @Test
		public void TC_05_Incorrect_Password() {
			// TODO Auto-generated method stub
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			 
			 driver.findElement(By.id("txtFirstname")).sendKeys("Ha An");
			 driver.findElement(By.id("txtEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtCEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtPassword")).sendKeys("123456789");
			 driver.findElement(By.id("txtCPassword")).sendKeys("1234567890");
			 driver.findElement(By.id("txtPhone")).sendKeys("0956784567");
			 
			 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
			 
			 //verify
			 
			 Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
				
		}
	 @Test
		public void TC_06_Invalid_Phone() {
			// TODO Auto-generated method stub
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			
			 //Action1
			 driver.findElement(By.id("txtFirstname")).sendKeys("Ha An");
			 driver.findElement(By.id("txtEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtCEmail")).sendKeys("haan@gmail.com");
			 driver.findElement(By.id("txtPassword")).sendKeys("123456789");
			 driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
			 driver.findElement(By.id("txtPhone")).sendKeys("09567845");
			 
			 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
			 
			 //verify1
			 
			 Assert.assertEquals( driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
			
			 // Action 2
			 
			 driver.findElement(By.id("txtPhone")).clear();
			 driver.findElement(By.id("txtPhone")).sendKeys("0987654784345");
			 
			 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
//			// verify 2
			 
			 Assert.assertEquals( driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
			
 			// Action 3
			 
			 driver.findElement(By.id("txtPhone")).clear();
			 driver.findElement(By.id("txtPhone")).sendKeys("34567893456");
			 
			 driver.findElement(By.xpath("//form[@id=\"frmLogin\"]//button[text()='ĐĂNG KÝ']")).click();
//			// verify 3
			 
			 Assert.assertEquals( driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
			 
		}
	@AfterClass
	public void afterClass() {
		driver.quit();
}
}
