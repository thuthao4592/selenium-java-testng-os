package Polymorphism;

// Tính đa hình: các hàm có cùng tên nhưng có nhiều hình thái và thực hiện các chức năng khác nhau
// Overloading
public class Operator {
	public void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public void sum(double a, double b) {
		System.out.println(a + b);
	}
	
	public void sum(float a, float b) {
		System.out.println(a + b);
	}
	public void sum(long a, long b) {
		System.out.println(a + b);
	}
	
	public static void main (String[] args) {
		Operator opr = new Operator();
		
		// Trình biên dịch (compile code) sẽ lựa chọn phương thức nào
		opr.sum(5, 8);
		opr.sum(5444444l, 6145884l);
		
		
		
	}
}
