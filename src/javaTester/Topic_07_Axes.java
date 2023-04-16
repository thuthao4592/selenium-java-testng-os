package javaTester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Axes {
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
	public void TC_01_Demo1(){
		//tim button Add to cart của sp Sony Xperia
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button")).click();	
		
		
	}
	
	@Test
	public void TC_02_Demo1(){
		//tim button Add to cart của sp Sony Xperia
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		//tim the a class=product-image
				driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::*/following-sibling::div//*[@class='rating']/ancestor::*[@class='product-info']/preceding-sibling::*"));	
				
	}
	
	@Test
	public void TC_02_Demo2(){
		driver.get("https://subscription.packtpub.com/search?query=Java&_ga=2.162054268.1585234536.1680418315-178060828.1680418315");
		
		//lấy ngày của block Java Coding Problems
		System.out.println("Ngay:"+driver.findElement(By.xpath("//div[text()='Java Coding Problems']/ancestor::a/following-sibling::a/div/div[1]")).getText());	
		
		//lấy page của block Java Coding Problems
		System.out.println("Trang:"+driver.findElement(By.xpath("//div[text()='Java Coding Problems']/ancestor::a/following-sibling::a//div[@class='pages']")).getText());	
		
		}
	@Test
	public void TC_03_Demo3(){
		driver.get("https://fptshop.com.vn/apple/macbook");
		
		//lay button của block Java Coding Problems
		driver.findElement(By.xpath("//a[@title='MacBook Air 13\" 2020 M1 256GB']/ancestor::div[@class='product_info']/following-sibling::div/a[text()='MUA NGAY']"));	
		
		}
	@Test
	public void TC_04_Demo4(){
		
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//a[text()='here']")).click();

		driver.findElement(By.xpath("//td[text()='Email ID']/following-sibling::td/input")).sendKeys("nguyenphuongd94@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//lấy user va password của block Java Coding Problems
		String a=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();	
		String b=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		
		//su dung user va password de dang nhap
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//td[text()='UserID']/following-sibling::td/input")).sendKeys(a);
		driver.findElement(By.xpath("//td[text()='Password']/following-sibling::td/input")).sendKeys(b);
		driver.findElement(By.xpath("//input[@type='submit']")).click();


		}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
