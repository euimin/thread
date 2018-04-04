package jdbc25.callable;

import java.sql.SQLException;
import java.sql.Types;

import jdbc25.service.IConnectImpl;

/*
 * CREATE OR REPLACE PROCEDURE PROC_MEMBER_INSERT
(
	PID MEMBER.ID%TYPE,
	PNAME MEMBER.NAME%TYPE,
	PPWD MEMBER.PWD%TYPE,
	RTSTR OUT NVARCHAR2
)
IS
BEGIN
	INSERT INTO MEMBER(ID,PWD,NAME)
	VALUES(PID,PPWD,PNAME);
	IF SQL%FOUND THEN
		RTSTR:='입력 성공';
		COMMIT;
	END IF;
	EXCEPTION
	WHEN OTHERS THEN
	BEGIN
		RTSTR:='입력 실패-아이디 중복';
		ROLLBACK;
	END;
END;
/
 * 
 * 
 */
public class InsertProcCall extends IConnectImpl {
	public InsertProcCall(){
		super(ORACLE_URL,"USER1","USER1");
	}
	@Override
	public void execute() {
		try {
			//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
		    /*Connection객체의 prepareCall("{call 프로시저명(?,?,...)}")
		    *메소드 호출
		    *-인 파라미터 설정시에는 setXXXX(파라미터인덱스,값)로
		    *-아웃 파라미터 설정시에는 
		    *registerOutParameter(파라미터인덱스,java.sql.Types클래스의 int형상수)
		    */
			csmt = conn.prepareCall("{call PROC_MEMBER_INSERT(?,?,?,?)}");
			/*2]파라미터 설정
		    2-1]인파라미터(?) 설정
		        오라클의 IN 파라미터에 해당하는 ? 설정
		        setXXXX()로*/
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("이름"));
			csmt.setString(3, getValue("비번"));
			//2-2]오라클의 OUT 파라미터에 해당하는 ? 설정
			//    registerOutParameter()로
			csmt.registerOutParameter(4,Types.NVARCHAR);
			//3]프로시저 실행-execute()
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			//  CallableStatement객체의 getXXX()계열 메소드.
			System.out.println("결과 값:"+csmt.getString(4));
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			close();
		}
	}////////////////////////////////	
	public static void main(String[] args) {
		new InsertProcCall().execute();

	}//////////////////////

}//////////////////////////
