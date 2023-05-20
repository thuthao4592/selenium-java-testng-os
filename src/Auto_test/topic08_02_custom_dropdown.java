package Auto_test;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class topic08_02_custom_dropdown {
	WebDriver driver;
	WebDriverWait exDriverWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
		//dropdown
		// Default dropdown  HTML của nó là thẻ select và thẻ option
		//Custsom dropdown: khác thẻ select/option
		//li/ul/div/span...
		driver = new FirefoxDriver();
		exDriverWait = new WebDriverWait(driver, 30);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	

	//@Test
	public void TC_01_JQuery() {
         driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
         sleepInSecond(3);
		
		// Muốn chọ item cho speed dropdown
		selectItemInDropdown("span#speed-button","ul#speed-menu div[role='option']","Fast");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Fast");
		
		selectItemInDropdown("span#speed-button","ul#speed-menu div[role='option']", "Slow");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slow");
		
		selectItemInDropdown("span#speed-button","ul#speed-menu div[role='option']","Medium");
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Medium");
		
	}
	
	//@Test
	public void TC_02_ReactJS() {
         driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        
         selectItemInDropdown("i.dropdown.icon", "span.text", "Elliot Fu");
 		sleepInSecond(2);
 	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Elliot Fu");
 	    
 	   selectItemInDropdown("i.dropdown.icon", "span.text", "Stevie Feliciano");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");
	    
		selectItemInDropdown("i.dropdown.icon","span.text","Matt");
 		sleepInSecond(2);
 	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Matt");
 	    
 		selectItemInDropdown("i.dropdown.icon","span.text","Justen Kitsune");
 		sleepInSecond(2);
 	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");
      // Mục địch click vào xổ ra là được, xem nó là parentcss   
         
	}


	//@Test
	public void TC_03_VueJS() {
         driver.get("https://mikerodham.github.io/vue-dropdowns/");
         
         selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Second Option");
  		sleepInSecond(2);
  	    Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
  	    
  	  selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "First Option");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
	    
	    selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu>li>a", "Third Option");
  		sleepInSecond(2);
  	    Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
	}
	// test1,2,2 là select table: chỉ được chọn
		// edit table: vừa chọn vừa nhập
		
	@Test
	public void TC_04_Edittable() {
         driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
         
         enterandselectItemInDropdown("input.search", "span.text", "Angola");
  		sleepInSecond(2);
  	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Angola");
  	    
  	  enterandselectItemInDropdown("input.search", "span.text", "Australia");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Australia");
	    
	    enterandselectItemInDropdown("input.search", "span.text", "Belize");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belize");
	    
	    enterandselectItemInDropdown("input.search", "span.text", "Aruba");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Aruba");
	    
	    enterandselectItemInDropdown("input.search", "span.text", "Belarus");
		sleepInSecond(2);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belarus");
	}
	
	//viết hàm tránh lặp lại code nhiều lần chỉ cần gọi ra hàm 1 lần
	// di kèm với tham số
	// Nếu truyền cứng 1 giá trị trong hàm thì vô nghĩa
	public void selectItemInDropdown(String parentcss, String allItemcss, String expectedTextItem) {
		
		//1-Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item của dropdown
		driver.findElement(By.cssSelector(parentcss)).click();
		sleepInSecond(1);
		//2- Chờ tất cả các item được load ra thành công
		//locator phải lấy để đại diện cho tất cả item
		//Lấy ra thẻ chưa text 
		
		exDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemcss)));
		 
		//Đưa hết các item trong dropdow vào 1 list
		List<WebElement> speedDropdownItems = driver.findElements((By.cssSelector(allItemcss)));
		// 3-tìm xem đúng cái đang cần ko (Dùng vòng lặp duyệt qua)
		
		 for (WebElement tempItem: speedDropdownItems) {
			 String itemText = tempItem.getText();
			 System.out.println(itemText);
			// 4. Tìm ra cái  text của item đúng với cái mình mong muốn
			if (itemText.trim().equals(expectedTextItem)) {
				// trim() xóa khoảng trắng đầu và cuối
				 // 5 Click vào item đấy
				 tempItem.click();
				 sleepInSecond(1);
				 
				 // Thoát ra khỏi vòng lặp ko xét các case còn lại nữa
				 break;
			// } else {
				//System.out.println("Không click vào item");
			}
			 		 
			
		}
	}
	
public void enterandselectItemInDropdown(String textboxcss, String allItemcss, String expectedTextItem) {
		
		//1-Nhập expected item vào tự động sổ ra tất cả các item matching
	    driver.findElement(By.cssSelector(textboxcss)).clear();
		driver.findElement(By.cssSelector(textboxcss)).sendKeys(expectedTextItem);;
		sleepInSecond(1);
		//2- Chờ tất cả các item được load ra thành công
		//locator phải lấy để đại diện cho tất cả item
		//Lấy ra thẻ chưa text 
		
		exDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allItemcss)));
		 
		//Đưa hết các item trong dropdow vào 1 list
		List<WebElement> speedDropdownItems = driver.findElements((By.cssSelector(allItemcss)));
		// 3-tìm xem đúng cái đang cần ko (Dùng vòng lặp duyệt qua)
		
		 for (WebElement tempItem: speedDropdownItems) {
			 String itemText = tempItem.getText();
			 System.out.println(itemText);
			// 4. Tìm ra cái  text của item đúng với cái mình mong muốn
			if (itemText.trim().equals(expectedTextItem)) {
				// trim() xóa khoảng trắng đầu và cuối
				 // 5 Click vào item đấy
				 tempItem.click();
				 sleepInSecond(1);
				 
				 // Thoát ra khỏi vòng lặp ko xét các case còn lại nữa
				 break;
			// } else {
				//System.out.println("Không click vào item");
			}
			 		 
			
		}
	}
    public WebDriver getdDriver() {
    	Return driver ;
		return null;
		
	}// Hàm lấy ra drive trả về kiểu  webdrive
    private void sleepInSecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
