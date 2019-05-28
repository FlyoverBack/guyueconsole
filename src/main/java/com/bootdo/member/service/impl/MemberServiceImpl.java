package com.bootdo.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.member.dao.MemberDao;
import com.bootdo.member.domain.MemberDO;
import com.bootdo.member.service.MemberService;



@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDO get(String memId){
		return memberDao.get(memId);
	}
	
	@Override
	public List<MemberDO> list(Map<String, Object> map){
		return memberDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberDao.count(map);
	}
	
	@Override
	public int save(MemberDO member){
		return memberDao.save(member);
	}
	
	@Override
	public int update(MemberDO member){
		return memberDao.update(member);
	}
	
	@Override
	public int remove(String memId){
		return memberDao.remove(memId);
	}
	
	@Override
	public int batchRemove(String[] memIds){
		return memberDao.batchRemove(memIds);
	}
	
}
