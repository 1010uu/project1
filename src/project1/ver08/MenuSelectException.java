package project1.ver08;

//내가 정의한 예외 클래스?
public class MenuSelectException extends Exception
{
	public MenuSelectException()
	{
		super("[예외발생]숫자를 잘못 입력했습니다.");
		System.out.println("1부터 5사이의 숫자를 입력하세요.");
	}
}
