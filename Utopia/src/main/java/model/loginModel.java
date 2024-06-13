package model;

public class loginModel {
	private String phoneNumber;
	private String password;
	
	public loginModel(String phoneNumber, String password) {
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}