package JavaOOp_OverRiding;

// Class con có thể ghi đè 1 hàm của class cha
// Thay đổi hành vi phù hợp cho class con
public abstract class Person {
	public void eat() {
		System.out.println("Suất cơm 20K");
	}
	
	public abstract void sleep();
}
