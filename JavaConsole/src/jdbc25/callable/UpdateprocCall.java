package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 * CREATE OR REPLACE PROCEDURE PROC_MEMBER_UPDATE
(
	PID MEMBER.ID%TYPE,	
	PPWD MEMBER.PWD%TYPE,
	PNAME MEMBER.NAME%TYPE,
	RT   OUT CHAR
)
IS

BEGIN
	UPDATE MEMBER SET NAME=PNAME,PWD =PPWD
	WHERE ID = PID;
	
	IF SQL%FOUND THEN

		RT:='S';
		COMMIT;
	ELSE
		RT:='F';--없는 아이디
		ROLLBACK;
	END IF;
	
	EXCEPTION
	WHEN OTHERS THEN
	BEGIN
		RT:='F';
		ROLLBACK;
	END;
			

END;
/
 * 
 * 
 */
public class UpdateprocCall extends IConnectImpl {

	public UpdateprocCall(){
		super(ORACLE_URL,"USER1","USER1");
	}
	@Override
	public void execute() {
		try {
			//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
			csmt = conn.prepareCall("{call PROC_MEMBER_UPDATE(?,?,?,?)}");
			//2]인/아웃파라미터 설정
			csmt.setString(1,getValue("수정할 아이디"));
			csmt.setString(2,getValue("비번"));
			csmt.setString(3,getValue("이름"));
			csmt.registerOutParameter(4, Types.CHAR);
			//3]프로시저 실행
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			String rtvalue=csmt.getString(4).trim();
			
			if(rtvalue.toUpperCase().equals("S"))
				System.out.println("수정 성공");
			else
				System.out.println("수정 실패");
		} 		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new UpdateprocCall().execute();
	}

}
