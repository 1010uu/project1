package project1.ver09;

public class DeleteSQL extends IConnectImpl
{
	public DeleteSQL() {
		super("kosmo", "1234");
	}
	
	//실행부
	@Override
	public void execute()
	{
		try
		{
			//쿼리문
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			//prepared객체 생성
			psmt = con.prepareStatement(query);
			//인파라미터
			psmt.setString(1, scanValue("삭제할 이름"));
			//쿼리 실행
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
