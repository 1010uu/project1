package project1.ver05;

public class PhoneCompanyInfo extends PhoneInfo
{
	String CompanyName;	//회사명(자식의 멤버변수)

	public PhoneCompanyInfo(String name, String phoneNumber, 
							String birthday, String CompanyName) 
	{
		super(name, phoneNumber, birthday);
		this.CompanyName = CompanyName;
	}

	public PhoneCompanyInfo(String name, String phoneNumber,
							String CompanyName) {
		super(name, phoneNumber);
		this.CompanyName = CompanyName;
	}
	
	@Override
	public void showPhoneInfo() 
	{
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		System.out.println("회사:"+ CompanyName);
	}
}
