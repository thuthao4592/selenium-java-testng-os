package JavaAccModSecond;

import JavaAccModFirst.Dog;

public class Fish {
	// Không thể truy cập vào class Cat (không có public) thì nếu không cùng package sẽ không thể truy cập được
	// Khác package nhưng class ở chế độ public nên vẫn truy cập vào được
	// import package
	Dog dog = new Dog();
}
