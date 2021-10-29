package project1.ver08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.text.ChangedCharSetException;

import project1.ver08.PhoneInfo;

public class PhoneBookManager implements SubMenultem
{
	private HashSet<PhoneInfo> phoneBookSet = new HashSet<PhoneInfo>();
	
	//메뉴출력
	public void printMenu()
	{
		System.out.println("==================메뉴를 선택하세요.==================");
		System.out.println("1.주소록 입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("======================================================");
		System.out.print("메뉴선택:");
	}
	
	//입력
	public void dataInput()
	{
		Scanner scanner = new Scanner(System.in);
		String name, phoneNumber, birth, major, company;
		int grade;
		
		System.out.println("===주소록을 입력함===");
		System.out.println("데이터 입력을 시작합니다");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.println("선택>>");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		if(num==GENERAL)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("생년월일:"); birth = scanner.nextLine();
			
			PhoneInfo info = new PhoneInfo(name, phoneNumber, birth);
			change(name);
			phoneBookSet.add(info);
		}
		if(num==SCHOOLMATE)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("전공:"); major = scanner.nextLine();
			System.out.println("학년:"); grade = scanner.nextInt();
			
			PhoneSchoolInfo info = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			change(name);
			phoneBookSet.add(info);	
		}
		if(num==COLLEAGUE)
		{
			System.out.print("이름:"); name = scanner.nextLine();
			System.out.print("전화번호:"); phoneNumber = scanner.nextLine();
			System.out.print("회사:"); company = scanner.nextLine();
			
			PhoneCompanyInfo info = new PhoneCompanyInfo(name, phoneNumber, company);
			change(name);
			phoneBookSet.add(info);
		}
		System.out.println("===입력이 완료됐습니다===");
	}
	
	void change(String name)
	{
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();
		Scanner scanner = new Scanner(System.in);

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(name.equals(info.name)) 
			{
				while(true) 
				{
					System.out.println("이미 저장된 데이터입니다.");
					System.out.println("덮어쓸까요? Y(y) / N(n)");
					
					String yes = scanner.nextLine();
					
					if(yes.equalsIgnoreCase("Y"))
					{
						itr.remove();
					}
					else
					{
						info.showPhoneInfo();
					}
					return;
				}	
			}
		}
	}
	
	//검색
	public void dataSearch()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(searchName.equals(info.name))
			{
				info.showPhoneInfo();
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

		Iterator<PhoneInfo> itr = phoneBookSet.iterator();

		while(itr.hasNext())
		{
			PhoneInfo info = itr.next();
			if(deleteName.equals(info.name))
			{
				phoneBookSet.remove(info);
				System.out.println("데이터 삭제가 완료되었습니다.");
			}
		}	
	}
	
	AutoSaverT saver ; //^^쓰레드클래스^^
	//자동저장
	public void AutoSave()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("===저장옵션선택===");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장On, 2.자동저장Off");
		System.out.println("선택:");
		
		int selectNumber = scanner.nextInt();
		if(selectNumber==1)
		{
			if(Thread.activeCount()==1)
			{	//쓰레드 객체 재 생성 해야함.
				System.out.println("자동저장을 시작합니다.");
				saver = new AutoSaverT(); 
				saver.setDaemon(true);
				saver.start();				
			}
			else
			{
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		}
		else if(selectNumber==2) //중단
		{
			saver.interrupt();
			System.out.println("자동저장을 종료합니다.");
		}
	}
	
	//output
	public void out_info()
	{
		FileOutputStream f_stream = null;
		try
		{
			f_stream = new FileOutputStream("src/project1/ver08/AutoSaveBook.obj");
			ObjectOutputStream d_stream = new ObjectOutputStream(f_stream);

			for(PhoneInfo info : phoneBookSet)
			{
				d_stream.writeObject(info);
			}
			
			f_stream.close();
			d_stream.close();
			System.out.println("obj파일로 저장됐습니다.");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}
	//input
	public void in_info()
	{
		FileInputStream f_stream = null;
		PhoneInfo info = null;
		try
		{
			f_stream = new FileInputStream("src/project1/ver08/AutoSaveBook.obj");
			ObjectInputStream d_stream = new ObjectInputStream(f_stream);

			info = (PhoneInfo)d_stream.readObject();
			
			info.showPhoneInfo();
			
			f_stream.close();
			d_stream.close();
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}
	//주소록전체출력
	public void dataAllShow()
	{
		for(PhoneInfo info : phoneBookSet)
		{
			info.showPhoneInfo();
		}
	}
}