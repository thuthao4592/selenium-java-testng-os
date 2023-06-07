package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Wait_Page_Ready {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExcutor;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);		
		jsExcutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		}
	
	
	@Test
	public void TC_01_Orange_HRM_API() {	
		driver.get("https://api.orangehrm.com/");
		// Wait cho icon loading biến mất
		// Vì khi nó biến mất thì trang sẽ load dữ liệu về thành công
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loader div.spinner")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
		
	}

	@Test
	public void TC_02_Admin_NopCommerce() {
		driver.get("https://admin-demo.nopcommerce.com");
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("button.login-button")).click();
		
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());
		
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
	}

	@Test
	public void TC_02_Admin_NopCommerce_CachII() {
		driver.get("https://admin-demo.nopcommerce.com");
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("button.login-button")).click();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
	}
	
	@Test
	public void TC_03_Blog_Test_Project() {
		driver.get("https://blog.testproject.io/");
	
		// Hover chuột vào 1 element bất kỳ để page ready
		action.moveToElement(driver.findElement(By.cssSelector("h1.main-heading"))).perform();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		String keyword = "Selenium";
		driver.findElement(By.cssSelector("section#search-2 input.search-field")).sendKeys(keyword);
		driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
		
		// phải wait cho 1 element bất kỳ của trang search xuất hiện (nếu không nó sẽ chạy wait cho page ready)
		// Khi đó nó sẽ k sang được trang search mà vẫn ở trang home thì verify ở trang home ---> fail testcase
		// Wait cho page heading của trang search visible
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[@class='main-heading' and text()='Search Results']")));
		Assert.assertTrue(isPageLoadedSuccess());
		
		List<WebElement> postArticles = driver.findElements(By.cssSelector("h3.post-title>a"));
		
		for (WebElement article : postArticles) {
			Assert.assertTrue(article.getText().contains(keyword));
			
		}

	}
	
	public boolean waitForAjaxBusyLoadingInvisible() {
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
		
	}
	
	// Wait cho page load complete/ page ready
	public boolean isPageLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
		
	
