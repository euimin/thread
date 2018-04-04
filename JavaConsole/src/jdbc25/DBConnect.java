package jdbc25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*1]오라클용 JDBC드라이버 메모리에 로딩
		Class.forName("패키지를 포함한 클래스명"):클래스명으로
		해당 클래스를 찾아서 메모리에 로딩하는 메소드(new하지 않고)
		메모리에 로딩된 드라이버가 DriverManager라는 클래스에 등록됨.
		*/
		Class.forName("oracle.jdbc.OracleDriver");
		/*2]DriverManger클래스의 getConnection()메소드로 
		  오라클에 연결시도
	      연결되면 주소반환,실패하면 null반환.
	      오라클 주소 설정: 
	       드라이버종류://오라클이 설치된 주소:포트:전역데이타베이스명(SID)
		예]jdbc:oracle:thin-드라이버 종류
		   localhost - 오라클이 설치된 주소
		   */
		//오라클 주소]
		String url="jdbc:oracle:thin://localhost:1521:orcl";
		//계정 정보]
		String user="scott";
		String password="scott1234";
		
		Connection con= 
				DriverManager.getConnection(url, user, password);
		
		if(con !=null){ 
			System.out.println("데이타베이스 연결 성공:"+con);
			//3]쿼리문(SQL)전송을 위한 Statement계열의 객체 생성
			//  연결된 Connection객체(con)를 통해서 생성
			Statement stmt= con.createStatement();
			//4]쿼리문 작성
			String sql="SELECT * FROM emp ORDER BY hiredate DESC";
			//5]Statement계열 클래스(stmt)의 execute계열 메소드를 
			//  이용해서 쿼리문 실행(오라클에 명령전송)
			ResultSet rs=stmt.executeQuery(sql);
			//6]ResultSet에 담긴 select쿼리 결과를, 커서를 아래로(forward)
			//  이동하면서 꺼내오자.
			while(rs.next()){//next():더 이상 꺼내올 레코드가 없으면 false반환
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job   = rs.getString("JOB");
				int sal      = rs.getInt(6);
				java.sql.Date  hiredate = rs.getDate("HIREDATE");
				System.out.println(
						String.format("%-5d%-8s%-10s%-5d%10s",
								empno,ename,job,sal,hiredate
								));
				
						
			}
			//7]자원반납
			con.close();
		}
		else System.out.println("데이타베이스 연결 실패");
		
		
		
	}////////////

}/////////////////////////
