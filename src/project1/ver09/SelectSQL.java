package project1.ver09;

public class SelectSQL extends IConnectImpl
{
	public SelectSQL() 
	{
		super("kosmo", "1234");
	}
	
	//실행부
	public void execute() 
	{
		try
		{
			//statement 객체 생성
			stmt = con.createStatement();
				
			//2.쿼리작성
			String sql = "SELECT idx, name, phone_number, birthday "
					+ " FROM phonebook_tb WHERE 1=1";

			String searchStr = scanValue("검색할 이름");
			if(searchStr!=null) {
				sql = sql + " AND name "
						+ " LIKE '%"+ searchStr +"%' ";
			}
			//System.out.println("쿼리문:"+ sql);
			
			sql = sql + " ORDER BY idx DESC";
			
			//3.쿼리실행
			rs = stmt.executeQuery(sql);		
			
			//4.ResultSet의 갯수만큼 반복하며 출력
			System.out.println("No  이름  전화번호  생년월일");
			while(rs.next()){
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String PhoneNum = rs.getString(3);
				String birth = rs.getString(4);
				
			
				System.out.printf("%2s %s %s %s \n", 
						idx, name, PhoneNum, birth);
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
