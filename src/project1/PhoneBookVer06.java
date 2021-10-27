package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneInfo;
import project1.ver06.MenuSelectException;
import project1.ver06.Menultem;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06 implements Menultem
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager mgr = new PhoneBookManager(); 
		
		while(true) 
		{
			mgr.printMenu();
			System.out.print("선택:");
			
			try
			{
				int choice = scanner.nextInt();	
				
				try
				{
					if(choice<1 || choice>5)
					{
						MenuSelectException warn = new MenuSelectException();
						throw warn;
					}
				}
				catch (MenuSelectException e)
				{
					System.out.println(e.getMessage());
				}
		
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
			catch (InputMismatchException e)
			{
				scanner.nextLine();
				System.out.println("[예외발생]문자가 입력됐습니다.");
				System.out.println("숫자를 입력해주세요");
			}
		}
	}
}
