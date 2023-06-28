package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	//@Test
	public void TC_01_(String browserName) {
		driver = getBrowserDriver(browserName);
		
		System.out.println(browserName);		
		driver.quit();		
	}
	
	// break: giúp không chạy hết tất cả các case ---> TC chạy đúng dù không bắt buộc dùng
	//@Test
	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + month + " có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng " + month + " có 30 ngày");
		default:
			System.out.println("Tháng " + month + " sai định dạng.");
			break;
		}
	}
	
	//@Test
	public void TC_03() {
		int number = scanner.nextInt();
		switch (number) {
		case 1: 
			System.out.println("one");
			break;
		case 2:	
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		case 4:
			System.out.println("four");
			break;
		case 5:
			System.out.println("five");
			break;
		case 6:
			System.out.println("six");
			break;
		case 7:
			System.out.println("seven");
			break;
		case 8:
			System.out.println("eight");
			break;
		case 9:
			System.out.println("nine");
			break;
		case 10:
			System.out.println("ten");
			break;
		default:
			System.out.println("Nhập số từ 1-10");
			break;
		}
	}
	
	//@Test
	public void TC_04_() {
		int firstName = scanner.nextInt();
		int secondName = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = "+ (firstName + secondName));
			break;
		
		case "-":
			System.out.println("A - B = "+ (firstName - secondName));
			break;
			
		case "*":
			System.out.println("A * B = "+ (firstName * secondName));
			break;
			
		case "/":
			System.out.println("A / B = "+ (firstName / secondName));
			break;	
			
		case "%":
			System.out.println("A % B = "+ (firstName % secondName));
			break;	
	
		default:
			break;
		}
		
	}

	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();			
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers/msedgedriver.exe");
			driver = new EdgeDriver();		
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;	
		default:
			new RuntimeException("Please input correct browserName");
			break;		
		}
		return driver;
	}
	
	
}
