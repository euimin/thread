package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class UpdateSQL extends IConnectImpl {

	public UpdateSQL(String url,String user,String password){
		super(url,user,password);
	}	
	@Override
	public void execute() {
		try{
			//1]쿼리 전송용 Statement객체 생성
			stmt = conn.createStatement();
			//2]쿼리문 작성
			String sql="UPDATE member SET name='바길동',pwd='9898' WHERE id='PARK'";
			//3]쿼리 실행
			System.out.println(stmt.executeUpdate(sql)+"행이 수정됨!!");
		}
		catch(SQLException e){
			System.out.println("Statement객체 생성 실패");
		}
		finally {
			//4]자원반납
			close();
		}
		
	}
	public static void main(String[] args) {
		new UpdateSQL(ORACLE_URL,"JAVA","JAVA9999").execute();
	}

}
