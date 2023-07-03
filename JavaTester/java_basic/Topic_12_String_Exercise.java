package java_basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	String courseName = "Automation Testing advANced 25154 7";

	//@Test
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countUpperCase = 0;
		int countLowerCase = 0;
		int countNumber = 0; 
		
		for (char character : courseNameArr) {
			// UpperCase
			if (character <= 'Z' && character >= 'A') {
				countUpperCase++;
			}
	
			// LowerCase
			if (character <= 'z' && character >= 'a') {
				countLowerCase++;
			}

			// Number
			if (character <= '9' && character >= '0') {
				countNumber++;
			}
		}
		
		System.out.println("Sum of UpperCase = " + countUpperCase);
		System.out.println("Sum of LowerCase = " + countLowerCase);
		System.out.println("Sum of Number = " + countNumber);
			
	}


	//@Test
	public void TC_02() {
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		int countNumber = 0;
		for (char c : courseNameArr) {
			if (c== 'i') {
				count++;
			}
			
			if (c <= '9' && c>= '0') {
				countNumber++;
			}
		}
		System.out.println("Number of 'i' = " + count);
		System.out.println("Kiểm tra chuỗi có chứa từ 'Testing' = " + courseName.contains("Testing"));
		System.out.println("Kiểm tra chuỗi có bắt đầu bằng từ 'Automation' = " + courseName.startsWith("Automation"));
		System.out.println("Kiểm tra chuỗi có kết thúc bằng từ 'Online = " + courseName.endsWith("Online"));
		System.out.println("Lấy vị trí của từ 'Testing' = " + courseName.indexOf("Testing"));
		courseName.replace("Online", "Offline");
		System.out.println("Thay thế từ 'Online' bằng từ 'Offline' = " + courseName);
		System.out.println("Đếm số lượng ký tự là số = " + countNumber);
		
		
	}

	@Test
	public void TC_03() {
		char courseNameArr[] = courseName.toCharArray();
			
		for (int i = courseNameArr.length - 1; i >=0 ; i--) {			
			System.out.println(courseNameArr[i]);
		}
	}
}