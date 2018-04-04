package jdbc25.prepared;

import java.sql.ResultSetMetaData;
import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 * Statement계열의 execute()메소드]
 * 
 * Statement나 PreparedStatement객체로 일반 쿼리문 실행시
 * SELECT이면 executeQuery()
 * UPDATE/DELETE/INSERT이면 executeUpate()로 실행
 * 
 * 단,execute()메소드로 실행해도 쿼리가 실행됨
 * execute()메소드는
 * 쿼리문이 SELECT이면 true반환
 * 쿼리문이 UPDATE/DELETE/INSERT이면 false반환

 * CallableStatement는 프로시저나 함수실행시 사용하는
 * Statement계열로
 * 실행시에는 반드시 execute()메소드로.....

 */
public class ExcecuteSQL extends IConnectImpl {
	@Override
	public void execute() {
		//1]데이타 베이스 연결
		connect(ORACLE_URL, "JAVA", "JAVA9999");
		while(true){
			try{
				//2]쿼리문 준비
				String sql = getQueryString();
				if(sql.trim().equalsIgnoreCase("EXIT")){
					System.out.println(
							"Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - Product"+
							"\r\nWith the Partitioning, OLAP, Data Mining and Real Application Testi");
					//자원반납]
					close();
					break;
				}
				//3]Statement계열 객체 생성-쿼리 실행용
				psmt = conn.prepareStatement(sql);
				//4]쿼리 실행-execute():쿼리문이 미정 임으로
				/*
				execute()메소드로 쿼리 실행후 쿼리문이 SELECT인 경우
				ResultSet에 담긴 결과를 가져오려면 Statement계열 객체의
				getResultSet()메소드 호출
				
				쿼리문이 INSERT/DELETE/UPDATE일때
				영향받은 행의 수를 반환 받을때는 
				getUpdateCount()메소드 호출
				*/
				boolean bFlag=psmt.execute();
				if(bFlag){//쿼리문이 SELECT
					//ResultSet객체 얻기]
					rs=psmt.getResultSet();
					//컬럼정보 얻기위한 ResultSetMetaData얻기]
					ResultSetMetaData rsmd= rs.getMetaData();
					//컬럼수 얻기]
					int columnCount = rsmd.getColumnCount();
					
					//최대 컬럼 자리수 얻기]
					int max=0;
					for(int i=1; i <=columnCount;i++){
						if(max <=rsmd.getPrecision(i))
							max =rsmd.getPrecision(i);
					}
					//컬럼명 출력]
					for(int i=1; i <=columnCount;i++){			
						System.out.print(
								String.format("%-"+(max+2)+"s",
								rsmd.getColumnName(i)));
						
					}
					System.out.println();
					for(int i=1; i <=columnCount;i++){			
						for(int k=1;k <=max+2;k++)	System.out.print("-");
					}
					System.out.println();
					//레코드 출력]
					while(rs.next()){
						for(int i=1;i <=columnCount;i++){
							int types=rsmd.getColumnType(i);
							if(types == Types.TIMESTAMP)
								System.out.print(
										String.format("%-"+(max+2)+"s",rs.getDate(i)));
							else	System.out.print(
										String.format("%-"+(max+2)+"s",rs.getString(i)));
						}//FOR
						System.out.println();
					}
				}
				else{//쿼리문이 INSERT/DETELE/UPDATE
					//영향받은 행의 수 얻기]
					int updateCount = psmt.getUpdateCount();
					if(sql.trim().toUpperCase().startsWith("INSERT"))
						System.out.println(updateCount+"행이 입력됨");
					else if(sql.trim().toUpperCase().startsWith("DELET"))
						System.out.println(updateCount+"행이 삭제됨");
					else if(sql.trim().toUpperCase().startsWith("UPDATE"))
						System.out.println(updateCount+"행이 수정됨");
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}//while	
	}//////////////////////////////////////////
	public static void main(String[] args) {
		new ExcecuteSQL().execute();
	}/////////////////MAIN

}////////////////CLASS
