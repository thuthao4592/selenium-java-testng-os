package Java_Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {
	public static void main(String[] args) {
		int number = 10;
		
		try {
			// Nếu đúng: chạy hết code trong try và không qua catch
			// Nếu sai: Gặp exeption - nhảy qua catch
			number = number /0;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		
		System.out.println(number);
		
		String[] browserName = {"Chrome", "Edge", "Firefox"};
	
//		try {
//			browserName[0] = "Safari";
//			browserName[3] = "Internet Explorer";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		for (String browser : browserName) {
//			System.out.println(browser);
//		}
		
//		try {
//			int array[] = new int[10];
//			array[10] = 30/0;
//		} catch (ArithmeticException e ) {
//			e.printStackTrace();
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C://automationfc.jpg");
			outputStream.write(65);
			outputStream.close();
		} catch (FileNotFoundException e ) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void findFile() throws IOException {
		String fileName = "automation.jpg";
		File newFile = new File(fileName);
		if (newFile.exists() && newFile.isDirectory()) {
			// Action something
		} else {
			throw new IOException("This file not found" + fileName);
		}
	}
}
	
