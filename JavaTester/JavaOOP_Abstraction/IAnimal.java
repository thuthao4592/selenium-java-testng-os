package JavaOOP_Abstraction;

public interface IAnimal {
	//Các biến (thuộc tính) trong Interface mặc định là public static final (hằng số)
	public int number = 100;
	// Dù có chỉ rõ hay không thì các hàm này đều ở dạng public & abstract (cho cả object và method)
	// Nó không có dạng private & protected	
	public String getName();
	void setName (String name);
	
	abstract String getAddress();
	abstract void setAddrress (String address);
}
