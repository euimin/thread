package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class SelectSQL extends IConnectImpl {

	public SelectSQL(String url, String user, String password) {
		//데이타 베이스 연결]
		super(url,user,password);
	}
	@Override
	public void execute() {
		try{
			//1]미리 쿼리문 준비
			//1-1]인파라미터가 없는 쿼리문
			//String sql="SELECT ename,trim(to_char(sal,'L999,999')) sal,job,to_char(hiredate,'YYYY.MM.DD') FROM emp ORDER BY hiredate DESC ";
			//1-2]파라미터가 있는 쿼리문-특정 문자로 시작하는 레코드 검색
			//String sql="SELECT ename,trim(to_char(sal,'L999,999')) sal,job,to_char(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE ? || '%' ";
			//1-3]파라미터가 있는 쿼리문-특정 문자로 끝나는 레코드 검색
			//String sql="SELECT ename,trim(to_char(sal,'L999,999')) sal,job,to_char(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE '%' || ? ";
			//1-4]파라미터가 있는 쿼리문-특정 문자가 포함된 레코드 검색
			String sql="SELECT ename,trim(to_char(sal,'L999,999')) sal,job,to_char(hiredate,'YYYY.MM.DD') FROM emp WHERE ename LIKE '%' || ? || '%' ";
			
			//2]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			//3]인파라미터 설정-인파라미터 있는 경우
			psmt.setString(1, getValue("찾는 문자열"));
			//4]쿼리실행
			rs=psmt.executeQuery();
			
			while(rs.next()){
				String ename = rs.getString(1);
				String sal   = rs.getString(2);
				String job   = rs.getString(3);
				String hiredate = rs.getString(4);
				System.out.println(
						String.format("%-10s%-10s%-12s%s",
								ename,
								sal,
								job,
								hiredate));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new SelectSQL(ORACLE_URL,"scott","scott1234").execute();
	}

}
