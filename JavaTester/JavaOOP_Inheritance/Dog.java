package JavaOOP_Inheritance;

public class Dog extends Animal {
	// Đóng gói dữ liệu để private
	private int age;
	
	public void run() {
		System.out.println("Running.....");
	}
	
	// Hàm setter và getter
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
		else this.age = 0;
	}
	
	public int getAge() {
		return this.age;
	}
}
