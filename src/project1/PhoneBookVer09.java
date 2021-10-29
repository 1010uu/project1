package project1;

import java.util.Scanner;

import project1.ver03.PhoneInfo;
import project1.ver03.PhoneBookManager;

public class PhoneBookVer09 
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
			case 1:
				mgr.dataInput();
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
