package java_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class Topic_11_Array {

	public static void main(String[] args) {
		// Cách khai báo mảng phổ biến nhất
		int number[] = {10,15,27,48,61};
		int[] student = {10,15,27,48,61};
		
		// Lấy ra phần tử đầu tiên
		System.out.println(number[0]);
		
		// Khi nhập index vượt ngoài số lượng các phần tử của mảng
		// Sẽ throw ra 1 exception ArrayIndexOut
		//System.out.println(number[7]);
		
		// Cố định
		// Được define cố định bao nhiêu phần tử khi mình viết code (compile)
		String studentName[] = {"Nam", "Long", "An"};
		studentName[0] = "Hoa";
		
		// Clone 1 mảng
		String stdNewName[] = studentName.clone();
		
		// Cách 1
		for (int i = 0; i < studentName.length; i++) {
			System.out.println(studentName[i]);
			
		}
		
		// Cách 2:
		// Tuy nhiên cách này không kết hợp với điều kiện được
		for (String stn : studentName) {
			System.out.println(stn);
		}
		
		// Câu lệnh for có thể kết hợp với điều kiện được 
		for (int i = 0; i < studentName.length; i++) {
			if (studentName[i].equals("Long")) {
				System.out.println("Accept");
			}
		}
		
		// Động 
		ArrayList<String> stdName = new ArrayList<String>();
		
		// Khi chạy code mới add (Runtime)
		for (String std : stdName) {
			stdName.add(std);
		}
		
		List<String> names = Arrays.asList("Tom", "Jerry", "Max");
		for (String name : names) {
			System.out.println("Name: " + name);
			
		}
		
		// In ra kiểu chuỗi [Hoa, Long, An]
		String std_Name = Arrays.toString(studentName);
		System.out.println(std_Name);
	}
	
	int number[] = {2,-8,7,6,-5,8,9,-3,90,5};
	
	//@Test
	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x<number[i]) {
				x = number[i];
			}
		}
		System.out.println("Max number = " + x);
	}
	
	//@Test
	public void TC_02_Sum_FirstNumber_LastNumber() {	
		System.out.println("Sum = " + (number[0] + number[number.length-1]));
	}
	
	//@Test
	public void TC_03_Select_EvenNumber() {	
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Even number = " + number[i]);
			}
		}
	}
	
	//@Test
	public void TC_04_Sum_OddNumber() {	
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 != 0 && number[i] > 0) {
				x+=number[i];
			}
		}
		System.out.println("Sum_OddNumber = " + x);
	}
	
	//@Test
	public void TC_05_Select_Number0den10() {			
		for (int i = 0; i < number.length; i++) {
			if (number[i] >=0 && number[i] <=10) {
				System.out.println("Number in [0,10] = " + number[i]);
			}
		}
		
	}
	
	//@Test
	public void TC_06_Sum() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			x+= number[i];
		}
		System.out.println("Sum = " + x);
		float average = x/number.length;
		System.out.println("Average = " + average);
	}
	
}
