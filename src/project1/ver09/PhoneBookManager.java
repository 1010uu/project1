package project1.ver09;

import java.util.Scanner;

import project1.ver09.PhoneInfo;

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
		System.out.print("선택:");
	}
	//입력
	public void dataInput()
	{
//		Scanner scanner = new Scanner(System.in);

		InsertSQL insertSQL = new InsertSQL();
		insertSQL.execute();
		System.out.println("데이터 입력이 완료됐습니다.");
	}
	
	//검색
	public void dataSearch()
	{
//		Scanner scanner = new Scanner(System.in);
		
		System.out.println("데이터 검색을 시작합니다.");
		SelectSQL selectSQL = new SelectSQL();
		selectSQL.execute();
		System.out.println("데이터 검색이 완료되었습니다.");
	}
	
	//삭제
	public void dataDelete() 
	{
//		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		DeleteSQL deleteSQL = new DeleteSQL();
		deleteSQL.execute();
		System.out.println("데이터 삭제가 완료되었습니다.");
			
	}
//주소록전체출력
	public void dataAllShow()
	{
		AllShowQuery allShowQuery = new AllShowQuery();
		allShowQuery.execute();
		
	}
	
}
