package java_basic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	
	public void TC_01_() {
		int number = scanner.nextInt();
		
		if (number % 2 == 0 ) {
			System.out.println("Số: " + number + " là số chẵn");
		} else {
			System.out.println("Số: " + number + " là số lẻ");
		}
	
	}
	
	//@Test
	public void TC_02_() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA >= numberB) {
			System.out.println(numberA + " lớn hơn hoặc bằng " + numberB);
		} else {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}
	}
	
	//@Test
	public void TC_03_() {
		String personA = scanner.nextLine();
		String personB = scanner.nextLine();
		
		// Equal dùng cho kiểu Reference: String
		// Kiểm tra cái value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		if (personA.equals(personB)) {
			System.out.println("2 người cùng tên");
		} else {
			System.out.println("2 người khác tên");
		}
		
		// Equal dùng cho kiểu primitive type
		if (personA == personB) {
			System.out.println("2 người cùng tên");
		} else {
			System.out.println("2 người khác tên");
		}
	}
	
	// @Test
	public void TC_04_() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA);
		} else if (numberB > numberA && numberB > numberC) {
			System.out.println(numberB);
		} else {
			System.out.println(numberC);
		}
	}

	//@Test
	public void TC_05_() {
		int numberA = scanner.nextInt();
		
		if (numberA >= 10 && numberA <=100) {
			System.out.println(numberA + " nằm trong [10,100]");
		} else {
			System.out.println(numberA + " không nằm trong [10,100]");
		}
	}
	
	//@Test
	public void TC_06_() {
		float studentPoint = scanner.nextFloat();
		
		if (studentPoint >=0 && studentPoint < 5) {
			System.out.println(studentPoint + ": Điểm D");
		} else if (studentPoint >=5 && studentPoint < 7.5) {
			System.out.println(studentPoint + ": Điểm C");
		} else if (studentPoint >=7.5 && studentPoint < 8.5) {
			System.out.println(studentPoint + ": Điểm B");
		} else {
			System.out.println(studentPoint + ": Điểm A");
		}
	}
	
	@Test 
	public void TC_07_() {
		int month = scanner.nextInt();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) {
			System.out.println("Tháng " + month + " có 31 ngày");
		} else if (month == 2) {
			System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
		} else {
			System.out.println("Tháng " + month + " có 30 ngày");
		}
	}
}
