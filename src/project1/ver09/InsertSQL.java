package project1.ver09;

import java.util.Scanner;

public class InsertSQL extends IConnectImpl
{
	//kosmo계정 접속
	public InsertSQL() 
	{
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	//실행부 기술
	@Override
	public void execute()
	{
		try
		{
			//1.쿼리문 준비
			String query = "INSERT INTO phonebook_tb VALUES (seq_serial_num.nextval ,?, ?, ?)" ;
			
			//2.prepared 객체 생성
			psmt = con.prepareStatement(query);
			
			//3.내용 입력 받기
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름:");
			String name = scanner.nextLine();
			System.out.print("전화번호:");
			String phoneNum = scanner.nextLine();
			System.out.print("생년월일:");
			String birth = scanner.nextLine();
			
			//4.인파라미터 설정 하기
			psmt.setString(1, name);
			psmt.setString(2, phoneNum);
			psmt.setString(3, birth);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch (Exception e) 
		{
			System.out.println("Insert 쿼리문 오류 발생");
			e.printStackTrace();
		}
	}
}
