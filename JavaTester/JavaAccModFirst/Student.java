package JavaAccModFirst;

public class Student {
	// Cho private để không thể truy cập trực tiếp mà phải thông qua hàm
	private int age;
	public void setAge(int enterAge) {
		if (enterAge > 0) {
			this.age = enterAge;
		}	else {
			System.out.println("Enter age is invalid");
		}
	}
	public int getAge() {
		return this.age;	
	}
	
}
