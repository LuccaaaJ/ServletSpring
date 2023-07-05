package com.exam.myapp.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BbsServiceImpl implements BbsService{
	
	@Autowired
	private BbsDao bbsDao;
		
	@Override
	public List<BbsVo> selectBbsList() {
		// TODO Auto-generated method stub
		return bbsDao.selectBbsList();
	}

	@Override
	public int insertBbs(BbsVo vo) {
		// TODO Auto-generated method stub
		return bbsDao.insertBbs(vo);
	}

	@Override
	public int deleteBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return bbsDao.deleteBbs(bbsNo);
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return bbsDao.selectBbs(bbsNo);
	}

	@Override
	public int updateBbs(BbsVo vo) {
		// TODO Auto-generated method stub
		return bbsDao.updateBbs(vo);
	}

	

}
