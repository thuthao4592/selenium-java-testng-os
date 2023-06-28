package java_basic;

import JavaTester.Student;

public class Topic_11_Array_Object {
	String name;
	int age;
	
	public Topic_11_Array_Object(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
	
	public static void main(String[]args) {
		Topic_11_Array_Object[] students = new Topic_11_Array_Object[3];
		students[0] = new Topic_11_Array_Object("Tuan",24);
		students[1] = new Topic_11_Array_Object("Cuong0",25);
		students[2] = new Topic_11_Array_Object("Duc",24);
		
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}
}
