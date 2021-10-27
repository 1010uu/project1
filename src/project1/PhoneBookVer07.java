package project1;

import java.util.Scanner;

import project1.ver07.PhoneInfo;
import project1.ver07.Menultem;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07 implements Menultem
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager mgr = new PhoneBookManager(); 
		
		while(true) 
		{
			mgr.printMenu();
			
			System.out.print("선택:");
			int choice = scanner.nextInt();	
			
			switch (choice) 
			{
			case INPUT_DATE:
				System.out.println("데이터 입력을 시작합니다");
				System.out.println("1.일반, 2.동창, 3.회사");
				System.out.println("선택>>");
				int select = scanner.nextInt();
				mgr.dataInput(select);
				break;
			case SEARCH_DATE:
				mgr.dataSearch();
				break;
			case DELETE_DATE:
				mgr.dataDelete();
				break;
			case OUTPUT_DATE:
				mgr.dataAllShow();
				break;
			case EXIT_PROGRAM:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
