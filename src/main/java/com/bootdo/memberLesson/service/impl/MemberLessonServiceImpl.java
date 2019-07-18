package com.bootdo.memberLesson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.memberLesson.dao.MemberLessonDao;
import com.bootdo.memberLesson.domain.MemberLessonDO;
import com.bootdo.memberLesson.service.MemberLessonService;



@Service
public class MemberLessonServiceImpl implements MemberLessonService {
	@Autowired
	private MemberLessonDao memberLessonDao;
	
	@Override
	public MemberLessonDO get(String memId){
		return memberLessonDao.get(memId);
	}
	
	@Override
	public List<MemberLessonDO> list(Map<String, Object> map){
		return memberLessonDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberLessonDao.count(map);
	}
	
	@Override
	public int save(MemberLessonDO memberLesson){
		return memberLessonDao.save(memberLesson);
	}
	
	@Override
	public int update(MemberLessonDO memberLesson){
		return memberLessonDao.update(memberLesson);
	}
	
	@Override
	public int remove(String memId){
		return memberLessonDao.remove(memId);
	}
	
	@Override
	public int batchRemove(String[] memIds){
		return memberLessonDao.batchRemove(memIds);
	}
	
}
