package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {
	public static void main(String [] args) {
		// Kiểu dữ liệu nguyên thuỷ (Primitive)
		
		// Số nguyên: byte short int long (không có phần thập phân)
		byte bNumber = 127;
		
		short sNumber = 32000;
		
		int iNumber = 499233299;
		
		long lNumber = 83294;
		
		// Số thực: float double (có phần thập phân)
		float studentPoint = 9.5f;
		
		double employeeSalary = 35.6d;
		
		// Logic: boolean
		boolean status = true; //Nam
		status = false; //Nữ
		
		// Kí tự: char
		char a = 'A';
		
		// Kiểu dữ liệu tham chiếu (Reference)  
		//Class
		FirefoxDriver driver = new FirefoxDriver();
		
		
		//Interface
		WebElement firstNameTextbox;
		
		//String
		String firstName = "Automation Testing";
		
		//Object
		Object peple;
		
		//Array
		String[] studentName = {"A B C","4 5 6"	};
		
		//Collection: List/ Set/ Queue
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(""));
		
		//Map
		Map<String, Integer> student = new HashMap<String, Integer>();

	}
}
	
