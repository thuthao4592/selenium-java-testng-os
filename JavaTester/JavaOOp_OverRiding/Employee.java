package JavaOOp_OverRiding;

public class Employee extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Suất cơm 25K");
	}
	
	@Override
	public void sleep() {
		System.out.println("Ngày ngủ 8 tiếng");
	}
	
	@Override
	public void workingTime() {
		System.out.println("Làm 8 tiếng/ ngày");
	}
}
