package project1;

import java.util.Scanner;

import project1.ver04.PhoneInfo;
import project1.ver04.PhoneBookManager;

public class PhoneBookVer04 
{
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		project1.ver04.PhoneBookManager mgr = new project1.ver04.PhoneBookManager();
		
		while(true) 
		{
			mgr.printMenu();
			
			System.out.print("선택:");
			int choice = scanner.nextInt();	
			
			switch (choice) 
			{
			case 1:
				System.out.println("데이터 입력을 시작합니다");
				System.out.println("1.일반, 2.동창, 3.회사");
				System.out.println("선택>>");
				int select = scanner.nextInt();
				mgr.dataInput(select);
				break;
			case 2:
				mgr.dataSearch();
				break;
			case 3:
				mgr.dataDelete();
				break;
			case 4:
				mgr.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
