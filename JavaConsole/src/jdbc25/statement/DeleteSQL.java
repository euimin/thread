package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
	//[멤버변수]
	private Connection con;
	private Statement stmt;
	//[생성자]
	public DeleteSQL(){
		//1]드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않아요");
		}
	}/////////////////////
	//[데이타베이스 연결용 메소드]
	private void connect(){
		try{
			//2]데이타 베이스 연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://localhost:1521:orcl",
					"JAVA","JAVA9999");
		}
		catch(SQLException e){
			System.out.println("디비 연결 실패");
		}
	}//////////////////////////////////////
	
	private void execute(){
		try {
			//데이타 베이스 연결
			connect();
			//3]Statement객체 생성
			stmt = con.createStatement();
			//4]쿼리작성
			try{
				//5]쿼리 실행
				int affected=stmt.executeUpdate("DELETE member WHERE id='KIM'");
				System.out.println(affected+"행이 삭제됨");
			}
			catch(SQLException e){
				System.out.println("쿼리 실행 실패:"+e.getMessage());
			}
		} 
		catch (SQLException e) {
			System.out.println("Statement객체 생성실패");
		}
		finally{
			//자원반납
			close();
		}
	}
	private void close() {
		try {
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		} catch (SQLException e) {}
		
	}////////////////////////////////
	public static void main(String[] args) {
		new DeleteSQL().execute();
	}/////////////////main

}////////////////////class
