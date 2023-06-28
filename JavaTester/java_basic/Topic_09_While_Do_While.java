package java_basic;

import java.util.Scanner;

import org.testng.annotations.Test;

// Class
public class Topic_09_While_Do_While {
	static Scanner scanner = new Scanner(System.in);

	// Function
	public static void main(String[] args) {
		Topic_09_While_Do_While topic = new Topic_09_While_Do_While();
		topic.TC_04_While();
		
	}
	
	//@Test
	public  void TC_01_For() {
		int number = scanner.nextInt(); 
		
		for (int i = number; i <=100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			
		}
	}
	
	//@Test
	public void TC_02_While() {
		int number = scanner.nextInt(); 
		int i = number;
		while (i<=100) {
			if (i%2==0) {
				System.out.println(i);
				i++;
			}
		}		
	}
	
	//@Test
	public void TC_03_Do_While() {
		int number = scanner.nextInt(); 
		int i = number;
		do {
			if (i%2==0) {
				System.out.println(i);	
				i++;
			}
		}	while (i<=100);
			
	}
	
	//@Test
	public void TC_04_While() {
		int numberA = scanner.nextInt(); 
		int numberB = scanner.nextInt();
		while (numberA <= numberB) {
			if (numberA%3==0 && numberA%5==0) {
				System.out.println(numberA);				
			}
			numberA++;
		}
			
	}
	
	//@Test
	public void TC_05_While() {
		int number = scanner.nextInt();
		int i = 0;
		while (number>0) {
			if (number % 2 !=0) {
				i+=number;	
			}
			number--;			
			}
		System.out.println(i);		
	}
	
	//@Test
	public void TC_06_While() {
		int numberA = scanner.nextInt(); 
		int numberB = scanner.nextInt();
		while (numberA <= numberB) {
			if (numberA%3==0) {
				System.out.println(numberA);				
			}
			numberA++;
		}
	}
	
	//@Test
	public void TC_07_While() {
		int number = scanner.nextInt();
		int i = 1;
		while (number>0) {
			i*=number;
			number--;			
			}
		System.out.println(i);		
	}
	
	@Test
	public void TC_08_While() {
		int number = scanner.nextInt();
		int i = 1;
		while (number<=10 && number >=1) {
			i+=number;
			number--;			
			}
		System.out.println(i);		
	}
}
