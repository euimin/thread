package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL {
	//[멤버변수]
	private Connection con;
	private Statement stmt;
	//[생성자]
	public InsertSQL(){
		try{
			//1]JDBC용 오라클 드라이버를 메모리에 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2]오라클에 연결시도:DriverManager의 getConnection()메소드로
			con=DriverManager.getConnection(
					"jdbc:oracle:thin://127.0.0.1:1521:orcl", 
					"JAVA", 
					"JAVA9999");
		}
		catch(ClassNotFoundException e){
			System.out.println("OracleDriver클래스가 없어요");
		}
		catch(SQLException e){
			System.out.println("데이타베이스 연결 실패");
		}
		
	}////////////////
	private void execute(){
		try{
			//3]쿼리 실행하기 위한  Statement객체 생성
			//  연결된 Connection객체로....
			stmt=con.createStatement();
			//4]쿼리문 작성
			String sql="INSERT INTO member(id,pwd,name) VALUES('KIM','1234','김길동')";
			//5]Statement계열 객체로 쿼리 실행
			/*
			 * 쿼리문이 DELETE/UPDATE/INSERT일때는 int executeUpdate()
			 * 쿼리문이 SELECT일때는 ResultSet executeQuery()호출
			 * 
			 */
			try{
				// executeUpdate()는 영향받은 행의 수 반환]
				int affected = stmt.executeUpdate(sql);
				System.out.println(affected+"행이 입력됨");
			}
			catch(SQLException e){
				System.out.println("쿼리 실행 실패:"+e.getMessage());
			}
		}
		catch (SQLException e) {
			System.out.println("Statement객체 생성 실패");
		}
		finally {
			//6]자원반납
			close();
		}
		
	}/////////////////////////////	
	private void close(){
		try{
			//자원 반납
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		}
		catch(SQLException e){}
	}/////////////////////////////	
	public static void main(String[] args) {
		new InsertSQL().execute();
	}//////////////main

}/////////////////
