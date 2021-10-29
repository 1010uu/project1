package project1.ver03;

import java.util.Scanner;

import project1.ver03.PhoneInfo;

public class PhoneBookManager {
	
	private PhoneInfo[] phoneBook = new PhoneInfo[100];
	private int numOfInfo = 0;
	
	//메뉴출력
	public void printMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}
	//입력
	public void dataInput()
	{
		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birth;

		System.out.print("이름:"); name = scanner.nextLine();
		System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
		System.out.print("생년월일:"); birth = scanner.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phoneNumber, birth);
		phoneBook[numOfInfo++] = info;
		
		System.out.println("데이터 입력이 완료됐습니다.");
	}
	//검색
	public void dataSearch()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		
		for(int i=0 ; i<numOfInfo ; i++)
		{
			if(searchName.compareTo(phoneBook[i].name)==0)
			{
				phoneBook[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
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
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfInfo ; i++)
		{
			if(deleteName.compareTo(phoneBook[i].name)==0)
			{
				phoneBook[i] = null;
				deleteIndex = i;
				numOfInfo--;
				break;
			}
		}
		if(deleteIndex!=-1) {
			for(int i=deleteIndex; i<numOfInfo; i++) 
			{
				phoneBook[i] = phoneBook[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}	
	}
	
	//주소록전체출력
	public void dataAllShow()
	{
		for(int i=0 ; i<numOfInfo ; i++)
		{
			phoneBook[i].showPhoneInfo();
		}
	}
	
}
