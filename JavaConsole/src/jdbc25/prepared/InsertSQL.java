package jdbc25.prepared;

import java.sql.SQLException;

import jdbc25.service.IConnectImpl;

public class InsertSQL extends IConnectImpl{

	public InsertSQL(String url, String user, String password) {
		connect(url, user, password);
	}
	@Override
	public void execute() {
		//1]쿼리문 미리 준비
		//1-1]인파라미터(?)가 없는 쿼리문
		//String sql="INSERT INTO MEMBER VALUES('KIM','1234','김길동',SYSDATE)";
		//2-2]인파라미터(?)가 있는 쿼리문
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?)";
		try{
			//2]쿼리실행을 위한 Statement계열 객체 생성
			/*
			    PreparedStatement객체는 객체 생성시 미리 쿼리문을 준비해서
			    Connection객체의 prepareStatement(쿼리문)메소드의 인자로 
			    전달해야 한다. 
			     
		     	- PreparedStatement객체 생성시 전달된 쿼리문을 먼저
		       	  parsing하기때문에 실행시에는 바로 실행한다.
		          그럼으로 실행시에는 쿼리문을 전달할 필요가 없다.
			*/
			psmt=conn.prepareStatement(sql);
			
			try{
				//3]쿼리 실행-실행시 쿼리문 전달 불필요
				//3-1]인파라미터가 없는 쿼리문
				//    -인파라미터 설정 불필요.바로 실행하면 됨.
				//System.out.println(psmt.executeUpdate()+"행이 입력됨");
				//3-2]인파라미터가 있는 쿼리문-실행전 반드시 값을 설정
				//?(인파라미터 설정)
				/*
				쿼리 실행전에 값에 해당하는 부분을 ?처리한 경우
				값을 설정해줘야 함.
				
				?(인파라미터)는 쿼리문의 값에 해당하는 부분에만
				넣어줘야 한다.
				
				-인 파라미터를 설정할때는 PreparedStatement객체의
				setXXXX(파라미터인덱스,설정할 값)메소드로 설정한다
				예]			
				Oracle의 자료형이 NUMBER 라면 setInt(),
				                  char/varchar2 ->setString()
				
				
				자료형에 상관없이 setString()설정가능
				즉 ResultSet객체로 값을 읽어오는 getXXXX()메소드와 사용법이
				동일하다.			
				 */
				//4-2-1]인파라미터 설정
				psmt.setString(1, "ORACLE");
				psmt.setString(2, "1234");
				psmt.setString(3, "오라클");
				//날짜를 java.sql.Date타입으로 설정시]
				//setDate(int,java.sql.Date)
				/*
				java.util.Date utildate = new java.util.Date();
				java.sql.Date date = new java.sql.Date(utildate.getTime());
				psmt.setDate(4,date);*/
				//날짜를 문자열로 설정시]
				psmt.setString(4, "2017-5-31");
				//쿼리 실행
				System.out.println(psmt.executeUpdate()+"행이 입력됨");
			}
			catch(SQLException e){
				System.out.println("쿼리 실행 실패:"+e.getMessage());
			}
		}
		catch(SQLException e){
			System.out.println("PreparedStatement객체 생성 실패");
		}
		finally {
			close();
		}
	}/////////////////////////
	public static void main(String[] args) {
		new InsertSQL(ORACLE_URL,"JAVA","JAVA9999").execute();
	}///////////main

}////////////////////class
