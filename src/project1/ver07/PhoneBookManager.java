package project1.ver07;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.text.ChangedCharSetException;

import project1.ver07.PhoneInfo;

public class PhoneBookManager implements SubMenultem
{
	private HashSet<PhoneInfo> phoneBookSet = new HashSet<PhoneInfo>();
	
	//메뉴출력
	public void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택:");
	}
	
	//입력
	public void dataInput()
	{
		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birth, major, company;
		int grade;
		
		System.out.println("데이터 입력을 시작합니다");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.println("선택>>");
		int num = scanner.nextInt();
		scanner.nextLine();

		if(num==GENERAL)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("생년월일:"); birth = scanner.nextLine();
			
			PhoneInfo info = new PhoneInfo(name, phoneNumber, birth);
			change(name);
			phoneBookSet.add(info);
		}
		if(num==SCHOOLMATE)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("전공:"); major = scanner.nextLine();
			System.out.println("학년:"); grade = scanner.nextInt();
			
			PhoneSchoolInfo info = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			change(name);
			phoneBookSet.add(info);	
		}
		if(num==COLLEAGUE)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("회사:"); company = scanner.nextLine();
			
			PhoneCompanyInfo info = new PhoneCompanyInfo(name, phoneNumber, company);
			change(name);
			phoneBookSet.add(info);
		}
		System.out.println("데이터 입력이 완료됐습니다.");
	}
	
	void change(String name)
	{
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();
		Scanner scanner = new Scanner(System.in);

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(name.equals(info.name))
			{
				while(true) 
				{
					System.out.println("이미 저장된 데이터입니다.");
					System.out.println("덮어쓸까요? Y(y) / N(n)");
					
					String yes = scanner.nextLine();
					
					switch (yes)
					{
					case "Y": case"y":	
						itr.remove();
					default:
						info.showPhoneInfo();
						return;
					}
				}	
			}
		}
	}
	
	//검색
	public void dataSearch()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(searchName.equals(info.name))
			{
				info.showPhoneInfo();
			}
		}
		
	}
	
	//삭제
	public void dataDelete() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();

		Iterator<PhoneInfo> itr = phoneBookSet.iterator();

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(deleteName.equals(info.name))
			{
				phoneBookSet.remove(info);
				System.out.println("데이터 삭제가 완료되었습니다.");
			}
		}	
	}
	
	//주소록전체출력
	public void dataAllShow()
	{
		for(PhoneInfo info : phoneBookSet)
		{
			info.showPhoneInfo();
		}
	}


}
