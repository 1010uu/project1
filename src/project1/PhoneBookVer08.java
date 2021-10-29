package project1;


import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.PhoneInfo;
import project1.ver06.MenuSelectException;
import project1.ver08.Menultem;
import project1.ver08.PhoneBookManager;

public class PhoneBookVer08 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager mgr = new PhoneBookManager(); 
		
		mgr.in_info(); //처음에 정보 가져오기
		
		while(true) 
		{
			mgr.printMenu();
			
			try//문자입력 예외발생
			{
				int choice = scanner.nextInt();	
				
				try//1~5사이가 아닌 숫자를 넣었을 때 예외발생
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
				case Menultem.AUTO_SAVE:
					mgr.AutoSave();
					break;
				case Menultem.EXIT_PROGRAM:
					mgr.out_info(); //정보 저장하기
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
