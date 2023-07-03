package java_basic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

	public static void main(String[] args) {
//		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		String schoolName = "Automation Testing School";
		String courseName = schoolName.toLowerCase();
		String schoolAddress = "Ho Chi Minh";		

		System.out.println("Độ dài = " + schoolName.length());
		
		System.out.println("Lấy ra 1 ký tự nào đó = " + schoolName.charAt(2));
		
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + " " + schoolAddress); // Thực tế hay dùng cách này thay vì dùng concat
		
		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing School"));
		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));
		
		// startsWith/ endsWith/ contains
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("A")); //1 ký tự
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("Automation")); // 1 chuỗi ký tự 
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("T")); // trả ra false
		
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Testing")); 
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("T")); 
		System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Advanced")); 
		
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("l")); 
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("School"));
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("Automation"));
		
		
		System.out.println("Vị trí của 1 ký tự / chuỗi ký tự trong chuỗi = " + schoolName.indexOf("Automation")); 
		System.out.println("Vị trí của 1 ký tự / chuỗi ký tự trong chuỗi = " + schoolName.indexOf("A")); 
		System.out.println("Vị trí của 1 ký tự / chuỗi ký tự trong chuỗi = " + schoolName.indexOf("Testing")); 
		
		
		System.out.println("Tách 1 ký tự / chuỗi ký tự trong chuỗi = " + schoolName.substring(11)); 
		System.out.println("Tách 1 ký tự / chuỗi ký tự trong chuỗi = " + schoolName.substring(11,15)); 
		
		// Split: Tách chuỗi thành 1 mảng dựa vào 1 ký tự/ chuỗi ký tự
		// Giống với demo phần alert
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");
		System.out.println(results[1]);
		
		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		
		// Convert từ string sang float
		float productPriceF = Float.parseFloat(productPrice); // Kiểu này mới dùng để tính toán được
		System.out.println(productPriceF);
		
		// Trả về kiểu String
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);
		
		// Windows 10
		// Handle multiple OS: MAC/ Windows (Actions - keys - Ctrl/ command)
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;			
		} else {
			Keys key = Keys.COMMAND;
		}
		
		// Multiple brower: toUpperCase
		// firefox = FIREFOX (Enum)
//		String driverInstanceName = driver.toString();
//		System.out.println(driverInstanceName);
//		
//		if (driverInstanceName.contains("internetexplorer")) {
//			// Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
//		}
		
		String helloWorld = "  \n   \t          Hello World         ";
		System.out.println(helloWorld.trim());
		
		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty()); // Blank thì vẫn chứa ký tự
		System.out.println("Blank = " + helloWorld.isBlank());
		
		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));

	}

}
