package swing27.service;

import java.util.Vector;

import swing27.model.MemberDAO;
import swing27.model.MemberDTO;

public class IMemberServiceImpl implements IMemberService{

	//[멤버변수]
	MemberDAO dao;
	
	//[인자 생성자]
	public IMemberServiceImpl(String url,String user,String password){
		dao = new MemberDAO(url,user,password);
	}///////////////////////
	//전체 레코드  쿼리]
	@Override
	public Vector<Vector> selectList(MemberDTO dto) throws Exception {
		
		return dao.selectList(dto);
	}///////////////////////

	@Override
	public MemberDTO selectOne(MemberDTO dto) throws Exception {		
		return dao.selectOne(dto);
	}///////////////////////

	@Override
	public int insert(MemberDTO dto) throws Exception {
		
		return dao.insert(dto);
	}////////////////////////

	@Override
	public int delete(MemberDTO dto) throws Exception {		
		return dao.delete(dto);
	}///////////////////////////

	@Override
	public int update(MemberDTO dto) throws Exception {		
		return dao.update(dto);
	}////////////////////////////

	@Override
	public void close() {
		dao.close();	
	}//////////////////////////////////

}
