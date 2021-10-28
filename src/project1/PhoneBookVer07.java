package project1;

import java.util.Scanner;

import project1.ver07.PhoneInfo;
import project1.ver07.Menultem;
import project1.ver07.PhoneBookManager;

public class PhoneBookVer07
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager mgr = new PhoneBookManager(); 
		
		while(true) 
		{
			mgr.printMenu();

			int choice = scanner.nextInt();	
			
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
	}
}
