package swing27.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import jdbc25.service.IConnect;
import swing27.service.IMemberService;

/*
DAO(Data Access Object)계열 클래스:
데이타에 접근하여 CRUD작업을 처리하는 업무처리 로직(비지니스 로직)
*/
public class MemberDAO implements IMemberService {
	//[멤버 변수]
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	//[생성자]
	public MemberDAO(String url, String user, String password) {
		//데이타베이스 연결]
		try {
			Class.forName(IConnect.ORACLE_DRIVER);
			conn = DriverManager.getConnection(url,user,password);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이타베이스 연결 오류:"+e.getMessage());
		}
	}

	@Override
	public Vector<Vector> selectList(MemberDTO dto) throws Exception {
		
		String sql="SELECT * FROM MEMBER ";
		if(dto !=null){//검색
			sql+=" WHERE INSTR(ID,?) !=0 OR INSTR(NAME,?) !=0  ";
		}
		sql+=" ORDER BY REGIDATE DESC";
		
		
		psmt = conn.prepareStatement(sql);
		if(dto !=null){//검색
			psmt.setString(1,dto.getId());
			psmt.setString(2, dto.getName());
		}		
		rs = psmt.executeQuery();
		Vector<Vector> records = new Vector<Vector>();
		while(rs.next()){
			//※아래 record에 값 저장시 JTable의 컬럼 순서와 
			//동일해야한다.
			Vector record = new Vector();
			record.add(rs.getString(1));
			record.add(rs.getString(2));
			record.add(rs.getString(3));
			record.add(rs.getString(4));
			record.add(rs.getString(5));			
			records.add(record);			
		}
		return records;
	}

	@Override
	public MemberDTO selectOne(MemberDTO dto) throws Exception {
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		rs=psmt.executeQuery();
		MemberDTO member=null;
		if(rs.next()){
			member= new MemberDTO(
					dto.getId(),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5)
					);
		}		
		return member;
	}

	@Override
	public int insert(MemberDTO dto) throws Exception {
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?,SYSDATE)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getId());
		psmt.setString(2, dto.getPwd());
		psmt.setString(3, dto.getName());
		psmt.setString(4, dto.getAge());
		return psmt.executeUpdate();
	}

	@Override
	public int delete(MemberDTO dto) throws Exception {
		psmt = conn.prepareStatement("DELETE MEMBER WHERE ID=?");
		psmt.setString(1, dto.getId());
		return psmt.executeUpdate();
	}

	@Override
	public int update(MemberDTO dto) throws Exception {
		String sql="UPDATE MEMBER SET NAME=?,PWD=?,AGE=? WHERE ID=?";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dto.getName());
		psmt.setString(2, dto.getPwd());
		psmt.setString(3, dto.getAge());
		psmt.setString(4, dto.getId());
		return psmt.executeUpdate();
	}

	@Override
	public void close() {
		try {
			if(rs !=null) rs.close();
			if(psmt !=null) psmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {}	
	}

}
