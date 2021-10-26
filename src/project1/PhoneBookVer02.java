package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 
{
	public static void addinfo()
	{
		Scanner scanner = new Scanner(System.in);  
		String name, phoneNumber, birth;
		
		System.out.print("이름:"); name = scanner.nextLine();
		System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
		System.out.print("주소:"); birth = scanner.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phoneNumber, birth);
		info.showPhoneInfo();
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("선택하세요");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			
			int choice = scanner.nextInt();			
			switch (choice) 
			{
			case 1:
				addinfo();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
