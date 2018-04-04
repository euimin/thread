package jdbc25.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSQLMore {
	//[멤버변수]
	private Connection con;
	private Statement stmt;
	//[생성자]
	public InsertSQLMore(){
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
	//[쿼리 실행 메소드]
	private void execute(){
		try{
			//3]쿼리 실행하기 위한  Statement객체 생성
			//  연결된 Connection객체로....
			stmt=con.createStatement();
			
			while(true){
				try{
					//4]쿼리문 작성
					String id = getValue("아이디").toString();
					String pwd= getValue("비밀번호").toString();
					String name=getValue("이름").toString();
					
					String sql="INSERT INTO member(id,pwd,name) VALUES('"+id+"','"+pwd+"','"+name+"')";
					//5]Statement계열 객체로 쿼리 실행
					/*
					 * 쿼리문이 DELETE/UPDATE/INSERT일때는 int executeUpdate()
					 * 쿼리문이 SELECT일때는 ResultSet executeQuery()호출
					 * 
					 */
				
					// executeUpdate()는 영향받은 행의 수 반환]
					int affected = stmt.executeUpdate(sql);
					System.out.println(affected+"행이 입력됨");
				}
				catch(SQLException e){
					System.out.println("쿼리 실행 실패:"+e.getMessage());
				}
				//EXIT입력시 null을 반환함으로...
				catch(NullPointerException e){
					System.out.println("수고 했어요!!!");
					break;
				}
			}/////////////while
			
		}
		catch (SQLException e) {
			System.out.println("Statement객체 생성 실패");
		}
		finally {
			//6]자원반납
			close();
		}
		
	}/////////////////////////////	
	//[자원 반납용 메소드]
	private void close(){
		try{
			//자원 반납
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
		}
		catch(SQLException e){}
	}/////////////////////////////	
	static Scanner scanner = new Scanner(System.in);
	//[사용자 입력용 메소드]
	public static Object getValue(String title){
		System.out.println(title+"을(를) 입력하세요?");
		String value=scanner.nextLine();
		if("EXIT".equalsIgnoreCase(value)){
			return null;
		}
		return value;
	}/////////////////////
	public static void main(String[] args) {
		new InsertSQLMore().execute();
	}//////////////main

}/////////////////
