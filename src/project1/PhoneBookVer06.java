package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneInfo;
import project1.ver06.MenuSelectException;
import project1.ver06.Menultem;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager mgr = new PhoneBookManager(); 
		
		while(true) 
		{
			mgr.printMenu();
			
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
				case Menultem.INPUT_DATE:
					mgr.dataInput();
					break;
				case Menultem.SEARCH_DATE:
					mgr.dataSearch();
					break;
				case Menultem.DELETE_DATE:
					mgr.dataDelete();
					break;
				case Menultem.OUTPUT_DATE:
					mgr.dataAllShow();
					break;
				case Menultem.EXIT_PROGRAM:
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
