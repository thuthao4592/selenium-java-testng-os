package JavaOOP_Abstraction;

public class Dog implements IAnimal, ICity {
	// Implements không mang sử dụng được luôn
	// Phải viết lại mới sử dụng được
	// Khác knowledge của kế thừa (extends)
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddrress(String address) {
		// TODO Auto-generated method stub
		
	}

}
