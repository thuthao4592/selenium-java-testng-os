package javaTester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Data_Type {

	public static void main(String[] args) {
// Kiểu dữ liệu nguyên thuỷ (Primitive) 
			// Số nguyên: byte, short, int, long (ko có phần thập phân)
			byte bNumber = 127;
			short sNumber = 3200;
			int iNumber = 499233399;
			// Số thực : fload double (Có phần thập phân)
			// Logic: boolean (true/fail)
			// Kí tự: char
			char a = 'A';
			
// Kiểu dữ liệu tham chiếu (Reference)
			// Class
			FirefoxDriver driver = new FirefoxDriver();
			
			// Interface
			WebElement firsNameTextbox;
			//String
			String firsName = "Automation Testing";
			//Object
			Object peple;
			//Array
			String[] studentName = {"Nguyen Thi Lan","Đặng Thị "};
			//Collection: List/Set/Queue
			List<WebElement> checkboxes = driver.findElements(By.cssSelector(""));
			
			//Map
			Map<String, Integer> student = new HashMap<>();

	}

}
