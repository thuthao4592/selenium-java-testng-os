package Auto_test;

import java.awt.Window;
import java.lang.annotation.Target;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.Option;

import org.checkerframework.framework.qual.TargetLocations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.page.model.NavigatedWithinDocument;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import dev.failsafe.Timeout;
import graphql.execution.instrumentation.tracing.TracingInstrumentation.Options;

public class code_selenium {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
		
		//@Test 
		public void TC_01_login_with_empty_email_password() {
		
		//>=2 nó sẽ đóng task window mà nó đang đứng
		//=1 nó cũng đóng browser
		driver.close();
		
		// Không quan tâm bao nhiêu task/ window nó sẽ đóng browser
		driver.quit();
		
		// tìm 1 element
		WebElement emailTexbox = driver.findElement(By.xpath(""));
		// Tìm nhiều element
		List<WebElement> password = driver.findElements(By.xpath(""));
		
		// mở ra 1 URL nào đó
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		// trả về URL của page hiện tại
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		 //Verify tương đối
		driver.getPageSource();
		
		Assert.assertTrue(driver.getPageSource().contains("Xin chúc mừng bạn nhận được 1 phiếu mua hàng may mắn trị giá 1 tỷ"));
		Assert.assertTrue(driver.getPageSource().contains("Xin chúc mừng bạn"));
		Assert.assertTrue(driver.getPageSource().contains("phiếu mua hàng may mắn"));
		
		// Trả về title của pgae hiện tại
		driver.getTitle();
		//Đăng nhập tài khoản - Mua sắm Online | Shopee Việt Nam
		Assert.assertEquals(driver.getTitle(), "Đăng nhập tài khoản - Mua sắm Online | Shopee Việt Nam");
		
		// webdrive api  - window/tab
		// Lấy ra được ID của window/tab mà drive đang đứng (active)
		String loginWindowID = driver.getWindowHandle();
		
		// Lấy ra tất cả ID của window/tab 
		Set<String> allID = driver.getWindowHandles();
		
		//cookie/cache
		org.openqa.selenium.WebDriver.Options opt =  driver.manage();
		
		 // login thành công -> lưu lại
		opt.getCookies();
		// test case khác cookie vào lại không cần login nữa
		  opt.logs();
		  
		   opt.timeouts();
		   Timeouts time = opt.timeouts();
		   // Khoảng thời gian chờ element xuất hiện trong vòng bao x giây
		   time.implicitlyWait(5, TimeUnit.SECONDS);
		   time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		   time.implicitlyWait(5000000, TimeUnit.MICROSECONDS);
		   
		 // khoảng thời gian chờ page load xong trong vòng x giây
		   time.pageLoadTimeout(3, TimeUnit.SECONDS);
		   
		  // khoảng thời gian chờ script được thực thi trong vòng x giây
		   time.setScriptTimeout(0, TimeUnit.SECONDS);
		   
		   org.openqa.selenium.WebDriver.Window win = opt.window();
		   win.fullscreen();
		   win.maximize();
		   
		   //test FUI: functional
		   //test GUI: size/ font/ Color/ Position/ Location...
		   win.getPosition();
		   win.getSize();
		   
		   
		   Navigation nav =  driver.navigate();
		   nav.back();
		   nav.forward();
		   nav.refresh();
		    
		   nav.to("http://live.techpanda.org/index.php/customer/account/login/"); // giống với 
			driver.get("http://live.techpanda.org/index.php/customer/account/login/");
			
			TargetLocator tar =   driver.switchTo();
			tar.alert();
			
			tar.frame("");
			
			tar.window("");
			
		   
		   
		
		
		
		
		
		
		
	}
}
