package swing27.service;

import java.util.Vector;

import swing27.model.MemberDTO;

public interface IMemberService {

	//여러개 레코드 반환]
	Vector<Vector> selectList(MemberDTO dto) throws Exception;
	//한 개의 레코드 반환]
	MemberDTO selectOne(MemberDTO dto) throws Exception;
	//CRUD작업용]Create(Insert)Read(Select)Update(Update)Delete(Delete)
	int insert(MemberDTO dto) throws Exception;
	int delete(MemberDTO dto) throws Exception;
	int update(MemberDTO dto) throws Exception;
	//자원 반납용]
	void close();
}
