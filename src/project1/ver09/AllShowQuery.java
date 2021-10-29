package project1.ver09;

import java.sql.SQLException;

public class AllShowQuery extends ConnectDB
{
	public AllShowQuery() 
	{
		super();
	}
	
	//실행부
	@Override
	void execute() 
	{
		try 
		{
			stmt = con.createStatement();
			
			String query 
				= "SELECT idx, name, phone_number, birthday "
						+ " FROM test_tb";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);//id컬럼
				String phoneNum = rs.getString(3);
				String birth = rs.getString(4);

				System.out.println("No  이름  전화번호  생년월일");
				System.out.printf("%2s %s %s %s\n",
						idx, name, phoneNum, birth);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); 
		}
		
	}
	public static void main(String[] args) {
		AllShowQuery selectSQL = new AllShowQuery();
		selectSQL.execute();
	}
	
}













