package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class InsertSQLMore extends IConnectImpl {

	public InsertSQLMore(String url, String user, String password) {
		super(url,user,password);
	}///////////////	
	@Override
	public void execute() {
		try{
			//1]쿼리문 미리 준비	
			String sql="INSERT INTO MEMBER VALUES(?,?,?,SYSDATE)";
			//2]쿼리실행을 위한 Statement계열 객체 생성
			psmt=conn.prepareStatement(sql);
			while(true){
				//3]쿼리 실행			
				//3-1]인파라미터 설정
				psmt.setString(1, getValue("아이디"));
				psmt.setString(2, getValue("비번"));
				psmt.setString(3, getValue("이름"));
				//3-2]쿼리 실행
				System.out.println(psmt.executeUpdate()+"행이 입력됨");
			}
		}
		catch(SQLException e){
			System.out.println("에러 메시지:"+e.getMessage());
		}
		
	}//////////////////////////
	public static void main(String[] args) {		
		new InsertSQLMore(ORACLE_URL,"JAVA","JAVA9999").execute();
	}/////////////////main

}
