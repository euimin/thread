package jdbc25.prepared;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import jdbc25.service.IConnectImpl;

public class ResultSetMetaDataSQL extends IConnectImpl {

	public ResultSetMetaDataSQL(String url, String user, String pass) {
		super(url,user,pass);
	}//////////////////////////
	
	@Override
	public void execute() {
		try{
			//1]쿼리문 준비
			String sql= getQueryString();
			//2]PreparedStatement객체 생성
			psmt = conn.prepareStatement(sql);
			//3]쿼리 실행
			rs = psmt.executeQuery();
			/* SELECT쿼리 실행시 컬럼에 대한 정보 얻기*/
			//가]ResultSet객체의 getMetaData()로 ResultSetMetaData얻기
			ResultSetMetaData rsmd= rs.getMetaData();
			
			//나]총 컬럼수 얻기-ResultSetMetaData의 int getColumnCount()
			int columnCount=rsmd.getColumnCount();
			System.out.println("총 컬럼 수:"+columnCount);
			//다]컬럼명 얻기-ResultSetMetaData의 String getColumnName(int column)
			System.out.println("[컬럼명 얻기]");
			for(int i=1; i <=columnCount;i++){
				int length = rsmd.getColumnName(i).length()+2;
				System.out.print(
						String.format("%-"+length+"s",
						rsmd.getColumnName(i)));
				
			}
			//라]컬럼타입 얻기-int getColumnType(int column)
			//   타입과 관련된 상수는 java.sql.Types클래스에 정의됨.
			System.out.println("\r\n[자바의 컬럼타입으로 얻기]");
			for(int i=1; i <=columnCount;i++){
				int columnType = rsmd.getColumnType(i);
				switch(columnType){
					case Types.VARCHAR:
						System.out.println("오라클의 VARCHAR2");
						break;
					case Types.NVARCHAR:
						System.out.println("오라클의 NVARCHAR");
						break;
					case Types.CHAR:
						System.out.println("오라클의 CHAR");
						break;
					case Types.NCHAR:
						System.out.println("오라클의 NCHAR");
						break;
					case Types.NUMERIC:
						System.out.println("오라클의 NUMBER");
						break;
					case Types.TIMESTAMP:
						System.out.println("오라클의 DATE");
						break;
					default:System.out.println("오라클의 기타 자료형");
				}
			}
			//마]String getColumnTypeName(int column)
			//오라클의 타입명으로 반환
			System.out.println("[오라클의 타입명으로 얻기]");
			for(int i=1; i <=columnCount;i++){
				System.out.println(rsmd.getColumnTypeName(i));
			}
			//바]컬럼의 NULL허용여부 :int isNullable(int column) 
			//   NULL허용 :1,NOT NULL:0
			System.out.println("[컬럼의 NULL허용 여부 얻기]");
			for(int i=1; i <=columnCount;i++){
				System.out.println(rsmd.isNullable(i) ==1 ?"NULLABLE" :"NOT NULL");
			}
			
			//사]컬럼의 크기 얻기 -get
			System.out.println("[컬럼의 크기 얻기-()안에 지정한 값]");
			for(int i=1; i <=columnCount;i++){
				System.out.println(rsmd.getPrecision(i));
			}
			//컬럼명 출력]
			for(int i=1; i <=columnCount;i++){			
				System.out.print(
						String.format("%-12s",
						rsmd.getColumnName(i)));
			}
			System.out.println();
			for(int i=1; i <=columnCount;i++){			
				for(int k=1;k <=12;k++)	System.out.print("-");
			}
			System.out.println();
			//레코드 출력]
			while(rs.next()){
				for(int i=1;i <=columnCount;i++){
					int types=rsmd.getColumnType(i);
					if(types == Types.TIMESTAMP)
						System.out.print(
								String.format("%-12s",rs.getDate(i)));
					else	System.out.print(
								String.format("%-12s",rs.getString(i)));
				}//FOR
				System.out.println();
			}
			
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally { close();}
	}//////////////////////////

	public static void main(String[] args) {
		new ResultSetMetaDataSQL(ORACLE_URL,"scott","scott1234").execute();
	}////////////////////////

}/////////////////////////////////
