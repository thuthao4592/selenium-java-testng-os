package java_basic;

public class Topic_05_Reference_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Nhân viên: " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("A");
		secondStudent.setStudentName("SG");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("K");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
	}

}
