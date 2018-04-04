package jdbc25.callable;

import java.sql.SQLException;
import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 * CREATE OR REPLACE PROCEDURE PROC_MEMBER_DELETE
(
	PID IN MEMBER.ID%TYPE,
	AFFECTED OUT NUMBER
		
)
IS

BEGIN
	DELETE MEMBER WHERE ID=PID;
	
	IF SQL%FOUND THEN
		AFFECTED := SQL%ROWCOUNT;
		COMMIT;
	ELSE --아이디값이 없을때
		AFFECTED :=-1;
	END IF;	



	EXCEPTION
	WHEN OTHERS THEN   --자식이 참조하고 있을때
	BEGIN
		AFFECTED :=-2;
		ROLLBACK;
	END;	

END;
/
 * 
 */
public class DeleteProcCall extends IConnectImpl {
	public DeleteProcCall(){
		super(ORACLE_URL,"USER1","USER1");
	}
	@Override
	public void execute() {
		try{
			//1]프로시저를 실행하기 위한 CallableStatement객체 얻기
			csmt = conn.prepareCall("{call PROC_MEMBER_DELETE(?,?)}");
			//2]인/아웃파라미터 설정
			csmt.setString(1,getValue("삭제할 아이디"));
			csmt.registerOutParameter(2, Types.NUMERIC);
			//3]프로시저 실행
			csmt.execute();
			//4]out파라미터에 저장된 값 읽어 오기
			int rtvalue = csmt.getInt(2);
			if(rtvalue== -1)
				System.out.println("해당 아이디가 없어요");
			else if(rtvalue == -2)
				System.out.println("자식이 참조하고 있어요");
			else
				System.out.println(rtvalue+"행이 삭제됨.");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DeleteProcCall().execute();
	}

}
