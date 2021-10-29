package project1.ver09;

public interface IConnect {
	
	//멤버 상수
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:xe";
 
	//추상 메서드 정의
	void connect(String user, String pass); //db연결용
	void execute(); //쿼리 실행
	void close(); //자원반납
	
	String scanValue(String title); //추상 메서드 선언

}
