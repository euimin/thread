package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class UpdateSQLMore extends IConnectImpl{

	public UpdateSQLMore(String url, String user, String password) {
		super(url,user,password);
	}
	@Override
	public void execute() {
		try{
			//1]미리 쿼리문 준비
			String sql="UPDATE member SET name=?,pwd=? WHERE id=?";
			//2]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			while(true){
				//3]인파라미터 설정
				psmt.setString(1, getValue("이름"));
				psmt.setString(2, getValue("비번"));
				psmt.setString(3, getValue("아이디"));
				//4]쿼리 실행
				System.out.println(psmt.executeUpdate()+"행이 수정됨");
			}
		}
		catch(SQLException e){e.printStackTrace();}
	
	}
	public static void main(String[] args) {
		new UpdateSQLMore(ORACLE_URL,"JAVA","JAVA9999").execute();
	}

}
