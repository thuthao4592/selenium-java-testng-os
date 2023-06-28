package java_basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

		//@Test
		public void TC_01_If() {
			boolean status = 5 > 3;
			System.out.println(status);
			
			// Hàm if sẽ nhận vào một điều kiện đúng
			// Kiểm tra duy nhất 1 điều kiện
			// Nếu điều kiện này đúng thì sẽ action (xxx) trong phần thân của if
			if (!status) {
				// Đúng thì vào phần thân của if
				// Sai thì bỏ qua
				System.out.println("Go to if");
				
			}
			
			// Gán (assign)
			int studentNumber = 10;
			
			// Dùng == để so sánh
			status = (studentNumber != 10);
			System.out.println(status);
			
			WebDriver driver = new FirefoxDriver();
			
			// Element luôn có trong DOM dù popup hiển thị hay không
			WebElement salePopup = driver.findElement(By.cssSelector(""));
			if (salePopup.isDisplayed()) {
				
			}
			
			// Element không có trong DOM khi popup không hiển thị
			List<WebElement> salePopups = driver.findElements(By.cssSelector(""));
			if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
				
			}
			
			// Uncheck to checkbox
			WebElement languagesCheckbox = driver.findElement(By.cssSelector(""));
			if (languagesCheckbox.isSelected()) {
				languagesCheckbox.click();
				
			}
			
			// Check to checkbox				
			if (!languagesCheckbox.isSelected()) {
			
		}
			
		}

		//@Test
		public void TC_02_If_Else_() {
			// Có tới 2 điều kiện nếu đúng thì vào if sai thì vào else
			
			// Nếu driver start vs browser như Chrome/ Firefox/ Edge/ Safari thì dùng hàm click 
			// Thông thường (builtin) của Selenium WebElement
			
			// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			if (driver.toString().contains("internet explorer")) {
				System.out.println("Click by Javascript Executor");
			} else {
				System.out.println("Click by Selenium WebElement");
			}
	
		}

	public void TC_03_If_else_If_else(String browserName) {
		// Có nhiều điều kiện 
		// Best Practice: không nên if-else quá nhiều
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();			
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {//Safari/ Opera/..
			throw new RuntimeException("Please input correct browserName");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		driver.quit();
	}
		
  

	@Test
	public void TC_04_If_else_If_else() {
		String pageName = "Login";
		if (pageName.equals("Login")) {
			// LoginPage loginPage = new loginPage();
			// return loginPage;
		} else if (pageName.equals("Register")) {
			// RegisterPage registerPage = new RegisterPage();
			// return loginPage;
		} else if (pageName.equals("New Customer")) {
			// CustomerPage customerPage = new CustomerPage();
			// return customerPage;
		} else {
			// HomePage homePage = new HomePage();
			// return homePage;
			
		}
		
		// If-else
		int age = 20;
		String access = (age < 18) ? "You can not access" : "Welcome to our system!";
		
		if (age < 18) { 
			access = "You can not access";
		} else {
			access = "You can not access";
		}
		
	
	}
}
