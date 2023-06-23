package com.exam.myapp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
		
	@Override
	public List<MemberVo> selectMemberList() {
		// TODO Auto-generated method stub
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.insertMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		// TODO Auto-generated method stub
		return memberDao.selectMember(memId);
	}

	@Override
	public int updateMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVo selectLogin(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.selectLogin(vo);
	}

}
