package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_Find_Element_Find_Elements {
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
		
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		// Đang apply 15s cho việc findElement
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	
	
	@Test
	public void TC_01_FindElement() {	
		
		// Tìm thấy duy nhất 1 element/ node
		// Tìm thấy và thao tác trực tiếp lên node đó
		// Vì nó tìm thấy nên không cần chờ hết timeout 15s
		
		driver.findElement(By.cssSelector("input#email"));
		
		// Tìm thấy nhiêù hơn 1 element/ node
		// Nó sẽ thao tác với node đầu tiên, không quan tâm các node còn lại
		// Trong trường hợp bắt locator sai thì nó tìm sai
		
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("automation@gmail.com");

		// Không tìm thấy element/node nào
		// Có cơ chế tìm lại = 0.5s  sẽ tìm lại 1 lần
		// Nếu trong thời gian tìm lại mà thấy element thì thỏa mãn điều kiện ---> Pass
		// Nếu trong thời gian tìm lại mà không thấy element thì
		// + Đánh fail testcase tại step này
		// + Throw ra 1 ngoại lệ: NoSuchElementException
		
		driver.findElement(By.cssSelector("input[type='check']"));
		
	}

	@Test
	public void TC_02_FindElements() {
		// Tìm thấy duy nhất 1 element/ node
		// Tìm thấy và lưu nó vào list = 1 element
		// Vì nó tìm thấy nên không cần chờ hết timeout 15s
		
		List<WebElement> elements = driver.findElements(By.cssSelector("input#email"));
		System.out.println("List element number = " + elements.size());
		
		// Tìm thấy nhiêù hơn 1 element/ node
		// Tìm thấy và lưu nó vào list = số element tương ứng
		
		elements = driver.findElements(By.cssSelector("input[type='email']"));
		System.out.println("List element number = " + elements.size());
		
		
		// Không tìm thấy element/node nào
		// Có cơ chế tìm lại = 0.5s  sẽ tìm lại 1 lần
		// Nếu trong thời gian tìm lại mà thấy element thì thỏa mãn điều kiện ---> Pass
		// Nếu trong thời gian tìm lại mà không thấy element 
		//+ Không đánh fail testcase và vẫn run next step
		//+ Trả ra list rỗng = empty	
		
		elements = driver.findElements(By.cssSelector("input[type='check']"));
		System.out.println("List element number = " + elements.size());
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
		
	
