package webdriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Iframe_Frame {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath+ "\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Url() {
		driver.get("https://skills.kynaenglish.vn/");
		sleepInSecond(5);
		
//		Verify Facebook iframe hiển thị
//		Facebook iframe vẫn là 1 element của trang Kyna
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src , 'facebook.com')]")).isDisplayed());
		
//		Switch qua iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src , 'facebook.com')]")));
		
		String likeFacebook = driver.findElement(By.xpath("//a[@title = 'Kyna.vn']/parent::div/following-sibling::div")).getText();
		System.out.println(likeFacebook);
		Assert.assertEquals(likeFacebook, "165K người theo dõi");
		
//		Switch về main (content chung)
		driver.switchTo().defaultContent();
		
//		Chọn button Phản hồi
		driver.findElement(By.xpath("//lable[text() = 'Chào bạn. Chúng tôi có thể giúp gì cho bạn?']")).click();
		
//		Switch qua CHAT iframe
		driver.switchTo().frame(driver.findElement(By.id("cs_chat_iframe")));
		
		
		
	}

	public void TC_02_Logo() {
		
	}

	public void TC_03_Form() {
		
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
