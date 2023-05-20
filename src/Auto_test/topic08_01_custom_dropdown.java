package Auto_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class topic08_01_custom_dropdown {
	WebDriver driver;
	WebDriverWait exDriverWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		//dropdown
		// Default dropdown  HTML của nó là thẻ select và thẻ option
		//Custsom dropdown: khác thẻ select/option
		//li/ul/div/span...
		driver = new FirefoxDriver();
		exDriverWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
//Default dropdown
	@Test 
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		
		
		
		//1-Click vào 1 thẻ bất kỳ để làm sao cho nó xổ ra hết các item của dropdown
		driver.findElement(By.xpath("//span[@id= 'speed-button']")).click(); // css "span#speed-button"
		
		//2- Chờ tất cả các item được load ra thành công
		//locator phải lấy để đại diện cho tất cả item
		//Lấy ra thẻ chưa text 
		// nên define để dùng đi dùng lại nhiều lần
		
		exDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id= 'speed-menu']/li/div[@role= 'option']"))); // css "ul#speed-menu div[role= 'option']"
		 
		//Đưa hết các item trong dropdow vào 1 list
		List<WebElement> speedDropdownItems = driver.findElements((By.xpath("//ul[@id= 'speed-menu']/li/div[@role= 'option']")));
		// 3-tìm xem đúng cái đang cần ko (Dùng vòng lặp duyệt qua)
		
		 for (WebElement tempItem: speedDropdownItems) {
			 String itemText = tempItem.getText();
			 System.out.println(itemText);
			// 4. Tìm ra cái  text của item đúng với cái mình mong muốn
			if (itemText.equals("Fast")) {
				 // 5 Click vào item đấy
				 tempItem.click();
				 
				 // Thoát ra khỏi vòng lặp ko xét các case còn lại nữa
				 break;
			// } else {
				//System.out.println("Không click vào item");
			}
			 		 
			
		}
		
		//3.1 nếu nó nằm trong khoảng nhìn thấy của user thì ko cần phải scroll xuống
		//3.2 Nếu nó ko nằm trong khoảng nhìn thấy của user thì cần scroll xuống tới item đó
	
	}

	
	
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


