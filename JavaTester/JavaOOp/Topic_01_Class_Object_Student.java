package JavaOOp;

public class Topic_01_Class_Object_Student {
	private int studentID;
	private String studentName;
	private float knowledgePoint;
	private float practicePoint;
	
	protected int getStudentID() {
		return studentID;
	}

	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	protected String getStudentName() {
		return studentName;
	}

	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	protected float getKnowledgePoint() {
		return knowledgePoint;
	}

	protected void setKnowledgePoint(float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	protected float getPracticePoint() {
		return practicePoint;
	}

	protected void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	protected Topic_01_Class_Object_Student(int studentID, String studentName, float knowledgePoint,
			float practicePoint) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.knowledgePoint = knowledgePoint;
		this.practicePoint = practicePoint;
	}
	
	private Float getAveragePoint() {
		return (this.knowledgePoint + this.practicePoint * 2)/3;
		
	}
	
	public void showStudenInfo() {
		System.out.println("*********************************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());		
		System.out.println("Student Average Point = " + getAveragePoint());		
	}
	
	public static void main (String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student(1000456, "Nguyễn Văn A", 7f, 8f);
		firstStudent.showStudenInfo();
		
		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student(100287, "Nguyễn Thị Sinh", 9f, 5f);
		secondStudent.showStudenInfo();	
		
		Topic_01_Class_Object_Student thirdStudent = new Topic_01_Class_Object_Student(1000278, "Ngô Văn Sỹ", 5f, 9f);
		thirdStudent.showStudenInfo();
	}

}
