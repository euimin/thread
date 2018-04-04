package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class DeleteSQL extends IConnectImpl{
	
	@Override
	public void execute() {
		try{
			//0]데이타베이스 연결
			connect(ORACLE_URL, "JAVA", "JAVA9999");
			//1]미리 쿼리문 준비
			String sql="DELETE member WHERE id=?";
			//2]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			//3]인파라미터 설정
			psmt.setString(1,getValue("아이디"));
			//4]쿼리 실행
			System.out.println(psmt.executeUpdate()+"행이 삭제됨");
		}
		catch(SQLException e){
			System.out.println("에러:"+e.getMessage());
		}
		finally{
			//5]자원반납
			close();
		}
	}//////////////////
	public static void main(String[] args) {
		new DeleteSQL().execute();
	}///////////////////////////

}
