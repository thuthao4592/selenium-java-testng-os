package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_03 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test
	public void TC_04_RegiterwithPassword() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Trần Thị Thảo");
		driver.findElement(By.id("txtEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtPhone")).sendKeys("0961845598");	
		driver.findElement(By.id("txtPassword")).sendKeys("1111");
		driver.findElement(By.id("txtCPassword")).sendKeys("11111");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_RegisterConfirmPassword() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Actions
		driver.findElement(By.id("txtFirstname")).sendKeys("Trần Thị Thảo");
		driver.findElement(By.id("txtEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtPhone")).sendKeys("0961845598");	
		driver.findElement(By.id("txtPassword")).sendKeys("111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("11111");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
		//Verifys
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_06_InvalidPhone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Action1
		driver.findElement(By.id("txtFirstname")).sendKeys("Trần Thị Thảo");
		driver.findElement(By.id("txtEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("tranthithao@gmail.com");
		driver.findElement(By.id("txtPhone")).sendKeys("0961845598");	
		driver.findElement(By.id("txtPassword")).sendKeys("111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("111111");
		driver.findElement(By.id("txtPhone")).sendKeys("096184559");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
		//Verify1
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//Action2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("06184559");
		
		//Verify2
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
	}
//
//	@Test
//	public void TC_03_Form() {
//		
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
