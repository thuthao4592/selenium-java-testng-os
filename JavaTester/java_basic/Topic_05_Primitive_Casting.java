package java_basic;

public class Topic_05_Primitive_Casting {
	public static void main(String[] args) {
		
		// Ngầm định: Không mất dữ liệu
//		byte bNumber = 126;
//		System.out.println(bNumber);
//		
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//		long lNumber = sNumber;
//		System.out.println(lNumber);
//		float fNumber = sNumber;
//		System.out.println(fNumber);
//		double dNumber = fNumber;
//		System.out.println(dNumber);
		
		// Tường minh (Cast)
		double dNumber = 65432178945678d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(lNumber);
		
		short sNumber = (short) iNumber;
		System.out.println(sNumber);
		
		byte bNumber = (byte) sNumber;
		System.out.println(bNumber);
		
	}

}
