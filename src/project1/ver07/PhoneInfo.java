package project1.ver07;

public class PhoneInfo
{
	public String name; //이름
	String phoneNumber; //전화번호 
	String birthday; //생년월일
	
	//생성자1
	public PhoneInfo(String name, String phoneNumber, String birthday) 
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//생성자2
	public PhoneInfo(String name, String phoneNumber) 
	{
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	public void showPhoneInfo() 
	{
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		System.out.println("생년월일"+ birthday);
	}

}
