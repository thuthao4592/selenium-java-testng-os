package JavaAccModFirst;

import org.openqa.selenium.WebDriver;

public class Dog {
	WebDriver driver;
	Animal animal = new Animal();	// instance/ object
	// Có thể truy cập vào class Cat vì cùng package
	Cat cat = new Cat();
	
	public void showProperty() {
		System.out.println();
	}
}
