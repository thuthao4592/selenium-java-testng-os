package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Exercises {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {

		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}


		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test
	public void TC_01() {
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
	Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");	
		try        
		{
		    Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}

	@Test
	public void TC_02() {
		driver.findElement(By.id("txtFirstname")).sendKeys("Kieu Vy");
		driver.findElement(By.id("txtEmail")).sendKeys("vykty@gmail.com@@@");
		driver.findElement(By.id("txtCEmail")).sendKeys("vykty@gmail");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0854256406");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		try        
		{
		    Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}

	@Test
	public void TC_03() {
		
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtFirstname")).sendKeys("Kieu Vy");
		driver.findElement(By.id("txtEmail")).sendKeys("vykty@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("vykty@gmail");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0854256406");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		try        
		{
		    Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	@Test	
	public void TC_04() {
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtFirstname")).sendKeys("Kieu Vy");
		driver.findElement(By.id("txtEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1234");
		driver.findElement(By.id("txtCPassword")).sendKeys("1234");
		driver.findElement(By.id("txtPhone")).sendKeys("0854256406");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		try        
		{
		    Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	@Test
	public void TC_05() {
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtFirstname")).sendKeys("Kieu Vy");
		driver.findElement(By.id("txtEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789353");
		driver.findElement(By.id("txtPhone")).sendKeys("0854256406");
	driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
		try        
		{
		    Thread.sleep(2000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	@Test
	public void TC_06() {
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtFirstname")).sendKeys("Kieu Vy");
		driver.findElement(By.id("txtEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("kieuyenvy0512@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("08542564060099");
	driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
	Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
	
	try        
	{
	    Thread.sleep(2000);
	} 
	catch(InterruptedException ex) 
	{
	    Thread.currentThread().interrupt();
	}
	
	driver.findElement(By.id("txtPhone")).clear();
	driver.findElement(By.id("txtPhone")).sendKeys("1854256406");
driver.findElement(By.xpath("//div[@class='form frmRegister']//button[@class='btn_pink_sm fs16']")).click();
Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

