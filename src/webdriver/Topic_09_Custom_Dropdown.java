package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
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
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	
	//@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		// Muốn chọn item cho Speed dropdown
		selectItemInDropdown("span#speed-button", "ul#speed-menu div[role='option']", "Fast");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Fast");
		
		selectItemInDropdown("span#salutation-button", "ul#salutation-menu div[role='option']", "Prof.");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Prof.");

	}		
	

	//@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");		
		selectItemInDropdown("i.dropdown.icon", "span.text", "Stevie Feliciano");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");
		
	}

	//@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");		
		selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
				
	}
	
	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");		
		selectItemInDropdown("i.dropdown.icon", "span.text", "Albania");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Albania");
		
		EnterAndSelectItemInDropdown("input.search", "span.text", "Algeria");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
		
				
		
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
	
	public void selectItemInDropdown(String parentCss, String allItemCss, String expectedTextItem) {
	//B1: Click vào 1 thẻ bất kỳ để xổ ra hết các item của dropdown
	driver.findElement(By.cssSelector(parentCss)).click();
	sleepInSecond(1);
	
	//B2: Chờ cho tất cả các item load ra thành công
	//Locator lấy ra phải đại diện cho tất cả các item		
	// Lấy thẻ chứa cái text()
	explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
	
	// Đưa hết tất cả item trong dropdown vào 1 list
	List<WebElement> speedDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
	
	//B3: Tìm item xem đúng  cái đang cần hay không
	for (WebElement	tempItem : speedDropdownItems) {
			
	//---- Nếu nó nằm trong khoảng nhìn thấy của User không cần scroll xuống
	//---- Nếu nó không nằm trong khoảng nhìn thấy của User thì cần scroll xuống đến item đó
	//B4: Kiểm tra text của item đúng với cái mình mong muốn
	if (tempItem.getText().trim().equals(expectedTextItem)) {
		sleepInSecond(1);		
		//B5: Click vào item đó
		tempItem.click();
		break;
		}
	}
	
	}
	
	public void EnterAndSelectItemInDropdown(String TexboxCss, String allItemCss, String expectedTextItem) {
		//B1: Click vào 1 thẻ bất kỳ để xổ ra hết các item của dropdown
		driver.findElement(By.cssSelector(TexboxCss)).clear();
		driver.findElement(By.cssSelector(TexboxCss)).sendKeys(expectedTextItem);;
		sleepInSecond(1);
		
		//B2: Chờ cho tất cả các item load ra thành công
		//Locator lấy ra phải đại diện cho tất cả các item		
		// Lấy thẻ chứa cái text()
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
		
		// Đưa hết tất cả item trong dropdown vào 1 list
		List<WebElement> speedDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemCss)));
		
		//B3: Tìm item xem đúng  cái đang cần hay không
		for (WebElement	tempItem : speedDropdownItems) {
				
		//---- Nếu nó nằm trong khoảng nhìn thấy của User không cần scroll xuống
		//---- Nếu nó không nằm trong khoảng nhìn thấy của User thì cần scroll xuống đến item đó
		//B4: Kiểm tra text của item đúng với cái mình mong muốn
		if (tempItem.getText().trim().equals(expectedTextItem)) {
			sleepInSecond(1);		
			//B5: Click vào item đó
			tempItem.click();
			break;
		}
	}
	
	}
}
		
	
