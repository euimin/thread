package jdbc25.statement;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class UpdateSQLMore extends IConnectImpl {

	public UpdateSQLMore(String url,String user,String password){
		super(url,user,password);
	}	
	@Override
	public void execute() {
		try{
			//1]쿼리 전송용 Statement객체 생성
			stmt = conn.createStatement();
			while(true){
				try{			
					//2]쿼리문 작성
					String sql="UPDATE member SET name='"+getValue("이름")+"',pwd='"+getValue("비번")+"' WHERE id='"+getValue("아이디")+"'";
					//3]쿼리 실행
					System.out.println(stmt.executeUpdate(sql)+"행이 수정됨!!");
				}
				catch(SQLException e){
					System.out.println("쿼리 실패");
				}
			}/////////////while
		}
		catch(SQLException e){
			System.out.println("Statement객체 생성 실패");
		}
		
	}
	public static void main(String[] args) {
		new UpdateSQLMore(ORACLE_URL,"JAVA","JAVA9999").execute();
	}

}
