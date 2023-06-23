package com.exam.myapp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	//@Repository
	public class MemberDaoBatis implements MemberDao{
		
	
	//private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private SqlSession session;
	@Override
	public List<MemberVo> selectMemberList() {
		return session.selectList("com.exam.myapp.member.MemberDao.selectMemberList");
	
	}

	@Override
	public int insertMember(MemberVo vo) {
		return session.insert("com.exam.myapp.member.MemberDao.insertMember",vo);
	}
	
	//삭제버튼을 클릭하면, 삭제가 되도록 MemberDaoBatis 클래스와 MemberMapper.xml파일을 변경하세요.
	@Override
	public int deleteMember(String memId) {
		
		return session.delete("com.exam.myapp.member.MemberDao.deleteMember",memId);	
		
	}

	@Override
	public MemberVo selectMember(String memId) {
		
		return session.selectOne("com.exam.myapp.member.MemberDao.selectMember",memId);
		
	}

	@Override
	public int updateMember(MemberVo vo) {
		//데이터베이스에 회원정보가 변경되도록 구현
		
		return session.update("com.exam.myapp.member.MemberDao.updateMember",vo);
		
	}

	@Override
	public MemberVo selectLogin(MemberVo mvo) {
		//vo 에 들어있는 아이디, 비밀번호가 일치하는 회원정보를 데이터베이스에서 select하여 반환하도록 구현
		
		return session.selectOne("com.exam.myapp.member.MemberDao.selectLogin",mvo);
		
	}
	
	
	
}
