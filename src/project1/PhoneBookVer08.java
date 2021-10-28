package project1;

import java.io.Serializable;
import java.util.Scanner;

import project1.ver08.PhoneInfo;
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
			case Menultem.AUTO_SAVE:
				mgr.AutoSave();
				break;
			case Menultem.EXIT_PROGRAM:
				mgr.out_info();
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
