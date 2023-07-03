package JavaOOp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic_06_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Tên nhập không được bỏ trống!");
		} else {
			this.personName = personName;
		}
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		if (personAge > 15 && personAge < 60) {
			throw new IllegalArgumentException("Tuổi nhập vào không hợp lệ");
		} else {
			this.personAge = personAge;
		}
	}
	public int getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(int personPhone) {
		if(!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		} else if(personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải từ 10-11 số");
		} else {
		this.personPhone = personPhone;
		}
	}
	
	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}
	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}

	
}
