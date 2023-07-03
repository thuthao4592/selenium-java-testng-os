package JavaOOp_OverRiding;

public class Student extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("Suất cơm 15K");
	}
	
	@Override
	public void sleep() {
		System.out.println("Ngày ngủ 12 tiếng");
	} 
	
	@Override
	public void workingTime() {
		System.out.println("Học 6 tiếng/ ngày");
	}
	
}
