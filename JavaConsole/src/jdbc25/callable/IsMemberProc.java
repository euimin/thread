package jdbc25.callable;

import java.sql.Types;

import jdbc25.service.IConnectImpl;
/*
 * CREATE OR REPLACE PROCEDURE PROC_ISMEMBER
(PID MEMBER.ID%TYPE,
 PPWD MEMBER.PWD%TYPE,
 RTVAL OUT NUMBER
)
IS
	TMP NUMBER(1);
BEGIN
	SELECT COUNT(*) INTO TMP FROM MEMBER WHERE ID=PID;

	IF TMP = 1 THEN --아이디 일치
		SELECT COUNT(*) INTO TMP FROM MEMBER
		WHERE ID=PID AND PWD=PPWD;
		IF TMP = 1 THEN --회원
			RTVAL :=1;
		ELSE--아이디 일치/비번 불일치
			RTVAL :=0;
		END IF;
	ELSE    --아이디 불일치
		RTVAL := -1;
	END IF;

END;
/
 */
public class IsMemberProc extends IConnectImpl{

	public IsMemberProc(){
		super(ORACLE_URL,"USER1","USER1");
	}
	@Override
	public void execute() {
		try {
			csmt = conn.prepareCall("{call PROC_ISMEMBER(?,?,?)}");
			csmt.setString(1, getValue("아이디"));
			csmt.setString(2, getValue("비번"));
			csmt.registerOutParameter(3,Types.NUMERIC);
			
			csmt.execute();
			int rtval=csmt.getInt(3);
			
			if(rtval == -1)
				System.out.println("아이디가 일치하지 않아요");
			else if(rtval == 0)
				System.out.println("아이디 일치/비번 불일치");
			else
				System.out.println("회원님 즐감하세요");
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new IsMemberProc().execute();
	}

}
