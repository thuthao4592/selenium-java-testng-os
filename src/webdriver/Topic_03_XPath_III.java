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

public class Topic_03_XPath_III {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}


		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://www.facebook.com/");
	}
@Test
public void TC_01_AXES() {
		
		driver.get("http://live.techpanda.org/index.php/mobile.html");	
		driver.findElement(By.xpath("//a[contains(text(),'Samsung Galaxy')]/parent::h2/following-sibling::div[@class='actions']/button")).click();
//		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Samsung Galaxy')]/parent::h2/following-sibling::div[@class='actions']/button")).getText());
		}
	

	@Test
	public void TC_02_expire() {
		driver.get("https://subscription.packtpub.com/search?products=Book&category=Data");	
		System.out.println(driver.findElement(By.xpath("div[contains(text(),'Machine Learning with PyTorch and Scikit-Learn')]/ancestor::a/following-sibling::a/div[@class='product-footer']/div")));

		//div[contains(text(),'Machine Learning with PyTorch and Scikit-Learn')]/ancestor::div[@class='product-card']/descendant::div[@class='product-footer']/div[not(@class='cart-price')]
				//div[contains(text(),'Machine Learning with PyTorch and Scikit-Learn')]/ancestor::a/following-sibling::a/div[@class='product-footer']/div
	}
		

	@Test
	public void TC_03() {
		driver.get("https://fptshop.com.vn/apple/macbook");	
		driver.findElement(By.xpath("a[@title='MacBook Pro 13\" 2020 Touch Bar M1 512GB']/ancestor::div/following-sibling::div/a[@class='btn btn-primary btn-sm btn-main']")).click();
//		System.out.println(driver.findElement(By.xpath("a[@title='MacBook Pro 13\" 2020 Touch Bar M1 512GB']/ancestor::div/following-sibling::div/a[@class='btn btn-primary btn-sm btn-main']")));
		//
		//Vy viet a[@title='MacBook Pro 13" 2020 Touch Bar M1 512GB']/ancestor::div/following-sibling::div[@class='product__btn']/a[@class='btn btn-primary btn-sm btn-main']
	}
//	@Test
	
	public void TC_04() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
